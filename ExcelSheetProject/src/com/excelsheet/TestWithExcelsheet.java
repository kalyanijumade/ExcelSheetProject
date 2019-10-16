package com.excelsheet;

import java.io.File;
import java.io.IOException;

import org.eclipse.jdt.internal.compiler.codegen.ExceptionLabel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestWithExcelsheet {
	
	WebDriver driver ;
	

@BeforeTest
public void open_Browser() {
	driver =new FirefoxDriver();
	driver.get("file:///D:/Selenium%20Software/Offline%20Website/pages/examples/users.html");
}
	
  @Test(priority =1)
  public void actual_Sheet() throws BiffException, IOException {
	  File file1 = new File("D:\\Selenium Software\\excelsheet\\actualsheet.xls");
		
		Workbook workbook1 = Workbook.getWorkbook(file1);
		
		Sheet sheet = workbook1.getSheet(0);
		
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
  
  
@Test(priority =2)
public void expect_Sheet() throws BiffException, IOException{
File file2 = new File("D:\\\\Selenium Software\\\\excelsheet\\\\expectedsheet.xls");
	
	Workbook workbook2 = Workbook.getWorkbook(file2);
	
	Sheet sheet = workbook2.getSheet(0);
	
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
	

@Test(priority=3)
public boolean check_Actualsheet_with_Expectsheet(String filepath1, String filepath2) {
	boolean result =false;
	Excel.Applicatio excel = new Excel.Application();
	
	//Open files to compare
	Excel.Workbook workbook1 = excel.Workbooks.Open("D:\\Selenium Software\\excelsheet\\actualsheet.xls");
    Excel.Workbook workbook2 = excel.Workbooks.Open("D:\\\\Selenium Software\\\\excelsheet\\\\expectedsheet.xls");

    
    //Open sheets to grab values from
    Excel.Worksheet worksheet1 = (Excel.Worksheet)workbook1.Sheets[0];
    Excel.Worksheet worksheet2 = (Excel.Worksheet)workbook2.Sheets[0];

    //Get the used range of cells
    Excel.Range range = worksheet2.UsedRange;
    int maxColumns = range.Columns.Count;
    int maxRows = range.Rows.Count;

    //Check that each cell matches
    for (int i = 1; i <= maxColumns; i++)
    {
        for (int j = 1; j <= maxRows; j++)
        {
            if (worksheet1.Cells[j, i].Value == worksheet2.Cells[j, i].Value)
            {
                result = true;
            }
            else
                result = false;
        }
    }

  //Close the workbooks
    GC.Collect();
    GC.WaitForPendingFinalizers();
    Marshal.ReleaseComObject(range);
    Marshal.ReleaseComObject(worksheet1);
    Marshal.ReleaseComObject(worksheet2);
    workbook1.Close();
    workbook2.Close();
    excel.Quit();
    Marshal.ReleaseComObject(excel);

    //Tell us if it is true or false
    return result;
	return false;
	
}


  
}
