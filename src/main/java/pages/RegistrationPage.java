package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.PageBase;

public class RegistrationPage extends PageBase {

    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By dateOfBirthField = By.id("dob");
    private By streetField = By.id("street");
    private By postalCodeField = By.id("postal_code");
    private By cityField = By.id("city");
    private By stateField = By.id("state");
    private By countryField = By.id("country");
    private By phoneField = By.id("phone");
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By showPasswordButton = By.xpath("(button[class='btn btn-outline-secondary']");
    private By registerButton = By.cssSelector("button[data-test='register-submit']");

    private WebElement firstNameFieldElement;
    private WebElement lastNameFieldElement;
    private WebElement dateOfBirthFieldElement;
    private WebElement streetFieldElement;
    private WebElement postalCodeFieldElement;
    private WebElement cityFieldElement;
    private WebElement stateFieldElement;
    private WebElement countryFieldElement;
    private WebElement phoneFieldElement;
    private WebElement emailFieldElement;
    private WebElement passwordFieldElement;
    private WebElement showPasswordButtonElement;
    private WebElement registerButtonElement;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(String firstName) {
        firstNameFieldElement = driver.findElement(firstNameField);
        firstNameFieldElement.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameFieldElement = driver.findElement(lastNameField);
        lastNameFieldElement.sendKeys(lastName);
    }

    public void selectDateOfBirth(String day, String month, String year) {
        dateOfBirthFieldElement = driver.findElement(dateOfBirthField);
        dateOfBirthFieldElement.sendKeys(month + "/" + day + "/" + year);
    }

    public void enterStreet(String street) {
        streetFieldElement = driver.findElement(streetField);
        streetFieldElement.sendKeys(street);
    }

    public void enterPostalCode(String postalCode) {
        postalCodeFieldElement = driver.findElement(postalCodeField);
        postalCodeFieldElement.sendKeys(postalCode);
    }

    public void enterCity(String city) {
        cityFieldElement = driver.findElement(cityField);
        cityFieldElement.sendKeys(city);
    }

    public void enterState(String state) {
        stateFieldElement = driver.findElement(stateField);
        stateFieldElement.sendKeys(state);
    }

    public void selectCountry(String country) {
        countryFieldElement = driver.findElement(countryField);
        Select countryDropdown = new Select(countryFieldElement);
        countryDropdown.selectByVisibleText(country);
    }

    public void enterPhone(String phone) {
        phoneFieldElement = driver.findElement(phoneField);
        phoneFieldElement.sendKeys(phone);
    }

    public void enterEmail(String email) {
        emailFieldElement = driver.findElement(emailField);
        emailFieldElement.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordFieldElement = driver.findElement(passwordField);
        passwordFieldElement.sendKeys(password);
    }

    public void clickOnShowPasswordButton() {
        showPasswordButtonElement = driver.findElement(showPasswordButton);
        showPasswordButtonElement.click();
    }

    public void clickOnRegisterButton() {
        registerButtonElement = driver.findElement(registerButton);
        registerButtonElement.click();
    }
}
