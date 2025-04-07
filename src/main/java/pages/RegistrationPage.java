package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.PageBase;

public class RegistrationPage extends PageBase {

    By firstNameField = By.id("first_name");
    By firstNameErrorMessage = By.xpath("//div[@data-test='first-name-error']/div");
    By lastNameField = By.id("last_name");
    By lastNameErrorMessage = By.xpath("//div[@data-test='last-name-error']/div");
    By dateOfBirthField = By.id("dob");
    By dateOfBirthErrorMessage = By.xpath("//div[@class='alert alert-danger']");
    By streetField= By.id("street");
    By streetErrorMessage = By.xpath("//div[@data-test='street-error']/div");
    By postalCodeField = By.id("postal_code");
    By postalCodeErrorMessage = By.xpath("//div[@data-test='postal_code-error']/div");
    By cityField = By.id("city");
    By cityErrorMessage = By.xpath("//div[@data-test='city-error']/div");
    By stateField = By.id("state");
    By stateErrorMessage = By.xpath("//div[@data-test='state-error']/div");
    By countryField = By.id("country");
    By countryErrorMessage = By.xpath("//div[@data-test='country-error']/div");
    By phoneField = By.id("phone");
    By phoneErrorMessage = By.xpath("//div[@data-test='phone-error']/div");
    By emailField = By.id("email");
    By emailErrorMessage = By.xpath("//div[@data-test='email-error']/div");
    By passwordField = By.id("password");
    By passwordErrorMessage = By.xpath("//div[@data-test='password-error']/div");
    By registerButton = By.cssSelector("button[data-test='register-submit']");

    public RegistrationPage(WebDriver driver)
    {
        super(driver);
    }

    public void enterFirstName(String firstName)
    {
        waitUtils.waitForElementVisible(firstNameField).sendKeys(firstName);
    }

    public String getFirstNameErrorMessage()
    {
        return waitUtils.waitForElementVisible(firstNameErrorMessage).getText();
    }

    public void enterLastName(String lastName)
    {
        waitUtils.waitForElementVisible(lastNameField).sendKeys(lastName);
    }

    public String getLastNameErrorMessage()
    {
        return waitUtils.waitForElementVisible(lastNameErrorMessage).getText();
    }

    public void selectDateOfBirth(String day, String month, String year)
    {
        WebElement dateOfBirthFieldElement = driver.findElement(dateOfBirthField);
        dateOfBirthFieldElement.sendKeys(month + "/" + day + "/" + year);
    }

    public String getDateOfBirthErrorMessage()
    {
        return waitUtils.waitForElementVisible(dateOfBirthErrorMessage).getText();
    }

    public void enterStreet(String street)
    {
        WebElement streetFieldElement = driver.findElement(streetField);
        streetFieldElement.sendKeys(street);
    }

    public String getStreetErrorMessage()
    {
        return waitUtils.waitForElementVisible(streetErrorMessage).getText();
    }

    public void enterPostalCode(String postalCode)
    {
        WebElement postalCodeFieldElement = driver.findElement(postalCodeField);
        postalCodeFieldElement.sendKeys(postalCode);
    }

    public String getPostalCodeErrorMessage()
    {
        return waitUtils.waitForElementVisible(postalCodeErrorMessage).getText();
    }

    public void enterCity(String city)
    {
        WebElement cityFieldElement = driver.findElement(cityField);
        cityFieldElement.sendKeys(city);
    }

    public String getCityErrorMessage()
    {
        return waitUtils.waitForElementVisible(cityErrorMessage).getText();
    }

    public void selectCountry(String country)
    {
        WebElement countryFieldElement = driver.findElement(countryField);
        Select countryDropdown = new Select(countryFieldElement);
        countryDropdown.selectByVisibleText(country);
    }

    public String getCountryErrorMessage()
    {
        return waitUtils.waitForElementVisible(countryErrorMessage).getText();
    }

    public void enterState(String state)
    {
        WebElement stateFieldElement = driver.findElement(stateField);
        stateFieldElement.sendKeys(state);
    }

    public String getStateErrorMessage()
    {
        return waitUtils.waitForElementVisible(stateErrorMessage).getText();
    }

    public void enterPhone(String phone)
    {
        WebElement phoneFieldElement = driver.findElement(phoneField);
        phoneFieldElement.sendKeys(phone);
    }

    public String getPhoneErrorMessage() {
        return waitUtils.waitForElementVisible(phoneErrorMessage).getText();
    }

    public void enterEmail(String email)
    {
        WebElement emailFieldElement = driver.findElement(emailField);
        emailFieldElement.sendKeys(email);
    }

    public String getEmailErrorMessage()
    {
        return waitUtils.waitForElementVisible(emailErrorMessage).getText();
    }

    public void enterPassword(String password)
    {
        WebElement passwordFieldElement = driver.findElement(passwordField);
        passwordFieldElement.sendKeys(password);
    }

    public String getPasswordErrorMessage()
    {
        return waitUtils.waitForElementVisible(passwordErrorMessage).getText();
    }

    public void clickOnRegisterButton()
    {
        WebElement registerButtonElement = driver.findElement(registerButton);
        registerButtonElement.click();
    }
}
