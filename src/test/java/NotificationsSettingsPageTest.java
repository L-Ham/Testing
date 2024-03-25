import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NotificationsSettingsPageTest extends TestBase {
    private NotificationsSettingsPage notificationsSettingsPage;
    private AccountSettingsPage accountSettingsPage;
    private LoginPage loginPage;

    @BeforeTest
    public void getNotificationsSettingsPage() {
        notificationsSettingsPage = new NotificationsSettingsPage(driver);
        loginPage = new LoginPage(driver);
        accountSettingsPage = new AccountSettingsPage(driver);
    }

    @Test
    public void changeMessagesNotificationsTest() {
        loginPage.login("Ill_Initial_3945", "/m4!2QHj!saysm4");
        implicitWait(5);
        accountSettingsPage.openSettings();
        implicitWait(5);
        notificationsSettingsPage.openNotificationsTab();
        implicitWait(5);
        notificationsSettingsPage.changeMessagesNotifications();
        implicitWait(5);
        Assert.assertTrue(driver.findElement(notificationsSettingsPage.privateMessagesCheckboxLocator).isDisplayed());
        implicitWait(5);
    }

    @Test
    public void changeActivityNotificationsTest() throws InterruptedException {
        loginPage.login("Ill_Initial_3945", "/m4!2QHj!saysm4");
        implicitWait(5);
        accountSettingsPage.openSettings();
        implicitWait(5);
        notificationsSettingsPage.openNotificationsTab();
        implicitWait(5);
        notificationsSettingsPage.changeMentionsNotifications();
        Thread.sleep(10000);
        notificationsSettingsPage.changeCommentsNotifications();
        Thread.sleep(10000);
        notificationsSettingsPage.changeUpvotesOnPostsNotifications();
        Thread.sleep(10000);
        notificationsSettingsPage.changeUpvotesOnCommentsNotifications();
        Thread.sleep(10000);
        notificationsSettingsPage.changeRepliesToCommentsNotifications();
        Thread.sleep(10000);
        notificationsSettingsPage.changeActivityOnCommentNotifications();
        Thread.sleep(10000);
        notificationsSettingsPage.changeActivityOnChatPostsNotifications();
        Thread.sleep(10000);
        notificationsSettingsPage.changeNewFollowersNotifications();
        Thread.sleep(10000);
        notificationsSettingsPage.changeAwardsReceivedNotifications();
        Thread.sleep(10000);
        notificationsSettingsPage.changePostsFollowedNotifications();
        Thread.sleep(10000);
        notificationsSettingsPage.changeCommentsFollowedNotifications();
        Thread.sleep(10000);
        Assert.assertTrue(driver.findElement(notificationsSettingsPage.usernameMentionsCheckboxLocator).isDisplayed());
        implicitWait(5);
    }
}