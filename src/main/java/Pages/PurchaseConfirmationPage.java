package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseConfirmationPage {
    @FindBy(xpath = "//h2[normalize-space()='Thank you for your purchase!']")
    WebElement alertConfirmPurchase;
    WebDriver driver;
    @FindBy(xpath = "//button[normalize-space()='OK']")
    WebElement okButton;
    public PurchaseConfirmationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickOKButton(){
        okButton.click();
    }
    public String getAlertConfirmPurchase(){
        return alertConfirmPurchase.getText();
    }
}
