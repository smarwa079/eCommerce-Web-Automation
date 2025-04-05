package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends CommonPage {

    @FindBy (id = "search-query")
    private WebElement searchFieldElement;

    @FindBy (xpath = "//button[text()='Search']")
    private WebElement searchButtonElement;

    @FindBy (xpath = "//button[@data-test='search-reset']")
    private WebElement resetSearchButtonElement;

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    public void enterSearchForProduct(String searchQuery)
    {
        waitUtils.waitForElementVisible(searchFieldElement).sendKeys(searchQuery);
        waitUtils.waitForElementClickable(searchButtonElement).click();
    }

    public void clickOnResetSearchButton()
    {
        waitUtils.waitForElementClickable(resetSearchButtonElement).click();
    }
}