package Pages;

import Utility.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeCategoriesPage {
    @FindBy (linkText = "Laptops")
    WebElement laptopsCategory;
    WebDriver driver;

    public HomeCategoriesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void navigateToDemoblazeHome(){
        //Dirección a la que quiero que navegue
        driver.navigate().to(PropertiesFile.getProperty("url_base"));
        //Para poner el driver maximizado
        driver.manage().window().maximize();
    }

    public void clickLaptop(){
        //Click categoría Laptops
        laptopsCategory.click();
    }

    public void quit(){
        //Cierro el navegador
        driver.quit();
    }

}
