package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PageBase;

public class BillingAddressPage extends PageBase {

    By streetField = By.id("street");
    By cityField = By.id("city");
    By stateField = By.id("state");
    By countryField = By.id("country");
    By postCodeField = By.id("postal_code");
    By proceedToCheckoutButton = By.xpath("//button[@data-test='proceed-3']");

    public BillingAddressPage(WebDriver driver) {
        super(driver);
    }

    public void enterStreet(String street)
    {
        waitUtils.waitForElementVisible(streetField).sendKeys(street);
    }

    public void enterCity(String city)
    {
        waitUtils.waitForElementVisible(cityField).sendKeys(city);
    }

    public void enterState(String state)
    {
        waitUtils.waitForElementVisible(stateField).sendKeys(state);
    }

    public void enterCountry(String country)
    {
        waitUtils.waitForElementVisible(countryField).sendKeys(country);
    }

    public void enterPostCode(String postCode)
    {
        waitUtils.waitForElementVisible(postCodeField).sendKeys(postCode);
    }

    public void clickOnProceedToCheckoutButton() {
        waitUtils.waitForElementClickable(proceedToCheckoutButton).click();
    }
}
