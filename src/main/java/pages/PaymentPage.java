package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.PageBase;

public class PaymentPage extends PageBase {

    @FindBy (id = "payment-method")
    private WebElement paymentMethodsElement;

    @FindBy (xpath = "//button[@data-test='finish']")
    private WebElement confirmButton;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void selectPaymentMethod(String paymentMethod) {
        Select options = new Select(paymentMethodsElement);
        options.selectByVisibleText(paymentMethod);
    }

    public void clickOnConfirmButton()
    {
        waitUtils.waitForElementClickable(confirmButton).click();
    }


}
