package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class DataProvider {

	static String FilePath = (System.getProperty("user.dir")+ "\\TestData.xlsx");
	static FileInputStream fileStream = null;
	static HSSFWorkbook workbook = null;
	static HSSFSheet sheet = null;
	static HSSFRow row = null;
	static HSSFCell cell = null;
	static String valueName, returnValue;
	
	public static String getValueOf(String inputValue)  {
	try {
		fileStream = new FileInputStream(FilePath);
	} catch (FileNotFoundException e) {
	
		e.printStackTrace();
	}
	try {
		workbook = new HSSFWorkbook(fileStream);
	} catch (IOException e) {
		
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
	case ("DB URL"):
	{
		row = sheet.getRow(6);
		cell = row.getCell(2);
		returnValue = cell.getStringCellValue();
		break;
	}
	case ("DB User ID"):
	{
		row = sheet.getRow(7);
		cell = row.getCell(2);
		returnValue = cell.getStringCellValue();
		break;
	}
	case ("DB Password"):
	{
		row = sheet.getRow(8);
		cell = row.getCell(2);
		returnValue = cell.getStringCellValue();
		break;
	}
	case ("AC1 Code"):
	{
		row = sheet.getRow(12);
		cell = row.getCell(3);
		DecimalFormat df = new DecimalFormat("0000");
		//gets the numeric value from the excel file and converts it to a string with 4 characters. For eg: 10 will be converted to "0010"
		returnValue=df.format(cell.getNumericCellValue());
		break;
	}
	
	}
	return returnValue;

	}
	
	
	public static double getWaitTime(String inputValue)  {
		double returnWait = 30;
		try {
			fileStream = new FileInputStream(FilePath);
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		try {
			workbook = new HSSFWorkbook(fileStream);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		sheet = workbook.getSheet("Sheet1");
		valueName = inputValue;
		
		switch(valueName) {
		
		case ("WaitDuration"):
		{
			row = sheet.getRow(14);
			cell = row.getCell(2);
			 returnWait = cell.getNumericCellValue();
			break;
		}
		
		
	}
		return returnWait;
	}
}
