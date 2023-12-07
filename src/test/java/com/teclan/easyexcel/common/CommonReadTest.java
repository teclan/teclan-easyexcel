package com.teclan.easyexcel.common;

import com.teclan.easyexcel.handler.DefaultExcelAnalysisHandler;
import com.teclan.easyexcel.handler.DefaultExcelHandler;
import com.teclan.easyexcel.model.DefExcelModel;
import org.junit.Test;


public class CommonReadTest {
    String fileName = "D:\\Codes\\teclan-easyexcel\\excel\\数据收集.xlsx";

    @Test
    public void read1()  {
        new DefaultExcelHandler()
                .setPath(fileName)
                .setExcelAnalysisHandler(new DefaultExcelAnalysisHandler())
                .setDataModel(DefExcelModel.class)
                .read();
    }

    @Test
    public void read2()  {
        new DefaultExcelHandler()
                .setPath("D:\\数据治理\\押品系统+核心系统_存单信息-原稿.xlsx")
                .setExcelAnalysisHandler(new DefaultExcelAnalysisHandler())
                .setDataModel(DefExcelModel.class)
                .read();
    }

    @Test
    public void read3()  {
        new DefaultExcelHandler()
                .setPath("D:\\数据治理\\押品系统+核心系统_存单信息-原稿.xlsx")
                .setExcelAnalysisHandler(new DefaultExcelAnalysisHandler())
                .setDataModel(DefExcelModel.class)
                .read(0);
    }
}
