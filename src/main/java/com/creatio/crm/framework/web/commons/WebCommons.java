package com.creatio.crm.framework.web.commons;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.creatio.crm.framework.base.BasePage;

public class WebCommons
{

	public WebDriver driver = new BasePage().getDriver();
	private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	private JavascriptExecutor js = (JavascriptExecutor) driver;
	private Actions action = new Actions(driver);

	public void clickElement(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	public void clickElementByJSScript(WebElement element)
	{
		js.executeScript("arguments[0].scrollIntoView()", element);
		js.executeScript("arguments[0].click()", element);
	}

	public void getHistoryByJSScript(WebElement element)
	{

	}
	
	public String getURLByJSScript()
	{
		return js.executeScript("return document.URL;").toString();
	}
	
	public String getDomainNameByJSScript()
	{
		return js.executeScript("return document.domain;").toString();
	}
	
	public String getTitleByJSScript()
	{
		return js.executeScript("return document.title;").toString();
	}

	public void refreshWebPage()
	{
		driver.navigate().refresh();
	}

	public void refreshBrowserWindowByJSScript()
	{
		js.executeScript("location.reload();");
	//  js.executeScript("history.go(0)");
		
	}
	
	public String getInnerTextOfWebPage()
	{
		return js.executeScript("return document.innerText();").toString();
	}
	
	public void scrollThePageWithPixelsByJSScript(int x,int y)
	{
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	public  String getHeightWebPageByJSScript()
	{
		return js.executeScript("return window.innerHeight;").toString();
	}
	
	public String getWidthWebPageByJSScript()
	{
		return js.executeScript("return window.innerWidth;").toString();
	}
	public void loadTheWebPage(String url)
	{
		driver.get(url);
	}
	
	public void navigateToWebPage(String url)
	{
		driver.navigate().to(url);
	}

	public void navigateToPreviousPage()
	{
		driver.navigate().back();
	}

	public void navigateToNextPage()
	{
		driver.navigate().forward();
	}

	
	public String getWindowHandle()
	{
		return driver.getWindowHandle();
	}

	public Set<String> getWindowHandles()
	{
		return driver.getWindowHandles();
	}

	public void moveToPartiularWindow(String window)
	{
		Set<String> windows = new HashSet<String>();
		windows = driver.getWindowHandles();

		for (String webpage : windows)
		{
			if (webpage.equals(window))
			{
				driver.navigate().to(window);
			}
		}
	}
	// ADFC153394 manasa d employee id

	public void clickByActionMovement(WebElement element)
	{
		action.scrollToElement(element).build().perform();
		action.moveToElement(element).click().perform();
	}

	public void clickByAction(WebElement element)
	{
		action.scrollToElement(element).build().perform();
		action.click(element).perform();
	}

	public void doubleClick(WebElement element)
	{
		action.scrollToElement(element).build().perform();
		action.doubleClick(element).build().perform();
	}

	public void typeTextByAction(WebElement element, String data)
	{
		action.sendKeys(element, data).build().perform();
	}

	public void dragAndDropElementByHold(WebElement source, WebElement destination)
	{
		action.moveToElement(source).clickAndHold().moveToElement(destination).release().perform();
	}

	public void dragAndDropElement(WebElement source, WebElement destination)
	{
		action.dragAndDrop(source, destination).perform();
	}

	public void rightClick()
	{
		action.contextClick();
	}

	public void rightClickTheElement(WebElement element)
	{
		action.contextClick(element);
	}

	public void selectBy(WebElement element, String selection, String data)
	{
		Select option = new Select(element);
		if (selection.equalsIgnoreCase("text"))
		{
			option.selectByVisibleText(data);
		} else if (selection.contains("text"))
		{
			option.selectByContainsVisibleText(data);
		} else if (selection.equalsIgnoreCase("value"))
		{
			option.selectByValue(data);
		} else if (selection.equalsIgnoreCase("index"))
		{
			option.selectByIndex(Integer.parseInt(data));
		}
	}

	public void deselectBy(WebElement element, String selection, String data)
	{
		Select option = new Select(element);
		if (selection.equalsIgnoreCase("text"))
		{
			option.deselectByVisibleText(data);
		} else if (selection.equalsIgnoreCase("value"))
		{
			option.deselectByValue(data);
		} else if (selection.contains("text"))
		{
			option.deSelectByContainsVisibleText(data);
		} else if (selection.equalsIgnoreCase("index"))
		{
			option.deselectByIndex(Integer.parseInt(data));
		}
	}

	public void deselectAll(WebElement element)
	{
		Select option = new Select(element);
		option.deselectAll();
	}

	public List<WebElement> getAllSelectedOptions(WebElement element)
	{
		Select option = new Select(element);
		List<WebElement> selectedOption = option.getAllSelectedOptions();
		return selectedOption;
	}

	public boolean isDisplayed(WebElement element)
	{
		return element.isDisplayed();
	}

	public boolean isEnabled(WebElement element)
	{
		return element.isEnabled();
	}

	public boolean isSelected(WebElement element)
	{
		return element.isSelected();
	}

	public void submit(WebElement element)
	{
		element.submit();
	}

	public String getAttributeValue(WebElement element, String attribute)
	{
		return element.getDomAttribute(attribute);
	}

	public String getText(WebElement element)
	{
		return element.getText();
	}

	public boolean isMultiDropDown(WebElement element)
	{
		Select option = new Select(element);
		return option.isMultiple();
	}

	public String getSelectedOptionText(WebElement element)
	{
		Select option = new Select(element);
		return option.getFirstSelectedOption().getText();
	}

	public void getAllAvailableOptionsText(WebElement element)
	{
		Select option = new Select(element);
		List<WebElement> availableOptions = option.getOptions();

		for (WebElement ele : availableOptions)
		{
			System.out.println(ele.getText());
		}
	}

	public String getCurrentURL()
	{
		return driver.getCurrentUrl();
	}

	public void pressArrowUpAction(WebElement element)
	{
		action.sendKeys(Keys.ARROW_UP).build().perform();
	}

	public void pressArrowDownAction(WebElement element)
	{
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
	}

	public void closeBrowser()
	{
		driver.close();
	}

	public Dimension getWindowSize()
	{
		return driver.manage().window().getSize();
	}

	public void setWindowSize(int x, int y)
	{
		Dimension value = new Dimension(x, y);
		driver.manage().window().setSize(value);
	}

	public void switchWindow(String win)
	{
		driver.switchTo().window(win);
	}

	public void switchFrameByIndex(int index)
	{
		driver.switchTo().frame(index);
	}

	public void switchFrameByText(String value)
	{
		driver.switchTo().frame(value);
	}

	public void switchFrameByElement(WebElement element)
	{
		driver.switchTo().frame(element);
	}

	public void switchToParentFrame()
	{
		driver.switchTo().parentFrame();
	}

	public void switchToDefaultWindow()
	{
		driver.switchTo().defaultContent();
	}

	public void launchNewTabInCurrentWindow()
	{
		driver.switchTo().newWindow(WindowType.TAB);
	}

	public void launchNewWindow()
	{
		driver.switchTo().newWindow(WindowType.WINDOW);
	}

	public void acceptAlert()
	{
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	public void dismissAlert()
	{
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public void typeTextInAlert(String value)
	{
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}

	public String getTextFromAlert()
	{
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	

	public void fileUpload(WebElement element, String filename)
	{
		element.sendKeys(filename);
	}

}
