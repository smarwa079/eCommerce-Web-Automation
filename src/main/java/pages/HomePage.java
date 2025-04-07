package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class HomePage extends CommonPage {

    By searchField = By.id("search-query");
    By searchButton = By.xpath("//button[text()='Search']");
    By resetSearchButton = By.xpath("//button[@data-test='search-reset']");

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    public void enterSearchForProduct(String searchQuery)
    {
        WebElement searchFieldElement = driver.findElement(searchField);
        searchFieldElement.sendKeys(searchQuery);
        waitUtils.waitForElementClickable(searchButton).click();
    }

    public List<WebElement> getSearchResults()
    {
        String oldFirstProductName = productsList.getFirst().getText();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(driver -> {
            String newFirstProductName = driver.findElement(products).getText();
            return !newFirstProductName.equals(oldFirstProductName);
        });

        return driver.findElements(products);
    }

    public void clickOnResetSearchButton()
    {
        waitUtils.waitForElementClickable(resetSearchButton).click();
    }
}