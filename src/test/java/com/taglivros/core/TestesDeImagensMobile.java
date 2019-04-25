package com.taglivros.core;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class TestesDeImagensMobile {
    WebDriver driver;

    @Test
    public void imagensMobileEstaoSendoExibidas(){
        driver.get("http://taglivros.com");
        List<WebElement> images = driver.findElements(By.tagName("picture"));

        HashMap<String, Boolean> result = new HashMap<String, Boolean>();
        for (WebElement image : images){
            result.put(image.getAttribute("innerHTML"), image.isDisplayed());
        }

        int i = 1;
    }


    @Before
    public void doBefore(){
        try {
            driver = TagDriver.getMobileDriver();
        }
        catch (Exception e){
            System.out.println("Ops, algo deu errado ao iniciar o WebDriver Mobile");
        }

    }

    @After
    public void doAfter(){
        if (driver != null)
        {
            driver.close();
            driver.quit();
        }
    }

}
