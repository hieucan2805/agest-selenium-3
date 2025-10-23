package agest.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    // This is a static initializer block.
    // It runs 'once' when the class is first loaded by JVM.
    static {
        // Define the path to the properties file
        String path = "src/test/resources/config.properties";

        try {
            // Create a FileInputStream to read the file
            FileInputStream file = new FileInputStream(path);

            // Initialize the Properties object
            properties = new Properties();

            // Load the properties from the file
            properties.load(file);

            // Close the file stream
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
            // This will stop the execution if the config file is not found
            throw new RuntimeException("Config file not found at " + path);
        }
    }

    /**
     * Gets a property value by its key.
     * @param key The key of the property (e.g., "browser", "url.google")
     * @return The value as a String
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
