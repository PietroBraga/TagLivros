package com.taglivros.navegacao.elementos;

import com.taglivros.navegacao.setup.Setup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Elementos extends Setup {
    @FindBy(xpath = "//*[contains(text(),'Associe-se')]")
    protected WebElement botaoAssociese;

//region botoes
@FindBy(css =  "div.home-primeira-faixa__video > div > div > div > span > a > i")
protected WebElement EntendaATag;
//endregion botoes
}
