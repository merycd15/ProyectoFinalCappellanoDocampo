package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Utility.DriverFactory.wait;

public class WaitsPage{
    public static String waitForAlert(WebDriver driver){
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        //Obtengo el mensaje del alert
        String alertmessage = alert.getText();
        //Acepto el alert
        alert.accept();
        return alertmessage;
    }
}
