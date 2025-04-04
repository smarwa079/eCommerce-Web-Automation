package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends CommonPage {

    @FindBy (id = "search-query")
    WebElement searchFieldElement;

    @FindBy (xpath = "//button[text()='Search']")
    WebElement searchButtonElement;

    @FindBy (xpath = "//button[@data-test='search-reset']")
    WebElement resetSearchButtonElement;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void enterSearchQuery(String searchQuery) {
        searchFieldElement.sendKeys(searchQuery);
    }

    public void clickOnSearchButton() {
        searchButtonElement.click();
    }

    public List<WebElement> getSearchResults() {
        return productsList;
    }

    public void clickOnResetSearchButton() {
        resetSearchButtonElement.click();
    }
}