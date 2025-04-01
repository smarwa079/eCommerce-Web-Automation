package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageBase;

public class SignInPage extends PageBase {

    @FindBy (id = "email")
    private WebElement emailFieldElement;

    @FindBy (id = "password")
    private WebElement passwordFieldElement;

    @FindBy (xpath = "//button[@class='btn btn-outline-secondary']")
    private WebElement showPasswordButtonElement;

    @FindBy (css = "input[value='Login']")
    private WebElement loginButtonElement;

    @FindBy (css = "a[data-test='register-link']")
    private WebElement registerLinkElement;

    @FindBy (className = "ForgetPwd")
    private WebElement forgotPasswordLinkElement;

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
