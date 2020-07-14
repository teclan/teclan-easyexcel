package com.teclan.easyexcel.lpr.cusphone;

import com.teclan.easyexcel.Utils.FileUtils;
import org.junit.Test;

import com.teclan.easyexcel.Utils.ExcelUtils;
import com.teclan.easyexcel.handler.CusPhoneHandler;
import com.teclan.easyexcel.listener.CusPhoneListener;
import com.teclan.easyexcel.model.CusPhone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CusPhoneTest {
private final static Logger LOGGER = LoggerFactory.getLogger(CusPhoneTest.class);

	String fileName = "E:\\Codes\\openSource\\teclan-easyexcel\\excel\\20200713-供应链LPR补签数据-正确手机号.xlsx";

	@Test
	public void getSql() {

		String openDay = "2020-07-14";
		String targetFileName = "sql/供应链LPR补签数据-正确手机号_" + openDay.replace("-", "") + ".sql";
		String[] header = new String[] { "客户号", "客户名称", "证件号", "供应链合作协议", "还款账号", "当前系统匹配手机号", "手机号"};
		FileUtils.deleteFile(targetFileName);
		LOGGER.info("SQL脚本路径:{}",targetFileName);
		ExcelUtils.read(fileName, CusPhone.class,
				new CusPhoneListener(new CusPhoneHandler(header, targetFileName, openDay)));
	}

}
