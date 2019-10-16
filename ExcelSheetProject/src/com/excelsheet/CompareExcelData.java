package com.company;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class CompareExcelData {
    private static final String FILE_NAME = "C:\\Personal\\workspace\\Java\\Kalyani\\Book1.xlsx";
    public static void main(String args[]){
        try {

            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            iterator.next();
            List<Employee> employeeList = new ArrayList<>();
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                employeeList.add(assignValue(currentRow));
            }
            List<Employee> employeeList1 = new ArrayList<>(employeeList);
            Collections.sort(employeeList);
            List<Employee> employeeList2 = new ArrayList<>(employeeList);
            for(int i = 0 ; i< employeeList.size(); i++){
                System.out.println("For the "+i+ "value is : " + employeeList.get(i).equals(employeeList1.get(i)));
            }
            System.out.println("==========================================================");
            for(int i = 0 ; i< employeeList.size(); i++){
                System.out.println("For the "+i+ "value is : " + employeeList.get(i).equals(employeeList2.get(i)));
            }

            System.out.println(employeeList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static Employee assignValue(Row row){
        Employee employee = new Employee();
        employee.setSrNo(row.getCell(0).getNumericCellValue());
        employee.setUserName(row.getCell(1).getStringCellValue());
        employee.setEmail(row.getCell(2).getStringCellValue());
        employee.setMobile(row.getCell(3).getNumericCellValue());
        employee.setIsDefault(row.getCell(4).getStringCellValue());
        employee.setGender(row.getCell(5).getStringCellValue());
        employee.setState(row.getCell(6).getStringCellValue());
        employee.setAction(row.getCell(7).getStringCellValue());
        return employee;
    }


}
