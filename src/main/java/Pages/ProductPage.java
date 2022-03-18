package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    @FindBy (css = "h2.name")
    WebElement nameProduct;
    WebDriver driver;

    @FindBy (css = "h3.price-container")
    WebElement priceProduct;

    @FindBy (linkText = "Add to cart")
    WebElement addToCart;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getLaptopModel() {
        return nameProduct.getText();
    }

    public String getLaptopPrice() {
        String priceText = priceProduct.getText();
        int inicioPrice = priceText.indexOf("$") + 1;
        int finPrice = priceText.indexOf("*") - 1;
        return (priceText.substring(inicioPrice, finPrice));
    }

    public void clickAddToCart(){
        addToCart.click();
    }
}
