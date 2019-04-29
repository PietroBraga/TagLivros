package com.taglivros.core.imagens;

import com.taglivros.imagens.TagImagens;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import java.io.File;
import java.io.IOException;

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




