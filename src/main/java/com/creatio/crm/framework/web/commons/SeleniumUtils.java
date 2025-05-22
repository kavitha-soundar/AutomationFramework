package com.creatio.crm.framework.web.commons;

import com.creatio.crm.framework.web.constants.FrameworkConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.creatio.crm.framework.driver.DriverManager.getDriver;

public class SeleniumUtils {
    private static WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(FrameworkConstants.getWaitTime()));
    private JavascriptExecutor js = (JavascriptExecutor) getDriver();
    private Actions action = new Actions(getDriver());

    private SeleniumUtils() {
    }

    public static void waitForElementPresence(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitForElementToBeClickable(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitForElementToBeVisible(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementToBeInvisible(By by) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static void waitForElementToBeSelected(By by) {
        wait.until(ExpectedConditions.elementToBeSelected(by));
    }

    public static Boolean waitForAlertIsPresent() {
        return wait.until(ExpectedConditions.alertIsPresent()) != null;
    }

    public static void WaitForFrameIsPresent(By by) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
    }

    public static void waitAndClick(By by) {
        waitForElementToBeClickable(by);
        getDriver().findElement(by).click();
    }

    public void clickElementByJSScript(By by) {
        js.executeScript("arguments[0].scrollIntoView()", getDriver().findElement(by));
        js.executeScript("arguments[0].click()", getDriver().findElement(by));
    }

    public static void waitAndSendKeys(By by, String text) {
        waitForElementToBeClickable(by);
        getDriver().findElement(by).sendKeys(text);
    }

    public void getHistoryByJSScript(WebElement element) {

    }

    public String getURLByJSScript() {
        return js.executeScript("return document.URL;").toString();
    }

    public String getDomainNameByJSScript() {
        return js.executeScript("return document.domain;").toString();
    }

    public String getTitleByJSScript() {
        return js.executeScript("return document.title;").toString();
    }

    public void refreshWebPage() {
        getDriver().navigate().refresh();
    }

    public void refreshBrowserWindowByJSScript() {
        js.executeScript("location.reload();");
        //  js.executeScript("history.go(0)");

    }

    public String getInnerTextOfWebPage() {
        return js.executeScript("return document.innerText();").toString();
    }

    public void scrollThePageWithPixelsByJSScript(int x, int y) {
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    public String getHeightWebPageByJSScript() {
        return js.executeScript("return window.innerHeight;").toString();
    }

    public String getWidthWebPageByJSScript() {
        return js.executeScript("return window.innerWidth;").toString();
    }

    public void loadTheWebPage(String url) {
        getDriver().get(url);
    }

    public void navigateToWebPage(String url) {
        getDriver().navigate().to(url);
    }

    public void navigateToPreviousPage() {
        getDriver().navigate().back();
    }

    public void navigateToNextPage() {
        getDriver().navigate().forward();
    }


    public String getWindowHandle() {
        return getDriver().getWindowHandle();
    }

    public Set<String> getWindowHandles() {
        return getDriver().getWindowHandles();
    }

    public void moveToPartiularWindow(String window) {
        Set<String> windows = new HashSet<String>();
        windows = getDriver().getWindowHandles();

        for (String webpage : windows) {
            if (webpage.equals(window)) {
                getDriver().navigate().to(window);
            }
        }
    }
    // ADFC153394 manasa d employee id

    public void clickByActionMovement(WebElement element) {
        action.scrollToElement(element).build().perform();
        action.moveToElement(element).click().perform();
    }

    public void clickByAction(WebElement element) {
        action.scrollToElement(element).build().perform();
        action.click(element).perform();
    }

    public void doubleClick(WebElement element) {
        action.scrollToElement(element).build().perform();
        action.doubleClick(element).build().perform();
    }

    public void typeTextByAction(WebElement element, String data) {
        action.sendKeys(element, data).build().perform();
    }

    public void dragAndDropElementByHold(WebElement source, WebElement destination) {
        action.moveToElement(source).clickAndHold().moveToElement(destination).release().perform();
    }

    public void dragAndDropElement(WebElement source, WebElement destination) {
        action.dragAndDrop(source, destination).perform();
    }

    public void rightClick() {
        action.contextClick();
    }

    public void rightClickTheElement(WebElement element) {
        action.contextClick(element);
    }

    public void selectBy(WebElement element, String selection, String data) {
        Select option = new Select(element);
        if (selection.equalsIgnoreCase("text")) {
            option.selectByVisibleText(data);
        } else if (selection.contains("text")) {
            option.selectByContainsVisibleText(data);
        } else if (selection.equalsIgnoreCase("value")) {
            option.selectByValue(data);
        } else if (selection.equalsIgnoreCase("index")) {
            option.selectByIndex(Integer.parseInt(data));
        }
    }

    public void deselectBy(WebElement element, String selection, String data) {
        Select option = new Select(element);
        if (selection.equalsIgnoreCase("text")) {
            option.deselectByVisibleText(data);
        } else if (selection.equalsIgnoreCase("value")) {
            option.deselectByValue(data);
        } else if (selection.contains("text")) {
            option.deSelectByContainsVisibleText(data);
        } else if (selection.equalsIgnoreCase("index")) {
            option.deselectByIndex(Integer.parseInt(data));
        }
    }

    public void deselectAll(WebElement element) {
        Select option = new Select(element);
        option.deselectAll();
    }

    public List<WebElement> getAllSelectedOptions(WebElement element) {
        Select option = new Select(element);
        List<WebElement> selectedOption = option.getAllSelectedOptions();
        return selectedOption;
    }

    public boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }

    public boolean isSelected(WebElement element) {
        return element.isSelected();
    }

    public void submit(WebElement element) {
        element.submit();
    }

    public String getAttributeValue(WebElement element, String attribute) {
        return element.getDomAttribute(attribute);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public boolean isMultiDropDown(WebElement element) {
        Select option = new Select(element);
        return option.isMultiple();
    }

    public String getSelectedOptionText(WebElement element) {
        Select option = new Select(element);
        return option.getFirstSelectedOption().getText();
    }

    public void getAllAvailableOptionsText(WebElement element) {
        Select option = new Select(element);
        List<WebElement> availableOptions = option.getOptions();

        for (WebElement ele : availableOptions) {
            System.out.println(ele.getText());
        }
    }

    public String getCurrentURL() {
        return getDriver().getCurrentUrl();
    }

    public void pressArrowUpAction(WebElement element) {
        action.sendKeys(Keys.ARROW_UP).build().perform();
    }

    public void pressArrowDownAction(WebElement element) {
        action.sendKeys(Keys.ARROW_DOWN).build().perform();
    }

    public void closeBrowser() {
        getDriver().close();
    }

    public Dimension getWindowSize() {
        return getDriver().manage().window().getSize();
    }

    public void setWindowSize(int x, int y) {
        Dimension value = new Dimension(x, y);
        getDriver().manage().window().setSize(value);
    }

    public void switchWindow(String win) {
        getDriver().switchTo().window(win);
    }

    public void switchFrameByIndex(int index) {
        getDriver().switchTo().frame(index);
    }

    public void switchFrameByText(String value) {
        getDriver().switchTo().frame(value);
    }

    public void switchFrameByElement(WebElement element) {
        getDriver().switchTo().frame(element);
    }

    public void switchToParentFrame() {
        getDriver().switchTo().parentFrame();
    }

    public void switchToDefaultWindow() {
        getDriver().switchTo().defaultContent();
    }

    public void launchNewTabInCurrentWindow() {
        getDriver().switchTo().newWindow(WindowType.TAB);
    }

    public void launchNewWindow() {
        getDriver().switchTo().newWindow(WindowType.WINDOW);
    }

    public void acceptAlert() {
        waitForAlertIsPresent();
        Alert alert = getDriver().switchTo().alert();
        alert.accept();

    }

    public void dismissAlert() {
        waitForAlertIsPresent();
        Alert alert = getDriver().switchTo().alert();
        alert.dismiss();
    }

    public void typeTextInAlert(String value) {
        waitForAlertIsPresent();
        Alert alert = getDriver().switchTo().alert();
        alert.sendKeys(value);
    }

    public String getTextFromAlert() {
        waitForAlertIsPresent();
        Alert alert = getDriver().switchTo().alert();
        return alert.getText();
    }


}
