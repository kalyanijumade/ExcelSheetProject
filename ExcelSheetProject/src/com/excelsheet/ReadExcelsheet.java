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

	/**
	 * Code need to complete by creating the new Class and putting class in ArrayList
	 * Task To-do
	 * Create Object where we need to store the value of Entity - Employee/Student/Anything
	 * create ArrayList and store mutliple Object in ArrayList
	 *
	 */
	for(int i=1; i< sheet.getRows(); i++){
		Cell[] cellArray = sheet.getRow(i);
		System.out.println("Cell 0: " +cellArray[0].getContents());
		//skObj.setSrNo(cellArray[0].getContents());
		System.out.println("Cell 1: " +cellArray[1].getContents());
		System.out.println("Cell 2: " +cellArray[2].getContents());
		System.out.println("Cell 3: " +cellArray[3].getContents());
		System.out.println("Cell 4: " +cellArray[4].getContents());
		System.out.println("Cell 5: " +cellArray[5].getContents());
		System.out.println("Cell 6: " +cellArray[6].getContents());
		System.out.println("Cell 7: " +cellArray[7].getContents());

		System.out.println("========================================");
		for(Cell cell: cellArray){
			System.out.print(cell.getContents() + "------");



		}
		System.out.println();

	}

	/*End of the code*/


}
}
