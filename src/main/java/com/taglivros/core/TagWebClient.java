package com.taglivros.core;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebClientOptions;

import java.util.TimeZone;

public class TagWebClient {

    public static WebClient getWebClient(){
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        WebClientOptions option = webClient.getOptions();
        webClient.waitForBackgroundJavaScript(20000);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        option.setJavaScriptEnabled(false);
        option.setDownloadImages(true);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.setCssErrorHandler(new SilentCssErrorHandler());
        return webClient;
    }

    public static WebClient getMobileClient(){
        BrowserVersion bv = new BrowserVersion.BrowserVersionBuilder(BrowserVersion.CHROME)
                //.setApplicationName("Chrome")
                //.setApplicationVersion("5.0 (Linux; Android 8.0.0; SM-G960F Build/R16NW) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.84 Mobile Safari/537.36")
                .setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 12_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) CriOS/69.0.3497.105 Mobile/15E148 Safari/605.1")
                .build();
        WebClient webClient = new WebClient(bv);
        WebClientOptions option = webClient.getOptions();
        webClient.getOptions().setScreenHeight(736);
        webClient.getOptions().setScreenWidth(414);
        webClient.waitForBackgroundJavaScript(20000);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        option.setJavaScriptEnabled(false);
        option.setDownloadImages(true);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.setCssErrorHandler(new SilentCssErrorHandler());
        return webClient;
    }
}
