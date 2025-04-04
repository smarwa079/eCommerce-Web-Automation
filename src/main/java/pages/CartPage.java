package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageBase;

import java.util.List;

public class CartPage extends PageBase {

    @FindBy (xpath = "//table[@class='table table-hover']/tbody/tr/td[1]")
    List<WebElement>  cartItemsList;

    @FindBy (xpath = "//input[@data-test='product-quantity']")
    List<WebElement> quantityInputsList;

    @FindBy (xpath = "//table[@class='table table-hover']/tbody/tr/td[3]")
    List<WebElement> pricesList;

    @FindBy (css = ".btn.btn-danger")
    List<WebElement> removeButtonsList;

    @FindBy(xpath = "//button[text()='Proceed to checkout']")
    public WebElement proceedToCheckoutElement;

    @FindBy(xpath = "//td[@data-test='cart-total']")
    WebElement totalPriceElement;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int getCartItemsCount() {
        return cartItemsList.size();
    }

    public void updateProductQuantity(String productName, int quantity) {
        List<WebElement> items = cartItemsList.stream().filter(i -> i.getText().equalsIgnoreCase(productName)).toList();

        int index = items.indexOf(productName);

        quantityInputsList.get(index).sendKeys(Integer.toString(quantity));
    }

    public void clickOnRemoveProductButton(String productName) {
        List<WebElement> items = cartItemsList.stream().filter(i -> i.getText().equalsIgnoreCase(productName)).toList();

        int index = items.indexOf(productName);

        removeButtonsList.get(index).click();

    }

    public double getTotalPrice() {
        return Double.parseDouble(totalPriceElement.getText().replace("$", ""));
    }

    public void clickOnProceedToCheckoutButton() {
        proceedToCheckoutElement.click();
    }

}
