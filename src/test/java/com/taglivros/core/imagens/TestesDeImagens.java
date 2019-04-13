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
import com.google.errorprone.annotations.Var;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        HashMap<String, Boolean> results = new HashMap<String, Boolean>();
        try{
            page = webClient.getPage("http://taglivros.com.br");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        List<HtmlImage> images = page.getByXPath("//img");
        for (HtmlImage image: images) {
            String src = image.getAttribute("src");
            if (src.equals("")){
                src = image.getAttribute("data-src");
            }
            if (src.equals("")){
                src = image.getAttribute("data-lazy-load");
            }
            results.put(src, image.isComplete());
        }

        for (Map.Entry<String, Boolean> result: results.entrySet()) {
            System.out.println(result.getKey() + " : " + result.getValue());
        }
        Assert.assertTrue(!results.values().toString().contains("f"));
    }
}
