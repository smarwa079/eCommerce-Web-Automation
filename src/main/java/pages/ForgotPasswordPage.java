package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageBase;

public class ForgotPasswordPage extends PageBase {

    @FindBy (id = "email")
    private WebElement emailFieldElement;

    @FindBy (className = "btnSubmit")
    private WebElement sendNewPasswordButtonElement;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        emailFieldElement.sendKeys(email);
    }

    public void clickOnSendNewPasswordButton() {
        sendNewPasswordButtonElement.click();
    }
}
