package com.teclan.easyexcel.write;

import com.teclan.easyexcel.Utils.ExcelUtils;
import com.teclan.easyexcel.Utils.FileUtils;
import com.teclan.easyexcel.handler.DefaultExcelHandler;
import com.teclan.easyexcel.handler.ExcelHandler;
import com.teclan.easyexcel.model.ExcelSheetModel;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class WriteTest {

    @Test
    public  void writeSingleSheet() throws IOException {
        String path = "excel/测试写入文件1.xlsx";
        FileUtils.deleteFile(path);

        List<TableModel> datas = new ArrayList<TableModel>();
        for(int i=1;i<=5;i++){
            TableModel tableModel = new TableModel();
            tableModel.setIndex(i);
            tableModel.setTableName("表"+i);
            tableModel.setComments("备注"+i);
            datas.add(tableModel);
        }
        ExcelHandler excelHandler = new DefaultExcelHandler(path);
        excelHandler.writeSingleSheet(path,"表数据1",datas,TableModel.class);
    }


    @Test
    public  void write() throws IOException {
        String path = "excel/测试写入文件2.xlsx";
        FileUtils.deleteFile(path);

        List<TableModel> datas = new ArrayList<TableModel>();
        for(int i=1;i<=5;i++){
            TableModel tableModel = new TableModel();
            tableModel.setIndex(i);
            tableModel.setTableName("表"+i);
            tableModel.setComments("备注"+i);
            datas.add(tableModel);
        }

        ExcelHandler excelHandler = new DefaultExcelHandler(path);
        ExcelSheetModel excelSheetModel3 = new ExcelSheetModel("表3",datas);
        ExcelSheetModel excelSheetModel2 = new ExcelSheetModel("表2",datas);
        ExcelSheetModel excelSheetModel1 = new ExcelSheetModel("表1",datas);
        ExcelSheetModel excelSheetModel4 = new ExcelSheetModel("表4",datas);
        excelHandler.setData(excelSheetModel3,excelSheetModel2,excelSheetModel1,excelSheetModel4);
        excelHandler.write();

    }
}
