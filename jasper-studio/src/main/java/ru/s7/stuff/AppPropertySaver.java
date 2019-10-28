package ru.s7.stuff;

import java.io.*;
import java.net.URL;
import java.util.Properties;

public class AppPropertySaver {

    static File file;

    public static void save(Properties prop){
        try {
            URL url = prop.getClass().getClassLoader().getResource("app.properties");
            file = new File( url.getPath() );
            FileOutputStream fr = new FileOutputStream(file);
            prop.store(fr, "Properties");
            fr.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
