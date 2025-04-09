package pages;

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

    public void signIn(String email, String password)
    {
        waitUtils.waitForElementVisible(emailField).sendKeys(email);

        waitUtils.waitForElementVisible(passwordField).sendKeys(password);

        waitUtils.waitForElementClickable(loginButton).click();
        waitUtils.waitForElementVisible(myAccountDropdown);
    }

    public String getEmailErrorMessage()
    {
        return waitUtils.waitForElementVisible(emailErrorMessage).getText();
    }

    public String getPasswordErrorMessage()
    {
        return waitUtils.waitForElementVisible(passwordErrorMessage).getText();
    }

    public RegistrationPage clickOnRegisterLink()
    {
        waitUtils.waitForElementClickable(registerLink).click();

        return new RegistrationPage(driver);
    }

    public ForgotPasswordPage clickOnForgotPasswordLink() {


        waitUtils.waitForElementClickable(forgotPasswordLink).click();

        return new ForgotPasswordPage(driver);
    }


}
