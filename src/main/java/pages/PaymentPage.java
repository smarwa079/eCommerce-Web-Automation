package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.PageBase;

public class PaymentPage extends PageBase {

    By paymentMethods = By.id("payment-method");
    By bankNameField = By.xpath("//input[@data-test='bank_name']");
    By bankNameErrorMessage = By.xpath("//input[@data-test='bank_name']/following-sibling::div[1]");
    By accountNameField = By.xpath("//input[@data-test='account_name']");
    By accountNameErrorMessage = By.xpath("//input[@data-test='bank_name']/following-sibling::div[2]");
    By accountNumberField = By.xpath("//input[@data-test='account_number']");
    By accountNumberErrorMessage = By.xpath("//input[@data-test='bank_name']/following-sibling::div[3]");
    By confirmButton = By.xpath("//button[@data-test='finish']");
    By successPaymentMessage = By.xpath("//div[@data-test='payment-success-message']");

    private WebElement paymentMethodsElement;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    @Step ("Pay Cash on Delivery")
    public void payCashOnDelivery()
    {
        paymentMethodsElement = driver.findElement(paymentMethods);
        Select options = new Select(paymentMethodsElement);
        options.selectByVisibleText("Cash on Delivery");
    }

    @Step ("Pay using Bank Transfer: {bankName}, {accountName}, {accountNumber}")
    public void payUsingBankTransfer(String bankName, String accountName, String accountNumber)
    {
        paymentMethodsElement = driver.findElement(paymentMethods);
        Select options = new Select(paymentMethodsElement);
        options.selectByVisibleText("Bank Transfer");

        waitUtils.waitForElementVisible(bankNameField).sendKeys(bankName);

        WebElement accountNameFieldElement = driver.findElement(accountNameField);
        accountNameFieldElement.sendKeys(accountName);

        WebElement accountNumberFieldElement = driver.findElement(accountNumberField);
        accountNumberFieldElement.sendKeys(accountNumber);
    }

    @Step ("Get bank name field error message")
    public String getBankNameErrorMessage() {
        return waitUtils.waitForElementVisible(bankNameErrorMessage).getText();
    }

    @Step ("Get account name field error message")
    public String getAccountNameErrorMessage() {
        return waitUtils.waitForElementVisible(accountNameErrorMessage).getText();
    }

    @Step ("Get account number field error message")
    public String getAccountNumberErrorMessage() {
        try{
            return waitUtils.waitForElementVisible(accountNumberErrorMessage).getText();
        }catch(org.openqa.selenium.NoSuchElementException e){
            return "";
        }
    }

    @Step ("Get success payment message")
    public String getSuccessPaymentMessage() {
        return waitUtils.waitForElementVisible(successPaymentMessage).getText();
    }

    @Step ("Click on confirm button")
    public void clickOnConfirmButton()
    {
        waitUtils.waitForElementClickable(confirmButton).click();
    }

}
