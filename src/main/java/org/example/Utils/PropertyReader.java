package org.example.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    public PropertyReader() {
    }

    // same below code in API also , Loading file
    public static String readKey(String key) throws IOException {
        FileInputStream fileInputStream = null;
        Properties p =null;
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/Resources/data.properties");
            p = new Properties();
            p.load(fileInputStream);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        return p.getProperty(key);
    }
}
// Advantage of property reader is in class -"CommonToAllPage" ,we can replace the hardcoded url in function openVWOLoginURL