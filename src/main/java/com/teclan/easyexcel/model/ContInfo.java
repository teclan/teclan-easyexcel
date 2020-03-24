package com.teclan.easyexcel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.fastjson.JSON;

public class ContInfo {
	@ExcelProperty("数据日期")
	private String dataTime;
	@ExcelProperty("客户号")
	private String cusId;
	@ExcelProperty("客户名称")
	private String cusName;
	@ExcelProperty("证件号码")
	private String certCode;
	@ExcelProperty("手机号码")
	private String phone;
	@ExcelProperty("贷款品种明细")
	private String bizType;
	@ExcelProperty("贷款品种明细名称")
	private String prdName;
	@ExcelProperty("合同金额")
	private String contAmount;
	@ExcelProperty("合同余额")
	private String contBalance;
	@ExcelProperty("合同编号")
	private String contNo;
	@ExcelProperty("贷款期限")
	private String loanTerm;
	@ExcelProperty("合同生效日期")
	private String loanStartDate;
	@ExcelProperty("合同终止日期")
	private String loanEndDate;
	@ExcelProperty("合同状态名称")
	private String contState;
	@ExcelProperty("账务机构名称")
	private String findBr;
	@ExcelProperty("合同名称")
	private String contName;
	
	
	public ContInfo(){
		
	}
	
	public ContInfo(String dataTime, String cusId, String cusName, String certCode, String phone, String bizType,
			String prdName, String contAmount, String contBalance, String contNo, String loanTerm, String loanStartDate,
			String loanEndDate, String contState, String findBr, String contName) {
		super();
		this.dataTime = dataTime;
		this.cusId = cusId;
		this.cusName = cusName;
		this.certCode = certCode;
		this.phone = phone;
		this.bizType = bizType;
		this.prdName = prdName;
		this.contAmount = contAmount;
		this.contBalance = contBalance;
		this.contNo = contNo;
		this.loanTerm = loanTerm;
		this.loanStartDate = loanStartDate;
		this.loanEndDate = loanEndDate;
		this.contState = contState;
		this.findBr = findBr;
		this.contName = contName;
	}
	public String getDataTime() {
		return dataTime;
	}
	public void setDataTime(String dataTime) {
		this.dataTime = dataTime;
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
	public String getBizType() {
		return bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	public String getPrdName() {
		return prdName;
	}
	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}
	public String getContAmount() {
		return contAmount;
	}
	public void setContAmount(String contAmount) {
		this.contAmount = contAmount;
	}
	public String getContBalance() {
		return contBalance;
	}
	public void setContBalance(String contBalance) {
		this.contBalance = contBalance;
	}
	public String getContNo() {
		return contNo;
	}
	public void setContNo(String contNo) {
		this.contNo = contNo;
	}
	public String getLoanTerm() {
		return loanTerm;
	}
	public void setLoanTerm(String loanTerm) {
		this.loanTerm = loanTerm;
	}
	public String getLoanStartDate() {
		return loanStartDate;
	}
	public void setLoanStartDate(String loanStartDate) {
		this.loanStartDate = loanStartDate;
	}
	public String getLoanEndDate() {
		return loanEndDate;
	}
	public void setLoanEndDate(String loanEndDate) {
		this.loanEndDate = loanEndDate;
	}
	public String getContState() {
		return contState;
	}
	public void setContState(String contState) {
		this.contState = contState;
	}
	public String getFindBr() {
		return findBr;
	}
	public void setFindBr(String findBr) {
		this.findBr = findBr;
	}
	public String getContName() {
		return contName;
	}
	public void setContName(String contName) {
		this.contName = contName;
	}
	
	public String toString() {
		   return JSON.toJSONString(this);
	   }
}
