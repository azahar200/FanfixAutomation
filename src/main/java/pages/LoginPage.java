package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    private WebElement loginButton;

    public void login(String email, String password) {
        waitForElementToAppear(emailInput);
        emailInput.sendKeys(email);
        System.out.println("username entered");
        passwordInput.sendKeys(password);
        System.out.println("passwword entered");
        loginButton.click();
        System.out.println("submit button clicked");
        sleep(5000);
    }
}
