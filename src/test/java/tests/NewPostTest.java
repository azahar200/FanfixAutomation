package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;
import pages.NewPostPage;
import utils.WebDriverManagerUtil;

public class NewPostTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private NewPostPage newPostPage;

    @BeforeClass
    public void setup() {
        driver = WebDriverManagerUtil.getDriver();
        driver.get("https://client-auth-dev.fanfix.dev/login");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        newPostPage = new NewPostPage(driver);
    }

    @Test
    public void testCreateNewPost() {
        loginPage.login("testqa@mailinator.com", "123456789");
        homePage.navigateToNewPost();
        String caption = "This post is done by automation assignment";
        String path = "src\\test\\resources\\fanfix.png";
        newPostPage.createNewPost(caption, path, 5);

        // Check if the Post button is disabled for prices less than $5
        for (int subPrice = 1; subPrice <= 6; subPrice++) {
            for (int nonSubPrice = 1; nonSubPrice <= 6; nonSubPrice++) {
                newPostPage.setCustomPrices(subPrice, nonSubPrice);
                if (subPrice < 5 || nonSubPrice < 5) {
                    Assert.assertFalse(newPostPage.isPostButtonEnabled(), "Post button should be disabled for prices less than $5");
                } else {
                    Assert.assertTrue(newPostPage.isPostButtonEnabled(), "Post button should be enabled for prices $5 and above");
                }
            }
        }

        // Set prices to $5 and submit the post
        newPostPage.setCustomPrices(5, 5);
        newPostPage.submitPost();

        // Verify the latest post
        boolean isPostCreated = newPostPage.verifyLatestPost(caption);
        Assert.assertTrue(isPostCreated, "The latest post should be created successfully with the correct caption.");
    }

    @AfterClass
    public void teardown() {
        WebDriverManagerUtil.quitDriver();
    }
}
