package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage extends CommonPage {

    By searchField = By.id("search-query");
    By searchButton = By.xpath("//button[text()='Search']");
    By resetSearchButton = By.xpath("//button[@data-test='search-reset']");

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    @Step ("Search for product: {searchQuery}")
    public void searchForProduct(String searchQuery)
    {
        WebElement searchFieldElement = driver.findElement(searchField);
        searchFieldElement.clear();
        searchFieldElement.sendKeys(searchQuery);
        waitUtils.waitForElementClickable(searchButton).click();
        refreshProductsList();
    }

    @Step ("Click on reset search button")
    public void clickOnResetSearchButton()
    {
        waitUtils.waitForElementClickable(resetSearchButton).click();
    }
}