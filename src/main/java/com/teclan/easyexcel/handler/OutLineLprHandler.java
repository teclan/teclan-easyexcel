package com.teclan.easyexcel.handler;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.teclan.easyexcel.Utils.Assert;
import com.teclan.easyexcel.Utils.FileUtils;
import com.teclan.easyexcel.model.OutLineLpr;

public class OutLineLprHandler implements Handler {
	private static final Logger LOGGER = LoggerFactory.getLogger(OutLineLprHandler.class);
	private static String SQL_TEMPLAT = "INSERT INTO PBOC2LPR_FROM_OUT_LINE "
			+ "(CONT_NO, BILL_NO, RATE_MODE, FLOAT_CYCLE, Y_M_CYCLE, CTR_DATUM, CTR_BP_TYPE, CTR_BP_NUMBER, CTR_CALC_BP_NUMBER, CTR_COL_EXE_RATE, ACC_DATUM, ACC_BP_TYPE, ACC_BP_NUMBER, ACC_CALC_BP_NUMBER, ACC_COL_EXE_RATE,IS_ON_LINE,CREATE_TIME) "
			+ "VALUES('%s', '%s', '%s', '%s', '%s', %s, %s, %s, %s, %s, %s, %s, %s, %s,%s,'0','%s' );";

	private Long count = 0L;
	StringBuffer sb = new StringBuffer();

	private String targetFileName;
	private String openDay;
	private String[] headers;
	
	public OutLineLprHandler(String[] headers,String targetFileName,String openDay){
		this.headers=headers;
		this.targetFileName=targetFileName;
		this.openDay=openDay;
	}

	public void handle(List<?> list) {

		for (Object obj : list) {
			OutLineLpr outLineLpr = (OutLineLpr) obj;

			
			if(Assert.assertNull(outLineLpr.getContNo())) {
				LOGGER.info("跳过：{}",outLineLpr);
				continue;
			}
			LOGGER.info("处理：{}",outLineLpr);
			String sql = String.format(SQL_TEMPLAT, outLineLpr.getContNo(), outLineLpr.getBillNo(),
					outLineLpr.getRateModel(), outLineLpr.getFloatCycle(), outLineLpr.getYmCycle(),
					outLineLpr.getContDatum(), getBpType(outLineLpr.getContDpNumber()),
					getBpNumber(outLineLpr.getContDpNumber()), outLineLpr.getContDpNumber(),
					outLineLpr.getOldContExeRate(), outLineLpr.getBillDatum(), getBpType(outLineLpr.getBillBpNumber()),
					getBpNumber(outLineLpr.getBillBpNumber()), outLineLpr.getBillBpNumber(),
					outLineLpr.getOldBillExeRate(),openDay);
			
			
			sb.append(sql + "\n");

			count++;
		}
		
		try {
			FileUtils.write2File(targetFileName, sb);
			sb.setLength(0);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(),e);
		}
	}

	public Long getCount() {
		return count;
	}
	
private String getBpType(String calcBpNumber) {
		
		if(Assert.assertNull(calcBpNumber)) {
			return null;
		}
		
		Double number = Double.valueOf(calcBpNumber);
		if(number>0) {
			return "1";
		}else if(number==0) {
			return "2";
		}else {
			return "3";
		}
	}
	
	private String getBpNumber(String calcBpNumber) {
		if(Assert.assertNull(calcBpNumber)) {
			return null;
		}
		
		return new BigDecimal(calcBpNumber).abs().toPlainString();
	}


	public String[] getHeaders() {
		return headers;
	}
}
