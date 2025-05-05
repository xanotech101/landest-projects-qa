package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.PageInitializer;

import java.time.Duration;

public class CommonMethods extends PageInitializer {

    // WebDriver instance initialized once
    public static WebDriver driver;

    // Initialize WebDriver if it's not already initialized
    public static void initializeWebDriver() {
        if (driver == null) {
            ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH); // Load properties
            String browser = ConfigReader.getPropertyValue("browser");

            switch (browser.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Invalid browser specified in config.");
            }

            // Configure WebDriver settings
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
        }
    }

    public static void openBrowserAndLaunchBackOfficeApplication() {
        initializeWebDriver();
        driver.get(ConfigReader.getPropertyValue("backOfficeUrl"));
        initializePageObject();
    }

    public static void openBrowserAndLaunchSubdomainApplication() {
        initializeWebDriver();
        driver.get(ConfigReader.getPropertyValue("subdomainUrl"));
        initializePageObject();
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;  // Clean up WebDriver after tests
        }
    }

    public static void loginAsAgencyRep() {
        String email = ConfigReader.getEnvValue("agencyRepEmail");
        String password = ConfigReader.getEnvValue("agencyRepPassword");
        System.out.println("Logging in with email: " + email);
        // Implement login logic using the email and password
    }
    public static void sendText(WebElement element, String textToSend){
        element.clear();
        element.sendKeys(textToSend);
    }

    public static WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
        return wait;

    }
   public static void waitForClickability(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click(WebElement element){
        waitForClickability(element);
        element.click();
    }

    public static void waitForElementToBeVisible(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }
    //This method will return JavascriptExecutor object
    public static JavascriptExecutor getJSExecutor(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    public static void jsClick(WebElement element){
        getJSExecutor().executeScript("arguments[0].click();", element);

    }

    public static void selectDropDown(WebElement element, String text) {
        Select s = new Select(element);
        s.selectByVisibleText(text);
    }





}
