package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

    protected WebDriver driver;

    @FindBy (linkText = "Home")
    protected WebElement homeLinkElement;

    @FindBy (linkText = "Categories")
    protected WebElement categoriesDropdownElement;

    @FindBy (linkText = "Contact")
    protected WebElement contactLinkElement;

    @FindBy (linkText = "Sign in")
    protected WebElement signInLinkElement;

    @FindBy (css = "a[aria-label='cart']")
    protected WebElement cartLinkElement;

    public PageBase(WebDriver driver)
    {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void clickOnHomeLink()
    {
        homeLinkElement.click();
    }

    public void clickOnCategoriesLink()
    {
        categoriesDropdownElement.click();
    }

    public void selectCategory(String category)
    {
        driver.findElement(By.linkText(category)).click();
    }

    public void clickOnContactLink()
    {
        contactLinkElement.click();
    }

    public void clickOnSignInLink()
    {
        signInLinkElement.click();
    }

    public void clickOnCartLink()
    {
        cartLinkElement.click();
    }
}
