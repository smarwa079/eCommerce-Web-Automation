package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class WaitUtils {

    private WebDriver driver;
    private WebDriverWait wait;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement waitForElementVisible(WebElement element) {
        return wait.until(visibilityOf(element));
    }

    public WebElement waitForElementVisible(By locator) {
        return wait.until(visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementClickable(WebElement element) {
        return wait.until(elementToBeClickable(element));
    }

    public WebElement waitForElementClickable(By locator) {
        return wait.until(elementToBeClickable(locator));
    }

    public Boolean waitForElementInvisibility(By locator) {
        return wait.until(invisibilityOfElementLocated(locator));
    }


}
