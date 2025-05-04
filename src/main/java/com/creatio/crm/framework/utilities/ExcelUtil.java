package com.creatio.crm.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.creatio.crm.framework.web.constants.ApplicationConstants;

public class ExcelUtil
{
	public static List<Map<String, String>> readDataUsingSheetName(String fileName, String sheetName)
	{
		List<Map<String, String>> excelData = new ArrayList<Map<String, String>>();
		try
		{
			FileInputStream file = new FileInputStream(ApplicationConstants.ExcelFileLocation + fileName);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int totalRows = sheet.getPhysicalNumberOfRows();
			int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();

			for (int row = 1; row <= totalRows; row++)
			{
				Map<String, String> cellData = new HashMap<String, String>();
				for (int col = 0; col <= totalColumns; col++)
				{
					String columnName = sheet.getRow(0).getCell(col).getStringCellValue();
					String columnValue = null;
					if (sheet.getRow(row).getCell(col).getCellType() == CellType.STRING)
					{
						columnValue = sheet.getRow(row).getCell(col).getStringCellValue();
					} else if (sheet.getRow(row).getCell(col).getCellType() == CellType.NUMERIC)
					{
						columnValue = String.valueOf(sheet.getRow(row).getCell(col).getNumericCellValue());
					} else if (sheet.getRow(row).getCell(col).getCellType() == CellType.BOOLEAN)
					{
						columnValue = String.valueOf(sheet.getRow(row).getCell(col).getBooleanCellValue());
					}
					cellData.put(columnName, columnValue);
				}
				excelData.add(cellData);
			}
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return excelData;
	}
	
	public static List<Map<String, String>> readDataUsingSheetIndex(String fileName, String sheetName)
	{
		List<Map<String, String>> excelData = new ArrayList<Map<String, String>>();
		try
		{
			FileInputStream file = new FileInputStream(ApplicationConstants.ExcelFileLocation + fileName);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			
			int TotalSheet = workbook.getNumberOfSheets();
			XSSFSheet sheet = null;
			for(int i=1 ;i<=TotalSheet;i++)
			{
				if(workbook.getSheetAt(i).getSheetName().equalsIgnoreCase(sheetName))
				{
					sheet =  workbook.getSheetAt(i);
				}
			}
			int totalRows = sheet.getPhysicalNumberOfRows();
			int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();

			for (int row = 1; row <= totalRows; row++)
			{
				Map<String, String> cellData = new HashMap<String, String>();
				for (int col = 0; col <= totalColumns; col++)
				{
					String columnName = sheet.getRow(0).getCell(col).getStringCellValue();
					String columnValue = null;
					if (sheet.getRow(row).getCell(col).getCellType() == CellType.STRING)
					{
						columnValue = sheet.getRow(row).getCell(col).getStringCellValue();
					} else if (sheet.getRow(row).getCell(col).getCellType() == CellType.NUMERIC)
					{
						columnValue = String.valueOf(sheet.getRow(row).getCell(col).getNumericCellValue());
					} else if (sheet.getRow(row).getCell(col).getCellType() == CellType.BOOLEAN)
					{
						columnValue = String.valueOf(sheet.getRow(row).getCell(col).getBooleanCellValue());
					}
					cellData.put(columnName, columnValue);
				}
				excelData.add(cellData);
			}
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return excelData;
	}
	
	public static void writeDataUsingSheetName(String fileName, String sheetName)
	{
		try
		{
		FileInputStream file = new FileInputStream(ApplicationConstants.ExcelFileLocation + fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
