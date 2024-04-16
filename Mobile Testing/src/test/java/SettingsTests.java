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
               {"MarlyM@gmail.com", "123456789"},
        };
    }


    @Test (dataProvider= "loginData" ,priority = 1)
    public void updateEmailTest(String email, String password) throws InterruptedException
    {
        loginScreen.clickContinueButton();
        loginScreen.clickOnLoginButton();
        loginScreen.login("Marly", password);
        accountSettingsScreen.openAccountSettings();
        accountSettingsScreen.updateEmail(email, password);
        driver.navigate().back();
        driver.navigate().back();
        accountSettingsScreen.closeSidebarButton();
        loginScreen.logout();
    }

    @Test (priority = 2)
    public void changePasswordTest() throws InterruptedException
    {
        loginScreen.login("Marly", "123456789");
        accountSettingsScreen.openAccountSettings();
        accountSettingsScreen.changePassword("123456789", "1234567890", "1234567890");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(accountSettingsScreen.passwordChangedLocator)));
        driver.navigate().back();
        driver.navigate().back();
        accountSettingsScreen.closeSidebarButton();
loginScreen.logout();

    }

    @Test (priority = 3)
    public void invalidPasswordChangeTest() throws InterruptedException
    {
        loginScreen.login("Marly", "1234567890");
        accountSettingsScreen.openAccountSettings();
        accountSettingsScreen.changePassword("12345678", "12345678","12345678");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(accountSettingsScreen.invalidPasswordLocator)));
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        accountSettingsScreen.closeSidebarButton();
        loginScreen.logout();
    }

    @Test (priority = 4)
    public void samePasswordChangeTest() throws InterruptedException
    {
        loginScreen.login("Marly", "1234567890");
        accountSettingsScreen.openAccountSettings();
        accountSettingsScreen.changePassword("1234567890", "1234567890", "1234567890");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(accountSettingsScreen.samePasswordLocator)));
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        accountSettingsScreen.closeSidebarButton();
        loginScreen.logout();
    }

    @Test (priority = 5)
    public void manageMessagesNotificationsTest() throws InterruptedException
    {
        loginScreen.login("Marly", "1234567890");
        accountSettingsScreen.openAccountSettings();
        accountSettingsScreen.manageNotifications();
        accountSettingsScreen.managePrivateMessages();
        accountSettingsScreen.manageChatMessages();
        accountSettingsScreen.manageChatRequests();
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        accountSettingsScreen.closeSidebarButton();
        loginScreen.logout();
    }

    @Test (priority = 6)
    public void manageActivityNotificationsTest() throws InterruptedException
    {
        loginScreen.login("Marly", "1234567890");
        accountSettingsScreen.openAccountSettings();
        accountSettingsScreen.manageNotifications();
        accountSettingsScreen.manageMentions();
        accountSettingsScreen.manageComments();
        accountSettingsScreen.manageUpvotesOnPosts();
        accountSettingsScreen.manageUpvotesOnComments();
        accountSettingsScreen.manageRepliesToComments();
        accountSettingsScreen.manageNewFollowers();
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        accountSettingsScreen.closeSidebarButton();
        loginScreen.logout();

    }

    @Test (priority = 7)
    public void blockUserTest() throws InterruptedException
    {
        loginScreen.login("Marly", "1234567890");
        accountSettingsScreen.openAccountSettings();
        accountSettingsScreen.blockAccount("peter");
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        accountSettingsScreen.closeSidebarButton();
        loginScreen.logout();
    }

    @Test (priority = 8)
    public void unblockUserTest() throws InterruptedException
    {
        loginScreen.login("Marly", "1234567890");
        accountSettingsScreen.openAccountSettings();
        accountSettingsScreen.unblockAccount("peter");
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        accountSettingsScreen.closeSidebarButton();
        loginScreen.logout();
    }

    @Test (priority = 9)
    public void changeGenderTest() throws InterruptedException {
        loginScreen.login("Marly", "1234567890");
        accountSettingsScreen.openAccountSettings();
        accountSettingsScreen.changeGender("I prefer not to say");
        driver.navigate().back();
        driver.navigate().back();
        accountSettingsScreen.closeSidebarButton();
        loginScreen.logout();
    }

    @Test (priority = 10)
    public void changeLocationTest() throws InterruptedException {
        loginScreen.clickContinueButton();
        loginScreen.clickOnLoginButton();
        loginScreen.login("Marly", "1234567890");
        accountSettingsScreen.openAccountSettings();
        accountSettingsScreen.changeLocation("Chile");
        driver.navigate().back();
        driver.navigate().back();
        accountSettingsScreen.closeSidebarButton();
        loginScreen.logout();
    }
}