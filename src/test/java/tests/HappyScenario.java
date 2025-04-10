package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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
    SignInPage signInPage;
    BillingAddressPage addressPage;

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
        Assert.assertEquals(updatedPrice, 22.96, "Updated price is not correct");
        cartPage.clickOnProceedToCheckoutFirstButton();
    }

    @DataProvider(name = "registrationData")
    public Object[][] provideRegistrationData() {
        return new Object[][] {
         {"marwa", "salah", "27", "8", "1996", "123 main st.", "12345", "Zamalek", "cairo",
                 "Egypt", "01235675901", "marwass80@gmail.com", "m_Salah1234"}
        };
        }

     @Test(priority = 4, dataProvider = "registrationData")
    public void cartSignIn(String firstName, String lastName, String day, String month, String year, String street, String postalCode, String city, String state,String country, String phone, String email, String password) {
    signInPage = new SignInPage(driver);
    cartPage = new CartPage(driver);

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

    cartPage.clickOnProceedToCheckoutFirstButton();
    cartPage.clickOnProceedToCheckoutSecondButton();

    }
    @Test(priority = 5)
    public void billingAddress() {
        addressPage = new BillingAddressPage(driver);
        addressPage.clickOnProceedToCheckoutButton();
    }

    @Test(priority = 6)
    public void payment() {
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.payCashOnDelivery();
        paymentPage.clickOnConfirmButton();
        Assert.assertEquals(paymentPage.getSuccessPaymentMessage(), "Payment was successful");
    }


}
