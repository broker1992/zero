package com.zero.one.cell.second;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Neure_second_0 {

    private Properties prop = new Properties();
    private static String filePath_prefix = "src/main/resources/config/cell/first/";
    private static String filePath_suffix = ".properties";
    public Neure_second_0() {
        try{
            String className = this.getClass().getSimpleName();
            File file = new File(filePath_prefix+className+filePath_suffix);
            if (!file.exists())
                file.createNewFile();
            InputStream fis = new FileInputStream(file);
            prop.load(fis);
            fis.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
