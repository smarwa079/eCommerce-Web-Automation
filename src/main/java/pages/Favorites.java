package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageBase;

import java.util.List;

public class Favorites extends PageBase {

    @FindBy (xpath = "//h5[@data-test='product-name']")
    List<WebElement> productsNamesList;

    @FindBy (xpath = "//button[@data-test='delete']")
    List<WebElement> deleteButtonsList;

    public Favorites(WebDriver driver) {
        super(driver);
    }

    public String getProductFromFavorites(String productName)
    {
        List<WebElement> product = productsNamesList.stream().filter(p -> p.getText().equalsIgnoreCase(productName)).toList();

        return (product.isEmpty())? "Not Found" : product.getFirst().getText();
    }

    public void deleteProductFromFavorites(String productName)
    {
        List<WebElement> product = productsNamesList.stream().filter(p -> p.getText().equalsIgnoreCase(productName)).toList();

        int index = product.indexOf(productName);

        deleteButtonsList.get(index).click();
    }

}
