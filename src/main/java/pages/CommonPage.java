package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PageBase;

import java.util.List;

public class CommonPage extends PageBase {

    By products = By.xpath("//h5[@data-test='product-name']");
    By categories = By.xpath("//input[@name='category_id']/parent::label");
    By brands = By.xpath("//input[@name='brand_id']/parent::label");
    By nextPageButton = By.xpath("//a[@aria-label='Next']/parent::li");
    By previousPageButton = By.xpath("//a[@aria-label='Previous']/parent::li");

    public List<WebElement> productsList;

    public CommonPage(WebDriver driver)
    {
        super(driver);
        productsList = driver.findElements(products);
    }

    public void filterProductsByCategory(String category)
    {
        List<WebElement> categoriesList = driver.findElements(categories);

        WebElement categoryCheckbox= categoriesList.stream()
                .filter(categoryElement -> categoryElement.getText().equals(category))
                .findFirst()
                .get();

        waitUtils.waitForElementClickable(categoryCheckbox).click();
    }

    public void filterProductsByBrand(String brand)
    {
        List<WebElement> brandsList = driver.findElements(brands);

        WebElement brandCheckbox = brandsList.stream()
                .filter(brandElement -> brandElement.getText().equalsIgnoreCase(brand))
                .findFirst()
                .get();

        waitUtils.waitForElementClickable(brandCheckbox).click();
    }

    public ProductDetailsPage selectProduct(String productName)
    {
        WebElement productElement = productsList.stream()
                .filter(product -> product.getText().equalsIgnoreCase(productName))
                .findFirst()
                .get();

        waitUtils.waitForElementClickable(productElement).click();

        return new ProductDetailsPage(driver);
    }

    public void clickOnNextPageButton()
    {
        waitUtils.waitForElementClickable(nextPageButton).click();
    }

    public void clickOnPreviousPageButton()
    {
        waitUtils.waitForElementClickable(previousPageButton).click();
    }
}
