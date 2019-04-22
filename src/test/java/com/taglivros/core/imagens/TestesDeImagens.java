package com.taglivros.core.imagens;

import com.gargoylesoftware.htmlunit.*;
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
import java.sql.Time;
import java.util.*;

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

        @Test
        public void mobile() throws Exception {
            BrowserVersion bv = new BrowserVersion.BrowserVersionBuilder(BrowserVersion.CHROME)
                    .setApplicationCodeName("Mozilla")
                    .setApplicationMinorVersion("0")
                    .setApplicationVersion("5.0 (Linux; Android 5.0; SM-G900P Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Mobile Safari/537.36")
                    .setVendor("")
                    .setBrowserLanguage("pt-BR")
                    .setCpuClass("x86")
                    .setOnLine(true)
                    //.setPlatform("Linux; Android 7.0; SM-G930V Build/NRD90M")
                    .setSystemLanguage("pt-BR")
                    .setSystemTimezone(TimeZone.getTimeZone("America/New_York"))
                    .setUserLanguage("pt-BR")
                    .setHtmlAcceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                    .setImgAcceptHeader("image/webp,image/apng,image/*,*/*;q=0.8")
                    .setCssAcceptHeader("\"text/css,*/*;q=0.1\"")
                    .setScriptAcceptHeader("*/*")
                    .setXmlHttpRequestAcceptHeader("*/*")
                    .setUserAgent("Mozilla/5.0 (Linux; Android 5.0; SM-G900P Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Mobile Safari/537.36")
                    .build();

            final WebClient webClient = new WebClient(bv);
            WebClientOptions option = webClient.getOptions();
            webClient.getOptions().setScreenHeight(736);
            webClient.getOptions().setScreenWidth(414);
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
                try {
                    image.getImageReader();
                }
                catch (Exception e) {}
                results.put(src, image.isComplete());
            }

            for (Map.Entry<String, Boolean> result: results.entrySet()) {
                System.out.println(result.getKey() + " : " + result.getValue());
            }
            Assert.assertTrue(!results.values().toString().contains("f"));
        }
    }