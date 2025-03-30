package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PageBase;

public class ProductDetailsPage extends PageBase {

    private By productName = By.cssSelector("h1[data-test='product-name']");
    private By increaseQuantityButton = By.className("btn-increase-quantity");
    private By decreaseQuantityButton = By.className("btn-decrease-quantity");
    private By addToCartButton = By.id("btn-add-to-cart");
    private By addToFavoritesButton = By.id("btn-add-to-favorites");
    private By addToCartMessage = By.id("toast-container");

    private WebElement productNameElement;
    private WebElement increaseQuantityButtonElement;
    private WebElement decreaseQuantityButtonElement;
    private WebElement addToCartButtonElement;
    private WebElement addToFavoritesButtonElement;
    private WebElement addToCartMessageElement;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        productNameElement = driver.findElement(productName);
        return productNameElement.getText();
    }

    public void clickOnIncreaseQuantityButton() {
        increaseQuantityButtonElement = driver.findElement(increaseQuantityButton);
        increaseQuantityButtonElement.click();
    }

    public void clickOnDecreaseQuantityButton() {
        decreaseQuantityButtonElement = driver.findElement(decreaseQuantityButton);
        decreaseQuantityButtonElement.click();
    }

    public void clickOnAddToCartButton() {
        addToCartButtonElement = driver.findElement(addToCartButton);
        addToCartButtonElement.click();
    }

    public void clickOnAddToFavoritesButton() {
        addToFavoritesButtonElement = driver.findElement(addToFavoritesButton);
        addToFavoritesButtonElement.click();
    }

    public String getAddToCartMessage() {
        addToCartMessageElement = driver.findElement(addToCartMessage);
        return addToCartMessageElement.getText();
    }
}
