package Genaric_Utility;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility {
    /**
     * This method is used to read data from properties_file
     * @param key
     * @return
     * @throws Throwable
     */

    public String getKeyAndValuePair(String key) throws Throwable
    {
        FileInputStream Pfile = new FileInputStream("./PropertiesFile/VTiger.Properties");
        Properties pro = new Properties();
        pro.load(Pfile);
        String data = pro.getProperty(key);
        return data;
    }
}
