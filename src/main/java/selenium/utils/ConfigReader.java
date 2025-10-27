package selenium.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        String path = "src/test/resources/config.properties";
        try {
            FileInputStream file = new FileInputStream(path);
            properties = new Properties();
            properties.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Config file not found at " + path);
        }
    }

    /**
     * Gets a property value.
     * Priority Order:
     * 1. System Property (from -D command line)
     * 2. config.properties file
     *
     * @param key The key of the property
     * @return The value as a String
     */
    public static String getProperty(String key) {
        // 1. Check for the property in System Properties first
        String value = System.getProperty(key);

        if (value != null) {
            // If found in System Properties, return it
            return value;
        }

        // 2. If not found, check in the loaded config.properties file
        return properties.getProperty(key);
    }
}
