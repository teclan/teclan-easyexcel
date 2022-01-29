## Excel 读写工具

- 数据收集.xlsx 内如如下

|姓名|性别|单位|职业|
|:---:|:---:|:---:|:---:|
|赵四|男|象牙山村|农民|
|刘大脑袋|男|象牙山庄|职工|



- 读 Excel
``` 
public class ReadTest {

	String fileName = "E:\\Codes\\openSource\\teclan-easyexcel\\excel\\数据收集.xlsx";

	@Test
	public void readError1() {
		String[] header = new String[] {  "性别","姓名", "单位", "职业" }; // 姓名、性别顺序交换
		ExcelHandler excelHandler = new DefaultExcelHandler(fileName);
		excelHandler.read(Person.class,new DefaultAnalysisEventListener(header));
	}
    /************************ 运行结果 ******************************************************************
    09:41:22.276 [main] DEBUG c.a.e.m.property.ExcelHeadProperty - The initialization sheet/table 'ExcelHeadProperty' is complete , head kind is CLASS
    09:41:22.306 [main] DEBUG c.a.e.context.AnalysisContextImpl - Initialization 'AnalysisContextImpl' complete
    09:41:22.452 [main] DEBUG c.a.e.c.s.SimpleReadCacheSelector - Use map cache.size:419
    09:41:22.808 [main] DEBUG c.a.e.m.property.ExcelHeadProperty - The initialization sheet/table 'ExcelHeadProperty' is complete , head kind is CLASS
    09:41:22.809 [main] DEBUG c.a.e.context.AnalysisContextImpl - Began to read：ReadSheetHolder{sheetNo=0, sheetName='Sheet1'} com.alibaba.excel.read.metadata.holder.xlsx.XlsxReadSheetHolder@482cd91f
    09:41:22.923 [main] INFO  c.t.e.l.AbstractAnalysisEventListener - 解析到表头数据:{0:{"dataFormat":0,"dataFormatString":"General","formula":false,"stringValue":"姓名","type":"STRING"},1:{"dataFormat":0,"dataFormatString":"General","formula":false,"stringValue":"性别","type":"STRING"},2:{"dataFormat":0,"dataFormatString":"General","formula":false,"stringValue":"单位","type":"STRING"},3:{"dataFormat":0,"dataFormatString":"General","formula":false,"stringValue":"职业","type":"STRING"}}
    09:41:22.936 [main] ERROR c.t.e.l.AbstractAnalysisEventListener - 
    表头不匹配，位置:0，预期[性别]->实际[姓名]
    09:41:22.988 [main] INFO  c.t.e.l.AbstractAnalysisEventListener - 共处理记录数:0
   *****************************************************************************************************/


	@Test
	public void readError2() {
		String[] header = new String[] { "姓名", "性别", "单位", "职业","备注" }; // 比实际文件多一个 “备注” 字段
		ExcelHandler excelHandler = new DefaultExcelHandler(fileName);
		excelHandler.read(Person.class,new DefaultAnalysisEventListener(header));
	}

   /************************ 运行结果 ******************************************************************
   09:43:14.614 [main] DEBUG c.a.e.m.property.ExcelHeadProperty - The initialization sheet/table 'ExcelHeadProperty' is complete , head kind is CLASS
   09:43:14.639 [main] DEBUG c.a.e.context.AnalysisContextImpl - Initialization 'AnalysisContextImpl' complete
   09:43:14.728 [main] DEBUG c.a.e.c.s.SimpleReadCacheSelector - Use map cache.size:419
   09:43:15.050 [main] DEBUG c.a.e.m.property.ExcelHeadProperty - The initialization sheet/table 'ExcelHeadProperty' is complete , head kind is CLASS
   09:43:15.050 [main] DEBUG c.a.e.context.AnalysisContextImpl - Began to read：ReadSheetHolder{sheetNo=0, sheetName='Sheet1'} com.alibaba.excel.read.metadata.holder.xlsx.XlsxReadSheetHolder@482cd91f
   09:43:15.163 [main] INFO  c.t.e.l.AbstractAnalysisEventListener - 解析到表头数据:{0:{"dataFormat":0,"dataFormatString":"General","formula":false,"stringValue":"姓名","type":"STRING"},1:{"dataFormat":0,"dataFormatString":"General","formula":false,"stringValue":"性别","type":"STRING"},2:{"dataFormat":0,"dataFormatString":"General","formula":false,"stringValue":"单位","type":"STRING"},3:{"dataFormat":0,"dataFormatString":"General","formula":false,"stringValue":"职业","type":"STRING"}}
   09:43:15.164 [main] ERROR c.t.e.l.AbstractAnalysisEventListener - 
   表头不匹配，位置:4，预期[备注]->实际[未找到]
   09:43:15.226 [main] INFO  c.t.e.l.AbstractAnalysisEventListener - 共处理记录数:0
   *****************************************************************************************************/

	@Test
	public void readCorrect1() {
		String[] header = new String[] { "姓名", "性别", "单位", "职业" };
		ExcelHandler excelHandler = new DefaultExcelHandler(fileName);
		excelHandler.read(Person.class,new DefaultAnalysisEventListener(header));
	}

   /************************ 运行结果 ******************************************************************
   09:43:47.479 [main] DEBUG c.a.e.m.property.ExcelHeadProperty - The initialization sheet/table 'ExcelHeadProperty' is complete , head kind is CLASS
   09:43:47.501 [main] DEBUG c.a.e.context.AnalysisContextImpl - Initialization 'AnalysisContextImpl' complete
   09:43:47.586 [main] DEBUG c.a.e.c.s.SimpleReadCacheSelector - Use map cache.size:419
   09:43:47.899 [main] DEBUG c.a.e.m.property.ExcelHeadProperty - The initialization sheet/table 'ExcelHeadProperty' is complete , head kind is CLASS
   09:43:47.900 [main] DEBUG c.a.e.context.AnalysisContextImpl - Began to read：ReadSheetHolder{sheetNo=0, sheetName='Sheet1'} com.alibaba.excel.read.metadata.holder.xlsx.XlsxReadSheetHolder@482cd91f
   09:43:48.018 [main] INFO  c.t.e.l.AbstractAnalysisEventListener - 解析到表头数据:{0:{"dataFormat":0,"dataFormatString":"General","formula":false,"stringValue":"姓名","type":"STRING"},1:{"dataFormat":0,"dataFormatString":"General","formula":false,"stringValue":"性别","type":"STRING"},2:{"dataFormat":0,"dataFormatString":"General","formula":false,"stringValue":"单位","type":"STRING"},3:{"dataFormat":0,"dataFormatString":"General","formula":false,"stringValue":"职业","type":"STRING"}}
   09:43:48.075 [main] INFO  c.t.e.h.AbstractExcelAnalysisHandler - 处理：{"job":"农民","name":"赵四","sex":"男","unit":"象牙山村"}
   09:43:48.078 [main] INFO  c.t.e.h.AbstractExcelAnalysisHandler - 处理：{"job":"职工","name":"刘大脑袋","sex":"男","unit":"象牙山庄"}
   09:43:48.079 [main] INFO  c.t.e.l.AbstractAnalysisEventListener - 共处理记录数:2
   *****************************************************************************************************/

	@Test
	public void readCorrect2() {
		String[] header = new String[] {  "性别","姓名", "单位", "职业" }; // 姓名、性别顺序交换
		ExcelHandler excelHandler = new DefaultExcelHandler(fileName);
		DefaultAnalysisEventListener defaultAnalysisEventListener = new DefaultAnalysisEventListener(header);
		defaultAnalysisEventListener.setStrictMode(false); // 关闭严格模式（取消表头顺序校验）
		excelHandler.read(Person.class,defaultAnalysisEventListener);
	}

   /************************ 运行结果 ******************************************************************
   09:44:15.110 [main] DEBUG c.a.e.m.property.ExcelHeadProperty - The initialization sheet/table 'ExcelHeadProperty' is complete , head kind is CLASS
   09:44:15.135 [main] DEBUG c.a.e.context.AnalysisContextImpl - Initialization 'AnalysisContextImpl' complete
   09:44:15.234 [main] DEBUG c.a.e.c.s.SimpleReadCacheSelector - Use map cache.size:419
   09:44:15.538 [main] DEBUG c.a.e.m.property.ExcelHeadProperty - The initialization sheet/table 'ExcelHeadProperty' is complete , head kind is CLASS
   09:44:15.538 [main] DEBUG c.a.e.context.AnalysisContextImpl - Began to read：ReadSheetHolder{sheetNo=0, sheetName='Sheet1'} com.alibaba.excel.read.metadata.holder.xlsx.XlsxReadSheetHolder@482cd91f
   09:44:15.670 [main] INFO  c.t.e.l.AbstractAnalysisEventListener - 解析到表头数据:{0:{"dataFormat":0,"dataFormatString":"General","formula":false,"stringValue":"姓名","type":"STRING"},1:{"dataFormat":0,"dataFormatString":"General","formula":false,"stringValue":"性别","type":"STRING"},2:{"dataFormat":0,"dataFormatString":"General","formula":false,"stringValue":"单位","type":"STRING"},3:{"dataFormat":0,"dataFormatString":"General","formula":false,"stringValue":"职业","type":"STRING"}}
   09:44:15.670 [main] INFO  c.t.e.l.AbstractAnalysisEventListener - 表头顺序校验未开启...
   09:44:15.729 [main] INFO  c.t.e.h.AbstractExcelAnalysisHandler - 处理：{"job":"农民","name":"赵四","sex":"男","unit":"象牙山村"}
   09:44:15.732 [main] INFO  c.t.e.h.AbstractExcelAnalysisHandler - 处理：{"job":"职工","name":"刘大脑袋","sex":"男","unit":"象牙山庄"}
   09:44:15.732 [main] INFO  c.t.e.l.AbstractAnalysisEventListener - 共处理记录数:2
   *****************************************************************************************************/

}
```

- 写Excel

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