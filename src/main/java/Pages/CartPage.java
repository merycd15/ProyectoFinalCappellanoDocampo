package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    @FindBy(css = "tbody tr:nth-child(1) td:nth-child(2)")
    WebElement titleFirstProductCart;
    WebDriver driver;
    @FindBy(css = "tbody tr:nth-child(1) td:nth-child(3)")
    WebElement priceFirstProductCart;
    @FindBy(xpath = "//button[normalize-space()='Place Order']")
    WebElement buttonPlaceOrder;
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getProductTitle() {
        return titleFirstProductCart.getText();
    }
    public String getProductPrice() {
        return priceFirstProductCart.getText();
    }
    public void clickPlaceOrder(){
        buttonPlaceOrder.click();
    }
}
