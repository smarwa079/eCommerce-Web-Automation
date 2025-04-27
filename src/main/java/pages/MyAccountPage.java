package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PageBase;

public class MyAccountPage extends PageBase {

    By favoritesLink = By.cssSelector("a[routerlink='favorites']");
    By profileLink = By.cssSelector("a[routerlink='profile']");
    By invoicesLink = By.cssSelector("a[routerlink='invoices']");
    By messagesLink = By.cssSelector("a[routerlink='messages']");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step ("Click on Favorites Link")
    public void clickOnFavoritesLink()
    {
        WebElement favoritesLinkElement = driver.findElement(favoritesLink);
        favoritesLinkElement.click();
    }

    @Step ("Click on Profile Link")
    public void clickOnProfileLink()
    {
        WebElement profileLinkElement = driver.findElement(profileLink);
        profileLinkElement.click();
    }

    @Step ("Click on Invoices Link")
    public void clickOnInvoicesLink()
    {
        WebElement invoicesLinkElement = driver.findElement(invoicesLink);
        invoicesLinkElement.click();
    }

    @Step ("Click on Messages Link")
    public void clickOnMessagesLink()
    {
        WebElement messagesLinkElement = driver.findElement(messagesLink);
        messagesLinkElement.click();
    }
}
