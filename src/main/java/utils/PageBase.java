package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.CartPage;
import pages.SignInPage;

public class PageBase {

    protected WebDriver driver;

    @FindBy (linkText = "Home")
    public WebElement homeLinkElement;

    @FindBy (linkText = "Categories")
    public WebElement categoriesDropdownElement;

    @FindBy (linkText = "Contact")
    public WebElement contactLinkElement;

    @FindBy (linkText = "Sign in")
    public WebElement signInLinkElement;

    @FindBy (css = "a[aria-label='cart']")
    public WebElement cartLinkElement;

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

    public SignInPage clickOnSignInLink()
    {
        signInLinkElement.click();

        return new SignInPage(driver);
    }

    public CartPage clickOnCartLink()
    {
        cartLinkElement.click();

        return new CartPage(driver);
    }
}
