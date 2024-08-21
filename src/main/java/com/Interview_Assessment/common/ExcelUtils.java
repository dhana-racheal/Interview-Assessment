package com.Interview_Assessment.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static String readExcelData(String filePath, String sheetName, int rowNum, int cellNum) {
		File f = new File(filePath);
		
		FileInputStream fis;
		Workbook wb = null;
		try {
			fis = new FileInputStream(f);
			wb = new XSSFWorkbook(fis);
			Cell cell = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum);
			if (cell.getCellType().equals(CellType.STRING)) {
				String value = cell.getStringCellValue();
				wb.close();
				return value;

			} else if (cell.getCellType().equals(CellType.NUMERIC)) {
				wb.close();
				return Double.toString(cell.getNumericCellValue());
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}
	
	public static List<String> readAllExcelData(String filePath,String sheetName) throws InterruptedException, IOException{
File f = new File(filePath);
		
		FileInputStream fis;
		Workbook wb = null;
		List<String> arrList = null;
		
		try {
			fis = new FileInputStream(f);
			wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet(sheetName);
		    int rowcount = sheet.getLastRowNum()- sheet.getFirstRowNum();
		    for(int i=1; i<rowcount+1; i++){
		        Row row = sheet.getRow(i);
		        arrList = new ArrayList<>();
		        for(int j=0; j<row.getLastCellNum(); j++){
		            Cell cell = row.getCell(j);
		            arrList.add(cell.getStringCellValue());
		            }
//		        Iterator<String> itr = arrName.iterator();
//		        while(itr.hasNext()){
//		            System.out.println("arrayList values: "+itr.next());
//		        }
		        }

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return arrList;
	    

	}

	
}
