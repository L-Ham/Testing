import org.openqa.selenium.interactions.internal.TouchAction;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.appium.java_client.touch.offset.PointOption.point;

public class ModerationTest extends TestBase{
    ModerationScreen moderationPage;
    LoginScreen loginScreen;
    @BeforeTest
    public void setUp() throws InterruptedException
    {
        moderationPage = new ModerationScreen(driver);
        loginScreen = new LoginScreen(driver);
        loginScreen.clickOnLoginButton();
        loginScreen.login("hadidy", "12345678");
    }

    @Test(priority = 1)
    public void openModToolsTest() throws InterruptedException
    {
        Thread.sleep(2000);
        moderationPage.openLeftSidePan();
        Thread.sleep(2000);
        moderationPage.openCommunity();
        Thread.sleep(2000);
       String status = moderationPage.openModTools();
        Thread.sleep(2000);
        Assert.assertEquals(status,"Moderation is found");
    }

    @Test(priority = 2)
    public void openBannedListTest() throws InterruptedException
    {
        Thread.sleep(1000);
        String Status = moderationPage.openBannedUsersList();
        Assert.assertEquals(Status,"Banned List Found");
    }

    @Test(priority = 3)
    public void addBannedUsersTest() throws InterruptedException {
        String status = moderationPage.addBanningInfo();
        Assert.assertEquals(status, "Banned Successfully");
    }

    @Test(priority = 4)
    public void editBannedUserTest() throws InterruptedException {
        String status = moderationPage.editBannedUser();
        Assert.assertEquals(status, "Edited Successfully");
    }

    @Test(priority = 5)
    public void approvedUsersTest() throws InterruptedException

    {
         String status = moderationPage.approvedUser();
         Assert.assertEquals(status, "Approved Successfully");
    }

    @Test(priority = 6)
    public void approvedDate() throws InterruptedException
    {
        String status = moderationPage.getApprovedDate();
        System.out.println(status);
        Assert.assertEquals(status, "Wrong Date");
    }

    @Test (priority = 7)
public void testRedirectionToSendAMessageToAnApprovedUserTest() throws InterruptedException
    {
        String status = moderationPage.testRedirectionToSendAMessageToAnApprovedUser();
        System.out.println(status);
        Assert.assertEquals(status, "Message redirected");
        driver.hideKeyboard();
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
    }

    @Test(priority = 8)
    public void inviteModeratorTest() throws InterruptedException
    {
        String status = moderationPage.inviteModerator();
        Assert.assertEquals(status, "Moderator is invited");
    }

    @Test(priority = 9)
    public void removeModeratorTest() throws InterruptedException
    {
        String status = moderationPage.removeModerator();
        Assert.assertEquals(status, "Moderator is removed");
    }

    @Test(priority = 10)
    public void checkModeratorStatusTest() throws InterruptedException
    {
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        moderationPage.swipeLeft();
        Thread.sleep(2000);
        moderationPage.logout();
        loginScreen.login("sehs", "12345678");
        Thread.sleep(3000);
        moderationPage.openLeftSidePan();
        Thread.sleep(2000);
        String status=moderationPage.checkModeratorOfSubreddit();
        Assert.assertEquals(status, "Not a moderator anymore");
    }






}
