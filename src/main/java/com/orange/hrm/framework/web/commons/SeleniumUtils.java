package com.orange.hrm.framework.web.commons;

import com.orange.hrm.framework.WaitType;
import com.orange.hrm.framework.web.constants.FrameworkConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static com.orange.hrm.framework.driver.DriverManager.getDriver;

public final class SeleniumUtils {
    private static WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(FrameworkConstants.getWaitTime()));
    private static JavascriptExecutor js = (JavascriptExecutor) getDriver();
    private static Actions action = new Actions(getDriver());

    private SeleniumUtils() {
    }

    private static WebElement findElementBy(By by) {
        return getDriver().findElement(by);
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

    public static void waitAndClick(By by, WaitType wait) {
        waitForElementToBeClickable(by);
        if (wait == WaitType.PRESENCE) {
            waitForElementPresence(by);
        } else if (wait == WaitType.CLICKABLE) {
            waitForElementToBeClickable(by);
        } else if (wait == WaitType.VISIBLE) {
            waitForElementToBeVisible(by);
        }
        findElementBy(by).click();
    }

    public static void clickElementByJSScript(By by) {
        js.executeScript("arguments[0].scrollIntoView()", findElementBy(by));
        js.executeScript("arguments[0].click()", findElementBy(by));
    }

    public static void waitAndSendKeys(By by, String text) {
        waitForElementToBeClickable(by);
        findElementBy(by).sendKeys(text);
    }

    public static void getHistoryByJSScript(WebElement element) {

    }

    public static String getURLByJSScript() {
        return js.executeScript("return document.URL;").toString();
    }

    public static String getDomainNameByJSScript() {
        return js.executeScript("return document.domain;").toString();
    }

    public static String getTitleByJSScript() {
        return Objects.requireNonNull(js.executeScript("return document.title;")).toString();
    }

    public static void refreshWebPage() {
        getDriver().navigate().refresh();
    }

    public static void refreshBrowserWindowByJSScript() {
        js.executeScript("location.reload();");
        //  js.executeScript("history.go(0)");

    }

    public static String getInnerTextOfWebPage() {
        return js.executeScript("return document.innerText();").toString();
    }

    public static void scrollThePageWithPixelsByJSScript(int x, int y) {
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    public static String getHeightWebPageByJSScript() {
        return js.executeScript("return window.innerHeight;").toString();
    }

    public static String getWidthWebPageByJSScript() {
        return js.executeScript("return window.innerWidth;").toString();
    }

    public static void loadTheWebPage(String url) {
        getDriver().get(url);
    }

    public static void navigateToWebPage(String url) {
        getDriver().navigate().to(url);
    }

    public static void navigateToPreviousPage() {
        getDriver().navigate().back();
    }

    public static void navigateToNextPage() {
        getDriver().navigate().forward();
    }


    public static String getWindowHandle() {
        return getDriver().getWindowHandle();
    }

    public static Set<String> getWindowHandles() {
        return getDriver().getWindowHandles();
    }

    public static void moveToPartiularWindow(String window) {
        Set<String> windows = new HashSet<String>();
        windows = getDriver().getWindowHandles();

        for (String webpage : windows) {
            if (webpage.equals(window)) {
                getDriver().navigate().to(window);
            }
        }
    }

    public static void clickByActionMovement(By by) {
        WebElement element = findElementBy(by);
        action.scrollToElement(element).build().perform();
        action.moveToElement(element).click().perform();
    }

    public static void clickByAction(By by) {
        WebElement element = findElementBy(by);
        action.scrollToElement(element).build().perform();
        action.click(element).perform();
    }

    public static void doubleClick(By by) {
        WebElement element = findElementBy(by);
        action.scrollToElement(element).build().perform();
        action.doubleClick(element).build().perform();
    }

    public static void typeTextByAction(By by, String data) {
        action.sendKeys(findElementBy(by), data).build().perform();
    }

    public static void dragAndDropElementByHold(By source, By destination) {
        action.moveToElement(findElementBy(source)).clickAndHold().moveToElement(findElementBy(destination)).release().perform();
    }

    public static void dragAndDropElement(By source, By destination) {
        action.dragAndDrop(findElementBy(source), findElementBy(destination)).perform();
    }

    public static void rightClick() {
        action.contextClick().build().perform();
    }

    public static void rightClickTheElement(By by) {
        action.contextClick(findElementBy(by)).build().perform();
    }

    public static void selectBy(By by, String selection, String data) {
        Select option = new Select(findElementBy(by));
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

    public static void deselectBy(By by, String selection, String data) {
        Select option = new Select(findElementBy(by));
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

    public static void deselectAll(By by) {
        Select option = new Select(findElementBy(by));
        option.deselectAll();
    }

    public static List<WebElement> getAllSelectedOptions(By by) {
        Select option = new Select(findElementBy(by));
        return option.getAllSelectedOptions();
    }

    public static boolean isDisplayed(By by) {
        return findElementBy(by).isDisplayed();
    }

    public static boolean isEnabled(By by) {
        return findElementBy(by).isEnabled();
    }

    public static boolean isSelected(By by) {
        return findElementBy(by).isSelected();
    }

    public static void submit(By by) {
        findElementBy(by).submit();
    }

    public static String getAttributeValue(By by, String attribute) {
        return findElementBy(by).getDomAttribute(attribute);
    }

    public static String getText(By by) {
        return findElementBy(by).getText();
    }

    public static boolean isMultiDropDown(By by) {
        Select option = new Select(findElementBy(by));
        return option.isMultiple();
    }

    public static String getSelectedOptionText(By by) {
        Select option = new Select(findElementBy(by));
        return option.getFirstSelectedOption().getText();
    }

    public static void getAllAvailableOptionsText(By by) {
        Select option = new Select(findElementBy(by));
        List<WebElement> availableOptions = option.getOptions();

        for (WebElement ele : availableOptions) {
            System.out.println(ele.getText());
        }
    }

    public static String getCurrentURL() {
        return getDriver().getCurrentUrl();
    }

    public void pressArrowUpAction() {
        action.sendKeys(Keys.ARROW_UP).build().perform();
    }

    public static void pressArrowDownAction() {
        action.sendKeys(Keys.ARROW_DOWN).build().perform();
    }

    public static void closeBrowser() {
        getDriver().close();
    }

    public static Dimension getWindowSize() {
        return getDriver().manage().window().getSize();
    }

    public static void setWindowSize(int x, int y) {
        Dimension value = new Dimension(x, y);
        getDriver().manage().window().setSize(value);
    }

    public static void switchWindow(String win) {
        getDriver().switchTo().window(win);
    }

    public static void switchFrameByIndex(int index) {
        getDriver().switchTo().frame(index);
    }

    public static void switchFrameByText(String value) {
        getDriver().switchTo().frame(value);
    }

    public static void switchFrameByElement(WebElement element) {
        getDriver().switchTo().frame(element);
    }

    public static void switchToParentFrame() {
        getDriver().switchTo().parentFrame();
    }

    public static void switchToDefaultWindow() {
        getDriver().switchTo().defaultContent();
    }

    public static void launchNewTabInCurrentWindow() {
        getDriver().switchTo().newWindow(WindowType.TAB);
    }

    public static void launchNewWindow() {
        getDriver().switchTo().newWindow(WindowType.WINDOW);
    }

    public static void acceptAlert() {
        waitForAlertIsPresent();
        Alert alert = getDriver().switchTo().alert();
        alert.accept();

    }

    public static void dismissAlert() {
        waitForAlertIsPresent();
        Alert alert = getDriver().switchTo().alert();
        alert.dismiss();
    }

    public static void typeTextInAlert(String value) {
        waitForAlertIsPresent();
        Alert alert = getDriver().switchTo().alert();
        alert.sendKeys(value);
    }

    public static String getTextFromAlert() {
        waitForAlertIsPresent();
        Alert alert = getDriver().switchTo().alert();
        return alert.getText();
    }
}
