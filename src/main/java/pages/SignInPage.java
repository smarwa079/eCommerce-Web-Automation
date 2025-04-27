package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PageBase;

public class SignInPage extends PageBase {

    By emailField = By.xpath("//form[@data-test='login-form'] //input[@id='email']");
    By emailErrorMessage = By.xpath("//div[@data-test='email-error']/div");
    By passwordField = By.xpath("//form[@data-test='login-form'] //input[@id='password']");
    By passwordErrorMessage = By.xpath("//div[@data-test='password-error']/div");
    By loginButton = By.cssSelector("input[value='Login']");
    By registerLink = By.cssSelector("a[data-test='register-link']");
    By forgotPasswordLink = By.className("ForgetPwd");

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Step("Sign in with email: {0} and password: {1}")
    public void signIn(String email, String password)
    {
        waitUtils.waitForElementVisible(emailField).sendKeys(email);

        waitUtils.waitForElementVisible(passwordField).sendKeys(password);

        waitUtils.waitForElementClickable(loginButton).click();

        waitUtils.waitForElementVisible(myAccountDropdown);
    }

    @Step ("Get email field error message")
    public String getEmailErrorMessage()
    {
        return waitUtils.waitForElementVisible(emailErrorMessage).getText();
    }

    @Step("Get password field error message")
    public String getPasswordErrorMessage()
    {
        return waitUtils.waitForElementVisible(passwordErrorMessage).getText();
    }

    @Step("Click on register link")
    public RegistrationPage clickOnRegisterLink()
    {
        waitUtils.waitForElementClickable(registerLink).click();

        return new RegistrationPage(driver);
    }

    @Step("Click on forgot password link")
    public ForgotPasswordPage clickOnForgotPasswordLink() {


        waitUtils.waitForElementClickable(forgotPasswordLink).click();

        return new ForgotPasswordPage(driver);
    }


}
