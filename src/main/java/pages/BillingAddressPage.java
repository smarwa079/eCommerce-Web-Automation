package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.LogUtils;
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
        LogUtils.info("Enter street: ", street);
        waitUtils.waitForElementVisible(streetField).sendKeys(street);
    }

    @Step ("Enter city: {city}")
    public void enterCity(String city)
    {
        LogUtils.info("Enter city: ", city);
        waitUtils.waitForElementVisible(cityField).sendKeys(city);
    }

    @Step ("Enter state: {state}")
    public void enterState(String state)
    {
        LogUtils.info("Enter state: ", state);
        waitUtils.waitForElementVisible(stateField).sendKeys(state);
    }

    @Step ("Enter country: {country}")
    public void enterCountry(String country)
    {
        LogUtils.info("Enter country: ", country);
        waitUtils.waitForElementVisible(countryField).sendKeys(country);
    }

    @Step ("Enter postal code: {postCode}")
    public void enterPostCode(String postCode)
    {
        LogUtils.info("Enter postal code: ", postCode);
        waitUtils.waitForElementVisible(postCodeField).sendKeys(postCode);
    }

    @Step("Click on Proceed to Checkout button")
    public void clickOnProceedToCheckoutButton()
    {
        LogUtils.info("Click on ", proceedToCheckoutButton.toString());
        waitUtils.waitForElementClickable(proceedToCheckoutButton).click();
    }
}
