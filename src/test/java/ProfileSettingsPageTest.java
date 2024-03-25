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
        loginPage.login("Ill_Initial_3945", "/m4!2QHj!saysm4");
        implicitWait(5);
        accountSettingsPage.openSettings();
        implicitWait(5);
        profileSettingsPage.openProfileTab();
        implicitWait(5);
        profileSettingsPage.changeDisplayName("Hadidy El Boss");
        implicitWait(5);
        Assert.assertTrue(driver.findElement(profileSettingsPage.displayNameTextBoxLocator).isDisplayed());
        implicitWait(5);
    }

    @Test
    public void changeAboutTest() {
        loginPage.login("Ill_Initial_3945", "/m4!2QHj!saysm4");
        implicitWait(5);
        accountSettingsPage.openSettings();
        implicitWait(5);
        profileSettingsPage.openProfileTab();
        implicitWait(5);
        profileSettingsPage.changeAbout("My name is Hussein el Hadidy, I am a software engineer and I love coding.");
        implicitWait(5);
        Assert.assertTrue(driver.findElement(profileSettingsPage.aboutTextboxLocator).isDisplayed());
        implicitWait(5);
    }
}