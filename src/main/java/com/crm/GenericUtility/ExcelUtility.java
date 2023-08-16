package com.crm.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map.Entry;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtility {
	/**
	 * This method is used to get the data from excel
	 * @author Admin
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Throwable 
	 */
	public String readDataFromExcel(String sheetName,int rowNo, int cellNo) throws Throwable 
	{
		FileInputStream fi = new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fi);
		String value = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}

	/**
	 * This method is used to write date into Excel
	 * @author Admin
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param data
	 * @throws Throwable
	 */

	public void writeDataIntoExcel(String sheetName,int rowNo, int cellNo, String data) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fi);
		wb.getSheet(sheetName).createRow(0).createCell(cellNo).setCellValue(data);

		FileOutputStream fo = new FileOutputStream(IPathConstants.excelPath);
		wb.write(fo);
		wb.close();
	}

	/**
	 * This method is used to get the last row number
	 * @author Admin
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getLastrowNo(String sheetName) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		return count;
	}

	/**
	 * This method is used to get the multiple data from excel
	 * @author Admin
	 * @param sheetName
	 * @param keyColumn
	 * @param valueColumn
	 * @return
	 * @throws Throwable
	 */
	public HashMap<String, String> getMultipleDatafromExcel(String sheetName, int keyColumn, int valueColumn, WebDriver driver) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();

		HashMap<String, String> map = new HashMap<String, String>();
		
		JavaUtility jLib= new JavaUtility();
		for(int i=0; i<=count; i++)
		{
			String key = sh.getRow(i).getCell(keyColumn).getStringCellValue();
			String value = sh.getRow(i).getCell(valueColumn).getStringCellValue();
			map.put(key, value);
		}
		
		for(Entry<String, String> set:map.entrySet())
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+jLib.getRandomNum());
		}
		return map;
	}
	
	public Object[][] getMultipleDataFromDP(String sheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.excelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		int lastRowNum = sheet.getLastRowNum();
		int lastCellNum = sheet.getRow(1).getLastCellNum();
		
		Object[][] obj = new Object[lastRowNum+1][lastCellNum];
		for(int i=0; i<=lastRowNum ; i++)
		{
			for(int j=0; j<lastCellNum; j++)
			{
				obj[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
}
