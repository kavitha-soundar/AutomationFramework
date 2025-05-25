package com.orange.hrm.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BasePage {
	
	private static WebDriver driver = null;

	@BeforeMethod
	// @Parameter({"Browser"})
	private void setUpBrowser(String Browser) {
		if (Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (Browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@AfterMethod
	private void tearDownBrowser()
	{
		driver.quit();
	}
	
	public void setDriver(WebDriver driver)
	{
		BasePage.driver = driver;
	}
	
	public WebDriver getDriver()
	{
		return BasePage.driver;
	}
}
