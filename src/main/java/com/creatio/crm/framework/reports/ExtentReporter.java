package com.creatio.crm.framework.reports;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.creatio.crm.framework.web.constants.FrameworkConstants;

public class ExtentReporter {
    public static ExtentSparkReporter html = null;
    public static ExtentReports extent = null;
    public static ExtentTest logger = null;

    @BeforeSuite(alwaysRun = true)
    public static void setupReport() {
        DateFormat dateFormat = new SimpleDateFormat("dd_mm_yyyy:hh_mm_ss");
        Date date = new Date();
        String ExtentReportName = FrameworkConstants.getReportsLocation() + dateFormat.format(date) + FrameworkConstants.getReportName();
        html = new ExtentSparkReporter(ExtentReportName);
        extent = new ExtentReports();
        extent.attachReporter(html);
        extent.setSystemInfo("Environment", "PROD");
        extent.setSystemInfo("Host Name", FrameworkConstants.getUserName());
    }

    public static void startReporting(String testName) {
        logger = extent.createTest(testName);
        logger.info(testName + " execution started successfully");
    }

    public static void stopReporting() {
        extent.flush();
    }

    public static void log(String status, String message) {
        if (status.equalsIgnoreCase("pass")) {
            logger.pass(message);
        } else if (status.equalsIgnoreCase("fail")) {
            logger.fail(message);
        } else if (status.equalsIgnoreCase("warning")) {
            logger.warning(message);
        } else if (status.equalsIgnoreCase("info")) {
            logger.info(message);
        } else if (status.equalsIgnoreCase("skip")) {
            logger.skip(message);
        }
    }

    public static void attachScreenshot(WebDriver driver, String screenshotName) {
        logger.addScreenCaptureFromPath(takeScreenshot(driver, screenshotName));
    }

    public static String takeScreenshot(WebDriver driver, String methodName) {
        DateFormat dateFormat = new SimpleDateFormat("dd_mm_yyyy:hh_mm_ss");
        Date date = new Date();
        String destFileName = System.getProperty("user.dir") + "//Screenshots//" + methodName + "-" + dateFormat.format(date) + ".png";
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File(destFileName);
            FileUtils.copyFile(scrFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destFileName;
    }

}
