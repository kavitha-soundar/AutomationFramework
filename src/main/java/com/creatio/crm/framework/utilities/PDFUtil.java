package com.creatio.crm.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.creatio.crm.framework.web.constants.ApplicationConstants;

public class PDFUtil
{
	public static String ReadPDFFile(String filename)
	{
		String pdfFileData = null;
		String fileNameValue = ApplicationConstants.FilesLocation + filename;
		try
		{
			FileInputStream file = new FileInputStream(fileNameValue);
			PDDocument doc = PDDocument.load(file);
			PDFTextStripper textStrip = new PDFTextStripper();
			pdfFileData = textStrip.getText(doc);
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return pdfFileData;
	}
}
