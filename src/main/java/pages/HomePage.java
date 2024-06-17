package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(text(),'New Post')]")
    private WebElement newPostButton;

    public void navigateToNewPost() {
        waitForElementToAppear(newPostButton);
        newPostButton.click();
        System.out.println("New Post button clicked");
    }
}
