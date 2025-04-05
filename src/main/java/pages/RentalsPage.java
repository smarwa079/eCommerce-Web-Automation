package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageBase;

import java.util.List;

public class RentalsPage extends PageBase {

    @FindBy (css = ".card-title")
    List<WebElement> rentalsLists;

    public RentalsPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailsPage selectRentalProduct(String productName)
    {
        WebElement rentalElement= rentalsLists.stream()
                .filter(rent -> rent.getText().equalsIgnoreCase(productName))
                .findFirst()
                .get();

        waitUtils.waitForElementClickable(rentalElement).click();

        return new ProductDetailsPage(driver);
    }
}
