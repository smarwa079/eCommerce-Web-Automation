package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.CommonPage;
import pages.Favorites;
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
    protected By myFavorites = By.xpath("//a[@routerlink='/account/favorites']");
    protected By myFavoritesProducts = By.xpath("//div[@class='row no-gutters']");
    protected By products = By.xpath("//div[@class='col-md-9'] //div[@class='container'] //a[@class='card']");

    public PageBase(WebDriver driver)
    {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public CommonPage clickOnHomeLink()
    {
        waitUtils.waitForElementClickable(homeLink).click();
        waitUtils.waitForElementVisible(products);

        return new CommonPage(driver);
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
    public void clickOnAccountDropdown()
    {
        waitUtils.waitForElementVisible(myAccountDropdown).click();

    }
    public Favorites clickOnMyFavorites()
    {
        waitUtils.waitForElementVisible(myFavorites).click();
        waitUtils.waitForElementVisible(myFavoritesProducts);
        return new Favorites(driver);
    }

}
