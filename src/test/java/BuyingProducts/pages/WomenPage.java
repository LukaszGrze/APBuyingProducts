package BuyingProducts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenPage {
    private final WebDriver driver;

    public WomenPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//a[@title='Printed Dress'][normalize-space()='Printed Dress'])[1]")
    WebElement printedDress;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div[2]/ul/li[5]/div/div[2]/h5/a")
    WebElement printedSummerDress;


    public PrintedDressPage goToPrintedDressPage() {
        printedDress.click();
        return new PrintedDressPage(driver);
    }

    public PrintedSummerDressPage goToPrintedSummerDressPage() {
        printedSummerDress.click();
        return new PrintedSummerDressPage(driver);
    }
}
