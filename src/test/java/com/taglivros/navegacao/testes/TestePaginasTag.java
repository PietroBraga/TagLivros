package com.taglivros.navegacao.testes;
import com.taglivros.navegacao.paginas.Paginas;
import com.taglivros.navegacao.setup.Setup;
import org.junit.Assert;
import org.junit.Test;

public class TestePaginasTag  extends Setup {
//region Testes De Botoes
    @Test
    public void validarBotaoAssociese () throws Exception{
        Paginas paginas = new Paginas(driver);
        paginas.acessarPagina("");
        Assert.assertTrue(paginas.validaBotaoEstaClicavelByXpath("Associe-se"));
    }
    @Test
    public void validarBotaoOk () throws Exception{
        Paginas paginas = new Paginas(driver);
        paginas.acessarPagina("");
        Assert.assertTrue(paginas.validaBotaoEstaClicavelById("newsletter-button"));
    }
    //endregion Testes De botoes

//region Testes De Modal
    @Test
    public void validarModalEntendaATag () throws Exception{
        Paginas paginas = new Paginas(driver);
        paginas.acessarPagina("");
        paginas.clicaNoBotaoEntendaATag();
        Assert.assertTrue(paginas.validaModalByCss("body > div.modal__v2.video__modal.visible > div.modal__v2__container"));
    }
//endregion Testes De Modal
}

