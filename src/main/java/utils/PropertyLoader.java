package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Lucien.Minot on 8/26/2015.
 */
public class PropertyLoader {

    private static InputStream input = null;
    private static Properties configFile = new Properties();

    public String getPropertyValue(String fileName, String propertyName) {
        String value = null;
        input = getClass().getClassLoader().getResourceAsStream(fileName);
        try {
            configFile.load(input);
            value = configFile.getProperty(propertyName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return value;
    }
}
