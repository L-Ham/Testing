import org.testng.annotations.BeforeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
public class FeedSettingsPageTest extends TestBase{
private FeedSettingsPage feedSettingsPage;
private LoginPage loginPage;
private AccountSettingsPage accountSettingsPage;
@BeforeTest
public void getFeedSettingsPage() {
feedSettingsPage = new FeedSettingsPage(driver);
loginPage = new LoginPage(driver);
accountSettingsPage = new AccountSettingsPage(driver);
}

@Test
    public void toggleFeedSettings() {

        loginPage.login("Marly", "1234567890");
        explicitWait(10, accountSettingsPage.userProfileLocator);
        accountSettingsPage.openSettings();
        explicitWait(10, feedSettingsPage.feedTabLocator);
        feedSettingsPage.openFeedTab();
        feedSettingsPage.isMature();
        feedSettingsPage.enableFeedRecommendations();
        feedSettingsPage.autoplayMedia();
        feedSettingsPage.reduceAnimations();
        feedSettingsPage.communityThemes();
        feedSettingsPage.openPostsInNewTab();
        feedSettingsPage.defaultToMarkdowns();

    }

    @Test
    public void sortContent() throws InterruptedException{
        loginPage.login("Marly", "1234567890");
        explicitWait(10, accountSettingsPage.userProfileLocator);
        accountSettingsPage.openSettings();
        explicitWait(10, feedSettingsPage.feedTabLocator);
        feedSettingsPage.openFeedTab();
        explicitWait(10, feedSettingsPage.sortContentButtonLocator);
        feedSettingsPage.sortContent("New");
        feedSettingsPage.sortContent("Top");
        feedSettingsPage.sortContent("Rising");
    }

    @Test
    public void globalView() throws InterruptedException{
        loginPage.login("Marly", "1234567890");
        explicitWait(10, accountSettingsPage.userProfileLocator);
        accountSettingsPage.openSettings();
        explicitWait(10, feedSettingsPage.feedTabLocator);
        feedSettingsPage.openFeedTab();
        feedSettingsPage.globalView("Classic");
        feedSettingsPage.globalView("Compact");
    }



}
