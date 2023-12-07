package com.teclan.easyexcel.model;

import com.alibaba.fastjson.JSON;

public class Column {
    private String name;
    private String comment;

    public Column() {
    }

    public Column(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String toString(){
        return JSON.toJSONString(this);
    }
}
