package Pages;

import Utility.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InfoModalPage {
    @FindBy(xpath = "//div[@class='sweet-alert  showSweetAlert visible']/p")
    WebElement modalInfo;
    WebDriver driver;
    public static WebDriverWait wait;
    public  InfoModalPage(WebDriver driver){
        this.driver = driver;
        this.wait = DriverFactory.getWait();
        PageFactory.initElements(driver,this);
    }
    public String getTextFromWebElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
    public String getDetailPurchase() {
        return getTextFromWebElement(modalInfo);
    }
}
