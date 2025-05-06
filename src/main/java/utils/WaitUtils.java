package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class WaitUtils {

    private final WebDriverWait wait;

    public WaitUtils(WebDriver driver)
    {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement waitForElementVisible(WebElement element)
    {
        LogUtils.info("Waiting for element to be visible: ", element.toString());
        return wait.until(visibilityOf(element));
    }

    public WebElement waitForElementVisible(By locator)
    {
        LogUtils.info("Waiting for element to be visible: ", locator.toString());
        return wait.until(visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementClickable(WebElement element)
    {
        LogUtils.info("Waiting for element to be clickable: ", element.toString());
        return wait.until(elementToBeClickable(element));
    }

    public WebElement waitForElementClickable(By locator)
    {
        LogUtils.info("Waiting for element to be clickable: ", locator.toString());
        return wait.until(elementToBeClickable(locator));
    }

    public void waitForElementInvisibility(By locator)
    {
        LogUtils.info("Waiting for element to be invisible: ", locator.toString());
        wait.until(invisibilityOfElementLocated(locator));
    }

    public void waitForElementInvisibility(WebElement element)
    {
        LogUtils.info("Waiting for element to be invisible: ", element.toString());
        wait.until(invisibilityOf(element));
    }
}
