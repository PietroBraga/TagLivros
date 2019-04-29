package com.taglivros.navegacao.setup;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setup {
    protected static WebDriver driver;

    @Before
    public void inicia() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void termina(){
        driver.quit();
    }
}





