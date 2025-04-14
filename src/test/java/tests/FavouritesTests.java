package tests;

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
    Favorites favorites;

    @Test(priority = 3)
    public void addProductToFavourites()
    {
        this.pageBase = new PageBase(driver);

        this.commonPage = pageBase.clickOnHomeLink();

        this.productDetailsPage = commonPage.selectProduct("Combination Pliers");
        productDetailsPage.clickOnAddToFavoritesButton();
        Assert.assertEquals(productDetailsPage.getAddToFavouritesMessage(),"Product added to your favorites list." );
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        productDetailsPage.clickOnAddToFavoritesButton();
        Assert.assertEquals(productDetailsPage.getAddToFavouritesMessage(),"Product already in your favorites list." );
    }

    @Test(priority = 4)
    public void viewFavourites()
    {
        this.pageBase = new PageBase(driver);

        pageBase.clickOnAccountDropdown();
        pageBase.clickOnMyFavorites();

        this.favorites = new Favorites(driver);
        Assert.assertEquals(favorites.getProductFromFavorites("Combination Pliers"),"Combination Pliers");
    }

    @Test(priority = 5)
    public void removeProductFromFavourites()
    {
        this.favorites = new Favorites(driver);

        favorites.deleteProductFromFavorites("Combination Pliers");

        Assert.assertEquals(favorites.deleteProductMessage(), "There are no favorites yet. In order to add favorites, please go to the product listing and mark some products as your favorite.");
    }
}
