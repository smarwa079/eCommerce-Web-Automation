package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailsPage;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setup()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicesoftwaretesting.com/");
    }

    @Test
    public void test()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        HomePage homePage = new HomePage(driver);
        homePage.selectProduct("Bolt Cutters");

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

        productDetailsPage.clickOnAddToCartButton();
        productDetailsPage.clickOnAddToCartMessage();

        productDetailsPage.clickOnCartLink();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickOnRemoveProductButton("Bolt Cutters");
    }

    @AfterTest
    public void shutDown()
    {
        driver.quit();
    }

}
