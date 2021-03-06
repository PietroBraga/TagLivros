package com.taglivros.core.imagens;

import com.taglivros.imagens.TagImagens;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class TestesDeImagensTamanho {
    @Before
    public void doBefore() throws Exception {
        TagImagens.deletaDiretorio();
        TagImagens.efetuaDownloadDasImages();
    }

    @Test
    public void tamanhoDasImagens() {
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
                if (f.length() > 1024 * 1024) {
                    System.out.println(f.length() / (1024 * 1024) + " MB");
                }
                else if (f.length() > 1024) {
                    System.out.println(f.length() / (1024) + " KB");
                }
                else {
                    System.out.println(f.length() + " Bytes");
                }
            }
        }
        Assert.assertTrue(true);
    }

    @After
    public void doAfter() throws IOException {
        TagImagens.deletaDiretorio();
    }
}
