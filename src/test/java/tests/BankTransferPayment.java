package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;
import utils.PageBase;
import utils.WaitUtils;

public class BankTransferPayment extends BaseTest {


    ProductDetailsPage productDetailsPage;
    PageBase pageBase;
    PaymentPage paymentPage;
    HomePage homePage;
    CartPage cartPage;
    BillingAddressPage billingAddressPage;

    @BeforeClass
    public void processToPayment(){

        productDetailsPage = new ProductDetailsPage(driver);
        pageBase = new PageBase(driver);
        paymentPage = new PaymentPage(driver);
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        billingAddressPage = new BillingAddressPage(driver);

        pageBase.clickOnHomeLink();
        ProductDetailsPage detailsPage = homePage.selectProduct("pliers");
        detailsPage.clickOnAddToCartButton();
        detailsPage.clickOnCartIcon();
        cartPage.clickOnProceedToCheckoutFirstButton();
        cartPage.clickOnProceedToCheckoutSecondButton();
        billingAddressPage.clickOnProceedToCheckoutButton();
    }

    @DataProvider(name = "BankData")
    public Object[][] provideBankData() {
        return new Object[][] {
                {"Bank5 Connect", "Yara/", "111FQR"}
        };
    }

    @Test(priority = 1, dataProvider = "BankData")
    public void BankPayment(String bankName, String accountName, String accountNumber){

      paymentPage = new PaymentPage(driver);
      paymentPage.payUsingBankTransfer(bankName, accountName, accountNumber);
      //bug
        Assert.assertTrue(paymentPage.getBankNameErrorMessage().isEmpty());
        Assert.assertEquals(paymentPage.getAccountNameErrorMessage(),"Account name can contain letters, numbers, spaces, periods, apostrophes, and hyphens.");
        //bug
        Assert.assertTrue(paymentPage.getAccountNumberErrorMessage().isEmpty());
    }


}
