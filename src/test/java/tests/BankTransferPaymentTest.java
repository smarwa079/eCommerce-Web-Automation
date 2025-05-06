package tests;

import data.PaymentDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;
import utils.PageBase;

public class BankTransferPaymentTest extends BaseTest {
    ProductDetailsPage productDetailsPage;
    PageBase pageBase;
    PaymentPage paymentPage;
    HomePage homePage;
    CartPage cartPage;
    BillingAddressPage billingAddressPage;

    @BeforeClass
    public void processToPayment() {

        pageBase = new PageBase(driver);

        pageBase.clickOnHomeLink();

        homePage = new HomePage(driver);

        productDetailsPage = homePage.selectProduct("pliers");
        productDetailsPage.clickOnAddToCartButton();
        productDetailsPage.clickOnCartIcon();

        cartPage = new CartPage(driver);

        cartPage.clickOnProceedToCheckoutFirstButton();
        cartPage.clickOnProceedToCheckoutSecondButton();

        billingAddressPage = new BillingAddressPage(driver);
        billingAddressPage.clickOnProceedToCheckoutButton();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that the bank transfer payment process validates the bank name, account name, and account number correctly.")
    @Test(priority = 1, dataProvider = "BankData", dataProviderClass = PaymentDataProvider.class)
    public void BankPayment(String bankName, String accountName, String accountNumber) {

        paymentPage = new PaymentPage(driver);
        paymentPage.payUsingBankTransfer(bankName, accountName, accountNumber);
        //bug
        Assert.assertTrue(paymentPage.getBankNameErrorMessage().isEmpty());
        Assert.assertEquals(paymentPage.getAccountNameErrorMessage(), "Account name can contain letters, numbers, spaces, periods, apostrophes, and hyphens.");
        //bug
        Assert.assertTrue(paymentPage.getAccountNumberErrorMessage().isEmpty());
    }
}
