package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PageBase;

import java.util.List;
import java.util.stream.IntStream;

public class CartPage extends PageBase {

    By cartItems = By.xpath("//table[@class='table table-hover']/tbody/tr/td[1]");
    By quantityInputs = By.xpath("//input[@data-test='product-quantity']");
    By removeButtons = By.cssSelector(".btn.btn-danger");
    By proceedToCheckout1 = By.xpath("//button[@data-test='proceed-1']");
    By proceedToCheckout2 = By.xpath("//button[@data-test='proceed-2']");
    By totalPrice = By.xpath("//td[@data-test='cart-total']");


    public CartPage(WebDriver driver)
    {
        super(driver);
        waitUtils.waitForElementVisible(By.xpath("//table[@class='table table-hover']"));
    }

    public boolean findCartItem(String productName)
    {
        List<WebElement>  cartItemsList = driver.findElements(cartItems);
        return cartItemsList.stream().anyMatch(i -> i.getText().trim().equalsIgnoreCase(productName.trim()));
    }

    public int getCartItemsCount()
    {
        List<WebElement>  cartItemsList = driver.findElements(cartItems);
        return cartItemsList.size();
    }

    public void updateProductQuantity(String productName, int quantity)
    {
        List<WebElement>  cartItemsList = driver.findElements(cartItems);

        int index = IntStream.range(0, cartItemsList.size())
                .filter(i -> cartItemsList.get(i).getText().equalsIgnoreCase(productName))
                .findFirst()
                .orElse(-1);

        if (index != -1)
        {
            List<WebElement> quantityInputsList = driver.findElements(quantityInputs);
            waitUtils.waitForElementVisible(quantityInputsList.get(index)).sendKeys(Integer.toString(quantity));
        }
    }

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

    public double getTotalPrice()
    {
        return Double.parseDouble(waitUtils.waitForElementVisible(totalPrice).getText().replace("$", ""));
    }

    public void clickOnProceedToCheckoutFirstButton() {
        waitUtils.waitForElementClickable(proceedToCheckout1).click();
    }

    public void clickOnProceedToCheckoutSecondButton() {
        waitUtils.waitForElementClickable(proceedToCheckout2).click();
    }

}
