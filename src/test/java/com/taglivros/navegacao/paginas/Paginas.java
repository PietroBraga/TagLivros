package com.taglivros.navegacao.paginas;

import java.util.concurrent.TimeUnit;
import com.taglivros.navegacao.elementos.Elementos;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Paginas  extends Elementos {
    private WebDriver driver;
    public Paginas  (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void acessarPagina(String pagina) {
        driver.get("https://taglivros.com/" + pagina);
    }

//region valida botoes
    public boolean validaBotaoEstaClicavelByXpath(String descricaoBotao){
    if(isElementPresentDisplayedClicable(driver, By.xpath("//*[contains(text(), '"+descricaoBotao+"')]"), 5))
        return true;
    else
        return false;
}
    public boolean validaBotaoEstaClicavelById(String idElemento){
        if(isElementPresentDisplayedClicable(driver, By.id(idElemento), 5))
            return true;
        else
            return false;
    }

    public boolean validaBotaoEstaClicavelByName(String nameElemento){
        if(isElementPresentDisplayedClicable(driver, By.name(nameElemento), 5))
            return true;
        else
            return false;
    }

    public boolean validaBotaoEstaClicavelByCssSelector(String cssElemento){
        if(isElementPresentDisplayedClicable(driver, By.cssSelector(cssElemento),5))
            return true;
        else
            return false;
    }

    public void clicaNoBotaoEntendaATag(){
        EntendaATag.click();
    }

//endregion valida botoes
//region modal
    public boolean validaModalByCss(String cssModal){
    if(isElementPresentDisplayed(driver, By.cssSelector(cssModal), 5))
            return true;
        else
            return false;
}
//endregion modal

//region util
    public void wait(int seconds) {
    try {
        Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}


    public static final int DEFAULT_WAIT_4_ELEMENT = 10;

    public static boolean isElementPresentDisplayedClicable(WebDriver driver, By by, int timeOutInSeconds){
        try {
            setImplicitWait(driver, timeOutInSeconds);
            boolean isElementPresent = !driver.findElements(by).isEmpty();
            boolean isElementDisplayed = driver.findElement(by).isDisplayed();
            boolean IsClickable = driver.findElement(by).isEnabled();
            resetImplicitWait(driver);

            return isElementPresent && isElementDisplayed && IsClickable;
        }
        catch (Exception e) {
            return false;
        }
    }
    public static boolean isElementPresentDisplayed(WebDriver driver, By by, int timeOutInSeconds){
        try {
            setImplicitWait(driver, timeOutInSeconds);
            boolean isElementPresent = !driver.findElements(by).isEmpty();
            boolean isElementDisplayed = driver.findElement(by).isDisplayed();
            resetImplicitWait(driver);

            return isElementPresent && isElementDisplayed;
        }
        catch (Exception e) {
            return false;
        }
    }


    public static void setImplicitWait(WebDriver driver, int waitTime_InSeconds) {
        driver.manage().timeouts().implicitlyWait(waitTime_InSeconds, TimeUnit.SECONDS);
    }

    public static void resetImplicitWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_ELEMENT, TimeUnit.SECONDS);
    }

//endregion util
}

