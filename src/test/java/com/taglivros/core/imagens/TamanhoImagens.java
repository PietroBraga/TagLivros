package com.taglivros.core.imagens;

import com.taglivros.core.TagDriver;
import com.taglivros.imagens.TagImagens;
import com.twelvemonkeys.io.FileUtil;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.logging.LogEntries;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TamanhoImagens {
    @Before
    public void doBefore() throws Exception {
        TagImagens.deletaDiretorio();
        TagImagens.efetuaDownloadDasImages();
    }

    @Test
    public void _TamanhoDasImagens() {
        File file = TagImagens.getFile();
        File[] arquivos = file.listFiles();
        int aux = 0;
        if (arquivos != null) {
            int quantArquivo = arquivos.length;
            for (int i = 0; i < quantArquivo; ++i) {
                File f = arquivos[i];
                if (f.isFile()) {
                    aux++;
                }
                System.out.println(f.length());
            }
        }
    }

    @After
    public void doAfter() throws IOException {
        TagImagens.deletaDiretorio();
    }
}




