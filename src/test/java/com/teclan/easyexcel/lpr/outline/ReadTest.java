package com.teclan.easyexcel.lpr.outline;

import com.teclan.easyexcel.handler.DefaultExcelAnalysisHandler;
import com.teclan.easyexcel.handler.DefaultExcelHandler;
import com.teclan.easyexcel.handler.ExcelHandler;
import com.teclan.easyexcel.listener.DefaultAnalysisEventListener;
import org.junit.Test;

public class ReadTest {

	String fileName = "E:\\Codes\\openSource\\teclan-easyexcel\\excel\\数据收集.xlsx";

	@Test
	public void read() {
		String[] header = new String[] { "合同号", "利率模式", "浮动周期", "对年对月周期", "合同原执行利率", "合同LPR基准", "合同BP点数", "借据号",
				"借据原执行利率", "借据LPR基准", "借据点数" };
		ExcelHandler excelHandler = new DefaultExcelHandler(fileName);
		excelHandler.read(OutLineLpr.class,new DefaultAnalysisEventListener(new DefaultExcelAnalysisHandler(header)));
	}
}
