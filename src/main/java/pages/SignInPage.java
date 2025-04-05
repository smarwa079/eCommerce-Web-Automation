package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageBase;

public class SignInPage extends PageBase {

    @FindBy (xpath = "//form[@data-test='login-form'] //input[@id='email']")
    private WebElement emailFieldElement;

    @FindBy (xpath = "//form[@data-test='login-form'] //input[@id='password']")
    private WebElement passwordFieldElement;

    @FindBy (css = "input[value='Login']")
    private WebElement loginButtonElement;

    @FindBy (css = "a[data-test='register-link']")
    WebElement registerLinkElement;

    @FindBy (className = "ForgetPwd")
     WebElement forgotPasswordLinkElement;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void signIn(String email, String password)
    {
        waitUtils.waitForElementVisible(emailFieldElement).sendKeys(email);
        waitUtils.waitForElementVisible(passwordFieldElement).sendKeys(password);
        waitUtils.waitForElementClickable(loginButtonElement).click();
        waitUtils.waitForElementVisible(myAccountElement);
    }

    public RegistrationPage clickOnRegisterLink()
    {
        waitUtils.waitForElementClickable(registerLinkElement).click();

        return new RegistrationPage(driver);
    }

    public ForgotPasswordPage clickOnForgotPasswordLink() {
        forgotPasswordLinkElement.click();

        return new ForgotPasswordPage(driver);
    }

}
