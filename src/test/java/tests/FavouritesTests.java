package tests;

import data.RegistrationDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;
import utils.PageBase;
import utils.WaitUtils;

public class FavouritesTests extends BaseTest {
    CommonPage commonPage;
    WaitUtils waitUtils;
    ProductDetailsPage productDetailsPage;
    PageBase pageBase;
    SignInPage signInPage;
    RegistrationPage registrationPage;
    Favorites favorites;

    @Test(priority = 1)
    public void addProductToFavourites()
    {
        this.commonPage = new CommonPage(driver);
        this.waitUtils = new WaitUtils(driver);
        this.productDetailsPage = new ProductDetailsPage(driver);

        ProductDetailsPage detailsPage = commonPage.selectProduct("Combination Pliers");
        detailsPage.clickOnAddToFavoritesButton();
        Assert.assertEquals(productDetailsPage.getAddToFavouritesMessage(),"Unauthorized, can not add product to your favorite list.");
    }

    @Test(priority = 2, dataProvider = "registrationValidData", dataProviderClass = RegistrationDataProvider.class)
    public void registerToFavourites(String firstName, String lastName, String day, String month, String year, String street, String postalCode, String city, String state,String country, String phone, String email, String password)
    {
        commonPage = new CommonPage(driver);
        waitUtils = new WaitUtils(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        pageBase = new PageBase(driver);
        signInPage = new SignInPage(driver);
        registrationPage = new RegistrationPage(driver);

        pageBase.clickOnSignInLink();
        signInPage.clickOnRegisterLink();
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
    }
    @Test(priority = 3)
    public void addProductToFavourites2() {
        this.commonPage = new CommonPage(driver);
        this.waitUtils = new WaitUtils(driver);
        this.productDetailsPage = new ProductDetailsPage(driver);
        this.pageBase = new PageBase(driver);


        pageBase.clickOnHomeLink();
        ProductDetailsPage detailsPages = commonPage.selectProduct("Combination Pliers");
        detailsPages.clickOnAddToFavoritesButton();
        Assert.assertEquals(productDetailsPage.getAddToFavouritesMessage(),"Product added to your favorites list." );
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        detailsPages.clickOnAddToFavoritesButton();
        Assert.assertEquals(productDetailsPage.getAddToFavouritesMessage(),"Product already in your favorites list." );

    }

    @Test(priority = 4)
    public void viewFavourites() {
        this.commonPage = new CommonPage(driver);
        this.waitUtils = new WaitUtils(driver);
        this.productDetailsPage = new ProductDetailsPage(driver);
        this.pageBase = new PageBase(driver);
        this.favorites = new Favorites(driver);

        pageBase.clickOnAccountDropdown();
        pageBase.clickOnMyFavorites();
        Assert.assertEquals(favorites.getProductFromFavorites("Combination Pliers"),"Combination Pliers");
    }

    @Test(priority = 5)
    public void removeProductFromFavourites() {
        this.commonPage = new CommonPage(driver);
        this.waitUtils = new WaitUtils(driver);
        this.productDetailsPage = new ProductDetailsPage(driver);
        this.pageBase = new PageBase(driver);
        this.favorites = new Favorites(driver);

        favorites.deleteProductFromFavorites("Combination Pliers");
        Assert.assertEquals(favorites.getProductFromFavorites("Combination Pliers"),"Not Found");
    }
}
