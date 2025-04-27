package pages;

import io.qameta.allure.Step;
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

    @Step ("Enter street: {street}")
    public void enterStreet(String street)
    {
        waitUtils.waitForElementVisible(streetField).sendKeys(street);
    }

    @Step ("Enter city: {city}")
    public void enterCity(String city)
    {
        waitUtils.waitForElementVisible(cityField).sendKeys(city);
    }

    @Step ("Enter state: {state}")
    public void enterState(String state)
    {
        waitUtils.waitForElementVisible(stateField).sendKeys(state);
    }

    @Step ("Enter country: {country}")
    public void enterCountry(String country)
    {
        waitUtils.waitForElementVisible(countryField).sendKeys(country);
    }

    @Step ("Enter postal code: {postCode}")
    public void enterPostCode(String postCode)
    {
        waitUtils.waitForElementVisible(postCodeField).sendKeys(postCode);
    }

    @Step("Click on Proceed to Checkout button")
    public void clickOnProceedToCheckoutButton() {
        waitUtils.waitForElementClickable(proceedToCheckoutButton).click();
    }
}
