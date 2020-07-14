package com.teclan.easyexcel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.fastjson.JSON;

public class CusPhone {
	
	@ExcelProperty("客户号")
	private String cusId;

	@ExcelProperty("客户名称")
	private String cusName;
	
	@ExcelProperty("还款账号")
	private String repaymentAccount;
	
	@ExcelProperty("证件号")
	private String certCode;
	
	@ExcelProperty("手机号")
	private String phone;

	
	public CusPhone() {
		
	}
	
	public CusPhone(String cusId, String cusName, String repaymentAccount, String certCode, String phone) {
		super();
		this.cusId = cusId;
		this.cusName = cusName;
		this.repaymentAccount = repaymentAccount;
		this.certCode = certCode;
		this.phone = phone;
	}
	
	
	public String getCusId() {
		return cusId;
	}


	public void setCusId(String cusId) {
		this.cusId = cusId;
	}


	public String getCusName() {
		return cusName;
	}


	public void setCusName(String cusName) {
		this.cusName = cusName;
	}


	public String getRepaymentAccount() {
		return repaymentAccount;
	}


	public void setRepaymentAccount(String repaymentAccount) {
		this.repaymentAccount = repaymentAccount;
	}


	public String getCertCode() {
		return certCode;
	}


	public void setCertCode(String certCode) {
		this.certCode = certCode;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String toString() {
		   return JSON.toJSONString(this);
	}
	
	
}
