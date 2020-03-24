package com.teclan.easyexcel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.fastjson.JSON;

public class OutLineLpr {
	
	public OutLineLpr( ) {
	}
	public OutLineLpr(String contNo, String rateModel, String floatCycle, String ymCycle, String oldContExeRate,
			String contDatum, String contDpNumber, String billNo, String oldBillExeRate,
			String billDatum, String billBpNumber) {
		super();
		this.contNo = contNo;
		this.rateModel = rateModel;
		this.floatCycle = floatCycle;
		this.ymCycle = ymCycle;
		this.oldContExeRate = oldContExeRate;
		this.contDatum = contDatum;
		this.contDpNumber = contDpNumber;
		this.billNo = billNo;
		this.oldBillExeRate = oldBillExeRate;
		this.billDatum = billDatum;
		this.billBpNumber = billBpNumber;
	}


	@ExcelProperty("合同号")
	private String contNo;
	@ExcelProperty("利率模式")
	private String rateModel;
	@ExcelProperty("浮动周期")
	private String floatCycle;
	@ExcelProperty("对年对月周期")
	private String ymCycle;
	@ExcelProperty("合同原执行利率")
	private String oldContExeRate;
	@ExcelProperty("合同LPR基准")
	private String contDatum;
	@ExcelProperty("合同BP点数")
	private String contDpNumber;
	@ExcelProperty("借据号")
	private String billNo="";
	@ExcelProperty("借据原执行利率")
	private String oldBillExeRate;
	@ExcelProperty("借据LPR基准")
	private String billDatum;
	@ExcelProperty("借据BP点数")
	private String billBpNumber;
	
	public String getContNo() {
		return contNo;
	}

	public void setContNo(String contNo) {
		this.contNo = contNo;
	}

	public String getRateModel() {
		return rateModel;
	}

	public void setRateModel(String rateModel) {
		this.rateModel = rateModel;
	}

	public String getFloatCycle() {
		return floatCycle;
	}

	public void setFloatCycle(String floatCycle) {
		this.floatCycle = floatCycle;
	}

	public String getYmCycle() {
		return ymCycle;
	}

	public void setYmCycle(String ymCycle) {
		this.ymCycle = ymCycle;
	}


	public String getOldContExeRate() {
		return oldContExeRate;
	}


	public void setOldContExeRate(String oldContExeRate) {
		this.oldContExeRate = oldContExeRate;
	}


	public String getContDatum() {
		return contDatum;
	}


	public void setContDatum(String contDatum) {
		this.contDatum = contDatum;
	}


	public String getContDpNumber() {
		return contDpNumber;
	}


	public void setContDpNumber(String contDpNumber) {
		this.contDpNumber = contDpNumber;
	}


	public String getBillNo() {
		return billNo;
	}


	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}


	public String getOldBillExeRate() {
		return oldBillExeRate;
	}


	public void setOldBillExeRate(String oldBillExeRate) {
		this.oldBillExeRate = oldBillExeRate;
	}


	public String getBillDatum() {
		return billDatum;
	}


	public void setBillDatum(String billDatum) {
		this.billDatum = billDatum;
	}


	public String getBillBpNumber() {
		return billBpNumber;
	}


	public void setBillBpNumber(String billBpNumber) {
		this.billBpNumber = billBpNumber;
	}
	
   public String toString() {
	   return JSON.toJSONString(this);
   }
}
