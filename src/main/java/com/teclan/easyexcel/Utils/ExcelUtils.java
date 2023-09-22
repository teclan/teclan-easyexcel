package com.teclan.easyexcel.Utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.metadata.ReadSheet;

public class ExcelUtils {
	
	@SuppressWarnings("rawtypes")
	public static void read(String pathName,Class<?> cls,AnalysisEventListener readListener) {
	        ExcelReader excelReader = EasyExcel.read(pathName, cls, readListener).build();
	        ReadSheet readSheet = EasyExcel.readSheet(0).build();
	        excelReader.read(readSheet);
	        excelReader.finish();
	}

}
