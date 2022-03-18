import Pages.*;
import Utility.DriverFactory;
import Utility.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class SeleniumTestLaptop {
    //Seteo variable url con la dirección a la que quiero que navegue
    private String url = PropertiesFile.getProperty("url_base");
    //Seteo de Webdriver
    private WebDriver driver = DriverFactory.getDriver();

    @BeforeTest
    public void beforeTest(){
        System.out.println("*****Execution Before Test*****");
        HomeCategoriesPage homeCategoriesPage = new HomeCategoriesPage(driver);
        homeCategoriesPage.navigateToDemoblazeHome();
    }

    @Test
    public void NavigateToDemoblaze() throws Exception {

        //Variables locales de modelo y precio
        String modeloLaptop;
        String precioLaptop;

        //Instancio las pages
        HomeCategoriesPage homeCategoriesPage = new HomeCategoriesPage(driver);
        LaptopsPage laptopsPage = new LaptopsPage(driver);
        ProductPage productPage = new ProductPage(driver);
        MenuPage menuPage = new MenuPage(driver);
        CartPage cartPage = new CartPage(driver);
        PlaceOrderPage placeOrderPage = new PlaceOrderPage(driver);
        PurchaseConfirmationPage purchaseConfirmationPage = new PurchaseConfirmationPage(driver);
        WaitsPage waitsPage = new WaitsPage(driver);


        //Click categoría Laptops
        homeCategoriesPage.clickLaptop();

        Thread.sleep(1000);
        //Click primer laptop
        laptopsPage.clickPrimerProducto(10);

        //Obtengo modelo y precio de la laptop
        modeloLaptop = productPage.getLaptopModel();
        precioLaptop = productPage.getLaptopPrice();
        //Imprimo los datos por consola
        System.out.println("El modelo de la laptop es " + modeloLaptop + " y tiene un precio de " + precioLaptop);

        //Agrego al cart el producto
        productPage.clickAddToCart();

        // Espero a la presencia del alert, retorno testo y lo con el texto esperado "producto agregado"
        Assert.assertEquals(waitsPage.waitForAlert(),"Product added");

        //Voy al cart
        menuPage.clickCart();

        // Obtengo titulo y precio
        System.out.println("- Cart Info -" + "\n" +"Título: " + cartPage.getProductTitle() +"\n"+ "Precio: " + cartPage.getProductPrice());
        Assert.assertEquals(modeloLaptop, cartPage.getProductTitle());
        Assert.assertEquals(precioLaptop, cartPage.getProductPrice());

        //Click Place Order
        cartPage.clickPlaceOrder();

        //Completar Formulario de Compra y Click en "Purchase"
        placeOrderPage.formComplete("Maria", "Argentina","Buenos Aires","4444555566667777","12","2025");
        placeOrderPage.clickPurchase();

        //Comparo texto de la confirmación de compra y doy click al boton "OK"
        Assert.assertEquals(purchaseConfirmationPage.getAlertConfirmPurchase(),"Thank you for your purchase!");
        purchaseConfirmationPage.clickOKButton();
    }

   @AfterTest
    public void afterTest(){
        System.out.println("*****Execution After Test*****");
        //Cierro el navegador
        HomeCategoriesPage homeCategoriesPage = new HomeCategoriesPage(driver);
        homeCategoriesPage. quit();
    }

}
