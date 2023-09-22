package com.teclan.easyexcel.handler;

import com.teclan.easyexcel.model.ExcelModel;

import java.util.List;
import java.util.Map;

public interface ExcelAnalysisHandler {

	public void handle(List<ExcelModel> list);
	
	public Long getCount();
	
	public String[] getHeaders();
	
}
