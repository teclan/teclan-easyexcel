package com.teclan.easyexcel.common;

import com.teclan.easyexcel.Utils.FileUtils;
import com.teclan.easyexcel.Utils.Objects;
import com.teclan.easyexcel.db.DBFactory;
import com.teclan.easyexcel.handler.DefaultExcelAnalysisHandler;
import com.teclan.easyexcel.handler.DefaultExcelHandler;
import com.teclan.easyexcel.model.DefExcelModel;
import org.junit.Test;

import java.util.ArrayList;


public class CommonReadTest {
    String fileName = "D:\\Codes\\teclan-easyexcel\\excel\\数据收集.xlsx";

    @Test
    public void read1()  {
        DBFactory.open();
        new DefaultExcelHandler()
                .setPath(fileName)
                .setExcelAnalysisHandler(new DefaultExcelAnalysisHandler())
                .setDataModel(DefExcelModel.class)
                .read();

        DBFactory.close();
    }

    @Test
    public void read2()  {

        DBFactory.open();
        new DefaultExcelHandler()
                .setPath("D:\\数据治理\\押品系统+核心系统_存单信息-原稿.xlsx")
                .setExcelAnalysisHandler(new DefaultExcelAnalysisHandler())
                .setDataModel(DefExcelModel.class)
                .read();
        DBFactory.close();
    }

    @Test
    public void read3()  {
        DBFactory.open();
        new DefaultExcelHandler()
                .setPath("D:\\数据治理\\押品系统+核心系统_存单信息-原稿.xlsx")
                .setExcelAnalysisHandler(new DefaultExcelAnalysisHandler())
                .setDataModel(DefExcelModel.class)
                .read(1);
        DBFactory.close();
    }

    @Test
    public void write() throws Exception {


        char from = 'A';
        String[] array1 = new String[26];
        String[] array2 = new String[26];
        for(int i=0;i<26;i++){
            array1[i] = String.valueOf(from);
            array2[i] = String.valueOf(from);
            from++;
        }

        int index = 0;
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<26;i++){
            sb.append(String.format(" @ExcelProperty(index = %s )\n",index++));
            sb.append(String.format(" public String %s;\n\n",array1[i]));

        }

        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                sb.append(String.format(" @ExcelProperty(index = %s )\n",index++));
                sb.append(String.format(" public String %s;\n\n",array1[i]+array1[j]));
            }
        }

        FileUtils.write2File("./1.txt", sb);
    }
}
