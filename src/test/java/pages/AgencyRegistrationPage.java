package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AgencyRegistrationPage extends CommonMethods {

    @FindBy(xpath="//a[text()='Register']")
    public WebElement registrationLink;

    @FindBy(id="first_name")
    public WebElement firstName;

    @FindBy(id="last_name")
    public WebElement lastName;

    @FindBy(id="organization_name")
    public WebElement organizationName;

    @FindBy(xpath="//div[@id='react-select-4-placeholder' and contains(@class, 'css-1jqq78o-placeholder')]")
    public WebElement country;

    @FindBy(xpath="//span[@id='react-select-5-live-region']")
    public WebElement chooseCurrency;

    @FindBy(id="phone_number")
    public WebElement phoneNumber;

    @FindBy(id="email")
    public WebElement emailAddress;

    @FindBy(xpath="//input[@id='file' and @type='file']")
    public WebElement uploadBusinessLogo;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(id="confirmpassword")
    public WebElement confirmPassword;

    @FindBy(xpath="//button[.//span[text()='Sign Up']]")
    public WebElement signUpButton;


    public AgencyRegistrationPage(){
        //call selenium page factory to initialize all elements
        PageFactory.initElements(driver, this);
    }




}
