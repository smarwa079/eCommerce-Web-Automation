package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.SignInPage;

public class PageBase {

    protected WebDriver driver;
    protected WaitUtils waitUtils;

    @FindBy (linkText = "Home")
    protected WebElement homeLinkElement;

    @FindBy (linkText = "Categories")
    protected WebElement categoriesDropdownElement;

    @FindBy (linkText = "Contact")
    protected WebElement contactLinkElement;

    @FindBy (linkText = "Sign in")
    protected WebElement signInLinkElement;

    @FindBy (css = "a[data-test='nav-cart'] fa-icon svg")
    protected WebElement cartIconElement;

    @FindBy (xpath = "//li[@role='menuitem']//a[@data-test='nav-menu']")
    protected WebElement myAccountElement;

    public PageBase(WebDriver driver)
    {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);

        PageFactory.initElements(driver, this);
    }

    public void clickOnHomeLink()
    {
        waitUtils.waitForElementClickable(homeLinkElement).click();
    }

    public void clickOnCategoriesLink()
    {
       waitUtils.waitForElementClickable( categoriesDropdownElement).click();
    }

    public void selectCategory(String category)
    {
        WebElement categoryElement = driver.findElement(By.linkText(category));
        waitUtils.waitForElementClickable(categoryElement).click();
    }

    public void clickOnContactLink()
    {
        waitUtils.waitForElementClickable(contactLinkElement).click();
    }

    public SignInPage clickOnSignInLink()
    {
        waitUtils.waitForElementClickable(signInLinkElement).click();

        return new SignInPage(driver);
    }

    public void clickOnCartIcon()
    {
        waitUtils.waitForElementClickable(cartIconElement).click();
    }
}
