package tests;

import com.github.javafaker.Faker;
import data.RegistrationDataProvider;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;


public class HappyScenarioTests extends BaseTest
{
    HomePage homePage;
    CartPage cartPage;
    ProductDetailsPage productDetailsPage;
    SignInPage signInPage;
    BillingAddressPage addressPage;

    Locale locale = Locale.of("en", "US");
    Faker dataFaker = new Faker(locale);
    String firstName = dataFaker.name().firstName();
    String lastName = dataFaker.name().lastName();
    String street = dataFaker.address().streetAddress();
    String postalCode = dataFaker.address().zipCode();
    String city = dataFaker.address().city();
    String state = dataFaker.address().state();
    String country = dataFaker.address().country();
    String phone = dataFaker.phoneNumber().phoneNumber().replaceAll("[^\\d]", "");
    String day = String.valueOf(dataFaker.number().numberBetween(1, 28));
    String month = String.valueOf(dataFaker.number().numberBetween(1, 12));
    String year = String.valueOf(dataFaker.number().numberBetween(1980, 2007));
    String email = dataFaker.internet().emailAddress();
    String password = dataFaker.internet().password(8, 12, true, true, true);

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

    @Test(priority = 4)
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