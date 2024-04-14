import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SettingsTests extends TestBase{


    LoginScreen loginScreen;
    AccountSettingsScreen accountSettingsScreen;
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

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"david", "12345678"},
                {"davidG@gmail.com", "12345678"}
        };
    }

    @Test (dataProvider= "loginData" ,priority = 1)
    public void AccountSettingsTest(String userName, String password) throws InterruptedException
    {
        System.out.println("Application started...");
        loginScreen.login(userName, password);
        accountSettingsScreen.openAccountSettings();
        System.out.println("Back to the main screen...");
    }

    @Test (dataProvider= "loginData" ,priority = 2)
    public void UpdateEmailTest(String email, String password) throws InterruptedException {
        System.out.println("Application started...");
        loginScreen.login("david", password);
        accountSettingsScreen.openAccountSettings();
        accountSettingsScreen.updateEmail(email, password);
        System.out.println("Back to the main screen...");
    }
}