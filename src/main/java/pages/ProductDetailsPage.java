package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageBase;

public class ProductDetailsPage extends PageBase {

    @FindBy (css = "h1[data-test='product-name']")
    WebElement productNameElement;

    @FindBy (className = "btn-increase-quantity")
    WebElement increaseQuantityButtonElement;

    @FindBy (className = "btn-decrease-quantity")
    WebElement decreaseQuantityButtonElement;

    @FindBy (xpath = "//button[@data-test='add-to-cart']")
    WebElement addToCartButtonElement;

    @FindBy (id = "btn-add-to-favorites")
    WebElement addToFavoritesButtonElement;

    @FindBy (xpath = "//div[@role='alert']")
    WebElement addToCartMessageElement;

    public ProductDetailsPage(WebDriver driver)
    {
        super(driver);
    }

    public String getProductName()
    {
        return productNameElement.getText();
    }

    public void clickOnIncreaseQuantityButton()
    {
        waitUtils.waitForElementClickable(increaseQuantityButtonElement).click();
    }

    public void clickOnDecreaseQuantityButton()
    {
        waitUtils.waitForElementClickable(decreaseQuantityButtonElement).click();
    }

    public void clickOnAddToCartButton()
    {
        waitUtils.waitForElementClickable(addToCartButtonElement).click();
        waitUtils.waitForElementVisible(addToCartMessageElement).click();
    }

    public void clickOnAddToFavoritesButton()
    {
        waitUtils.waitForElementClickable(addToFavoritesButtonElement).click();
    }

    public String getAddToCartMessage()
    {
        return waitUtils.waitForElementVisible(addToCartMessageElement).getText();
    }
}
