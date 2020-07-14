package com.teclan.easyexcel.handler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.teclan.easyexcel.Utils.FileUtils;
import com.teclan.easyexcel.model.ContInfo;

public class ContInfoHandler implements Handler{
	private static final Logger LOGGER = LoggerFactory.getLogger(ContInfoHandler.class);
	private String SQL_TEMPLATE="INSERT INTO SPECIFY_CONT_4_LPR (DATA_TIME,CUS_ID,CUS_NAME,CERT_CODE,PHONE,BIZ_TYPE,"
			+ "PRD_NAME,CONT_AMOUNT,CONT_BALANCE,CONT_NO,LOAN_TERM,LOAN_START_DATE,LOAN_END_DATE,CONT_STAT,MIAN_BR_NAME,CONT_NAME) VALUES ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s');";
	private Long count=0L;
	
	private StringBuffer sb = new StringBuffer();
	
	private String targetFileName ;
	private String[] headers;
	
	public ContInfoHandler(String[] headers,String targetFileName){
		this.headers=headers;
		this.targetFileName=targetFileName;

	}
	
	public void handle(List<?> list)  {
		
		for(Object obj:list) {
			ContInfo contInfo = (ContInfo)obj;
//			LOGGER.info("{}",contInfo);
			count++;
			
			String sql=String.format(SQL_TEMPLATE, contInfo.getDataTime(),contInfo.getCusId(),contInfo.getCusName(),contInfo.getCertCode(),contInfo.getPhone(),contInfo.getBizType(),contInfo.getPrdName(),
					contInfo.getContAmount(),contInfo.getContBalance(),contInfo.getContNo(),contInfo.getLoanTerm(),contInfo.getLoanStartDate(),contInfo.getLoanEndDate(),contInfo.getContState(),contInfo.getFindBr(),contInfo.getContName());

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
