package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryPage extends CommonPage {

    By pageTitle = By.xpath("//h2[@data-test='page-title']");

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    @Step ("Get page title")
    public String getPageTitle()
    {
        return waitUtils.waitForElementVisible(pageTitle).getText();
    }
}
