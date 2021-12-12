package BuyingProducts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage {
    private final WebDriver driver;

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    WebElement emailFiled;
    @FindBy(id = "passwd")
    WebElement passwordField;
    @FindBy(id = "SubmitLogin")
    WebElement loginButton;
    @FindBy(css = ".login")
    WebElement signInButton;

    public MyAccountPage logIn(String email, String password) {
        emailFiled.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
        return new MyAccountPage(driver);
    }

    public String checkIfSignOut() {
        return signInButton.getText();
    }
}
