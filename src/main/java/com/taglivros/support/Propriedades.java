package com.taglivros.support;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Propriedades {
    private static String result;
    String propFileName = "config.properties";
    private static InputStream inputStream;

//    private Propriedades(){

   // }

    public static String obtemPropriedades(String nomeDaPropriedade) throws IOException {
        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";
            inputStream = Propriedades.class.getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            result = prop.getProperty(nomeDaPropriedade);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        finally {
            inputStream.close();
        }
        return result;
    }

    public static void escrevePropriedades(String nomeDaPropriedade, String valor) throws IOException {
        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";
            inputStream = Propriedades.class.getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            prop.setProperty(nomeDaPropriedade, valor);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        finally {
            inputStream.close();
        }
    }
}
