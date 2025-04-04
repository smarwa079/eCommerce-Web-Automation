package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageBase;

import java.util.List;

public class CommonPage extends PageBase {

    @FindBy (className = "card")
    List<WebElement> productsList;

    @FindBy(xpath = "//input[@name='category_id']/parent::label")
    List<WebElement> categoriesList;

    @FindBy (xpath = "//input[@name='brand_id']/parent::label")
    List<WebElement> brandsList;

    @FindBy (xpath = "//a[@aria-label='Next']/parent::li")
    WebElement nextPageButtonElement;

    @FindBy (xpath = "//a[@aria-label='Previous']/parent::li")
    WebElement previousPageButtonElement;

    public CommonPage(WebDriver driver) {
        super(driver);
    }

    public void filterProductsByCategory(String category) {
        categoriesList.stream().filter(categoryElement -> categoryElement.getText().equals(category)).findFirst().get().click();
    }

    public void filterProductsByBrand(String brand) {
        brandsList.stream()
                .filter(brandElement -> brandElement.getText().equalsIgnoreCase(brand))
                .findFirst()
                .ifPresent(element -> element.click());
    }

    public ProductDetailsPage selectProduct(String productName) {
        productsList.stream()
                .filter(product -> product.findElement(By.tagName("h5")).getText().equalsIgnoreCase(productName))
                .findFirst()
                .ifPresent(element -> element.click());

        return new ProductDetailsPage(driver);
    }

    public void clickOnNextPageButton() {
        nextPageButtonElement.click();
    }

    public void clickOnPreviousPageButton() {
        previousPageButtonElement.click();
    }
}
