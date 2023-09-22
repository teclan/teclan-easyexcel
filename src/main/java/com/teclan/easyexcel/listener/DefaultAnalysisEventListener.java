package com.teclan.easyexcel.listener;

import com.teclan.easyexcel.handler.DefaultExcelAnalysisHandler;
import com.teclan.easyexcel.handler.ExcelAnalysisHandler;

public  class DefaultAnalysisEventListener extends AbstractAnalysisEventListener  {
	public DefaultAnalysisEventListener(ExcelAnalysisHandler handelr) {
		super(handelr);
	}

	public DefaultAnalysisEventListener(String[] headers){
		super(new DefaultExcelAnalysisHandler(headers));
	}
}
