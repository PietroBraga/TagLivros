package com.taglivros.core;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlImage;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPicture;
import org.junit.Assert;
import org.junit.Test;
import java.util.*;

public class TestesDeImagensDesktop {
    @Test
    public void imagensDesktopEstaoSendoExibidas(){

        WebClient webClient = TagWebClient.getWebClient();
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
            String src = image.getSrcAttribute();
            if (src.equals("")) {
                src = image.getAttribute("data-src");
            }
            if (src.equals("")) {
                src = image.getAttribute("data-lazy-load");
            }

            if (src.contains("/")) {
                results.put(src.substring(src.lastIndexOf("/") + 1), image.isComplete());
            }
        }

        List<HtmlPicture> pictures = page.getByXPath("//picture");
        for (HtmlPicture picture: pictures) {
            String src = picture.getFirstElementChild().getAttribute("data-lazy-load");

            if (!src.toLowerCase().contains("mobile"))
            {
                results.put(src.substring(src.lastIndexOf("/") + 1), picture.isDisplayed());
            }
        }

        for (Map.Entry<String, Boolean> result: results.entrySet()) {
            System.out.println(result.getKey() + " : " + result.getValue());
        }
        Assert.assertTrue(!results.values().toString().contains("f"));
    }
}