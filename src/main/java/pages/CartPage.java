package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageBase;

import java.util.List;

public class CartPage extends PageBase {

    @FindBy (xpath = "//table[@class='table table-hover']/tbody/tr/td[1]")
    private List<WebElement>  cartItemsList;

    @FindBy (xpath = "//input[@data-test='product-quantity']")
    private List<WebElement> quantityInputsList;

    @FindBy (css = ".btn.btn-danger")
    private List<WebElement> removeButtonsList;

    @FindBy(xpath = "//button[@data-test='proceed-1']")
    private WebElement proceedToCheckoutElement1;

    @FindBy(xpath = "//button[@data-test='proceed-2']")
    private WebElement proceedToCheckoutElement2;

    @FindBy(xpath = "//td[@data-test='cart-total']")
    private WebElement totalPriceElement;

    public CartPage(WebDriver driver)
    {
        super(driver);
    }

    public int getCartItemsCount()
    {
        return cartItemsList.size();
    }

    public void updateProductQuantity(String productName, int quantity)
    {
        List<WebElement> items = cartItemsList.stream().filter(i -> i.getText().equalsIgnoreCase(productName)).toList();

        int index = items.indexOf(productName);

        waitUtils.waitForElementVisible(quantityInputsList.get(index)).sendKeys(Integer.toString(quantity));
    }

    public void clickOnRemoveProductButton(String productName)
    {
        List<WebElement> items = cartItemsList.stream().filter(i -> i.getText().equalsIgnoreCase(productName)).toList();

        int index = items.indexOf(productName);

        waitUtils.waitForElementClickable(removeButtonsList.get(index)).click();

    }

    public double getTotalPrice()
    {
        return Double.parseDouble(waitUtils.waitForElementVisible(totalPriceElement).getText().replace("$", ""));
    }

    public void clickOnProceedToCheckoutFirstButton() {
        waitUtils.waitForElementClickable(proceedToCheckoutElement1).click();
    }

    public void clickOnProceedToCheckoutSecondButton() {
        waitUtils.waitForElementClickable(proceedToCheckoutElement2).click();
    }

}
