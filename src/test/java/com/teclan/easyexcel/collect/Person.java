package com.teclan.easyexcel.collect;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.fastjson.JSON;
import com.teclan.easyexcel.Utils.Assert;
import com.teclan.easyexcel.model.ExcelModel;

public class Person implements ExcelModel {

	@ExcelProperty("姓名")
	private String name;
	@ExcelProperty("性别")
	private String sex;
	@ExcelProperty("单位")
	private String unit;
	@ExcelProperty("职业")
	private String job;

	public Person( ) {
	}

	public Person(String name, String sex, String unit, String job) {
		this.name = name;
		this.sex = sex;
		this.unit = unit;
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String toString() {
	   return JSON.toJSONString(this);
   }
}
