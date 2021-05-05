package com.qa.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	
	public static FileInputStream Fileloc;
	public static XSSFWorkbook wbook;
	public static XSSFSheet wsheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	// get row count
	public static int getrowcount(String Xfile, String xsheet) throws IOException {
		
		
		Fileloc = new FileInputStream(Xfile);
		wbook = new XSSFWorkbook(Fileloc);
		wsheet = wbook.getSheet(xsheet);
		int rowcount=wsheet.getLastRowNum();
		wbook.close();
		Fileloc.close();
		
		return rowcount;
		
	}
	
	
	// get cell count in each row
	public static int  getcellcount(String Xfile, String xsheet, int rowNum)throws IOException {
		Fileloc = new FileInputStream(Xfile);
		wbook = new XSSFWorkbook(Fileloc);
		wsheet = wbook.getSheet(xsheet);
		
		row= wsheet.getRow(rowNum);
		
		int cellcount = row.getLastCellNum();
		wbook.close();
		Fileloc.close();
		
		
		return cellcount;
		
	}
	
	
	// get cell data
	public static String  getcellData(String Xfile, String xsheet, int rowNum,int cellNum)throws IOException {
		Fileloc = new FileInputStream(Xfile);
		wbook = new XSSFWorkbook(Fileloc);
		wsheet = wbook.getSheet(xsheet);
		row= wsheet.getRow(rowNum);
		cell= row.getCell(cellNum);
		
		DataFormatter formatter = new DataFormatter();
		String celldata = formatter.formatCellValue(cell);
		wbook.close();
		Fileloc.close();
		
		
		return celldata;
		
	}
}
