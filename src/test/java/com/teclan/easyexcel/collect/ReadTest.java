package com.teclan.easyexcel.collect;

import com.teclan.easyexcel.handler.DefaultExcelAnalysisHandler;
import com.teclan.easyexcel.handler.DefaultExcelHandler;
import com.teclan.easyexcel.listener.DefaultAnalysisEventListener;
import org.junit.Test;

public class ReadTest {

	String fileName = "D:\\Codes\\teclan-easyexcel\\excel\\数据收集.xlsx";

	@Test
	public void readError1() {
		String[] header = new String[] {  "性别","姓名", "单位", "职业" }; // 姓名、性别顺序交换
		new DefaultExcelHandler()
				.setPath(fileName)
				.read(Person.class,new DefaultExcelAnalysisHandler(header));

	}

	@Test
	public void readError2() {
		String[] header = new String[] { "姓名", "性别", "单位", "职业","备注" }; // 比实际文件多一个 “备注” 字段
		new DefaultExcelHandler()
				.setPath(fileName)
				//.setExcelAnalysisHandler(new DefaultExcelAnalysisHandler(header))
				.setDefaultExcelAnalysisHandler(header)
				.setDataModel(Person.class)
				.read();

	}

	@Test
	public void readCorrect1() {
		String[] header = new String[] { "姓名", "性别", "单位", "职业" };
		new DefaultExcelHandler()
				.setPath(fileName)
				.setExcelAnalysisHandler(new DefaultExcelAnalysisHandler(header))
				.setDataModel(Person.class)
				.read();
	}

	@Test
	public void readCorrect2() {
		String[] header = new String[] {  "性别","姓名", "单位", "职业" }; // 姓名、性别顺序交换
		DefaultAnalysisEventListener defaultAnalysisEventListener = new DefaultAnalysisEventListener(header);
		defaultAnalysisEventListener.setStrictMode(false); // 关闭严格模式（取消表头顺序校验）
		new DefaultExcelHandler()
				.setPath(fileName)
				.read(Person.class,defaultAnalysisEventListener);
	}
}
