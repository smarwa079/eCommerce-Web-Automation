package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PageBase;

import java.util.List;

public class HomePage extends PageBase {

    List<WebElement> productsList;

    By nextPageButton = By.cssSelector("a[aria-label='Next']");
    By previousPageButton = By.cssSelector("a[aria-label='Previous']");

    WebElement nextPageButtonElement;
    WebElement previousPageButtonElement;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void SelectProduct(String productName) {
        productsList = driver.findElements(By.className("card"));

        productsList.stream().filter(product -> product.findElement(By.tagName("h5")).getText().equals(productName)).findFirst().get().click();
    }

    public void clickOnNextPageButton() {
        nextPageButtonElement = driver.findElement(nextPageButton);
        nextPageButtonElement.click();
    }

    public void clickOnPreviousPageButton() {
        previousPageButtonElement = driver.findElement(previousPageButton);
        previousPageButtonElement.click();
    }
}