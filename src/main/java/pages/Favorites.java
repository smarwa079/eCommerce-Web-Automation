package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PageBase;

import java.util.List;

public class Favorites extends PageBase {

    By productsNames = By.xpath("//h5[@data-test='product-name']");
    By deleteButtons = By.xpath("//button[@data-test='delete']");
    By removeMessage = By.xpath("//div[@class='ng-star-inserted']");

    public Favorites(WebDriver driver)
    {
        super(driver);
    }

    public String getProductFromFavorites(String productName)
    {
        List<WebElement> productsNamesList = driver.findElements(productsNames);
        List<WebElement> product = productsNamesList.stream().filter(p -> p.getText().equalsIgnoreCase(productName)).toList();

        return (product.isEmpty())? "Not Found" : product.getFirst().getText();
    }

    public void deleteProductFromFavorites(String productName)
    {
        List<WebElement> productsNamesList = driver.findElements(productsNames);
        List<WebElement> product = productsNamesList.stream().filter(p -> p.getText().equalsIgnoreCase(productName)).toList();

        int indexes = productsNamesList.indexOf(product.get(0));

        List<WebElement> deleteButtonsList = driver.findElements(deleteButtons);
        waitUtils.waitForElementClickable(deleteButtonsList.get(indexes)).click();
        waitUtils.waitForElementInvisibility(productsNames);
    }

    public  String deleteProductMessage()
    {
        String message =  waitUtils.waitForElementVisible(removeMessage).getText();
        return message;
    }

}
