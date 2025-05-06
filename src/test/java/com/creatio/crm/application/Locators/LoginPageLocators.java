package com.creatio.crm.application.Locators;

import org.openqa.selenium.By;

import com.creatio.crm.framework.base.BasePage;

public class LoginPageLocators
{
public By InputLogin 				= By.xpath("//input[@aria-label='Business email']]");
public By InputPassword 			= By.xpath("//input[@aria-label='Password']");
public By LinkForgotPassword 		= By.xpath("//a[contains(text(),'Forgot password')]");
public By ButtonLogin 				= By.xpath("//button[@type='button']//span[contains(text(),'LOG IN')]");
}
