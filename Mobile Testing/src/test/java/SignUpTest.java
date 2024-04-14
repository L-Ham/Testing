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

public class SignUpTest extends TestBase{
    SignUpScreen signUpScreen;
    @BeforeTest
    public void setSignUpScreenSetup()
    {
        signUpScreen = new SignUpScreen(driver);
    }

    @DataProvider
    public Object[][] signUpData() {
        return new Object[][]{
                {"abcdefgf@example.com","hihussein", "hussein50"}
        };
    }

    @Test (dataProvider= "signUpData" ,priority = 1)
    public void validsignUpCases(String email, String password, String username) throws InterruptedException
    {
        signUpScreen.signUpStart(email, password);
        signUpScreen.signContinued(username);
        signUpScreen.chooseGender("Man");
        explicitWait(By.xpath(signUpScreen.userProfileXPath));
        Assert.assertTrue(driver.findElementByXPath(signUpScreen.userProfileXPath).isDisplayed());
        System.out.println("Back to the main screen...");
    }

}