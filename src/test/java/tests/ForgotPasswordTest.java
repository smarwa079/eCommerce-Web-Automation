package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.SignInPage;
import utils.BaseTest;
import utils.PageBase;

public class ForgotPasswordTest extends BaseTest {

    ForgotPasswordPage forgotPasswordPage;
    SignInPage signInPage;
    PageBase pageBase;

    //BUG
    @Test
    public void forgotMyPassword()
    {
        signInPage = new SignInPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        pageBase = new PageBase(driver);

        pageBase.clickOnSignInLink();
        signInPage.clickOnForgotPasswordLink();
        forgotPasswordPage.enterEmail("marwas00@dmsa0.com");
        forgotPasswordPage.clickOnSendNewPasswordButton();

        Assert.assertTrue(forgotPasswordPage.isSendNewPasswordButtonClickable(),"Button Isn't Clickable");
        Assert.assertTrue(forgotPasswordPage.isPasswordResetSent(), "Button click didn't trigger expected behavior");
    }
}
