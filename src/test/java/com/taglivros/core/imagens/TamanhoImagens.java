package com.taglivros.core.imagens;

import com.taglivros.core.TagDriver;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.logging.LogEntries;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TamanhoImagens {

    File file = null;

/*    @Before
    public void _criarDiretorio() {

        File file = new File("C:\\Users\\paulo_corbacho\\Documents\\ImagensTag");
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
    }*/


    @Test
    public void baixarImagens() {
        //_LimparDiretorio();
        BufferedImage image = null;
        try {

            URL url = new URL("https://static.taglivros.com/v4.6.1/assets/images/common/curadoria_full_white.png");
            image = ImageIO.read(url);
            ImageIO.write(image, "png", new File("C:\\Users\\paulo_corbacho\\Documents\\ImagensTag\\Imagem1"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void _validaTamanhoImagens() {
        File file = new File("C:\\Users\\paulo_corbacho\\Documents\\ImagensTag");
        if (file.exists()) {
            int count = file.listFiles().length;

            for (int i = 0; i < count; i = i++) {
                double bytes = file.length();
                System.out.println("bytes : " + bytes);
            }
        } else {
            System.out.println("File does not exists!");
        }
    }

    @Test
    public void _TamanhoDasImagens() {

        File arquivo = new File("C:\\Users\\paulo_corbacho\\Documents\\ImagensTag");
        File[] arquivos = arquivo.listFiles();
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
    }


   /* @After
    public void _deletarDiretorio(){
      if ((file.exists()) && (file.isDirectory()))
    file.delete();
    }*/


    /*@Test
    public void errorConsole() throws Exception {

        LogEntries logs = TagDriver.getDriver().manage().logs().get("browser");
        logs.getAll();
    }*/




