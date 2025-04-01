package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageBase;

public class ProductDetailsPage extends PageBase {

    @FindBy (css = "h1[data-test='product-name']")
    private WebElement productNameElement;

    @FindBy (className = "btn-increase-quantity")
    private WebElement increaseQuantityButtonElement;

    @FindBy (className = "btn-decrease-quantity")
    private WebElement decreaseQuantityButtonElement;

    @FindBy (xpath = "//button[@data-test='add-to-cart']")
    private WebElement addToCartButtonElement;

    @FindBy (id = "btn-add-to-favorites")
    private WebElement addToFavoritesButtonElement;

    @FindBy (xpath = "//div[@role='alert']")
    private WebElement addToCartMessageElement;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return productNameElement.getText();
    }

    public void clickOnIncreaseQuantityButton() {
        increaseQuantityButtonElement.click();
    }

    public void clickOnDecreaseQuantityButton() {
        decreaseQuantityButtonElement.click();
    }

    public void clickOnAddToCartButton() {
        addToCartButtonElement.click();
    }

    public void clickOnAddToFavoritesButton() {
        addToFavoritesButtonElement.click();
    }

    public String getAddToCartMessage() {
        return addToCartMessageElement.getText();
    }

    public void clickOnAddToCartMessage()
    {
        addToCartMessageElement.click();
    }
}
