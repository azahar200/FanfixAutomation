package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    @FindBy(xpath = "//div[@class='MuiStack-root css-j7qwjs']/button[contains(text(),'Continue')]")
    private WebElement continueButton;

    @FindBy(xpath = "(//div[@class='MuiBox-root css-cnbb3m']/img)[1]")
    private WebElement selectedMedia;

    @FindBy(xpath = "//div[@class='MuiStack-root css-tyvx3d']/div/button[contains(text(),'Add Media')]")
    private WebElement addMediaButton;

    @FindBy(xpath = "(//div[@class='MuiBox-root css-i9gxme']/div/span/p[contains(text(),'$5')])[1]")
    private WebElement customSubscriptionPrice;

    @FindBy(xpath = "(//div[@class='MuiBox-root css-i9gxme']/div/span/p[contains(text(),'$5')])[3]")
    private WebElement customNonSubscriptionPrice;

    @FindBy(xpath = "//div[@class='MuiStack-root css-dvxtzn']/button[contains(text(),'Post to Profile')]")
    private WebElement postProfileButton;

    @FindBy(xpath = "postButton")
    private WebElement postButton;

    @FindBy(xpath = "//div[@class='latest-post-caption']")
    private List<WebElement> latestPostCaptions;

    public void createNewPost(String caption, String mediaPath, int customAmount) {
        waitForElementToAppear(postCaption);
        postCaption.sendKeys(caption);
        System.out.println("Post Caption entered");
        waitForElementToAppear(plusIcon);
        plusIcon.click();
        System.out.println("Plus icon button clicked");
        waitForElementToAppear(uploadMedia);
        uploadMedia.click();
        System.out.println("Upload media button clicked");
        waitForElementToAppear(browseButton);
        browseButton.sendKeys(mediaPath);
        System.out.println("Browse button clicked");
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

    public void setCustomPrices(int subscriptionPrice, int nonSubscriptionPrice) {
        customSubscriptionPrice.clear();
        customSubscriptionPrice.sendKeys(String.valueOf(subscriptionPrice));
        customNonSubscriptionPrice.clear();
        customNonSubscriptionPrice.sendKeys(String.valueOf(nonSubscriptionPrice));
    }

    public boolean isPostButtonEnabled() {
        return postButton.isEnabled();
    }

    public void submitPost() {
        postProfileButton.click();
    }

    public boolean verifyLatestPost(String expectedCaption) {
        for (WebElement captionElement : latestPostCaptions) {
            if (captionElement.getText().equals(expectedCaption)) {
                return true;
            }
        }
        return false;
    }
}
