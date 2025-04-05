package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.PageBase;

public class RegistrationPage extends PageBase {

    @FindBy (id = "first_name")
    private WebElement firstNameFieldElement;

    @FindBy (id = "last_name")
    private WebElement lastNameFieldElement;

    @FindBy (id = "dob")
    private WebElement dateOfBirthFieldElement;

    @FindBy (id = "street")
    private WebElement streetFieldElement;

    @FindBy (id = "postal_code")
    private WebElement postalCodeFieldElement;

    @FindBy (id = "city")
    private WebElement cityFieldElement;

    @FindBy (id = "state")
    private WebElement stateFieldElement;

    @FindBy (id = "country")
    private WebElement countryFieldElement;

    @FindBy (id = "phone")
    private WebElement phoneFieldElement;

    @FindBy (id = "email")
    private WebElement emailFieldElement;

    @FindBy (id = "password")
    private WebElement passwordFieldElement;

    @FindBy (css = "button[data-test='register-submit']")
    private WebElement registerButtonElement;

    public RegistrationPage(WebDriver driver)
    {
        super(driver);
    }

    public void enterFirstName(String firstName)
    {
        waitUtils.waitForElementVisible(firstNameFieldElement).sendKeys(firstName);
    }

    public void enterLastName(String lastName)
    {
        waitUtils.waitForElementVisible(lastNameFieldElement).sendKeys(lastName);
    }

    public void selectDateOfBirth(String day, String month, String year)
    {
        waitUtils.waitForElementVisible(dateOfBirthFieldElement).sendKeys(month + "/" + day + "/" + year);
    }

    public void enterStreet(String street)
    {
        waitUtils.waitForElementVisible(streetFieldElement).sendKeys(street);
    }

    public void enterPostalCode(String postalCode)
    {
        waitUtils.waitForElementVisible(postalCodeFieldElement).sendKeys(postalCode);
    }

    public void enterCity(String city)
    {
        waitUtils.waitForElementVisible(cityFieldElement).sendKeys(city);
    }

    public void enterState(String state) {
        stateFieldElement.sendKeys(state);
    }

    public void selectCountry(String country)
    {
        Select countryDropdown = new Select(countryFieldElement);
        countryDropdown.selectByVisibleText(country);
    }

    public void enterPhone(String phone)
    {
        waitUtils.waitForElementVisible(phoneFieldElement).sendKeys(phone);
    }

    public void enterEmail(String email)
    {
        waitUtils.waitForElementVisible(emailFieldElement).sendKeys(email);
    }

    public void enterPassword(String password)
    {
        waitUtils.waitForElementVisible(passwordFieldElement).sendKeys(password);
    }

    public void clickOnRegisterButton()
    {
        waitUtils.waitForElementClickable(registerButtonElement).click();
    }
}
