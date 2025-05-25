package com.orange.hrm.application.pageComponent;

import org.openqa.selenium.By;

public class LoginPageComponent
{
protected static final By InputUserName 	   = By.xpath("//input[@name='username']");
protected static final By InputPassword 	   = By.xpath("//input[@name='password']");
protected static final By LinkForgotPassword = By.xpath("//*[text()='Forgot your password? ']");
protected static final By ButtonLogin 	   = By.xpath("//button[@type='submit']");
}
