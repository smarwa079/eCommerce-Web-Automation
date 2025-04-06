package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PageBase;

import java.util.List;

public class RentalsPage extends PageBase {

    By rentals = By.cssSelector(".card-title");

    public RentalsPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailsPage selectRentalProduct(String productName)
    {
        List<WebElement> rentalsLists = driver.findElements(rentals);

        WebElement rentalElement= rentalsLists.stream()
                .filter(rent -> rent.getText().equalsIgnoreCase(productName))
                .findFirst()
                .get();

        waitUtils.waitForElementClickable(rentalElement).click();

        return new ProductDetailsPage(driver);
    }
}
