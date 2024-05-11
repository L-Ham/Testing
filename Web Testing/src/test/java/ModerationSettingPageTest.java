import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.chrono.ThaiBuddhistEra;

public class ModerationSettingPageTest extends TestBase
{
    ModerationSettingsPage moderationSettingsPage;
    SubredditCreationAndFlow subredditCreationAndFlow;
    LoginPage loginPage;
    @BeforeTest
    public void getUerManagment() throws InterruptedException {
        moderationSettingsPage = new ModerationSettingsPage(driver);
        loginPage = new LoginPage(driver);
        subredditCreationAndFlow = new SubredditCreationAndFlow(driver);
        loginPage.login("hadidy", "12345678");
       // System.out.println("Login successfully");
        Thread.sleep(5000);
        moderationSettingsPage.goToUserManagmentPage();
    }
    @DataProvider(name = "banUser")
    public Object[][] banUser()
    {
        return new Object[][] {{"Rana"}};
    }
    @Test(dataProvider = "banUser", priority = 1)
    public void banUserTest(String username)
    {
       String bannedStatus = moderationSettingsPage.banUser(username);
         Assert.assertEquals(bannedStatus, "User banned successfully");
    }
    @Test(priority = 2)
    public void testBanDate() throws InterruptedException
    {
        String banDate = moderationSettingsPage.getBanDate("Rana");
        Assert.assertEquals(banDate, "0 days ago (Permanent)");
    }
    @Test(priority = 3)
    public void banUserNotPostingTest() throws InterruptedException
    {
        driver.navigate().to("https://reddit-bylham.me");
        Thread.sleep(3000);
        loginPage.clickOnLogOut();
        loginPage.login("Rana", "12345678");
        Thread.sleep(5000);
        driver.get("https://reddit-bylham.me/r/CommunityHadidy");
        subredditCreationAndFlow.addTextPost("Title of a banned User", "I am a banned user");
        String status = moderationSettingsPage.banUserNotPosting("Rana", "Title of a banned User");
        Assert.assertEquals(status, "User cannot Post!");
        driver.navigate().to("https://reddit-bylham.me");
        Thread.sleep(3000);
        loginPage.clickOnLogOut();
        loginPage.login("hadidy", "12345678");
        Thread.sleep(4000);
    }

    @Test(priority = 4)
    public void unbanUserTest()
    {
        moderationSettingsPage.goToUserManagmentPage();
        String unbannedStatus = moderationSettingsPage.unbanUser("Rana");
        Assert.assertEquals(unbannedStatus, "User unbanned successfully");
    }

    @Test(priority = 5)
    public void unbannedUserPostingTest() throws InterruptedException
    {
        driver.navigate().to("https://reddit-bylham.me");
        Thread.sleep(3000);
        loginPage.clickOnLogOut();
        loginPage.login("Rana", "12345678");
        Thread.sleep(5000);
        driver.get("https://reddit-bylham.me/r/CommunityHadidy");
        subredditCreationAndFlow.addTextPost("Title of a unbanned User", "I am an unbanned user");
        String status = moderationSettingsPage.banUserNotPosting("Rana", "Title of a unbanned User");
        Assert.assertEquals(status, "User Can Post!");
    }

    @Test(priority = 6)
    public void banAnonUser() throws InterruptedException
    {
        driver.navigate().to("https://reddit-bylham.me");
        Thread.sleep(3000);
        loginPage.clickOnLogOut();
        loginPage.login("hadidy", "12345678");
        Thread.sleep(5000);
        moderationSettingsPage.goToUserManagmentPage();
        String bannedStatus = moderationSettingsPage.banANonUser();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(bannedStatus, "User is not found");
        softAssert.assertAll();
    }

    @Test(priority = 7)
    public void removeAUserFromCommunityTest() throws InterruptedException
    {
        System.out.println("Remove a user from community TESTT");
        Thread.sleep(3000);
        String removedStatus = moderationSettingsPage.removeAUserFromCommunity();
        Assert.assertEquals(removedStatus, "User removed successfuly");
    }
    @Test(priority = 8)
    public void checkJoinedStatusOfRemovedMemberTest() throws InterruptedException
    {
        driver.navigate().to("https://reddit-bylham.me");
        Thread.sleep(3000);
        loginPage.clickOnLogOut();
        loginPage.login("Rana", "12345678");
        Thread.sleep(5000);
        String removedStatus = moderationSettingsPage.checkJoinedStatus();
        Assert.assertEquals(removedStatus, "Join");
    }

    @Test(priority = 9)
    public void inviteUserToCommunityTest() throws InterruptedException
    {
        driver.navigate().to("https://reddit-bylham.me");
        Thread.sleep(3000);
        loginPage.clickOnLogOut();
        loginPage.login("hadidy", "12345678");
        Thread.sleep(5000);
        moderationSettingsPage.goToUserManagmentPage();
        String invitedStatus = moderationSettingsPage.inviteUserToCommunity("fofa");
        Assert.assertEquals(invitedStatus, "Moderator invited successfully");
    }
    @Test(priority = 10)
    public void checkInvitedModeratorIsModeratorTest() throws InterruptedException
    {
        driver.navigate().to("https://reddit-bylham.me");
        Thread.sleep(3000);
        loginPage.clickOnLogOut();
        loginPage.login("fofa", "1234");
        Thread.sleep(5000);
        driver.get("https://reddit-bylham.me/r/CommunityHadidy/about/usermanagement");
        String status = moderationSettingsPage.checkInvitedModeratorIsModerator();
        Assert.assertEquals(status, "Moderator accepted successfuly");
    }








}
