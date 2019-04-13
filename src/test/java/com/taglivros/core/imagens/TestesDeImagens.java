package com.taglivros.core.imagens;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebClientOptions;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlImage;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.javascript.JavaScriptErrorListener;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptJobManager;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TestesDeImagens {
    @Test
    public void homePage() throws Exception {

            final WebClient webClient = new WebClient(BrowserVersion.CHROME);
        WebClientOptions option = webClient.getOptions();
            webClient.waitForBackgroundJavaScript(20000);
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            option.setJavaScriptEnabled(true);
            option.setDownloadImages(true);
            webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
            webClient.setCssErrorHandler(new SilentCssErrorHandler());
            HtmlPage page = null;
            try{
                page = webClient.getPage("http://elemaisvelhoelamaisnova.blogspot.com/");
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            boolean test = false;
            List<HtmlImage> elements = page.getByXPath("//img");
            for (HtmlImage element: elements
                 ) {
                test = element.isComplete();
            }
            Assert.assertEquals("HtmlUnit - Welcome to HtmlUnit", page.getTitleText());

            final String pageAsXml = page.asXml();
            Assert.assertTrue(pageAsXml.contains("<body class=\"composite\">"));

            final String pageAsText = page.asText();
            Assert.assertTrue(pageAsText.contains("Support for the HTTP and HTTPS protocols"));
    }
}
