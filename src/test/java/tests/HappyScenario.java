package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;


public class HappyScenario extends BaseTest {

    @Test
    public void EndToEndTest() throws InterruptedException {

        HomePage homePage = new HomePage(driver);

        ProductDetailsPage detailsPage = homePage.selectProduct("Slip Joint Pliers");
        detailsPage.clickOnAddToCartButton();

        String addToCartMessage = detailsPage.getAddToCartMessage();

        Assert.assertEquals(addToCartMessage, "Product added to shopping cart.");

        detailsPage.clickOnCartIcon();

        CartPage cartPage = new CartPage(driver);

        Assert.assertTrue(cartPage.findCartItem("Slip Joint Pliers"));

        cartPage.clickOnProceedToCheckoutFirstButton();

        SignInPage signInPage = new SignInPage(driver);

        RegistrationPage registrationPage = signInPage.clickOnRegisterLink();

        registrationPage.enterFirstName("marwa");
        registrationPage.enterLastName("salah");
        registrationPage.selectDateOfBirth("27", "8", "1996");
        registrationPage.enterStreet("123 main st.");
        registrationPage.enterPostalCode("12345");
        registrationPage.enterCity("Zamalek");
        registrationPage.enterState("cairo");
        registrationPage.selectCountry("Egypt");
        registrationPage.enterPhone("01235675901");
        registrationPage.enterEmail("smarwas7980@hiyah000.com");
        registrationPage.enterPassword("m_Salah1234");

        registrationPage.clickOnRegisterButton();


        signInPage.signIn("smarwas7980@hiyah000.com", "m_Salah1234");

        signInPage.clickOnCartIcon();

        cartPage.clickOnProceedToCheckoutFirstButton();

        cartPage.clickOnProceedToCheckoutSecondButton();

        BillingAddressPage addressPage = new BillingAddressPage(driver);

        addressPage.clickOnProceedToCheckoutButton();

        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.payCashOnDelivery();
        paymentPage.clickOnConfirmButton();

    }
}
