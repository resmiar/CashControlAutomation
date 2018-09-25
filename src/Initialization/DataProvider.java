package Initialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataProvider {
	
	static String FilePath = (System.getProperty("user.dir")+ "\\TestData.xlsx");
	static FileInputStream fileStream = null;
	static XSSFWorkbook workbook = null;
	static XSSFSheet sheet = null;
	static XSSFRow row = null;
	static XSSFCell cell = null;
	static String valueName, returnValue;
	
	public static String getValueOf(String inputValue)  {
	try {
		fileStream = new FileInputStream(FilePath);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		workbook = new XSSFWorkbook(fileStream);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	sheet = workbook.getSheet("Sheet1");
	valueName = inputValue;
	
	switch(valueName) {
	case ("CCS UserName"):
	{
		row = sheet.getRow(1);
		cell = row.getCell(2);
		returnValue = cell.getStringCellValue();
		break;
	}
	case ("CCS Password"):
	{
		row = sheet.getRow(2);
		cell = row.getCell(2);
		returnValue = cell.getStringCellValue();
		break;
	}
	case ("CC Date"):
	{
		row = sheet.getRow(3);
		cell = row.getCell(2);
		Date dateValue = cell.getDateCellValue();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");     
	    // Using DateFormat format method we can create a string 
	    // representation of a date with the defined format.
	    returnValue = df.format(dateValue);
		break;
	}
	case ("Application URL"):
	{
		row = sheet.getRow(4);
		cell = row.getCell(2);
		returnValue = cell.getStringCellValue();
		break;
	}
	case ("Driver Path"):
	{
		row = sheet.getRow(5);
		cell = row.getCell(2);
		returnValue = cell.getStringCellValue();
		break;
	}
	}
	return returnValue;

	}
	
	}
