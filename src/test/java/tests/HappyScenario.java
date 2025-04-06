package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;
import utils.WaitUtils;


public class HappyScenario extends BaseTest {

    CommonPage commonPage;
    WaitUtils waitUtils;
    HomePage homePage;
    CartPage cartPage;
    ProductDetailsPage productDetailsPage;

    @Test(priority = 1)
    public void searchProductName() {
        this.commonPage = new CommonPage(driver);
        this.waitUtils = new WaitUtils(driver);
        this.homePage = new HomePage(driver);
        this.homePage.enterSearchForProduct("hammer");

        for(WebElement product : driver.findElements(By.xpath("//div[@class='col-md-9'] //div[@class='container']"))) {
            String productTitle = product.getText().toLowerCase();
            Assert.assertTrue(productTitle.contains("hammer"), "Product '" + productTitle + "' does not appear to be a hammer");
        }

    }

    @Test(priority = 2)
    public void addProductToCart() {
        this.homePage = new HomePage(driver);
        this.cartPage = new CartPage(driver);
        this.waitUtils = new WaitUtils(driver);
        ProductDetailsPage detailsPage = homePage.selectProduct("Claw Hammer");
        detailsPage.clickOnAddToCartButton();
        String addToCartMessage = detailsPage.getAddToCartMessage();
        System.out.println(addToCartMessage);
        detailsPage.clickOnCartIcon();
        waitUtils.waitForElementVisible(By.xpath("//table[@class='table table-hover']/tbody/tr/td[1]"));
       String cartItems = driver.findElement(By.xpath("//td[@class='col-md-4'] //span[@class='product-title']")).getText();
      //  Assert.assertTrue(cartPage.findCartItem("Claw Hammer"));
     Assert.assertTrue(cartItems.contains("Claw Hammer"), "Claw Hammer was not found in the cart items");
    }

    @Test(priority = 3)
    public void cart() {
        cartPage = new CartPage(driver);
        productDetailsPage= new ProductDetailsPage(driver);

        cartPage.updateQuantity("Claw Hammer", 2);
        double updatedPrice =cartPage.getTotalPrice();
        System.out.println(updatedPrice);

    }



//    @Test
//    public void EndToEndTest() throws InterruptedException {
//
//        HomePage homePage = new HomePage(driver);
//
//        ProductDetailsPage detailsPage = homePage.selectProduct("Slip Joint Pliers");
//        detailsPage.clickOnAddToCartButton();
//
//        String addToCartMessage = detailsPage.getAddToCartMessage();
//        System.out.println(addToCartMessage);
//        //Assert.assertEquals(addToCartMessage, "Product added to shopping cart.");
//
//        detailsPage.clickOnCartIcon();
//
//        CartPage cartPage = new CartPage(driver);
//
//        //Assert.assertTrue(cartPage.findCartItem("Slip Joint Pliers"));
//
//        cartPage.clickOnProceedToCheckoutFirstButton();
//
//        SignInPage signInPage = new SignInPage(driver);
//
//        RegistrationPage registrationPage = signInPage.clickOnRegisterLink();
//
//        registrationPage.enterFirstName("marwa");
//        registrationPage.enterLastName("salah");
//        registrationPage.selectDateOfBirth("27", "8", "1996");
//        registrationPage.enterStreet("123 main st.");
//        registrationPage.enterPostalCode("12345");
//        registrationPage.enterCity("Zamalek");
//        registrationPage.enterState("cairo");
//        registrationPage.selectCountry("Egypt");
//        registrationPage.enterPhone("01235675901");
//        registrationPage.enterEmail("marwas980@hiyah000.com");
//        registrationPage.enterPassword("m_Salah1234");
//
//        registrationPage.clickOnRegisterButton();
//
//
//        signInPage.signIn("marwas980@hiyah000.com", "m_Salah1234");
//
//        signInPage.clickOnCartIcon();
//
//        cartPage.clickOnProceedToCheckoutFirstButton();
//
//        cartPage.clickOnProceedToCheckoutSecondButton();
//
//        BillingAddressPage addressPage = new BillingAddressPage(driver);
//
//        addressPage.clickOnProceedToCheckoutButton();
//
//        PaymentPage paymentPage = new PaymentPage(driver);
//        paymentPage.payCashOnDelivery();
//        paymentPage.clickOnConfirmButton();
//
//    }
}
