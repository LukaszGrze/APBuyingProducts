package BuyingProducts;

import BuyingProducts.pages.*;
import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StorePageBase {
    MainPage mainPage;
    AuthenticationPage authenticationPage;
    MyAccountPage myAccountPage;
    WomenPage womenPage;
    PrintedDressPage printedDressPage;
    CartPage cartPage;
    PrintedSummerDressPage printedSummerDressPage;
    CheckoutPage checkoutPage;

    WebDriver driver;
    String URL = "http://automationpractice.com/";
    String email = "testmail2000@gmail.pl";
    String password = "testpassword";
    String userName = "Luke Skywalker";
    String pdExpectedName = "Printed Dress";
    String pdQuantity = "2";
    String pdSize = "M";
    String pdExpectedPrintedDressColourAndSize = "Color : Orange, Size : M";
    String pdExpectedUnitPrice = "$26.00";
    String pdExpectedTotalProductPrice = "$52.00";
    String psdExpectedName = "Printed Summer Dress";
    String psdQuantity = "3";
    String psdSize = "L";
    String psdExpectedPrintedDressColourAndSize = "Color : Blue, Size : L";
    String psdExpectedUnitPrice = "$28.98";
    String psdExpectedTotalProductPrice = "$86.94";
    String psdExpectedDiscount = "-5%";
    String comment = "Some random text";
    String expectedTotalPriceOfProducts = "$138.94";
    String expectedTotalShipping = "$2.00";
    String expectedTotalPriceOfProductsWithShipment = "$140.94";
    String expectedSignInButtonText = "Sign in";

    @Before
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        mainPage = new MainPage(driver);
    }

    @After
    public void driverQuit() {
        driver.quit();
    }
}
