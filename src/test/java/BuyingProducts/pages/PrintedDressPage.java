package BuyingProducts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PrintedDressPage {
    private final WebDriver driver;

    public PrintedDressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "quantity_wanted")
    WebElement quantityField;
    @FindBy(id = "group_1")
    WebElement selectSizeButton;
    @FindBy(id = "add_to_cart")
    WebElement addToCartButton;
    @FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")
    WebElement proceedButton;
    @FindBy(css = "a[title='Women']")
    WebElement womenButton;


    public void selectQuantityAndSize(String quantity, String size) {
        quantityField.clear();
        quantityField.sendKeys(quantity);
        new Select(selectSizeButton).selectByVisibleText(size);
    }

    public CartPage addToCart() {
        addToCartButton.click();
        proceedButton.click();
        return new CartPage(driver);
    }


    public WomenPage goToWomenPage() {
        womenButton.click();
        return new WomenPage(driver);
    }
}
