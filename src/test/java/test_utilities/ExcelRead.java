package test_utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import framework_test.Com_driver;

public class ExcelRead extends Com_driver{

	public void readexcel() throws IOException {
		
		File f = new File("D:\\Eclipse_Workspace\\Mavencheck\\datafiles\\data.xlsx");
		FileInputStream fis= new FileInputStream(f) ;
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheet("Sheet1");
		int rowcount = sheet.getLastRowNum()+1;
		int columncount = sheet.getRow(0).getLastCellNum();
		
		for(int i=0;i<columncount;i++) {
			
			map.put(format.formatCellValue(sheet.getRow(0).getCell(i)), format.formatCellValue(sheet.getRow(1).getCell(i)));
			//System.out.println(format.formatCellValue(sheet.getRow(0).getCell(i))  +"="+format.formatCellValue(sheet.getRow(1).getCell(i)));
		}
		
	}

public String getmapvalue(String key) throws IOException {
	readexcel();
	return map.get(key);
	
}
}
