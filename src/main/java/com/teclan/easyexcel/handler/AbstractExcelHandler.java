package com.teclan.easyexcel.handler;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.teclan.easyexcel.Utils.StyleExcelHandler;
import com.teclan.easyexcel.listener.DefaultAnalysisEventListener;
import com.teclan.easyexcel.model.ExcelModel;
import com.teclan.easyexcel.model.ExcelSheetModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractExcelHandler implements ExcelHandler {

    private List<ExcelSheetModel> excelSheetModels = new ArrayList<ExcelSheetModel>();
    private String pathName;

    ExcelWriter excelWriter = null;
    private ExcelAnalysisHandler excelAnalysisHandler;
    private Class excelModel;
    public AbstractExcelHandler(){ }

    public AbstractExcelHandler(String pathName) {
        this.pathName = pathName;
    }

    public ExcelHandler setPath(String pathName){
        this.pathName = pathName;
        return this;
    }

    @Override
    public void write() throws IOException {

        File file = new File(pathName);
        if(file.exists()){
            throw new IOException("文件已存在:"+pathName);
        }

        for (ExcelSheetModel excelSheetModel : excelSheetModels) {
            write(excelSheetModel.getSheetName(), excelSheetModel.getData(), excelSheetModel.getData().get(0).getClass());
        }
        finish();
    }

    /**
     * 将数据写入第一个sheet页
     * @param pathName
     * @param sheetName
     * @param data
     * @param cls
     * @throws IOException
     */
    public void writeSingleSheet(String pathName, String sheetName, List<? extends ExcelModel> data, Class<? extends ExcelModel> cls) throws IOException {

        File file = new File(pathName);
        if(file.exists()){
            throw new IOException("文件已存在:"+pathName);
        }

        OutputStream out = new FileOutputStream(new File(pathName));
//        ExcelWriter excelWriter = EasyExcelFactory.getWriter(out);
        ExcelWriter excelWriter =  new ExcelWriter(null, out, ExcelTypeEnum.XLSX, true, new StyleExcelHandler());
        WriteSheet writeSheet = EasyExcel.writerSheet(sheetName).head(cls).build();
        excelWriter.write(data,writeSheet);
        excelWriter.finish();
    }

    private void write(String sheetName, List<? extends ExcelModel> data, Class<? extends ExcelModel> cls) throws FileNotFoundException {
        WriteSheet writeSheet = EasyExcel.writerSheet(sheetName).head(cls).build();
        getExcelWriter().write(data, writeSheet);
    }

    @Override
    public ExcelWriter getExcelWriter() throws FileNotFoundException {
        if (excelWriter == null) {
            OutputStream out = new FileOutputStream(new File(pathName));
            excelWriter = new ExcelWriter(null, out, ExcelTypeEnum.XLSX, true, new StyleExcelHandler());
        }
        return excelWriter;
    }

    private void finish() throws FileNotFoundException {
        getExcelWriter().finish();
    }

    @Override
    public ExcelHandler setData(ExcelSheetModel excelSheetModel) {
        excelSheetModels.add(excelSheetModel);
        return this;
    }

    public ExcelHandler setData(ExcelSheetModel ... excelSheetModels){
        for(ExcelSheetModel excelSheetModel:excelSheetModels){
            setData(excelSheetModel);
        }
        return this;
    }
    public void setData(List<ExcelSheetModel> excelSheetModels) {
        this.excelSheetModels = excelSheetModels;
    }

    public void read(){
        ExcelReader excelReader = EasyExcel.read(pathName, excelModel, new DefaultAnalysisEventListener(excelAnalysisHandler)).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        excelReader.finish();
    }
    public void read( Class<?> cls, ReadListener readListener) {
        ExcelReader excelReader = EasyExcel.read(pathName, cls, readListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        excelReader.finish();
    }

    public void read( Class<?> cls, int sheetNo,ReadListener readListener) {
        ExcelReader excelReader = EasyExcel.read(pathName, cls, readListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(sheetNo).build();
        excelReader.read(readSheet);
        excelReader.finish();
    }

    public void read( Class<?> cls, ExcelAnalysisHandler excelAnalysisHandler){
        ExcelReader excelReader = EasyExcel.read(pathName, cls, new DefaultAnalysisEventListener(excelAnalysisHandler)).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        excelReader.finish();
    }

    public void read( Class<?> cls, int sheetNo,ExcelAnalysisHandler excelAnalysisHandler) {
        ExcelReader excelReader = EasyExcel.read(pathName, cls, new DefaultAnalysisEventListener(excelAnalysisHandler)).build();
        ReadSheet readSheet = EasyExcel.readSheet(sheetNo).build();
        excelReader.read(readSheet);
        excelReader.finish();
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public ExcelHandler setExcelAnalysisHandler(ExcelAnalysisHandler excelAnalysisHandler){
        this.excelAnalysisHandler=excelAnalysisHandler;
        return this;
    }

    public ExcelHandler setDefaultExcelAnalysisHandler(String ... header){
        this.excelAnalysisHandler=new DefaultExcelAnalysisHandler(header);
        return this;
    }

    public ExcelHandler setDataModel(Class<? extends ExcelModel> cls){
        this.excelModel=cls;
        return this;
    }

}
