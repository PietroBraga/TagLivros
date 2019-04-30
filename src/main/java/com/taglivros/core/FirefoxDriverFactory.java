package com.taglivros.core;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverFactory implements IWebDriver {
    private void setPath() {
        if (SystemUtils.IS_OS_WINDOWS){
            System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
        }
        else if (SystemUtils.IS_OS_LINUX){
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        }
    }

    public WebDriver createWebDriver() throws Exception {
        setPath();
        return new FirefoxDriver();
    }
}
