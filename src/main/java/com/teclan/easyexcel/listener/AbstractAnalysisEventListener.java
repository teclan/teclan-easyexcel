package com.teclan.easyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.CellExtra;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.teclan.easyexcel.Utils.Assert;
import com.teclan.easyexcel.Utils.Objects;
import com.teclan.easyexcel.config.CommonConfig;
import com.teclan.easyexcel.db.DBFactory;
import com.teclan.easyexcel.handler.ExcelAnalysisHandler;
import com.teclan.easyexcel.model.Column;
import com.teclan.easyexcel.model.DefExcelModel;
import com.teclan.easyexcel.model.ExcelModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class  AbstractAnalysisEventListener implements ReadListener<ExcelModel>   {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractAnalysisEventListener.class);
	private static final int BATCH_COUNT = 1000;
	List< ExcelModel>list = new ArrayList<ExcelModel>();

	private ExcelAnalysisHandler handler;

	private boolean headerVaild=true;

	/**
	 * 严格模式，开启严格模式将校验表头顺序与给定顺序完全一致
	 */
	private boolean strictMode = true;

	private ArrayList<Column> columns = new ArrayList<Column>();

	public AbstractAnalysisEventListener(ExcelAnalysisHandler handelr) {
		this.handler = handelr;
	}

	public void setStrictMode(boolean strictMode){
		this.strictMode=strictMode;
	}


	public void invoke(ExcelModel data, AnalysisContext context) {
		if(!headerVaild) {
			return;
		}
		list.add(data);
		if (list.size() >= BATCH_COUNT) {
			handler.handle(list);
			list.clear();
		}
	}

	public void doAfterAllAnalysed(AnalysisContext context) {
		handler.handle(list);
		list.clear();
		LOGGER.info("共处理记录数:{}",handler.getCount());
	}


	/**
	 * The current method is called when extra information is returned
	 *
	 * @param extra
	 *            extra information
	 * @param context
	 *            analysis context
	 */
	@Override
	public void extra(CellExtra extra, AnalysisContext context) {}

	/**
	 * All listeners receive this method when any one Listener does an error report. If an exception is thrown here, the
	 * entire read will terminate.
	 *
	 * @param exception
	 * @param context
	 */
	@Override
	public void onException(Exception exception, AnalysisContext context) throws Exception {
		throw exception;
	}

	@Override
	public void invokeHead(Map<Integer, CellData> headMap, AnalysisContext context) {

		JSONObject title = JSONObject.parseObject(JSON.toJSONString(headMap));
		LOGGER.info("解析到表头数据:{}", title);

		if(title.keySet().size()>702){
			LOGGER.info("超过支持解析的最大列数（702）列，列范围[A-ZZ]...");
			headerVaild=false;
			return;
		}

		for(String key:title.keySet()){
			JSONObject object = title.getJSONObject(key);
			LOGGER.info("index : {}, name = {}",key,object.getString("stringValue"));
			Column column = new Column(DefExcelModel.RANG[Integer.valueOf(key)],object.getString("stringValue"));
			columns.add(column);
		}
		boolean createTable = CommonConfig.getConfig().getBoolean("createTable");
		LOGGER.info("检测到建表配置：{}",createTable);
		if(createTable){
			String tableName = "table1";
			LOGGER.info("即将建表 ...");
			ArrayList<String> columns = new ArrayList<String>();
			ArrayList<String> comments = new ArrayList<String>();

			for(Column column: this.columns){
				columns.add(String.format("%s varchar(2000) comment '%s' ",column.getName(),column.getComment()));
			}

			String createTableSql = String.format("create table %s (\n%s\n) ",tableName,Objects.Joiner(",\n",columns));

			LOGGER.info(createTableSql);
			DBFactory.getDb().exec(createTableSql);
		}

		if(!strictMode){
			LOGGER.info("表头顺序校验未开启...");
			return;
		}

		String[] header = handler.getHeaders();
		for(int i=0;header!=null && i<header.length;i++) {

			if(headMap.size()<=i){
				LOGGER.error("\n表头不匹配，位置:{}，预期[{}]->实际[{}]",i,header[i],"未找到");
				headerVaild=false;
				return;
			}

			if(!Assert.assertEquals(header[i], headMap.get(Integer.valueOf(i)).getStringValue())) {
				LOGGER.error("\n表头不匹配，位置:{}，预期[{}]->实际[{}]",i,header[i],headMap.get(Integer.valueOf(i)));
				headerVaild=false;
				return;
			}
		}
	}

	@Override
	public boolean hasNext(AnalysisContext context) {
		return true;
	}

	public ExcelAnalysisHandler getHandler() {
		return handler;
	}

	public void setHandler(ExcelAnalysisHandler handler) {
		this.handler = handler;
	}

	public boolean isHeaderVaild() {
		return headerVaild;
	}

	public void setHeaderVaild(boolean headerVaild) {
		this.headerVaild = headerVaild;
	}
}
