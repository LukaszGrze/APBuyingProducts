package BuyingProducts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".button-exclusive")
    WebElement continueButton;
    @FindBy(xpath = "(//span[contains(text(),'Proceed to checkout')])[2]")
    WebElement proceedButton;


    public PrintedDressPage continueShopping() {
        continueButton.click();
        return new PrintedDressPage(driver);

    }


    public CheckoutPage goToCheckoutPage() {
        proceedButton.click();
        return new CheckoutPage(driver);
    }
}
