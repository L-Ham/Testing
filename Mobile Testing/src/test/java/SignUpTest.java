import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
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
    public Object[][] validSignUpData()
    {
        return new Object[][]
                {
                        {"ZiaBashaa53@gmail.com","hihussein", "ZiaBashaa53"}
                };
    }
    @DataProvider
    public Object[][] invalidSignUpData() {
        return new Object[][]
                {
                        {"abc","hihuss"},
                        {"abc@","hihussein"},
                        {"abcm","hih@.coussein"},
                        {"@gmail.com","hihussein"}
                };
    }

    @BeforeGroups("invalidSignUpTests")
    public void beforeInvalidSignUpTests() throws InterruptedException
    {

        signUpScreen.clickContinueButton();
        signUpScreen.invalidSignupSetup();
    }

    @Test (dataProvider= "validSignUpData" ,priority = 1)
    public void validsignUpCases(String email, String password, String username) throws InterruptedException
    {
        signUpScreen.signUpStart(email, password);
        signUpScreen.signContinued(username);
        signUpScreen.chooseGender("Man");
        explicitWait(By.xpath(signUpScreen.userProfileXPath));
        Assert.assertTrue(driver.findElementByXPath(signUpScreen.userProfileXPath).isDisplayed());
        System.out.println("Back to the main screen...");
        driver.closeApp();
    }

    @Test (dataProvider = "invalidSignUpData",priority = 2, groups = "invalidSignUpTests")
    public void invalidSignUpCases(String email, String password) throws InterruptedException
    {
        signUpScreen.invalidSignup(email, password);
        explicitWait(By.xpath(signUpScreen.invalidEmailAndPasswordXPath));
        Assert.assertTrue(driver.findElementByXPath(signUpScreen.invalidEmailAndPasswordXPath).isDisplayed());
        driver.hideKeyboard();
    }
    @Test (priority = 3)
    public void testUserAlreadyTaken() throws InterruptedException
    {
        ScreenBase.Clicking(signUpScreen.email);
        signUpScreen.email.clear();
        ScreenBase.sendText(signUpScreen.email, "husseinkhaled@gmail.com");
        ScreenBase.Clicking(signUpScreen.password);
        signUpScreen.password.clear();
        ScreenBase.sendText(signUpScreen.password, "123456789");
        signUpScreen.clickContinueFirstScreen();
        signUpScreen.userAlreadyTaken("hussein");
        explicitWait(By.xpath(signUpScreen.userAlreadyTakenXpath));
        Assert.assertTrue(driver.findElementByXPath(signUpScreen.userAlreadyTakenXpath).isDisplayed());
    }


}