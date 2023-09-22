package com.teclan.easyexcel.write;

import com.alibaba.excel.annotation.ExcelProperty;
import com.teclan.easyexcel.model.ExcelModel;

public class TableModel implements ExcelModel {
    @ExcelProperty(value = "序号", index = 0)
    private int index;
    @ExcelProperty(value = "表名", index = 1)
    private String  tableName;
    @ExcelProperty(value = "描述", index = 2)
    private String comments;

    public TableModel() {
    }

    public TableModel(int index, String tableName, String comments) {
        this.index=index;
        this.tableName = tableName;
        this.comments = comments;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
