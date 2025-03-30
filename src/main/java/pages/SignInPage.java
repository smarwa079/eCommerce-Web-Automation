package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PageBase;

public class SignInPage extends PageBase {

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By showPasswordButton = By.xpath("//button[@class='btn btn-outline-secondary']");
    private By loginButton = By.cssSelector("input[value='Login']");
    private By registerLink = By.cssSelector("a[data-test='register-link']");
    private By forgotPasswordLink = By.className("ForgetPwd");

    private WebElement emailFieldElement;
    private WebElement passwordFieldElement;
    private WebElement showPasswordButtonElement;
    private WebElement loginButtonElement;
    private WebElement registerLinkElement;
    private WebElement forgotPasswordLinkElement;

    public SignInPage(WebDriver driver) {
        super(driver);
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

    public void clickOnLoginButton() {
        loginButtonElement = driver.findElement(loginButton);
        loginButtonElement.click();
    }

    public RegistrationPage clickOnRegisterLink() {
        registerLinkElement = driver.findElement(registerLink);
        registerLinkElement.click();

        return new RegistrationPage(driver);
    }

    public ForgotPasswordPage clickOnForgotPasswordLink() {
        forgotPasswordLinkElement = driver.findElement(forgotPasswordLink);
        forgotPasswordLinkElement.click();

        return new ForgotPasswordPage(driver);
    }

}
