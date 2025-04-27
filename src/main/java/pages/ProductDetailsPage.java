package pages;

import io.qameta.allure.Step;
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
    By addToFavouritesMessage= By.xpath("//div[@role='alert']");
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

    @Step ("Click on increase quantity button")
    public void clickOnIncreaseQuantityButton()
    {
        waitUtils.waitForElementClickable(increaseQuantityButton).click();
    }

    @Step ("Click on decrease quantity button")
    public void clickOnDecreaseQuantityButton()
    {
        waitUtils.waitForElementClickable(decreaseQuantityButton).click();
    }

    @Step ("Click on add to cart button")
    public void clickOnAddToCartButton()
    {
        waitUtils.waitForElementClickable(addToCartButton).click();
        waitUtils.waitForElementVisible(addToCartMessage).click();
    }

    @Step ("Click on add to favorites button")
    public void clickOnAddToFavoritesButton()
    {
        waitUtils.waitForElementClickable(addToFavoritesButton).click();
        waitUtils.waitForElementVisible(addToFavouritesMessage).click();

    }

    @Step ("Get add to favorites message")
    public String getAddToFavouritesMessage()
    {
        return waitUtils.waitForElementVisible(addToFavouritesMessage).getText();
    }

    @Step ("Get add to cart message")
    public String getAddToCartMessage()
    {
        return waitUtils.waitForElementVisible(addToCartMessage).getText();
    }
}
