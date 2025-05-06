package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.LogUtils;
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
        LogUtils.info("Enter email: ", email);
        WebElement emailFieldElement = driver.findElement(emailField);
        emailFieldElement.sendKeys(email);
    }

    @Step("Click on Send New Password button")
    public void clickOnSendNewPasswordButton()
    {
        LogUtils.info("Click on ", sendNewPasswordButton.toString());
        waitUtils.waitForElementClickable(sendNewPasswordButton).click();
    }
}
