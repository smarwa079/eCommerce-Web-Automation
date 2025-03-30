package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PageBase;

public class ForgotPasswordPage extends PageBase {

    private By emailField = By.id("email");
    private By sendNewPasswordButton = By.className("btnSubmit");

    private WebElement emailFieldElement;
    private WebElement sendNewPasswordButtonElement;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        emailFieldElement = driver.findElement(emailField);
        emailFieldElement.sendKeys(email);
    }

    public void clickOnSendNewPasswordButton() {
        sendNewPasswordButtonElement = driver.findElement(sendNewPasswordButton);
        sendNewPasswordButtonElement.click();
    }
}
