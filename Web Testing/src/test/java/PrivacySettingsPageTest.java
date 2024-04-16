import dev.failsafe.internal.util.Durations;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
public class PrivacySettingsPageTest extends TestBase {
    private PrivacySettingsPage privacySettingsPage;
    private AccountSettingsPage accountSettingsPage;
   private LoginPage loginPage;


    @BeforeTest
    public void getProfileSettingsPage() {
        loginPage = new LoginPage(driver);
        accountSettingsPage = new AccountSettingsPage(driver);
        privacySettingsPage = new PrivacySettingsPage(driver);
    }

    @Test
    public void getPrivacySettingsPageTest() throws InterruptedException{
        loginPage.login("Marly", "1234567890");
        explicitWait(10, accountSettingsPage.userProfileLocator);
        accountSettingsPage.openSettings();
        explicitWait(10, privacySettingsPage.privacyTabLocator);
        privacySettingsPage.openPrivacyTab();
        explicitWait(10, privacySettingsPage.privacyFAQLinkLocator);
        privacySettingsPage.openPrivacyFAQ();
    }

    @Test
    public void blockUserTest() {
        loginPage.login("Marly", "1234567890");
        explicitWait(10, accountSettingsPage.userProfileLocator);
        accountSettingsPage.openSettings();
        explicitWait(10, privacySettingsPage.privacyTabLocator);
        privacySettingsPage.openPrivacyTab();
        privacySettingsPage.blockUser("fahdseddik");
        privacySettingsPage.blockUser("gaser");
        privacySettingsPage.blockUser("amrashraf");

    }

    @Test
    public void unblockUserTest() {
        loginPage.login("Marly", "1234567890");
        explicitWait(10, accountSettingsPage.userProfileLocator);
        accountSettingsPage.openSettings();
        explicitWait(10, privacySettingsPage.privacyTabLocator);
        privacySettingsPage.openPrivacyTab();
        privacySettingsPage.unblockUser("fahdseddik");
    }

    @Test
    public void muteCommunityTest() {
        loginPage.login("Marly", "1234567890");
        explicitWait(10, accountSettingsPage.userProfileLocator);
        accountSettingsPage.openSettings();
        explicitWait(10, privacySettingsPage.privacyTabLocator);
        privacySettingsPage.openPrivacyTab();
        privacySettingsPage.muteCommunity("xXegasiXx");
        privacySettingsPage.muteCommunity("OnePiece");
    }

    @Test
    public void unmuteCommunityTest() {
        loginPage.login("Marly", "1234567890");
        explicitWait(10, accountSettingsPage.userProfileLocator);
        accountSettingsPage.openSettings();
        explicitWait(10, privacySettingsPage.privacyTabLocator);
        privacySettingsPage.openPrivacyTab();
        privacySettingsPage.unmuteCommunity("xXegasiXx");
    }

    @Test
    public void togglePrivacySettingsTest() {
        loginPage.login("Marly", "1234567890");
        explicitWait(10, accountSettingsPage.userProfileLocator);
        accountSettingsPage.openSettings();
        explicitWait(10, privacySettingsPage.privacyTabLocator);
        privacySettingsPage.openPrivacyTab();
        privacySettingsPage.showUpInResults();
        privacySettingsPage.personalizedAds();
        privacySettingsPage.isAlcohol();
        privacySettingsPage.isDating();
        privacySettingsPage.isGambling();
        privacySettingsPage.isPregnancy();
        privacySettingsPage.isWeightLoss();
        privacySettingsPage.twoFactorAuth();

    }
}
