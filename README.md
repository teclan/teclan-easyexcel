## Excel 读写工具

- 读 Excel
```java

public class ReadTest {

	String fileName = "E:\\Codes\\openSource\\teclan-easyexcel\\excel\\数据收集.xlsx";

	@Test
	public void read() {
		String[] header = new String[] { "合同号", "利率模式", "浮动周期", "对年对月周期", "合同原执行利率", "合同LPR基准", "合同BP点数", "借据号",
				"借据原执行利率", "借据LPR基准", "借据点数" };
		ExcelHandler excelHandler = new DefaultExcelHandler(fileName);
		excelHandler.read(OutLineLpr.class,new DefaultAnalysisEventListener(new DefaultExcelAnalysisHandler(header)));
	}
}

```

- 写 Excel

```java

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
```