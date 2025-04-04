package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailsPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeSuite
    public void setup()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicesoftwaretesting.com/");
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

//    @Test
//    public void test()
//    {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        HomePage homePage = new HomePage(driver);
//        homePage.selectProduct("Bolt Cutters");
//
//        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
//
//        productDetailsPage.clickOnAddToCartButton();
//        productDetailsPage.clickOnAddToCartMessage();
//
//        productDetailsPage.clickOnCartLink();
//        CartPage cartPage = new CartPage(driver);
//        cartPage.clickOnRemoveProductButton("Bolt Cutters");
//    }

    @AfterMethod
    public void getScreenShot(ITestResult result) throws IOException {
        if(ITestResult.FAILURE == result.getStatus())
        {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File("./ScreenShots/"+result.getName()+".png");
            FileUtils.copyFile(source, destination);
        }

    }

    public void explicitWait()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElements());
    }

//    @AfterSuite
//    public void shutDown()
//    {
//        driver.quit();
//    }

}
