package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PageBase;

import java.time.Duration;
import java.util.List;

public class CommonPage extends PageBase {

    By products = By.xpath("//h5[@data-test='product-name']");
    By categories = By.xpath("//input[@name='category_id']/parent::label");
    By brands = By.xpath("//input[@name='brand_id']/parent::label");
    By nextPageButton = By.xpath("//a[@aria-label='Next']/parent::li");
    By previousPageButton = By.xpath("//a[@aria-label='Previous']/parent::li");

    public List<WebElement> productsList;

    public CommonPage(WebDriver driver) {
        super(driver);
        refreshProductsList();
    }

    public void refreshProductsList() {
        String oldFirstProductName = productsList == null || productsList.isEmpty() ? "" : productsList.get(0).getText();
        waitForProductsToUpdate(oldFirstProductName);
        productsList = driver.findElements(products);
    }

    private void waitForProductsToUpdate(String oldFirstProductName)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((ExpectedCondition<Boolean>) driver -> {
            List<WebElement> updatedProducts = driver.findElements(products);
            if (updatedProducts.isEmpty()) return false;
            String newFirstProductName = updatedProducts.get(0).getText();
            return !newFirstProductName.equals(oldFirstProductName);
        });
    }

    public List<WebElement> getProducts() {
        if (productsList == null || productsList.isEmpty()) {
            refreshProductsList();
        }
        return productsList;
    }

    public void filterProductsByCategory(String category) {
        List<WebElement> categoriesList = driver.findElements(categories);

        WebElement categoryCheckbox = categoriesList.stream()
                .filter(categoryElement -> categoryElement.getText().equals(category))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Category not found: " + category));

        waitUtils.waitForElementClickable(categoryCheckbox).click();
        refreshProductsList(); // Refresh the product list after filtering
    }

    public void filterProductsByBrand(String brand) {
        List<WebElement> brandsList = driver.findElements(brands);

        WebElement brandCheckbox = brandsList.stream()
                .filter(brandElement -> brandElement.getText().equalsIgnoreCase(brand))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Brand not found: " + brand));

        waitUtils.waitForElementClickable(brandCheckbox).click();
        refreshProductsList(); // Refresh the product list after filtering
    }

    public ProductDetailsPage selectProduct(String productName) {
        if (productsList == null || productsList.isEmpty()) {
            refreshProductsList();
        }
        WebElement productElement = productsList.stream()
                .filter(product -> product.getText().equalsIgnoreCase(productName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found: " + productName));

        waitUtils.waitForElementClickable(productElement).click();
        return new ProductDetailsPage(driver);
    }

    public void clickOnNextPageButton() {
        waitUtils.waitForElementClickable(nextPageButton).click();
        refreshProductsList(); // Refresh the product list after navigating
    }

    public void clickOnPreviousPageButton() {
        waitUtils.waitForElementClickable(previousPageButton).click();
        refreshProductsList(); // Refresh the product list after navigating
    }
}