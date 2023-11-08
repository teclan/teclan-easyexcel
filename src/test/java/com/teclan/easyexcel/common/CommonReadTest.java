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

}
