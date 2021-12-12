package BuyingProducts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PrintedSummerDressPage {
    private final WebDriver driver;

    public PrintedSummerDressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "old_price_display")
    WebElement oldPrice;
    @FindBy(id = "our_price_display")
    WebElement newPrice;
    @FindBy(id = "reduction_percent_display")
    WebElement discount;
    @FindBy(id = "color_14")
    WebElement blueColor;
    @FindBy(id = "quantity_wanted")
    WebElement quantityField;
    @FindBy(id = "group_1")
    WebElement selectSizeButton;
    @FindBy(id = "add_to_cart")
    WebElement addToCartButton;
    @FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")
    WebElement proceedButton;

    public void selectQuantitySizeColor(String quantity, String size) {
        quantityField.clear();
        quantityField.sendKeys(quantity);
        new Select(selectSizeButton).selectByVisibleText(size);
        blueColor.click();

    }

    public String checkDiscount() {
        return discount.getText();
    }

    public String checkRegular() {
        return oldPrice.getText();
    }

    public String checkCurrent() {
        return newPrice.getText();
    }


    public CartPage addToCard() {
        addToCartButton.click();
        proceedButton.click();
        return new CartPage(driver);
    }
}
