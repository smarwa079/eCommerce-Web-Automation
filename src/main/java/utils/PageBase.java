package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.SignInPage;

public class PageBase {

    protected WebDriver driver;
    protected WaitUtils waitUtils;

    protected By homeLink = By.linkText("Home");
    protected By categoriesDropdown = By.linkText("Categories");
    protected By contactLink = By.linkText("Contact");
    protected By signInLink = By.linkText("Sign in");
    protected By cartIcon = By.cssSelector("a[data-test='nav-cart'] fa-icon svg");
    protected By myAccountDropdown = By.xpath("//li[@role='menuitem']//a[@data-test='nav-menu']");

    public PageBase(WebDriver driver)
    {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnHomeLink()
    {
        waitUtils.waitForElementClickable(homeLink).click();
    }

    public void clickOnCategoriesLink()
    {
       waitUtils.waitForElementClickable( categoriesDropdown).click();
    }

    public void selectCategory(String category)
    {
        WebElement categoryElement = driver.findElement(By.linkText(category));
        waitUtils.waitForElementClickable(categoryElement).click();
    }

    public void clickOnContactLink()
    {
        waitUtils.waitForElementClickable(contactLink).click();
    }

    public SignInPage clickOnSignInLink()
    {
        waitUtils.waitForElementClickable(signInLink).click();

        return new SignInPage(driver);
    }

    public void clickOnCartIcon()
    {
        waitUtils.waitForElementClickable(cartIcon).click();
    }
}
