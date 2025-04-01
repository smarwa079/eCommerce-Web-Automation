package pages;

import org.openqa.selenium.By;
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

    @FindBy (xpath = "(button[class='btn btn-outline-secondary']")
    private WebElement showPasswordButtonElement;

    @FindBy (css = "button[data-test='register-submit']")
    private WebElement registerButtonElement;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(String firstName) {
        firstNameFieldElement.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameFieldElement.sendKeys(lastName);
    }

    public void selectDateOfBirth(String day, String month, String year) {
        dateOfBirthFieldElement.sendKeys(month + "/" + day + "/" + year);
    }

    public void enterStreet(String street) {
        streetFieldElement.sendKeys(street);
    }

    public void enterPostalCode(String postalCode) {
        postalCodeFieldElement.sendKeys(postalCode);
    }

    public void enterCity(String city) {
        cityFieldElement.sendKeys(city);
    }

    public void enterState(String state) {
        stateFieldElement.sendKeys(state);
    }

    public void selectCountry(String country) {
        Select countryDropdown = new Select(countryFieldElement);
        countryDropdown.selectByVisibleText(country);
    }

    public void enterPhone(String phone) {
        phoneFieldElement.sendKeys(phone);
    }

    public void enterEmail(String email) {
        emailFieldElement.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordFieldElement.sendKeys(password);
    }

    public void clickOnShowPasswordButton() {
        showPasswordButtonElement.click();
    }

    public void clickOnRegisterButton() {
        registerButtonElement.click();
    }
}
