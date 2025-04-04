package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;

import java.time.Duration;


public class HappyScenario extends BaseTest {

    @Test
    public void EndToEndTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        HomePage homePage = new HomePage(driver);
        // explicitWait();
        ProductDetailsPage detailsPage = homePage.selectProduct("Slip Joint Pliers");
        // explicitWait();
        detailsPage.clickOnAddToCartButton();
        // explicitWait();
        String addToCartMessage = detailsPage.getAddToCartMessage();
        detailsPage.clickOnAddToCartMessage();
        CartPage cartPage = detailsPage.clickOnCartLink();
        // explicitWait();
        cartPage.clickOnProceedToCheckoutButton();
        // explicitWait();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clickOnRegisterLink();
        // explicitWait();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterFirstName("yara");
        registrationPage.enterLastName("salah");
        registrationPage.selectDateOfBirth("27", "8", "1996");
        registrationPage.enterStreet("123 main st.");
        registrationPage.enterPostalCode("12345");
        registrationPage.enterCity("Zamalek");
        registrationPage.enterState("cairo");
        registrationPage.selectCountry("Egypt");
        registrationPage.enterPhone("01235675901");
        registrationPage.enterEmail("marwa980@gmail.com");
        registrationPage.enterPassword("m_Salah1234");

        WebDriverWait waits5 = new WebDriverWait(driver, Duration.ofSeconds(10));
        waits5.until(ExpectedConditions.elementToBeClickable(registrationPage.registerButtonElement));

        registrationPage.clickOnRegisterButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(signInPage.loginButtonElement));

        signInPage.enterEmail("marwa980@gmail.com");
        signInPage.enterPassword("m_Salah1234");
        signInPage.clickOnLoginButton();

        Thread.sleep(5000);

        // explicitWait();

        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
        waits.until(ExpectedConditions.elementToBeClickable(registrationPage.cartLinkElement));

        signInPage.clickOnCartLink();
        WebDriverWait wait67 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait67.until(ExpectedConditions.elementToBeClickable(cartPage.proceedToCheckoutElement));

        cartPage.clickOnProceedToCheckoutButton();

        WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait6.until(ExpectedConditions.elementToBeClickable(cartPage.proceedToCheckoutElement));

        cartPage.clickOnProceedToCheckoutButton();

        BillingAddressPage addressPage = new BillingAddressPage(driver);

    }
}
