
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPageTest extends TestBase{


    private LoginPage loginPage;

    @BeforeTest
    public void getLoginPage()
    {
        loginPage = new LoginPage(driver);
    }

    @DataProvider
    public Object[][] getValidData()
    {
        return new Object[][]
                {
                        {"Marly","123456789"},
                        {"husseinkh","hihussein"},
                        {"fahdseddik","12345678"}
                };
    }

    @DataProvider
    public Object[][] getRecoveryEmail()
    {
        return new Object[][]
                {
                        {"husshadidy11@gmail.com","buoyant-harmony-127"}
                };
    }

    @DataProvider
    public Object[][] getInValidData()
    {
        return new Object[][]
                {
                        {"husseinnkh", "hihussein"},     //wrong username, correct password
                        {"husseinkh", "eheldnia"},        //wrong password, correct username
                        {"fahdsedddik", "1234567890"}  //wrong password, wrong username
                };
    }
    @Test (dataProvider = "getValidData", priority = 1)
    public void validLoginTestCases(String username, String password) throws InterruptedException {
        Thread.sleep(2000);
        loginPage.login(username, password);
        explicitWait(10, loginPage.userProfileLocator);
        Assert.assertTrue(driver.findElement(loginPage.userProfileLocator).isDisplayed());
        String usernameCheck = loginPage.clickProfilePageGetName();
        Assert.assertEquals(usernameCheck,"u/"+username);
        loginPage.logOut();
    }
    @Test (dataProvider = "getInValidData", priority = 2)
    public void invalidLoginTestCases(String username, String password) throws InterruptedException {
        Thread.sleep(2000);
        loginPage.clearLoginCredentials();
        loginPage.login(username, password);
        explicitWait(10, loginPage.errorInvalidCredentialsLocator);
        Assert.assertEquals(driver.findElement(loginPage.errorInvalidCredentialsLocator).getText(), "Incorrect username or password");
        loginPage.clearLoginCredentials();
    }

    @Test (priority = 3)
    public void googleButtonTest() throws InterruptedException
    {
        Thread.sleep(2000);
        loginPage.clickGoogleButton();
        explicitWait(20, loginPage.userProfileLocator);
        Assert.assertTrue(driver.findElement(loginPage.userProfileLocator).isDisplayed());
    }

    @Test (priority = 4)
    public void hyperlinksTest() throws InterruptedException {
        Thread.sleep(2000);
        loginPage.clickProfilePageGetName();
        loginPage.logOut();
        String Main = driver.getWindowHandle();
        loginPage.clickPrivacyPolicy();
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        driver.switchTo().window(Main);
        loginPage.clickUserAgreement();
        driver.switchTo().window(driver.getWindowHandles().toArray()[2].toString());
        driver.switchTo().window(Main);
    }

    @Test (priority = 5, dataProvider = "getRecoveryEmail")
    public void recoverUsernameTest(String email,String username) throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://reddit-bylham.me/username");
        String Message = loginPage.sendRecoveredUsernameEmail(email);
        Assert.assertEquals(Message, "Thanks! If there are any Reddit accounts associated with that email\n" +
                "address, you'll get an email with your username(s) shortly.");
    }

    @Test (priority = 6, dataProvider = "getRecoveryEmail")
    public void sendRecoveredPasswordEmailTest(String email,String username) throws InterruptedException
    {
        Thread.sleep(2000);
        driver.get("https://reddit-bylham.me/password");
        String Message = loginPage.sendRecoveredPasswordEmail(email,username);
        Assert.assertEquals(Message, "Thanks! If your Reddit username and email address match, you'll get\n" +
                "an email with a link to reset your password shortly.");
    }


}
