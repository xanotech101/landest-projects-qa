package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class CommonMethods {

    public static WebDriver driver;

    public static void openBrowserAndLaunchApplication() {
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);

        switch (ConfigReader.getPropertyValue("browser")) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name");
        }

        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("backOfficeUrl"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void loginAsAgencyRep() {
        String email = ConfigReader.getEnvValue("agencyRepEmail");  // From .env
        String password = ConfigReader.getEnvValue("agencyRepPassword");  // From .env

        // Use these credentials in your login functionality
        System.out.println("Logging in with email: " + email);
    }
}
