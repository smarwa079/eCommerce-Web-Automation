package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageBase {

    protected WebDriver driver;

    protected By homeLink = By.linkText("Home");
    protected By categoriesDropdown = By.linkText("Categories");
    protected By contactLink = By.linkText("Contact");
    protected By SignInLink = By.linkText("Sign in");
    protected By cartLink = By.cssSelector("a[aria-label='cart']");

    public PageBase(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickOnHomeLink()
    {
        driver.findElement(homeLink).click();
    }

    public void clickOnCategoriesLink()
    {
        driver.findElement(categoriesDropdown).click();
    }

    public void selectCategory(String category)
    {
        driver.findElement(By.linkText(category)).click();
    }

    public void clickOnContactLink()
    {
        driver.findElement(contactLink).click();
    }

    public void clickOnSignInLink()
    {
        driver.findElement(SignInLink).click();
    }

    public void clickOnCartLink()
    {
        driver.findElement(cartLink).click();
    }
}
