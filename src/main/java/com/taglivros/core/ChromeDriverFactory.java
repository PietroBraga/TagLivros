package com.taglivros.core;

import com.taglivros.support.Propriedades;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class ChromeDriverFactory implements IWebDriver {
    private ChromeOptions options;

    private void setOptions(){
        options = new ChromeOptions();
        options.addArguments("--start-maximized");
    }

    public WebDriver createWebDriver() throws Exception {
        setPath();
        setOptions();
        return new ChromeDriver(options);
    }

    private void setPath() {
        if (SystemUtils.IS_OS_WINDOWS){
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        }
        else if (SystemUtils.IS_OS_LINUX){
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver");
        }
    }

    public WebDriver createMobileWebDriver() throws Exception {
        setOptions();
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Nexus 5");
        options.setExperimentalOption("mobileEmulation", mobileEmulation);
        return new ChromeDriver(options);
    }
}
