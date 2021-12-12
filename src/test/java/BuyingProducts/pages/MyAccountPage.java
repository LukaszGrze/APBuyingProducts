package BuyingProducts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    private final WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".account")
    WebElement userInfo;
    @FindBy(css = "a[title='Home']")
    WebElement homeButton;

    public String checkUser() {

        return userInfo.getText();
    }

    public MainPage goToMainPage() {
        homeButton.click();
        return new MainPage(driver);
    }
}
