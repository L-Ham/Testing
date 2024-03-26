import dev.failsafe.internal.util.Durations;
import org.openqa.selenium.WebDriver;
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
                        {"Ill_Initial_3945", "/m4!2QHj!saysm4"},
                        {"husseinhadidy", "^##)_qg/r=yeP2*"}
                };
    }

    @DataProvider
    public Object[][] getInValidData()
    {
        return new Object[][]
                {
                        {"Ill_Ini5", "/m4!2QHj!saysm4"},  //wrong username
                        {"husseinhadidy", "^##2*"}        //wrong password
                };
    }

    @Test (dataProvider = "getValidData", priority = 1)
    public void validLoginTestCases(String username, String password)
    {
        loginPage.resetLoginCredentials();
        loginPage.login(username, password);
        implicitWait(5);
        Assert.assertTrue(driver.findElement(loginPage.userProfileLocator).isDisplayed());
        loginPage.logOut();
        Assert.assertTrue(driver.findElement(loginPage.innerLoginButtonLocator).isDisplayed());
        loginPage.backToLogin();
    }

    @Test (dataProvider = "getInValidData", priority = 2)
    public void invalidLoginTestCases(String username, String password)
    {
        loginPage.resetLoginCredentials();
        loginPage.login(username, password);
        explicitWait(5, loginPage.errorInvalidCredentialsLocator);
        Assert.assertTrue(driver.findElement(loginPage.errorInvalidCredentialsLocator).getText().equals("Incorrect username or password"));
    }

    @Test (priority = 3)
    public void googleButtonTest() throws InterruptedException
    {
        String MainHandle = loginPage.clickGoogleButton();
        implicitWait(5);
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("https://accounts.google.com/"));
        driver.close();
        driver.switchTo().window(MainHandle);
        driver.navigate().to("https://www.reddit.com/account/login/");
    }

    @Test (priority = 4)
    public void recoverUsernameAndPasswordTests()
    {
        loginPage.clickRecoverUsername();
        implicitWait(5);
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.reddit.com/username/"));
        driver.navigate().to("https://www.reddit.com/account/login/");
        loginPage.clickRecoverPassword();
        implicitWait(5);
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.reddit.com/password/"));
        driver.navigate().to("https://www.reddit.com/account/login/");
    }

   @Test (priority = 5)
    public void signUpButtonTest()
    {
        loginPage.clickSignUpButton();
        implicitWait(5);
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.reddit.com/account/register/"));
    }














}
