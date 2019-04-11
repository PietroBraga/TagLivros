package com.taglivros.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverFactory implements IWebDriver {
    public WebDriver createWebDriver() throws Exception {
        return new FirefoxDriver();
    }
}
