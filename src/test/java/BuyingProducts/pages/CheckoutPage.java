package BuyingProducts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private final WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//textarea[@name='message']")
    WebElement formField;
    @FindBy(xpath = "(//span[contains(text(),'Proceed to checkout')])[2]")
    WebElement proceedButton;
    @FindBy(id = "cgv")
    WebElement agreeCheckbox;

    @FindBy(xpath = "//*[@id=\"product_3_14_0_614683\"]/td[2]/p/a")
    WebElement pdName;
    @FindBy(xpath = "//*[@id=\"product_3_14_0_614683\"]/td[2]/small[2]/a")
    WebElement pdColourAndSize;
    @FindBy(id = "product_price_3_14_614683")
    WebElement pdUnitPrice;
    @FindBy(xpath = "//*[@id=\"product_3_14_0_614683\"]/td[5]/span")
    WebElement pdUnitQuantity;
    @FindBy(id = "total_product_price_3_14_614683")
    WebElement pdUnitPriceTotal;

    @FindBy(xpath = "//*[@id=\"product_5_28_0_614683\"]/td[2]/p/a")
    WebElement psdName;
    @FindBy(xpath = "//*[@id=\"product_5_28_0_614683\"]/td[2]/small[2]/a")
    WebElement psdColourAndSize;
    @FindBy(css = ".special-price")
    WebElement psdUnitPrice;
    @FindBy(xpath = "//*[@id=\"product_5_28_0_614683\"]/td[5]/span")
    WebElement psdUnitQuantity;
    @FindBy(id = "total_product_price_5_28_614683")
    WebElement psdUnitPriceTotal;

    @FindBy(id = "total_product")
    WebElement totalProductsPrice;
    @FindBy(id = "total_shipping")
    WebElement totalShippingPrice;
    @FindBy(id = "total_price")
    WebElement totalPrice;

    @FindBy(css = ".bankwire")
    WebElement payByWireButton;
    @FindBy(xpath = "(//span[normalize-space()='I confirm my order'])[1]")
    WebElement confirmationButton;
    @FindBy(css = ".logout")
    WebElement logoutButton;


    public void buyProcedure(String comment) {
        formField.sendKeys(comment);
        proceedButton.click();
        agreeCheckbox.click();
        proceedButton.click();

    }

    public void payByWireAndLogout() {
        payByWireButton.click();
        confirmationButton.click();
        logoutButton.click();

    }

    public String pdCheckName() {
        return pdName.getText();
    }

    public String pdCheckColourAndSize() {
        return pdColourAndSize.getText();
    }

    public String pdCheckUnitPrice() {
        return pdUnitPrice.getText();
    }

    public String pdCheckUnitQuantity() {
        return pdUnitQuantity.getText();
    }

    public String pdCheckTotalProductPrice() {
        return pdUnitPriceTotal.getText();
    }

    public String psdCheckName() {
        return psdName.getText();
    }

    public String psdCheckColourAndSize() {
        return psdColourAndSize.getText();
    }

    public String psdCheckUnitPrice() {
        return psdUnitPrice.getText();
    }

    public String psdCheckUnitQuantity() {
        return psdUnitQuantity.getText();
    }

    public String psdCheckTotalProductPrice() {
        return psdUnitPriceTotal.getText();
    }

    public String checkTotalProductsPrice() {
        return totalProductsPrice.getText();
    }

    public String checkTotalShipping() {
        return totalShippingPrice.getText();
    }

    public String checkTotalPrice() {
        return totalPrice.getText();
    }

}
