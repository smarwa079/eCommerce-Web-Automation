package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.PageBase;

public class PaymentPage extends PageBase {

    @FindBy (id = "payment-method")
    WebDriver paymentMethodsElement;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void selectPaymentMethod(String paymentMethod) {
        Select options = new Select((WebElement) paymentMethodsElement);
        options.selectByVisibleText(paymentMethod);
    }
}
