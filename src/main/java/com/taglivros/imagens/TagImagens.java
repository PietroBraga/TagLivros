package com.taglivros.imagens;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlImage;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPicture;
import com.taglivros.core.TagWebClient;
import java.util.LinkedList;
import java.util.List;

public class TagImagens {
    public static List<String> obtemLinkDasImagens() throws Exception {
        WebClient client = TagWebClient.getWebClient();
        HtmlPage page = client.getPage("http://taglivros.com");

        List<String> result = new LinkedList<>();

        List<HtmlImage> images = page.getByXPath("//img");
        for (HtmlImage image : images) {
            String src = image.getSrcAttribute();
            if (src.isBlank()) {
                src = image.getAttribute("data-src");
            }
            if (src.isBlank()) {
                src = image.getAttribute("data-lazy-load");
            }

            if (src.contains(".png") || src.contains(".jpg") || src.contains(".svg")) {
                result.add(src);
            }
        }

        List<HtmlPicture> pictures = page.getByXPath("//picture");
        for (HtmlPicture picture : pictures){
            String src = picture.getFirstElementChild().getAttribute("data-lazy-load");

            if (src.contains(".png") || src.contains(".jpg") || src.contains(".svg"))
            {
                result.add(src);
            }
        }
        return result;
    }
}
