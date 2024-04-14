import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SettingsTests extends TestBase{


    LoginScreen loginScreen;
    AccountSettingsScreen accountSettingsScreen;
    WebDriverWait wait;
    @BeforeTest
    public void loginSetup()
    {
        loginScreen = new LoginScreen(driver);
    }

    @BeforeTest
    public void accountSettingsSetup()
    {
        accountSettingsScreen = new AccountSettingsScreen(driver);
    }

    @BeforeMethod
    public void waitSetup()
    {
        wait = new WebDriverWait(driver, 10);
    }
    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
               {"davidG@gmail.com", "12345678"},
        };
    }


    @Test (dataProvider= "loginData" ,priority = 1)
    public void updateEmailTest(String email, String password) throws InterruptedException
    {
        System.out.println("Application started...");
        loginScreen.login("david", password);
        accountSettingsScreen.openAccountSettings();
        accountSettingsScreen.updateEmail(email, password);
        System.out.println("Back to the main screen...");
    }

    @Test
    public void changePasswordTest() throws InterruptedException
    {
        loginScreen.login("david", "123456789");
        accountSettingsScreen.openAccountSettings();
        accountSettingsScreen.changePassword("123456789", "12345678", "12345678");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(accountSettingsScreen.passwordChangedLocator)));
        driver.navigate().back();

    }

    @Test
    public void invalidPasswordChangeTest() throws InterruptedException
    {
        loginScreen.login("david", "123456789");
        accountSettingsScreen.openAccountSettings();
        accountSettingsScreen.changePassword("12345678", "12345678","12345678");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(accountSettingsScreen.invalidPasswordLocator)));
    }

    @Test
    public void samePasswordChangeTest() throws InterruptedException
    {
        loginScreen.login("david", "123456789");
        accountSettingsScreen.openAccountSettings();
        accountSettingsScreen.changePassword("123456789", "123456789", "123456789");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(accountSettingsScreen.samePasswordLocator)));
    }

    @Test
    public void manageMessagesNotificationsTest() throws InterruptedException
    {
        loginScreen.login("david", "12345678");
        accountSettingsScreen.openAccountSettings();
        accountSettingsScreen.manageNotifications();
        accountSettingsScreen.managePrivateMessages();
        accountSettingsScreen.manageChatMessages();
        accountSettingsScreen.manageChatRequests();
    }

    @Test
    public void manageActivityNotificationsTest() throws InterruptedException
    {
        loginScreen.login("david", "12345678");
        accountSettingsScreen.openAccountSettings();
        accountSettingsScreen.manageNotifications();
        accountSettingsScreen.manageMentions();
        accountSettingsScreen.manageComments();
        accountSettingsScreen.manageUpvotesOnPosts();
        accountSettingsScreen.manageUpvotesOnComments();
        accountSettingsScreen.manageRepliesToComments();
        accountSettingsScreen.manageNewFollowers();

    }

    @Test
    public void blockUserTest() throws InterruptedException
    {
        loginScreen.login("david", "12345678");
        accountSettingsScreen.openAccountSettings();
        accountSettingsScreen.blockAccount("Soso");
    }

    @Test
    public void unblockUserTest() throws InterruptedException
    {
        loginScreen.login("david", "12345678");
        accountSettingsScreen.openAccountSettings();
        accountSettingsScreen.unblockAccount("Soso");
    }

    @Test
    public void changeGenderTest() throws InterruptedException {
        loginScreen.login("david", "12345678");
        accountSettingsScreen.openAccountSettings();
        accountSettingsScreen.changeGender("I prefer not to say");
    }
}