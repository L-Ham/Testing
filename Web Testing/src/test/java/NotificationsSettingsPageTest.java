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
        loginPage.login("Marly", "1234567890");
        explicitWait(10, accountSettingsPage.userProfileLocator);
        accountSettingsPage.openSettings();
        explicitWait(10, notificationsSettingsPage.notificationsTabLocator);
        notificationsSettingsPage.openNotificationsTab();
        Thread.sleep(2000);
        notificationsSettingsPage.changePrivateMessagesNotifications();
        Thread.sleep(2000);
        notificationsSettingsPage.changeChatMessagesNotifications();
        Thread.sleep(2000);
        notificationsSettingsPage.changeChatRequestsNotifications();
    }

    @Test
    public void changeActivityNotificationsTest() throws InterruptedException {
        loginPage.login("Marly", "1234567890");
        explicitWait(10, accountSettingsPage.userProfileLocator);
        accountSettingsPage.openSettings();
        explicitWait(10, notificationsSettingsPage.notificationsTabLocator);
        notificationsSettingsPage.openNotificationsTab();
        Thread.sleep(2000);
        notificationsSettingsPage.changeMentionsNotifications();
        Thread.sleep(2000);
        notificationsSettingsPage.changeCommentsNotifications();
        Thread.sleep(2000);
        notificationsSettingsPage.changeUpvotesOnPostsNotifications();
        Thread.sleep(2000);
        notificationsSettingsPage.changeUpvotesOnCommentsNotifications();
        Thread.sleep(2000);
        notificationsSettingsPage.changeRepliesToCommentsNotifications();
        Thread.sleep(2000);
        notificationsSettingsPage.changeActivityOnCommentNotifications();
        Thread.sleep(2000);
        notificationsSettingsPage.changeActivityOnChatPostsNotifications();
        Thread.sleep(2000);
        notificationsSettingsPage.changeNewFollowersNotifications();
        Thread.sleep(2000);
        notificationsSettingsPage.changeAwardsReceivedNotifications();
        Thread.sleep(2000);
        notificationsSettingsPage.changePostsFollowedNotifications();
        Thread.sleep(2000);
        notificationsSettingsPage.changeCommentsFollowedNotifications();
    }

    @Test
    public void changeRecommendationsNotificationsTest() throws InterruptedException {
        loginPage.login("Marly", "1234567890");
        explicitWait(10, accountSettingsPage.userProfileLocator);
        accountSettingsPage.openSettings();
        explicitWait(10, notificationsSettingsPage.notificationsTabLocator);
        notificationsSettingsPage.openNotificationsTab();
        Thread.sleep(2000);
        notificationsSettingsPage.changeTrendingPostsNotifications();
        Thread.sleep(2000);
        notificationsSettingsPage.changeCommunityRecommendationsNotifications();
        Thread.sleep(2000);
        notificationsSettingsPage.changeReRedditNotifications();
        Thread.sleep(2000);
        notificationsSettingsPage.changeFeaturedContentNotifications();
    }

    @Test
    public void changeUpdatesNotificationsTest() throws InterruptedException {
        loginPage.login("Marly", "1234567890");
        explicitWait(10, accountSettingsPage.userProfileLocator);
        accountSettingsPage.openSettings();
        explicitWait(10, notificationsSettingsPage.notificationsTabLocator);
        notificationsSettingsPage.openNotificationsTab();
        Thread.sleep(2000);
        notificationsSettingsPage.changeAnnouncementsNotifications();
        Thread.sleep(2000);
        notificationsSettingsPage.changeCakeDayNotifications();
        Thread.sleep(2000);
    }
}
