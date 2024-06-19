package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class NewPostPage extends BasePage {

    public NewPostPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//textarea[@id=\"post-caption\"]")
    private WebElement postCaption;

    @FindBy(xpath = "//div[@class='MuiStack-root css-1ud9st0']/button")
    private WebElement plusIcon;

    @FindBy(xpath = "//div[@class='MuiStack-root css-1y8k2lk']/button[contains(text(),'Upload Media')]")
    private WebElement uploadMedia;

    @FindBy(xpath = "//div[@class='filepond--drop-label']/label/span[contains(text(),'Browse')]")
    private WebElement browseButton;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement fileInput;

    @FindBy(xpath = "//div[@class='MuiStack-root css-j7qwjs']/button[contains(text(),'Continue')]")
    private WebElement continueButton;

    @FindBy(xpath = "(//div[@class='MuiBox-root css-cnbb3m']/img)[1]")
    private WebElement selectedMedia;

    @FindBy(xpath = "//div[@class='MuiStack-root css-tyvx3d']/div/button[contains(text(),'Add Media')]")
    private WebElement addMediaButton;

    @FindBy(xpath = "(//div[@class='MuiBox-root css-i9gxme']/div/span/p[contains(text(),'Custom')])[1]")
    private WebElement customSubscriptionPriceChoose;

    @FindBy(xpath = "(//*[@id=\"custom-sub\"])[1]")
    private WebElement customSubscriptionPrice;


    @FindBy(xpath = "(//div[@class='MuiBox-root css-i9gxme']/div/span/p[contains(text(),'Custom')])[2]")
    private WebElement customNonSubscriptionPriceChoose;

    @FindBy(xpath = "(//*[@id=\"custom-sub\"])[2]")
    private WebElement customNonSubscriptionPrice;

    @FindBy(xpath = "//div[@class='MuiStack-root css-dvxtzn']/button[contains(text(),'Post to Profile')]")
    private WebElement postProfileButton;

    @FindBy(xpath = "(//div[@class='MuiStack-root css-1ik4laa'])[1]")
    private WebElement latestPost;

    @FindBy(xpath = "//div[@class='MuiBox-root css-1c9mui1']/p/div")
    private WebElement latestPostCaptions;



    public void createNewPost(String caption, String mediaPath) {
        waitForElementToAppear(postCaption);
        postCaption.sendKeys(caption);
        System.out.println("Post Caption entered");
        waitForElementToAppear(plusIcon);
        plusIcon.click();
        System.out.println("Plus icon button clicked");
        waitForElementToAppear(uploadMedia);
        uploadMedia.click();
        System.out.println("Upload media button clicked");
        sleep(3000);
        waitForElementToAppear(browseButton);
        System.out.println("Browse button clicked");
        fileInput.sendKeys(mediaPath);
        waitForElementToAppear(continueButton);
        continueButton.click();
        System.out.println("Continue button clicked");
        waitForElementToAppear(selectedMedia);
        selectedMedia.click();
        System.out.println("Selected Media button clicked");
        waitForElementToAppear(addMediaButton);
        addMediaButton.click();
        System.out.println("Add Media button clicked");
    }
    public void clearField(WebElement field){
        field.sendKeys(Keys.BACK_SPACE);
        field.sendKeys(Keys.BACK_SPACE);
        field.sendKeys(Keys.BACK_SPACE);
        field.sendKeys(Keys.BACK_SPACE);
        field.sendKeys(Keys.BACK_SPACE);
    }

    public void setCustomPrices(int subscriptionPrice, int nonSubscriptionPrice) {
        customSubscriptionPriceChoose.click();
        waitForElementToAppear(customSubscriptionPrice);
        clearField(customSubscriptionPrice);
        customSubscriptionPrice.sendKeys(String.valueOf(subscriptionPrice));
        customNonSubscriptionPriceChoose.click();
        waitForElementToAppear(customNonSubscriptionPrice);
        clearField(customNonSubscriptionPrice);
        customNonSubscriptionPrice.sendKeys(String.valueOf(nonSubscriptionPrice));
        System.out.println("subscriptionPrice : " +subscriptionPrice+ ", nonSubscriptionPrice : " +nonSubscriptionPrice);
    }

    public boolean isPostButtonEnabled() {
        return postProfileButton.isEnabled();
    }

    public void submitPost(){
        waitForElementToAppear(postProfileButton);
        postProfileButton.click();
        System.out.println("Post profile button clicked");
        sleep(5000);
    }


    public boolean verifyLatestPost(String expectedCaption) {
        driver.navigate().refresh();
        System.out.println("Page refreshed");
        sleep(10000);
        waitForElementToAppear(latestPost);
        latestPost.click();
        System.out.println("latest post button clicked");
        sleep(3000);
        waitForElementToAppear(latestPostCaptions);
        WebElement captionElement = latestPostCaptions;
        return captionElement.getText().equals(expectedCaption);
    }
}
