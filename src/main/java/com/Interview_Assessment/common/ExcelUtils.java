package com.Interview_Assessment.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
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

	
}
