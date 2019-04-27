package com.taglivros.core;

import org.apache.commons.lang3.SystemUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class TestesDeImagensDesktop {
    private WebDriver driver;

    @Test
    public void imagensDesktopEstaoSendoExibidas(){
        driver.get("https://taglivros.com/associe-se/escolha-sua-caixinha");
        WebDriverWait wait = new WebDriverWait(driver, 2);

        HashMap<String, Boolean> results = new HashMap<String, Boolean>();

        //Obtem e testa as imagens com a tag picture
        List<WebElement> images = driver.findElements(By.tagName("picture"));
        for (WebElement image : images){
            WebElement source = image.findElement(By.tagName("source"));
            String name = source.getAttribute("srcset");

            if (!name.toLowerCase().contains("mobile")) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", image);
                try {
                    wait.until(ExpectedConditions.visibilityOf(image));
                }
                catch (Exception e){}
                results.put(name.substring(name.lastIndexOf("/") + 1), image.isDisplayed());
            }
        }
        //Obtem e testa as imagens com a tag img
        images = driver.findElements(By.tagName("img"));
        for (WebElement image : images){
            String name = image.getAttribute("src");
            if (name == null){
                name = image.getAttribute("data-src");
            }
            if (name == null){
                name = image.getAttribute("data-lazy-load");
            }
            if (name != null) {
                if ((name.contains(".png") || name.contains(".svg") || name.contains(".jpg")) && !name.contains("mobile")) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", image);
                    try {
                        wait.until(ExpectedConditions.visibilityOf(image));
                    }
                    catch (Exception e){}
                    results.put(name.substring(name.lastIndexOf("/") + 1), image.isDisplayed());
                }
            }
        }
        //imprime os resultados no Console
        for (Map.Entry<String, Boolean> result: results.entrySet()) {
            System.out.println(result.getKey() + " : " + result.getValue());
        }
        Assert.assertTrue(!results.values().toString().contains("f"));
    }

    @Test
    public void imagensMobileNaoEstaoSendoExibidas(){
        driver.get("https://taglivros.com/associe-se/escolha-sua-caixinha");
        WebDriverWait wait = new WebDriverWait(driver, 2);

        HashMap<String, Boolean> results = new HashMap<String, Boolean>();

        //Obtem e testa as imagens com a tag picture
        List<WebElement> images = driver.findElements(By.tagName("picture"));
        for (WebElement image : images){
            WebElement source = image.findElement(By.tagName("source"));
            String name = source.getAttribute("srcset");

            if (name.toLowerCase().contains("mobile")) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", image);
                try {
                    wait.until(ExpectedConditions.visibilityOf(image));
                }
                catch (Exception e){}
                results.put(name.substring(name.lastIndexOf("/") + 1), image.isDisplayed());
            }
        }
        //Obtem e testa as imagens com a tag img
        images = driver.findElements(By.tagName("img"));
        for (WebElement image : images){
            String name = image.getAttribute("src");
            if (name == null){
                name = image.getAttribute("data-src");
            }
            if (name == null){
                name = image.getAttribute("data-lazy-load");
            }
            if (name != null) {
                if ((name.contains(".png") || name.contains(".svg") || name.contains(".jpg")) && name.contains("mobile")) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", image);
                    try {
                        wait.until(ExpectedConditions.visibilityOf(image));
                    }
                    catch (Exception e){}
                    results.put(name.substring(name.lastIndexOf("/") + 1), image.isDisplayed());
                }
            }
        }
        //imprime os resultados no Console
        for (Map.Entry<String, Boolean> result: results.entrySet()) {
            System.out.println(result.getKey() + " : " + result.getValue());
        }
        Assert.assertTrue(results.values().toString().contains("f"));
    }
    @Before
    public void doBefore(){
        try {
            driver = TagDriver.getDriver();
        }
        catch (Exception e){
            System.out.println("Ops, algo deu errado ao iniciar o WebDriver Mobile");
        }

    }

    @After
    public void doAfter(){
        if (driver != null)
        {
            driver.quit();
        }
    }

}