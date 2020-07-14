package com.teclan.easyexcel.lpr.outline;

import org.junit.Test;

import com.teclan.easyexcel.Utils.ExcelUtils;
import com.teclan.easyexcel.Utils.FileUtils;
import com.teclan.easyexcel.handler.OutLineLprHandler;
import com.teclan.easyexcel.listener.OutLineLprListener;
import com.teclan.easyexcel.model.OutLineLpr;

public class OutLineLprTest {

	String fileName = "E:\\Codes\\openSource\\teclan-easyexcel\\excel\\LPR线下补签数据收集20200708.xlsx";

	@Test
	public void getSql() {

		String[] header = new String[] { "合同号", "利率模式", "浮动周期", "对年对月周期", "合同原执行利率", "合同LPR基准", "合同BP点数", "借据号",
				"借据原执行利率", "借据LPR基准", "借据点数" };
		String openDay = "2020-07-10";
		String targetFileName = "sql/线下补签_" + openDay.replace("-", "") + ".sql";
		
		FileUtils.deleteFile(targetFileName);
		
		ExcelUtils.read(fileName, OutLineLpr.class,
				new OutLineLprListener(new OutLineLprHandler(header, targetFileName, openDay)));
	}

}
