package com.teclan.easyexcel.handler;

import com.teclan.easyexcel.model.ExcelModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class AbstractExcelAnalysisHandler implements ExcelAnalysisHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractExcelAnalysisHandler.class);

	private Long count = 0L;

	private String[] headers;

	public AbstractExcelAnalysisHandler(String[] headers){
		this.headers=headers;
	}

	public void handle(List<ExcelModel> list)  {
		for (ExcelModel obj : list) {
			LOGGER.info("处理：{}",obj);
			addCount();
		}
	}

	public Long getCount() {
		return count;
	}

	public String[] getHeaders() {
		return headers;
	}

	public void addCount(){
		count++;
	}

}
