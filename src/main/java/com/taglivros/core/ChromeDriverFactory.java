package com.taglivros.core;

import com.taglivros.support.Propriedades;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class ChromeDriverFactory implements IWebDriver {
    private ChromeOptions options;

    private void setOptions() throws Exception{
        options = new ChromeOptions();
        options.addArguments("--start-maximized");
    }

    public WebDriver createWebDriver() throws Exception {
        setOptions();
        return new ChromeDriver(options);
    }

    public WebDriver createMobileWebDriver() throws Exception {
        setOptions();
        Map<String, String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName", "Nexus 5");
        options.setExperimentalOption("mobileEmulation", mobileEmulation);
        return new ChromeDriver(options);
    }
}
