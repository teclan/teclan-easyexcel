package com.teclan.easyexcel.model;

import java.util.List;

public class ExcelSheetModel {

    private String sheetName;
    private List<? extends ExcelModel> data;

    public ExcelSheetModel(){

    }

    public ExcelSheetModel(String sheetName,List<? extends ExcelModel> data){
     this.sheetName=sheetName;
     this.data=data;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public List<? extends ExcelModel> getData() {
        return data;
    }

    public void setData(List<? extends ExcelModel> data) {
        this.data = data;
    }
}
