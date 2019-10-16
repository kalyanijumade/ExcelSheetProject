package com.excelsheet;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcelsheet {
public static void main(String[] args) throws BiffException, IOException {

	File file = new File("D:\\\\Selenium Software\\\\excelsheet\\\\expectedsheet.xls");
	
	Workbook workbook = Workbook.getWorkbook(file);
	
	Sheet sheet = workbook.getSheet(0);
	
	int rows =sheet.getRows();
	int columns =sheet.getColumns();
	
	for(int i=0;i<rows;i++){
	
	for(int j=0;j<columns;j++) {
	
	
	Cell cell = sheet.getCell(j,i);
	String ss = cell.getContents();
	System.out.print(ss+" ");

			
	}
	System.out.println();
	}
}
}
