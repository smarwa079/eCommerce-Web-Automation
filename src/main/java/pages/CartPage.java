package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LogUtils;
import utils.PageBase;

import java.time.Duration;

import java.util.List;

public class CartPage extends PageBase {

    By cartItems = By.xpath("//table[@class='table table-hover']/tbody/tr/td[1]");
    By quantityInputs = By.xpath("//input[@data-test='product-quantity']");
    By removeButtons = By.cssSelector(".btn.btn-danger");
    By proceedToCheckout1 = By.xpath("//button[@data-test='proceed-1']");
    By proceedToCheckout2 = By.xpath("//button[@data-test='proceed-2']");
    By totalPrice = By.xpath("//td[@data-test='cart-total']");
    By updateCartMessage = By.xpath("//div[@role='alert']");

    public CartPage(WebDriver driver)
    {
        super(driver);
        waitUtils.waitForElementVisible(By.xpath("//table[@class='table table-hover']"));
    }

    @Step("Find cart item: {productName}")
    public boolean findCartItem(String productName)
    {
        List<WebElement>  cartItemsList = driver.findElements(cartItems);
        return cartItemsList.stream().anyMatch(i -> i.getText().trim().equalsIgnoreCase(productName.trim()));
    }

    @Step("Get cart items count")
    public int getCartItemsCount()
    {
        List<WebElement>  cartItemsList = driver.findElements(cartItems);
        int itemCount = cartItemsList.size();
        LogUtils.info("Cart items count: ", String.valueOf(itemCount));
        return itemCount;
    }

    @Step("Get cart item name: {productName}, quantity: {quantity}")
    public void updateProductQuantity(String productName, int quantity)
    {
        double oldTotalPrice = getTotalPrice();

        List<WebElement>  cartItemsList = driver.findElements(cartItems);
        cartItemsList.stream()
                .filter(item -> item.getText().contains(productName)) // Checks if the product exists
                .findFirst() // Takes the first match (if any)
                .ifPresentOrElse(
                        item -> {
                            // Find the quantity input INSIDE the same cart item (no index needed)
                            WebElement qtyInput = item.findElement(quantityInputs);
                            qtyInput.clear();
                            qtyInput.sendKeys(String.valueOf(quantity));
                            qtyInput.sendKeys(Keys.ENTER);

                            // Wait until the total price is updated
                            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                            wait.until((ExpectedCondition<Boolean>) driver -> {
                                double updatedTotalPrice = getTotalPrice();
                                return updatedTotalPrice != oldTotalPrice;
                            });

                        },
                        () -> {
                            LogUtils.error("Product '" + productName + "' not found in cart!");
                        }
                );

    }

    @Step ("Click on remove product button: {productName}")
    public void clickOnRemoveProductButton(String productName)
    {
        List<WebElement>  cartItemsList = driver.findElements(cartItems);

        cartItemsList.stream()
                .filter(item -> item.getText().equalsIgnoreCase(productName))
                .findFirst()
                .ifPresentOrElse(
                        item -> {
                            int index = cartItemsList.indexOf(item);
                            List<WebElement> removeButtonsList = driver.findElements(removeButtons);
                            waitUtils.waitForElementClickable(removeButtonsList.get(index)).click();
                        },
                        () -> {
                            LogUtils.error("Product '" + productName + "' not found in cart!");
                        }
                );
    }

    @Step ("Get total price")
    public double getTotalPrice()
    {
        String totalPriceText = waitUtils.waitForElementVisible(totalPrice).getText().replace("$", "");
        LogUtils.info("Total price: ", totalPriceText);
        return Double.parseDouble(totalPriceText);
    }

    @Step ("Click on Proceed to checkout button")
    public void clickOnProceedToCheckoutFirstButton() {
        LogUtils.info("Clicked on", proceedToCheckout1.toString());
        waitUtils.waitForElementClickable(proceedToCheckout1).click();
    }

    @Step ("Click on Proceed to checkout button")
    public void clickOnProceedToCheckoutSecondButton()
    {
        LogUtils.info("Clicked on", proceedToCheckout2.toString());
        waitUtils.waitForElementClickable(proceedToCheckout2).click();
    }

}
