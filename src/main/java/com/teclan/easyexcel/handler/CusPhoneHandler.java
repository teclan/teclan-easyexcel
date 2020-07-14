package com.teclan.easyexcel.handler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.teclan.easyexcel.Utils.Assert;
import com.teclan.easyexcel.Utils.FileUtils;
import com.teclan.easyexcel.model.CusPhone;

public class CusPhoneHandler implements Handler{
	private static final Logger LOGGER = LoggerFactory.getLogger(CusPhoneHandler.class);
	private String SQL_TEMPLATE="INSERT INTO PBOC2LPR_CUS_PHONE (CUS_ID,CUS_NAME,CERT_CODE,REPAYMENT_ACCOUNT,PHONE,INPUT_ID,CREATE_DATE,REMARK) VALUES ('%s','%s','%s','%s','%s','admin','%s','供应链LPR补签');";
	private Long count=0L;
	
	private StringBuffer sb = new StringBuffer();
	
	private String targetFileName ;
	private String[] headers;
	private String openDay;
	
	public CusPhoneHandler(String[] headers,String targetFileName,String openDay){
		this.headers=headers;
		this.targetFileName=targetFileName;
		this.openDay=openDay;
	}
	
	public void handle(List<?> list)  {
		
		for(Object obj:list) {
			CusPhone cusPhone = (CusPhone)obj;
			
			if(Assert.assertEquals(cusPhone.getPhone(), "无")) {
				continue;
			}
			if(Assert.assertNull(cusPhone.getPhone())) {
				continue;
			}
			count++;
			String sql=String.format(SQL_TEMPLATE,cusPhone.getCusId(),cusPhone.getCusName(),cusPhone.getCertCode(),cusPhone.getRepaymentAccount(),cusPhone.getPhone(),openDay );
			sb.append(sql+"\n");
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

	public String[] getHeaders() {
		return headers;
	}

}
