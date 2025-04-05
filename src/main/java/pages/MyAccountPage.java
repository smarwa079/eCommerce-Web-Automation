package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageBase;

public class MyAccountPage extends PageBase {

    @FindBy (css = "a[routerlink='favorites']")
    private WebElement favoritesLinkElement;

    @FindBy (css = "a[routerlink='profile']")
    private WebElement profileLinkElement;

    @FindBy (css = "a[routerlink='invoices']")
    private WebElement invoicesLinkElement;

    @FindBy (css = "a[routerlink='messages']")
    WebElement messagesLinkElement;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnFavoritesLink()
    {
        waitUtils.waitForElementClickable(favoritesLinkElement).click();
    }

    public void clickOnProfileLink()
    {
        waitUtils.waitForElementClickable(profileLinkElement).click();
    }

    public void clickOnInvoicesLink()
    {
        waitUtils.waitForElementClickable(invoicesLinkElement).click();
    }

    public void clickOnMessagesLink()
    {
        waitUtils.waitForElementClickable(messagesLinkElement).click();
    }
}
