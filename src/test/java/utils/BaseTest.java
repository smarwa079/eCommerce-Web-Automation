package utils;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

@Listeners(TestListener.class)
public class BaseTest {

    protected static WebDriver driver;

    protected Locale locale = Locale.of("en", "US");
    protected Faker dataFaker = new Faker(locale);
    protected String firstName = dataFaker.name().firstName();
    protected String lastName = dataFaker.name().lastName();
    protected String street = dataFaker.address().streetAddress();
    protected String postalCode = dataFaker.address().zipCode();
    protected String city = dataFaker.address().city();
    protected String state = dataFaker.address().state();
    protected String country = dataFaker.address().country();
    protected String phone = dataFaker.phoneNumber().phoneNumber().replaceAll("[^\\d]", "");
    protected String day = String.valueOf(dataFaker.number().numberBetween(1, 28));
    protected String month = String.valueOf(dataFaker.number().numberBetween(1, 12));
    protected String year = String.valueOf(dataFaker.number().numberBetween(1980, 2007));
    protected String email = dataFaker.internet().emailAddress();
    protected String password = dataFaker.internet().password(8, 12, true, true, true);

    @BeforeTest
    public void setup()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicesoftwaretesting.com/");
    }

    public static String takeScreenshot(String testCaseName) throws IOException
    {
        String filePath = System.getProperty("user.dir") + "/Screenshots/" + testCaseName +".png";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(filePath);
        FileUtils.copyFile(source, destination);

        return filePath;
    }

    @AfterTest
    public void shutDown()
    {
        driver.quit();
    }

}
