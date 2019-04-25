package com.taglivros.core;

import com.taglivros.support.Propriedades;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class TagDriver {

    private static WebDriver driver;

    public static WebDriver getDriver() throws Exception{
        String driverName = Propriedades.obtemPropriedades("webDriver");
        if (driverName.equals("Firefox")){
            driver = new FirefoxDriverFactory().createWebDriver();
        }
        else{
            driver = new ChromeDriverFactory().createWebDriver();
        }
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver getMobileDriver() throws Exception{
        return new ChromeDriverFactory().createMobileWebDriver();
    }
}
