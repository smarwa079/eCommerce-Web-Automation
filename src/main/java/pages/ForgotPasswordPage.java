package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PageBase;

public class ForgotPasswordPage extends PageBase {

    By emailField = By.id("email");
    By sendNewPasswordButton = By.className("btnSubmit");

    public ForgotPasswordPage(WebDriver driver)
    {
        super(driver);
    }

    @Step("Enter email: {email}")
    public void enterEmail(String email)
    {
        WebElement emailFieldElement = driver.findElement(emailField);
        emailFieldElement.sendKeys(email);
    }

    public boolean isPasswordResetSent() {
        try {

            WebElement successMessage = waitUtils.waitForElementVisible(By.xpath("//div[contains(text(),'Password reset link sent')]"));
            return successMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSendNewPasswordButtonClickable() {
        try {
            waitUtils.waitForElementClickable(sendNewPasswordButton);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Click on Send New Password button")
    public void clickOnSendNewPasswordButton()
    {
        waitUtils.waitForElementClickable(sendNewPasswordButton).click();
    }
}
