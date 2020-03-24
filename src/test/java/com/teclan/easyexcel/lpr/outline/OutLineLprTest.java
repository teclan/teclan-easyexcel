package com.teclan.easyexcel.lpr.outline;

import org.junit.Test;

import com.teclan.easyexcel.Utils.ExcelUtils;
import com.teclan.easyexcel.handler.OutLineLprHandler;
import com.teclan.easyexcel.listener.OutLineLprListener;
import com.teclan.easyexcel.model.OutLineLpr;

public class OutLineLprTest {

	String fileName = "excel/m-20200324-1739.xlsx";

	@Test
	public void getSql() {

		String[] header = new String[] { "合同号", "利率模式", "浮动周期", "对年对月周期", "合同原执行利率", "合同LPR基准", "合同BP点数", "借据号",
				"借据原执行利率", "借据LPR基准", "借据BP点数" };
		String openDay = "2020-06-28";
		String targetFileName = "sql/线下补签_" + openDay.replace("-", "") + ".sql";
		ExcelUtils.read(fileName, OutLineLpr.class,
				new OutLineLprListener(new OutLineLprHandler(header, targetFileName, openDay)));
	}

}
