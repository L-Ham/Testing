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

public class MobileTests extends TestBase{


    LoginScreen loginScreen;
    @BeforeTest
    public void loginSetup()
    {
        loginScreen = new LoginScreen(driver);
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"testuser", "testpassword"},
                {"testuser1", "testpassword1"},
                {"testuser2", "testpassword2"}
        };
    }

    @Test (dataProvider= "loginData" ,priority = 1)
    public void test1(String userName, String password) throws InterruptedException
    {
        System.out.println("Application started...");
        loginScreen.login(userName, password);
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        System.out.println("Back to the main screen...");
    }

}