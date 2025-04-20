package tests;

import data.RegistrationDataProvider;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;

import java.util.HashMap;
import java.util.List;


public class HappyScenarioTests extends BaseTest
{
    HomePage homePage;
    CartPage cartPage;
    ProductDetailsPage productDetailsPage;
    SignInPage signInPage;
    BillingAddressPage addressPage;

    @Test(priority = 1)
    public void searchProductName() {
        this.homePage = new HomePage(driver);

        this.homePage.searchForProduct("hammer");

        List<WebElement> productList = homePage.getProducts();

        for(WebElement product : productList) {
            String productTitle = product.getText().toLowerCase();
            Assert.assertTrue(productTitle.contains("hammer"), "Product '" + productTitle + "' does not appear to be a hammer");
        }
    }

    @Test(priority = 2)
    public void addProductToCart() {
        this.homePage = new HomePage(driver);

        ProductDetailsPage detailsPage = homePage.selectProduct("Claw Hammer");
        detailsPage.clickOnAddToCartButton();

        String addToCartMessage = detailsPage.getAddToCartMessage();
        System.out.println(addToCartMessage);
        Assert.assertEquals(addToCartMessage, "Product added to shopping cart.");

        detailsPage.clickOnCartIcon();

        this.cartPage = new CartPage(driver);

        Assert.assertTrue(cartPage.findCartItem("Claw Hammer"), "Claw Hammer was not found in the cart items");
    }

    @Test(priority = 3)
    public void cart() {
        this.cartPage = new CartPage(driver);

        cartPage.updateProductQuantity("Claw Hammer", 2);

        double updatedPrice = cartPage.getTotalPrice();
        System.out.println(updatedPrice);
        Assert.assertEquals(updatedPrice, 22.96, "Updated price is not correct");
        cartPage.clickOnProceedToCheckoutFirstButton();
    }

    @Test(priority = 4, dataProvider = "validRegistrationData", dataProviderClass = RegistrationDataProvider.class)
    public void cartSignIn(HashMap<String, String> testData)
    {
        this.signInPage = new SignInPage(driver);

        RegistrationPage registrationPage = signInPage.clickOnRegisterLink();
        registrationPage.enterFirstName(testData.get("firstName"));
        registrationPage.enterLastName(testData.get("lastName"));
        registrationPage.selectDateOfBirth(testData.get("day"), testData.get("month"), testData.get("year"));
        registrationPage.enterStreet(testData.get("street"));
        registrationPage.enterPostalCode(testData.get("postalCode"));
        registrationPage.enterCity(testData.get("city"));
        registrationPage.enterState(testData.get("state"));
        registrationPage.selectCountry(testData.get("country"));
        registrationPage.enterPhone(testData.get("phone"));
        registrationPage.enterEmail(testData.get("email"));
        registrationPage.enterPassword(testData.get("password") );
        registrationPage.clickOnRegisterButton();
        signInPage.signIn(testData.get("email"), testData.get("password"));
        signInPage.clickOnCartIcon();

        this.cartPage = new CartPage(driver);

        cartPage.clickOnProceedToCheckoutFirstButton();
        cartPage.clickOnProceedToCheckoutSecondButton();

    }
    @Test(priority = 5)
    public void billingAddress() {
        addressPage = new BillingAddressPage(driver);
        addressPage.clickOnProceedToCheckoutButton();
    }

    @Test(priority = 6)
    public void payment()
    {
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.payCashOnDelivery();
        paymentPage.clickOnConfirmButton();
        Assert.assertEquals(paymentPage.getSuccessPaymentMessage(), "Payment was successful");
    }
}