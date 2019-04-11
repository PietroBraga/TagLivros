package com.taglivros.core;

import com.taglivros.support.Propriedades;
import org.openqa.selenium.WebDriver;

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
        return driver;
    }

    public static WebDriver getMobileDriver() throws Exception{
        return new ChromeDriverFactory().createMobileWebDriver();
    }
}
