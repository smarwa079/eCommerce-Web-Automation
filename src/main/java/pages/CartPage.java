package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageBase;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

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
    private WebElement proceedToCheckoutElement;

    @FindBy(xpath = "//td[@data-test='cart-total']")
    WebElement totalPriceElement;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int getCartItemsCount() {
        return cartItemsList.size();
    }

    public void updateProductQuantity(String productName, int quantity) {
        OptionalInt indexOpt = IntStream.range(0, cartItemsList.size())
                .filter(i -> cartItemsList.get(i).getText().equals(productName))
                .findFirst();

        indexOpt.ifPresent(index -> {
            WebElement quantityInput = quantityInputsList.get(index);
            quantityInput.clear();
            quantityInput.sendKeys(String.valueOf(quantity));
        });
    }

    public void clickOnRemoveProductButton(String productName) {
        OptionalInt indexOpt = IntStream.range(0, cartItemsList.size())
                .filter(i -> cartItemsList.get(i).getText().equals(productName))
                .findFirst();

        // Click the corresponding remove button if the product is found
        indexOpt.ifPresent(index -> removeButtonsList.get(index).click());
    }

    public double getTotalPrice() {
        return Double.parseDouble(totalPriceElement.getText().replace("$", ""));
    }

    public void clickOnProceedToCheckoutButton() {
        proceedToCheckoutElement.click();
    }

}
