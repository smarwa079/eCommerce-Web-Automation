package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends CommonPage {

    @FindBy (xpath = "//h2[@data-test='page-title']")
    WebElement pageTitle;

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle()
    {
        return pageTitle.getText();
    }
}
