package com.teclan.easyexcel.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.teclan.easyexcel.Utils.Assert;
import com.teclan.easyexcel.handler.Handler;
import com.teclan.easyexcel.handler.OutLineLprHandler;
import com.teclan.easyexcel.model.OutLineLpr;

public class OutLineLprListener extends AnalysisEventListener<OutLineLpr> {
	private static final Logger LOGGER = LoggerFactory.getLogger(OutLineLprListener.class);
	private static final int BATCH_COUNT = 1000;
	List<OutLineLpr> list = new ArrayList<OutLineLpr>();

	private Handler handler;
	private boolean headerVaild=true;;

	public OutLineLprListener(Handler handelr) {
		this.handler = handelr;
	}
	
	 public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
	        LOGGER.info("解析到表头数据:{}", JSON.toJSONString(headMap));
	        String[] header = handler.getHeaders();
	        for(int i=0;i<header.length;i++) {
	        	if(!Assert.assertEquals(header[i], headMap.get(Integer.valueOf(i)))) {
	        		LOGGER.error("\n表头不匹配，位置:{}，预期[{}]->实际[{}]",i,header[i],headMap.get(Integer.valueOf(i)));
	        		headerVaild=false;
	        		return;
	        	}
	        }
	    }

	public void invoke(OutLineLpr data, AnalysisContext context) {
		
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

}
