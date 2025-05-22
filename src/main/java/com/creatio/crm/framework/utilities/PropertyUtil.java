package com.creatio.crm.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.creatio.crm.framework.web.constants.FrameworkConstants;

public class PropertyUtil
{
	public static Properties ReadPropertyFile(String filename)
	{
		Properties prop = new Properties();
		try
		{
			FileInputStream file = new FileInputStream(FrameworkConstants.getPropertyLocation() + filename);
			prop.load(file);
		} catch (FileNotFoundException e)
		{
			e.getStackTrace();
		}
		catch(IOException e)
		{
			e.getStackTrace();
		}
		return prop;
	}

	public static String ReadPropertyData(Properties prop, String key)
	{
		String value = prop.getProperty(key);
		return value;
	}
}
