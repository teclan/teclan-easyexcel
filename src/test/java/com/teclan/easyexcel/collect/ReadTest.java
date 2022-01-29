package com.teclan.easyexcel.collect;

import com.teclan.easyexcel.handler.DefaultExcelHandler;
import com.teclan.easyexcel.handler.ExcelHandler;
import com.teclan.easyexcel.listener.DefaultAnalysisEventListener;
import org.junit.Test;

public class ReadTest {

	String fileName = "E:\\Codes\\openSource\\teclan-easyexcel\\excel\\数据收集.xlsx";

	@Test
	public void readError1() {
		String[] header = new String[] {  "性别","姓名", "单位", "职业" }; // 姓名、性别顺序交换
		ExcelHandler excelHandler = new DefaultExcelHandler(fileName);
		excelHandler.read(Person.class,new DefaultAnalysisEventListener(header));
	}

	@Test
	public void readError2() {
		String[] header = new String[] { "姓名", "性别", "单位", "职业","备注" }; // 比实际文件多一个 “备注” 字段
		ExcelHandler excelHandler = new DefaultExcelHandler(fileName);
		excelHandler.read(Person.class,new DefaultAnalysisEventListener(header));
	}

	@Test
	public void readCorrect1() {
		String[] header = new String[] { "姓名", "性别", "单位", "职业" };
		ExcelHandler excelHandler = new DefaultExcelHandler(fileName);
		excelHandler.read(Person.class,new DefaultAnalysisEventListener(header));
	}

	@Test
	public void readCorrect2() {
		String[] header = new String[] {  "性别","姓名", "单位", "职业" }; // 姓名、性别顺序交换
		ExcelHandler excelHandler = new DefaultExcelHandler(fileName);
		DefaultAnalysisEventListener defaultAnalysisEventListener = new DefaultAnalysisEventListener(header);
		defaultAnalysisEventListener.setStrictMode(false); // 关闭严格模式（取消表头顺序校验）
		excelHandler.read(Person.class,defaultAnalysisEventListener);
	}
}
