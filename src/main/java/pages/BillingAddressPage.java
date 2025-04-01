package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageBase;

public class BillingAddressPage extends PageBase {

    @FindBy (id = "street")
    WebElement streetFieldElement;

    @FindBy (id = "city")
    WebElement cityFieldElement;

    @FindBy (id = "state")
    WebElement stateFieldElement;

    @FindBy (id = "country")
    WebElement countryFieldElement;

    @FindBy (id = "postal_code")
    WebElement postCodeFieldElement;

    @FindBy (xpath = "//button[text()='Proceed to checkout ']")
    WebElement proceedToCheckoutButtonElement;

    public BillingAddressPage(WebDriver driver) {
        super(driver);
    }

    public void enterStreet(String street) {
        streetFieldElement.sendKeys(street);
    }

    public void enterCity(String city) {
        cityFieldElement.sendKeys(city);
    }

    public void enterState(String state) {
        stateFieldElement.sendKeys(state);
    }

    public void enterCountry(String country) {
        countryFieldElement.sendKeys(country);
    }

    public void enterPostCode(String postCode) {
        postCodeFieldElement.sendKeys(postCode);
    }

    public void clickOnProceedToCheckoutButton() {
        proceedToCheckoutButtonElement.click();
    }
}
