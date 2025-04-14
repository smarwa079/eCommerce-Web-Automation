package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.ITestResult;

import org.testng.annotations.*;
import pages.HomePage;
import pages.ProductDetailsPage;


import java.io.File;
import java.io.IOException;


public class BaseTest {

    protected static WebDriver driver;

    @BeforeTest
    public void setup()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicesoftwaretesting.com/");
    }
    HomePage homePage;

//    @Test (priority = 1)
//    public void test1()
//    {
//        this.homePage = new HomePage(driver);
//        homePage.searchForProduct("hammer");
//    }
//
//    @Test (priority = 2)
//    public void test2()
//    {
//        this.homePage = new HomePage(driver);
//        ProductDetailsPage detailsPage = homePage.selectProduct("Claw Hammer");
//        detailsPage.clickOnAddToCartButton();
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

    @AfterTest
    public void shutDown()
    {
        driver.quit();
    }

}
