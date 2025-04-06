package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PageBase;

public class ProductDetailsPage extends PageBase {

    By productName = By.cssSelector("h1[data-test='product-name']");
    By increaseQuantityButton = By.className("btn-increase-quantity");
    By decreaseQuantityButton = By.className("btn-decrease-quantity");
    By addToCartButton = By.xpath("//button[@data-test='add-to-cart']");
    By addToFavoritesButton = By.id("btn-add-to-favorites");
    //
    By addToCartMessage = By.xpath("//div[@role='alert']");

    public ProductDetailsPage(WebDriver driver)
    {
        super(driver);
    }

    public String getProductName()
    {
        WebElement productNameElement = driver.findElement(productName);
        return productNameElement.getText();
    }

    public void clickOnIncreaseQuantityButton()
    {
        waitUtils.waitForElementClickable(increaseQuantityButton).click();
    }

    public void clickOnDecreaseQuantityButton()
    {
        waitUtils.waitForElementClickable(decreaseQuantityButton).click();
    }

    public void clickOnAddToCartButton()
    {
        waitUtils.waitForElementClickable(addToCartButton).click();
        waitUtils.waitForElementVisible(addToCartMessage).click();
    }

    public void clickOnAddToFavoritesButton()
    {
        waitUtils.waitForElementClickable(addToFavoritesButton).click();
    }

    public String getAddToCartMessage()
    {
        return waitUtils.waitForElementVisible(addToCartMessage).getText();
    }
}
