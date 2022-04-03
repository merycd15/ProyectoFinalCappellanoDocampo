package Utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DriverFactory {
    public static WebDriver driver;
    private static String browser;
    public static WebDriverWait wait;
    private static final int EXPLICIT_WAIT = 10;
    public static WebDriver getDriver(){
        //Obtengo el browser desde PropertiesFile
        browser = PropertiesFile.getProperty("browser");
        if (browser.equals("chrome")){ //Si el browser obtenido es chrome
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(browser.equals("firefox")){ //Si el browser obtenido es firefox
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if(browser.equals("edge")){ //Si el browser obtenido es edge
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("Tiempo del implicit wait: "+driver.manage().timeouts().getImplicitWaitTimeout());
        // Espera Explicita
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return driver;
    }
    public static WebDriverWait getWait() {
        return wait;
    }
}
