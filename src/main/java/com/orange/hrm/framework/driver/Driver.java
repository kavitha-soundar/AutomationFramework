package com.orange.hrm.framework.driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public class Driver {

    private Driver() {
    }

    protected static void initDriver(String browser) {
        if (Objects.isNull(DriverManager.getDriver())) {
            if (browser.equalsIgnoreCase("chrome")) {
                DriverManager.setDriver(new ChromeDriver());
            } else if (browser.equalsIgnoreCase("firefox")) {
                DriverManager.setDriver(new FirefoxDriver());
            } else if (browser.equalsIgnoreCase("edge")) {
                DriverManager.setDriver(new EdgeDriver());
            }
        }
    }

    protected static void tearDownDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }

}
