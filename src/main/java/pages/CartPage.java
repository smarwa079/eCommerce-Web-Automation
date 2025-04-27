package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PageBase;

import java.time.Duration;
import java.util.NoSuchElementException;

import java.util.List;
import java.util.stream.IntStream;

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
        return cartItemsList.size();
    }

    @Step("Get cart item name: {productName}, quantity: {quantity}")
    public void updateProductQuantity(String productName, int quantity)
    {
        double oldTotalPrice = getTotalPrice();

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

                            // Wait until the total price is updated
                            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                            wait.until((ExpectedCondition<Boolean>) driver -> {
                                double updatedTotalPrice = getTotalPrice();
                                return updatedTotalPrice != oldTotalPrice;
                            });

                        },
                        () -> { throw new NoSuchElementException("Product '" + productName + "' not found in cart!"); }
                );

    }

    @Step ("Click on remove product button: {productName}")
    public void clickOnRemoveProductButton(String productName)
    {
        List<WebElement>  cartItemsList = driver.findElements(cartItems);

        int index = IntStream.range(0, cartItemsList.size())
                .filter(i -> cartItemsList.get(i).getText().equals(productName))
                .findFirst()
                .orElse(-1);

        if (index != -1)
        {
            List<WebElement> removeButtonsList = driver.findElements(removeButtons);
            waitUtils.waitForElementClickable(removeButtonsList.get(index)).click();
        }
    }

    @Step ("Get total price")
    public double getTotalPrice()
    {
        return Double.parseDouble(waitUtils.waitForElementVisible(totalPrice).getText().replace("$", ""));
    }

    @Step ("Click on Proceed to checkout button")
    public void clickOnProceedToCheckoutFirstButton() {
        waitUtils.waitForElementClickable(proceedToCheckout1).click();
    }

    @Step ("Click on Proceed to checkout button")
    public void clickOnProceedToCheckoutSecondButton() {
        waitUtils.waitForElementClickable(proceedToCheckout2).click();
    }

}
