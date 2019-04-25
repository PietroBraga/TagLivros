package com.taglivros.core;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.rmi.server.ExportException;

import static org.junit.Assert.*;

public class TagDriverTest {

    private WebDriver driver;
    private static JavascriptExecutor js;

    @Test
    public void loadTime_Is_Less_Than_15_Sec() throws Exception {
        driver.get("http://taglivros.com.br");
        // time of the process of navigation and page load
        double loadTime = (Double) js.executeScript(
                "return (window.performance.timing.domComplete - window.performance.timing.navigationStart) / 1000");
        System.out.print(loadTime + " seconds");
    }

    @Before
    public void initializeDriver() throws Exception{
        driver = TagDriver.getDriver();
        js = (JavascriptExecutor) driver;
    }
    @After
    public void CloseDriver(){
        if (driver != null)
        {
            driver.close();
        }
    }
}