package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageBase;

public class ForgotPasswordPage extends PageBase {

    @FindBy (id = "email")
    WebElement emailFieldElement;

    @FindBy (className = "btnSubmit")
    WebElement sendNewPasswordButtonElement;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        waitUtils.waitForElementVisible(emailFieldElement).sendKeys(email);
    }

    public void clickOnSendNewPasswordButton()
    {
        waitUtils.waitForElementClickable(sendNewPasswordButtonElement).click();
    }
}
