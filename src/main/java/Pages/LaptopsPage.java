package Pages;

import Utility.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaptopsPage {
    @FindBy(linkText = "Sony vaio i5")
    WebElement primerProducto;
    WebDriver driver;
    public static WebDriverWait wait;
    public LaptopsPage(WebDriver driver){
        this.driver = driver;
        this.wait = DriverFactory.getWait();
        PageFactory.initElements(driver,this);
    }
    public void clickOnWebElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    public void clickPrimerProducto(){
        clickOnWebElement(primerProducto);
    }
}
