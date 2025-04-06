package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageBase;

import java.util.List;
import java.util.NoSuchElementException;

public class CartPage extends PageBase {
    // THIS OLD PATH DIDN'T WORK
    By cartItems = By.xpath("//td[@class='col-md-4'] //span[@class='product-title']");
    By quantityInputs = By.xpath("//input[@data-test='product-quantity']");
    By removeButtons = By.cssSelector(".btn.btn-danger");
    By proceedToCheckout1 = By.xpath("//button[@data-test='proceed-1']");
    By proceedToCheckout2 = By.xpath("//button[@data-test='proceed-2']");
    By updateCartMessage = By.xpath("//div[@role='alert']");
    By totalPrice = By.xpath("//td[@data-test='cart-total']");

    public CartPage(WebDriver driver)
    {
        super(driver);
    }
// THIS METHOD DIDN'T WORK
    public boolean findCartItem(String productName)
    {
        waitUtils.waitForElementVisible(cartItems);
        List<WebElement>  cartItemsList = driver.findElements(cartItems);
        return cartItemsList.stream().anyMatch(i -> i.getText().equals(productName));
    }

    public int getCartItemsCount()
    {
        List<WebElement>  cartItemsList = driver.findElements(cartItems);
        return cartItemsList.size();
    }
// THIS METHOD DIDN'T WORK
    public void updateProductQuantity(String productName, int quantity)
    {
        List<WebElement>  cartItemsList = driver.findElements(cartItems);

        List<WebElement> items = cartItemsList.stream().filter(i -> i.getText().equals(productName)).toList();

        int index = items.indexOf(productName);

        List<WebElement> quantityInputsList = driver.findElements(quantityInputs);

        waitUtils.waitForElementVisible(quantityInputsList.get(index)).sendKeys(Integer.toString(quantity));
    }

    public void updateQuantity(String productName, int quantity){
        List<WebElement>  cartItemsList = driver.findElements(cartItems);
        cartItemsList.stream()
                .filter(item -> item.getText().contains(productName)) // Checks if product exists
                .findFirst() // Takes the first match (if any)
                .ifPresentOrElse(
                        item -> {
                            // Find the quantity input INSIDE the same cart item (no index needed)
                            WebElement qtyInput = item.findElement(quantityInputs);
                            qtyInput.clear();
                            qtyInput.sendKeys(String.valueOf(quantity));
                            qtyInput.sendKeys(Keys.ENTER);

                        },
                        () -> { throw new NoSuchElementException("Product '" + productName + "' not found in cart!"); }
                );

    }

    public void clickOnRemoveProductButton(String productName)
    {
        List<WebElement>  cartItemsList = driver.findElements(cartItems);

        List<WebElement> items = cartItemsList.stream().filter(i -> i.getText().equals(productName)).toList();

        int index = items.indexOf(productName);

        List<WebElement> removeButtonsList = driver.findElements(removeButtons);

        waitUtils.waitForElementClickable(removeButtonsList.get(index)).click();

    }

    public double getTotalPrice()
    {
        waitUtils.waitForElementVisible(updateCartMessage).click();
        return Double.parseDouble(waitUtils.waitForElementVisible(totalPrice).getText().replace("$", ""));
    }

    public void clickOnProceedToCheckoutFirstButton() {
        waitUtils.waitForElementClickable(proceedToCheckout1).click();
    }

    public void clickOnProceedToCheckoutSecondButton() {
        waitUtils.waitForElementClickable(proceedToCheckout2).click();
    }

}
