package Pages;

import Utility.DriverFactory;
import Utility.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeCategoriesPage {
    @FindBy (linkText = "Laptops")
    WebElement laptopsCategory;
    WebDriver driver;
    public static WebDriverWait wait;
    public HomeCategoriesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = DriverFactory.getWait();
        PageFactory.initElements(driver,this);
    }
    public void navigateToDemoblazeHome(){
        //Dirección a la que quiero que navegue
        driver.navigate().to(PropertiesFile.getProperty("url_base"));
        //Para poner el driver maximizado
        driver.manage().window().maximize();
    }
    public void clickOnWebElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    public void clickLaptop(){
        clickOnWebElement(laptopsCategory);
    }
}
