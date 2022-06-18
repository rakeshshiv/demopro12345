package com.crm.genricutilities;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Admin
 *
 */

public class Excelutilities {
	/**
	 * its used to read the data from excel file
	 * @return
	 * @throws Throwable 
	 */
	public String readDataFromExcel(String sheetName,int rowNm,int cellNum) throws Throwable
	{
		FileInputStream fis=new FileInputStream(Ipathconstants.excelpath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNm);
		Cell cell = row.getCell(cellNum);
		
		DataFormatter data =new DataFormatter();
		String value = data.formatCellValue(cell);
		return value;
	}
	/**
	 * 
	 * this method is used to write data into excel
	 */
	public void writeDataIntoExcel(String sheetName,int rowNm,int cellNum,String value) throws Throwable
	{
		FileInputStream fis=new FileInputStream(Ipathconstants.excelpath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNm);
		Cell cell = row.getCell(cellNum);
	    cell.setCellValue(value);
		
}
}
