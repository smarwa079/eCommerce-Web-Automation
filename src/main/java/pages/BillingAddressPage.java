package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageBase;

public class BillingAddressPage extends PageBase {

    @FindBy (id = "street")
    private WebElement streetFieldElement;

    @FindBy (id = "city")
    private WebElement cityFieldElement;

    @FindBy (id = "state")
    private WebElement stateFieldElement;

    @FindBy (id = "country")
    private WebElement countryFieldElement;

    @FindBy (id = "postal_code")
    private WebElement postCodeFieldElement;

    @FindBy (xpath = "//button[@data-test='proceed-3']")
    private WebElement proceedToCheckoutButtonElement;

    public BillingAddressPage(WebDriver driver) {
        super(driver);
    }

    public void enterStreet(String street) {
        waitUtils.waitForElementVisible(streetFieldElement).sendKeys(street);
    }

    public void enterCity(String city) {
        waitUtils.waitForElementVisible(cityFieldElement).sendKeys(city);
    }

    public void enterState(String state) {
        waitUtils.waitForElementVisible(stateFieldElement).sendKeys(state);
    }

    public void enterCountry(String country) {
        waitUtils.waitForElementVisible(countryFieldElement).sendKeys(country);
    }

    public void enterPostCode(String postCode) {
        waitUtils.waitForElementVisible(postCodeFieldElement).sendKeys(postCode);
    }

    public void clickOnProceedToCheckoutButton() {
        waitUtils.waitForElementClickable(proceedToCheckoutButtonElement).click();
    }
}
