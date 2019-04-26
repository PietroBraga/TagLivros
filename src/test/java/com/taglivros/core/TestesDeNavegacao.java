package com.taglivros.core;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import java.util.logging.Level;
import static org.junit.Assert.*;

public class TestesDeNavegacao {

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

    @Test
    public void paginaNaoContemErrosDeJavaScript() throws Exception{
        driver.get("http://taglivros.com");
        LogEntries entries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : entries){
            if (entry.getLevel().equals(Level.SEVERE))
                System.out.println("\u001B[31m Level: " + entry.getLevel() + " Message: " + entry.getMessage() + "\u001B[0m");
            if (entry.getLevel().equals(Level.WARNING))
                System.out.println("\u001B[33m Level: " + entry.getLevel() + " Message: " + entry.getMessage() + "\u001B[0m");
        }
        assertTrue(!entries.iterator().hasNext());
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