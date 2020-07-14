package com.teclan.easyexcel.lpr.cont;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.teclan.easyexcel.Utils.ExcelUtils;
import com.teclan.easyexcel.handler.ContInfoHandler;
import com.teclan.easyexcel.listener.ConInfoListener;
import com.teclan.easyexcel.model.ContInfo;

public class ContInfoTest {
	
	private static SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	private static String fileName="E:\\Documents\\桂林银行\\信贷系统\\开发需求\\谭炳健\\测试中\\人行基准转LPR的需求\\第四批收集-发送短信4.13-无密码.xlsx";
	
	@Test
	public void getSql() {
		
		String[] header = new String[] {"数据日期","客户号","客户名称","证件号码","手机号码","贷款品种明细","贷款品种明细名称",
				"合同金额","合同余额","合同编号","贷款期限","合同生效日期","合同终止日期","合同状态名称","账务机构名称","合同名称"};
		 
		String targetFileName = "sql/指定合同信息_" + format.format(new Date()) + ".sql";
		
		 ExcelUtils.read(fileName, ContInfo.class,new ConInfoListener(new ContInfoHandler(header,targetFileName)));
	}
}
