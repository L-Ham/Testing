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
    public void changeMessagesNotificationsTest() throws InterruptedException {
        loginPage.login("Ill_Initial_3945", "/m4!2QHj!saysm4");
        implicitWait(5);
        accountSettingsPage.openSettings();
        implicitWait(5);
        notificationsSettingsPage.openNotificationsTab();
        implicitWait(5);
        notificationsSettingsPage.changePrivateMessagesNotifications();
        Thread.sleep(5500);
        notificationsSettingsPage.changeChatMessagesNotifications();
        Thread.sleep(5500);
        notificationsSettingsPage.changeChatRequestsNotifications();
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
        Thread.sleep(5500);
        notificationsSettingsPage.changeCommentsNotifications();
        Thread.sleep(5500);
        notificationsSettingsPage.changeUpvotesOnPostsNotifications();
        Thread.sleep(5500);
        notificationsSettingsPage.changeUpvotesOnCommentsNotifications();
        Thread.sleep(5500);
        notificationsSettingsPage.changeRepliesToCommentsNotifications();
        Thread.sleep(5500);
        notificationsSettingsPage.changeActivityOnCommentNotifications();
        Thread.sleep(5500);
        notificationsSettingsPage.changeActivityOnChatPostsNotifications();
        Thread.sleep(5500);
        notificationsSettingsPage.changeNewFollowersNotifications();
        Thread.sleep(5500);
        notificationsSettingsPage.changeAwardsReceivedNotifications();
        Thread.sleep(5500);
        notificationsSettingsPage.changePostsFollowedNotifications();
        Thread.sleep(5500);
        notificationsSettingsPage.changeCommentsFollowedNotifications();
    }

    @Test
    public void changeRecommendationsNotificationsTest() throws InterruptedException {
        loginPage.login("Ill_Initial_3945", "/m4!2QHj!saysm4");
        implicitWait(5);
        accountSettingsPage.openSettings();
        implicitWait(5);
        notificationsSettingsPage.openNotificationsTab();
        implicitWait(5);
        notificationsSettingsPage.changeTrendingPostsNotifications();
        Thread.sleep(5500);
        notificationsSettingsPage.changeCommunityRecommendationsNotifications();
        Thread.sleep(5500);
        notificationsSettingsPage.changeReRedditNotifications();
        Thread.sleep(5500);
        notificationsSettingsPage.changeFeaturedContentNotifications();
    }

    @Test
    public void changeUpdatesNotificationsTest() throws InterruptedException {
        loginPage.login("Ill_Initial_3945", "/m4!2QHj!saysm4");
        implicitWait(5);
        accountSettingsPage.openSettings();
        implicitWait(5);
        notificationsSettingsPage.openNotificationsTab();
        implicitWait(5);
        notificationsSettingsPage.changeAnnouncementsNotifications();
        Thread.sleep(5500);
        notificationsSettingsPage.changeCakeDayNotifications();
        Thread.sleep(5500);
    }
}