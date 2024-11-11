package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;

    // Loads the properties only once
    public static void readProperties(String filepath) {
        if (prop == null) {
            prop = new Properties();
            try (FileInputStream fis = new FileInputStream(filepath)) {
                prop.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to load configuration file at " + filepath);
            }
        }
    }

    // Overload for default file path
    public static void readProperties() {
        readProperties("src/test/resources/config/config.properties");
    }

    public static String getPropertyValue(String key) {
        if (prop == null) {
            readProperties();
        }
        return prop.getProperty(key);
    }
}
