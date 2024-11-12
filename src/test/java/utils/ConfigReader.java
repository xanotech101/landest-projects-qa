package utils;

import io.github.cdimascio.dotenv.Dotenv;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties prop;
    static Dotenv dotenv;

    static {
        dotenv = Dotenv.configure().load();  // this Loads/opens the .env file from the project root
    }
//Method to open and read the config.properties file
    public static Properties readProperties(String filepath) {
        try {
            FileInputStream fis = new FileInputStream(filepath);
            prop = new Properties();
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
//method to retrieve the values from the config.properties file
    public static String getPropertyValue(String key) {
        return prop.getProperty(key);
    }
//method to retrieve the values from the .env file
    public static String getEnvValue(String key) {
        return dotenv.get(key);  // Retrieves value from .env file
    }
}

