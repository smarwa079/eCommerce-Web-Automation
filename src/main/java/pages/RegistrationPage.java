package pages;

import io.qameta.allure.Step;
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
    By passwordSuccess =By.cssSelector("body app-root app-register li:nth-child(2)");
    By registerButton = By.cssSelector("button[data-test='register-submit']");

    public RegistrationPage(WebDriver driver)
    {
        super(driver);
    }

    @Step("Enter first name: {firstName}")
    public void enterFirstName(String firstName)
    {
        waitUtils.waitForElementVisible(firstNameField).sendKeys(firstName);
    }

    @Step("Get first name field error message")
    public String getFirstNameErrorMessage()
    {
        return waitUtils.waitForElementVisible(firstNameErrorMessage).getText();
    }

    @Step("Enter last name: {lastName}")
    public void enterLastName(String lastName)
    {
        waitUtils.waitForElementVisible(lastNameField).sendKeys(lastName);
    }

    @Step("Get last name field error message")
    public String getLastNameErrorMessage()
    {
        return waitUtils.waitForElementVisible(lastNameErrorMessage).getText();
    }

    @Step("Select date of birth: {day}/{month}/{year}")
    public void selectDateOfBirth(String day, String month, String year)
    {
        WebElement dateOfBirthFieldElement = driver.findElement(dateOfBirthField);
        dateOfBirthFieldElement.sendKeys(month + "/" + day + "/" + year);
    }

    @Step("Get date of birth field error message")
    public String getDateOfBirthErrorMessage()
    {
        return waitUtils.waitForElementVisible(dateOfBirthErrorMessage).getText();
    }

    @Step("Enter street: {street}")
    public void enterStreet(String street)
    {
        WebElement streetFieldElement = driver.findElement(streetField);
        streetFieldElement.sendKeys(street);
    }

    @Step("Get street field error message")
    public String getStreetErrorMessage()
    {
        return waitUtils.waitForElementVisible(streetErrorMessage).getText();
    }

    @Step("Enter postal code: {postalCode}")
    public void enterPostalCode(String postalCode)
    {
        WebElement postalCodeFieldElement = driver.findElement(postalCodeField);
        postalCodeFieldElement.sendKeys(postalCode);
    }

    @Step("Get postal code field error message")
    public String getPostalCodeErrorMessage()
    {
        return waitUtils.waitForElementVisible(postalCodeErrorMessage).getText();
    }

    @Step("Enter city: {city}")
    public void enterCity(String city)
    {
        WebElement cityFieldElement = driver.findElement(cityField);
        cityFieldElement.sendKeys(city);
    }

    @Step("Get city field error message")
    public String getCityErrorMessage()
    {
        return waitUtils.waitForElementVisible(cityErrorMessage).getText();
    }

    @Step("Select country: {country}")
    public void selectCountry(String country)
    {
        WebElement countryFieldElement = driver.findElement(countryField);
        Select countryDropdown = new Select(countryFieldElement);
        countryDropdown.selectByVisibleText(country);
    }

    @Step("Get country field error message")
    public String getCountryErrorMessage()
    {
        return waitUtils.waitForElementVisible(countryErrorMessage).getText();
    }

    @Step("Enter state: {state}")
    public void enterState(String state)
    {
        WebElement stateFieldElement = driver.findElement(stateField);
        stateFieldElement.sendKeys(state);
    }

    @Step("Get state field error message")
    public String getStateErrorMessage()
    {
        return waitUtils.waitForElementVisible(stateErrorMessage).getText();
    }

    @Step("Enter phone: {phone}")
    public void enterPhone(String phone)
    {
        WebElement phoneFieldElement = driver.findElement(phoneField);
        phoneFieldElement.sendKeys(phone);
    }

    @Step("Get phone field error message")
    public String getPhoneErrorMessage() {
        return waitUtils.waitForElementVisible(phoneErrorMessage).getText();
    }

    @Step("Enter email: {email}")
    public void enterEmail(String email)
    {
        WebElement emailFieldElement = driver.findElement(emailField);
        emailFieldElement.sendKeys(email);
    }

    @Step("Get email field error message")
    public String getEmailErrorMessage()
    {
        return waitUtils.waitForElementVisible(emailErrorMessage).getText();
    }

    @Step("Enter password: {password}")
    public void enterPassword(String password)
    {
        WebElement passwordFieldElement = driver.findElement(passwordField);
        passwordFieldElement.sendKeys(password);
    }

    @Step("Get password field error message")
    public String getPasswordErrorMessage()
    {
        return waitUtils.waitForElementVisible(passwordErrorMessage).getText();
    }

    @Step("Get password success message")
    public String getPasswordSuccessMessage()
    {
        return waitUtils.waitForElementVisible(passwordSuccess).getAttribute("class");
    }

    @Step("Click on register button")
    public void clickOnRegisterButton()
    {
        WebElement registerButtonElement = driver.findElement(registerButton);
        registerButtonElement.click();
    }
}
