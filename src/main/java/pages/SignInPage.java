package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageBase;

public class SignInPage extends PageBase {

    @FindBy (xpath = "//form[@data-test='login-form'] //input[@id='email']")
    WebElement emailFieldElement;

    @FindBy (xpath = "//form[@data-test='login-form'] //input[@id='password']")
    WebElement passwordFieldElement;

    @FindBy (xpath = "//button[@class='btn btn-outline-secondary']")
    WebElement showPasswordButtonElement;

    @FindBy (css = "input[value='Login']")
    public WebElement loginButtonElement;

    @FindBy (css = "a[data-test='register-link']")
    WebElement registerLinkElement;

    @FindBy (className = "ForgetPwd")
     WebElement forgotPasswordLinkElement;

    public SignInPage(WebDriver driver) {
        super(driver);
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

    public void clickOnLoginButton() {
        loginButtonElement.click();
    }

    public RegistrationPage clickOnRegisterLink() {
        registerLinkElement.click();

        return new RegistrationPage(driver);
    }

    public ForgotPasswordPage clickOnForgotPasswordLink() {
        forgotPasswordLinkElement.click();

        return new ForgotPasswordPage(driver);
    }

}
