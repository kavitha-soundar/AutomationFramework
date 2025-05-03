package com.creatio.crm.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.creatio.crm.framework.web.constants.ApplicationConstants;

public class ExcelUtil
{
	public static List<Map<String, String>> readData(String fileName, String sheetName)
	{
		List<Map<String, String>> excelData = new ArrayList<Map<String, String>>();
		try
		{
			FileInputStream file = new FileInputStream(ApplicationConstants.ExcelFileLocation + fileName);

			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int totalRows = sheet.getPhysicalNumberOfRows();

		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		return excelData;
	}
}
