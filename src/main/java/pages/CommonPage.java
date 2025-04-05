package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageBase;

import java.util.List;

public class CommonPage extends PageBase {

    @FindBy (className = "card")
    protected List<WebElement> productsList;

    @FindBy(xpath = "//input[@name='category_id']/parent::label")
    protected List<WebElement> categoriesList;

    @FindBy (xpath = "//input[@name='brand_id']/parent::label")
    protected List<WebElement> brandsList;

    @FindBy (xpath = "//a[@aria-label='Next']/parent::li")
    protected WebElement nextPageButtonElement;

    @FindBy (xpath = "//a[@aria-label='Previous']/parent::li")
    protected WebElement previousPageButtonElement;

    public CommonPage(WebDriver driver) {
        super(driver);
    }

    public void filterProductsByCategory(String category)
    {
        WebElement categoryCheckbox= categoriesList.stream()
                .filter(categoryElement -> categoryElement.getText().equals(category))
                .findFirst()
                .get();

        waitUtils.waitForElementClickable(categoryCheckbox).click();
    }

    public void filterProductsByBrand(String brand)
    {
        WebElement brandCheckbox = brandsList.stream()
                .filter(brandElement -> brandElement.getText().equalsIgnoreCase(brand))
                .findFirst()
                .get();

        waitUtils.waitForElementClickable(brandCheckbox).click();
    }

    public ProductDetailsPage selectProduct(String productName)
    {
        WebElement productElement = productsList.stream()
                .filter(product -> product.findElement(By.tagName("h5")).getText().equalsIgnoreCase(productName))
                .findFirst()
                .get();

        waitUtils.waitForElementClickable(productElement).click();

        return new ProductDetailsPage(driver);
    }

    public void clickOnNextPageButton()
    {
        waitUtils.waitForElementClickable(nextPageButtonElement).click();
    }

    public void clickOnPreviousPageButton()
    {
        waitUtils.waitForElementClickable(previousPageButtonElement).click();
    }
}
