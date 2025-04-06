package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryPage extends CommonPage {

    By pageTitle = By.xpath("//h2[@data-test='page-title']");

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle()
    {
        return waitUtils.waitForElementVisible(pageTitle).getText();
    }
}
