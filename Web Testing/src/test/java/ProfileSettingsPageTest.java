import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProfileSettingsPageTest extends TestBase {
    private ProfileSettingsPage profileSettingsPage;
    private AccountSettingsPage accountSettingsPage;
    private LoginPage loginPage;

    @BeforeTest
    public void getProfileSettingsPage() {
        profileSettingsPage = new ProfileSettingsPage(driver);
        loginPage = new LoginPage(driver);
        accountSettingsPage = new AccountSettingsPage(driver);
    }

    @Test
    public void changeDisplayNameTest() {
        loginPage.login("Marly", "1234567890");
        explicitWait(10, accountSettingsPage.userProfileLocator);
        accountSettingsPage.openSettings();
        explicitWait(10, profileSettingsPage.profileTabLocator);
        profileSettingsPage.openProfileTab();
        implicitWait(10);
        profileSettingsPage.changeDisplayName("Marlyyyy");
        explicitWait(10, profileSettingsPage.displayNameTextBoxLocator);
        Assert.assertTrue(driver.findElement(profileSettingsPage.displayNameTextBoxLocator).isDisplayed());

    }

    @Test
    public void changeAboutTest() {
        loginPage.login("Marly", "1234567890");
        explicitWait(10, accountSettingsPage.userProfileLocator);
        accountSettingsPage.openSettings();
        explicitWait(10, profileSettingsPage.profileTabLocator);
        profileSettingsPage.openProfileTab();
        explicitWait(10, profileSettingsPage.aboutTextboxLocator);
        profileSettingsPage.changeAbout("My name is Marly, I am a software engineer and I love coding.");
        explicitWait(10, profileSettingsPage.aboutTextboxLocator);
        Assert.assertTrue(driver.findElement(profileSettingsPage.aboutTextboxLocator).isDisplayed());

    }

    @Test
    public void addCustomURLTest() {
        loginPage.login("Marly", "1234567890");
        explicitWait(10, accountSettingsPage.userProfileLocator);
        accountSettingsPage.openSettings();
        explicitWait(10, profileSettingsPage.profileTabLocator);
        profileSettingsPage.openProfileTab();
        profileSettingsPage.addCustomURL("https://www.linkedin.com/in/marly-kh/", "LinkedIn");

    }
}
