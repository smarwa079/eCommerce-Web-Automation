package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;

import java.util.List;


public class HappyScenarioTests extends BaseTest
{
    HomePage homePage;
    CartPage cartPage;
    ProductDetailsPage productDetailsPage;
    SignInPage signInPage;
    BillingAddressPage addressPage;

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that a product can be searched by name.")
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
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that a product can be added to the cart.")
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
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the cart can be updated with a new quantity.")
    public void cart() {
        this.cartPage = new CartPage(driver);

        cartPage.updateProductQuantity("Claw Hammer", 2);

        double updatedPrice = cartPage.getTotalPrice();
        System.out.println(updatedPrice);
        Assert.assertEquals(updatedPrice, 22.96, "Updated price is not correct");
        cartPage.clickOnProceedToCheckoutFirstButton();
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that a user can register and sign in during the checkout process.")
    public void cartSignIn()
    {
        this.signInPage = new SignInPage(driver);

        RegistrationPage registrationPage = signInPage.clickOnRegisterLink();
        registrationPage.enterFirstName(firstName);
        registrationPage.enterLastName(lastName);
        registrationPage.selectDateOfBirth(day, month, year);
        registrationPage.enterStreet(street);
        registrationPage.enterPostalCode(postalCode);
        registrationPage.enterCity(city);
        registrationPage.enterState(state);
        registrationPage.selectCountry(country);
        registrationPage.enterPhone(phone);
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);
        registrationPage.clickOnRegisterButton();
        signInPage.signIn(email, password);
        signInPage.clickOnCartIcon();

        this.cartPage = new CartPage(driver);

        cartPage.clickOnProceedToCheckoutFirstButton();
        cartPage.clickOnProceedToCheckoutSecondButton();

    }
    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the billing address can be confirmed during checkout.")
    public void billingAddress()
    {
        addressPage = new BillingAddressPage(driver);
        addressPage.clickOnProceedToCheckoutButton();
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that a payment can be successfully processed.")
    public void payment()
    {
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.payCashOnDelivery();
        paymentPage.clickOnConfirmButton();
        Assert.assertEquals(paymentPage.getSuccessPaymentMessage(), "Payment was successful");
    }
}