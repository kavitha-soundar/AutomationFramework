package com.creatio.crm.framework.reports;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.creatio.crm.framework.web.constants.ApplicationConstants;

public class ExtentReporter
{
	public static ExtentHtmlReporter html = null;
	public static ExtentReports extent = null;
	public static ExtentTest logger = null;

	@BeforeSuite(alwaysRun = true)
	public static void setupReport()
	{
		DateFormat dateFormat = new SimpleDateFormat("dd_mm_yyyy:hh_mm_ss");
		Date date = new Date();
		String ExtentReportName = ApplicationConstants.REPORTS_LOCATION + dateFormat.format(date)
				+ ApplicationConstants.REPORT_NAME;
		html = new ExtentHtmlReporter(ExtentReportName);
		extent = new ExtentReports();
		extent.attachReporter(html);
		extent.setSystemInfo("Enironment", "PROD");
		extent.setSystemInfo("Host Name", ApplicationConstants.USER_NAME);
	}

	public static void startReporting(String testName)
	{
		logger = extent.createTest(testName);
		logger.info(testName + " execution started successfully");
	}

	public static void stopReporting()
	{
		extent.flush();
	}

	public static void log(String status, String message)
	{
		if (status.equalsIgnoreCase("pass"))
		{
			logger.pass(message);
		} else if (status.equalsIgnoreCase("fail"))
		{
			logger.fail(message);
		} else if (status.equalsIgnoreCase("warning"))
		{
			logger.warning(message);
		} else if (status.equalsIgnoreCase("info"))
		{
			logger.info(message);
		} else if (status.equalsIgnoreCase("skip"))
		{
			logger.skip(message);
		}
	}

	public static void attachScreenshot(WebDriver driver, String screenshotName)
	{
		try
		{
			logger.addScreenCaptureFromPath(takeScreenshot(driver, screenshotName));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static String takeScreenshot(WebDriver driver, String methodName)
	{
		DateFormat dateFormat = new SimpleDateFormat("dd_mm_yyyy:hh_mm_ss");
		Date date = new Date();
		String destFileName = System.getProperty("user.dir") + "//Screenshots//" + methodName + "-"
				+ dateFormat.format(date) + ".png";
		try
		{
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File destFile = new File(destFileName);
			FileUtils.copyFile(scrFile, destFile);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return destFileName;
	}

}
