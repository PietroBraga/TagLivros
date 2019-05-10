package com.taglivros.imagens;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlImage;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPicture;
import com.taglivros.core.TagWebClient;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class TagImagens {
    public static File getFile() {
        file = new File(System.getProperty("user.home") + "/Documents/ImagensTag");
        return file;
    }

    private static File file;

    public static List<String> obtemLinkDasImagens() throws Exception {
        WebClient client = TagWebClient.getWebClient();
        HtmlPage page = client.getPage("http://taglivros.com");

        List<String> result = new LinkedList<>();

        List<HtmlImage> images = page.getByXPath("//img");
        for (HtmlImage image : images) {
            String src = image.getSrcAttribute();
            if (src.isEmpty()) {
                src = image.getAttribute("data-src");
            }
            if (src.isEmpty()) {
                src = image.getAttribute("data-lazy-load");
            }

            if (src.contains(".png") || src.contains(".jpg") || src.contains(".svg")) {
                result.add(src);
            }
        }

        List<HtmlPicture> pictures = page.getByXPath("//picture");
        for (HtmlPicture picture : pictures) {
            String src = picture.getFirstElementChild().getAttribute("data-lazy-load");

            if (src.contains(".png") || src.contains(".jpg") || src.contains(".svg")) {
                result.add(src);
            }
        }
        return result;
    }

    public static void efetuaDownloadDasImages() throws Exception {
        criaDiretorio();
        List<String> urls = obtemLinkDasImagens();

        for (String link : urls) {
            URL url = new URL(link);
            FileUtils.copyURLToFile(url, new File(getFile() + "/" + link.substring(link.lastIndexOf("/") + 1)));
        }
    }

    public static void criaDiretorio() {
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
    }

    public static void deletaDiretorio() throws IOException {
        if ((getFile().exists()) && (getFile().isDirectory()))
            FileUtils.forceDelete(getFile());
    }
}
