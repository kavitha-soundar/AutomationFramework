package com.creatio.crm.framework.utilities;

import org.openqa.selenium.By;

public class DynamicXpathUtils {

    public static By getXpath(String locator, String content){
       return  By.xpath(locator.replace("%replaceable",content));
    }

    public static By getXpath(String locator, String content,String content2){
        return  By.xpath(locator.replace("%replaceable",content).replace("%replaceString",content2));
    }

}
