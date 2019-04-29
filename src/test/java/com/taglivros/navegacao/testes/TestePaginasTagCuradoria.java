package com.taglivros.navegacao.testes;
import com.taglivros.navegacao.paginas.Paginas;
import com.taglivros.navegacao.setup.Setup;
import org.junit.Assert;
import org.junit.Test;


public class TestePaginasTagCuradoria  extends Setup {
//region Testes De Botoes
    @Test
    public void validarBotaoAssociese () throws Exception{
        Paginas paginas = new Paginas(driver);
        paginas.acessarPagina("curadoria");
        Assert.assertTrue(paginas.validaBotaoEstaClicavelByXpath("Associe-se"));
    }
    @Test
    public void validarBotaoOk () throws Exception{
        Paginas paginas = new Paginas(driver);
        paginas.acessarPagina("curadoria");
        Assert.assertTrue(paginas.validaBotaoEstaClicavelById("newsletter-button"));
    }
//endregion Testes De Botoes
}

