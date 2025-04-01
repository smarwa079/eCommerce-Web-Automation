package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageBase;

public class MyAccountPage extends PageBase {

    @FindBy (css = "a[routerlink='favorites']")
    WebElement favoritesLinkElement;

    @FindBy (css = "a[routerlink='profile']")
    WebElement profileLinkElement;

    @FindBy (css = "a[routerlink='invoices']")
    WebElement invoicesLinkElement;

    @FindBy (css = "a[routerlink='messages']")
    WebElement messagesLinkElement;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnFavoritesLink() {
        favoritesLinkElement.click();
    }

    public void clickOnProfileLink() {
        profileLinkElement.click();
    }

    public void clickOnInvoicesLink() {
        invoicesLinkElement.click();
    }

    public void clickOnMessagesLink() {
        messagesLinkElement.click();
    }
}
