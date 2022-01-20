package com.teclan.easyexcel.handler;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.read.listener.ReadListener;
import com.teclan.easyexcel.model.ExcelModel;
import com.teclan.easyexcel.model.ExcelSheetModel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ExcelHandler {

    /**
     * 获取Excel写对象
     * @return
     * @throws FileNotFoundException
     */
    public ExcelWriter getExcelWriter () throws FileNotFoundException;

    /**
     * 执行写入操作（单个sheet页）
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void writeSingleSheet(String pathName, String sheetName, List<? extends ExcelModel> data, Class<? extends ExcelModel> cls) throws IOException;

    /**
     * 执行写入操作，将设置的sheet页数据写入
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void write() throws FileNotFoundException, IOException;

    /**
     * 设置要写入Excel的数据，针对单个 sheet页
     * @param excelSheetModel 写入的sheet页数据
     */
    public void setData(ExcelSheetModel excelSheetModel);

    /**
     * 设置要写入Excel的数据，
     * @param excelSheetModels 写入的sheet页数据集合，每个对象一个sheet页
     */
    public void setData(ExcelSheetModel ... excelSheetModels);

    /**
     * 设置要写入Excel的数据，
     * @param excelSheetModels 写入的sheet页数据集合，每个对象一个sheet页
     */
    public void setData(List<ExcelSheetModel> excelSheetModels);

    /**
     * 解析Excel
     * @param cls
     * @param readListener
     */
    public void read( Class<?> cls, ReadListener readListener);

    /**
     * 设置文件路径，用于读取或写入的文件路径
     * @param pathName
     */
    public void setPathName(String pathName);

}