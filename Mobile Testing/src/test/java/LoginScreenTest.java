import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginScreenTest extends TestBase{
    LoginScreen loginScreen;
    @BeforeTest
    public void loginSetup()
    {
        loginScreen = new LoginScreen(driver);
    }

    @DataProvider
    public Object[][] validloginData() {
        return new Object[][]{
                {"Marly","1234567890"}
        };
    }

    @DataProvider
    public Object[][] invalidloginData() {
        return new Object[][]{
                {"Marly","hihuss"},
                {"Marly@","hihus"},
                {"NoNo","ihuss"},
                {".com","hihsein"}
        };
    }

    @DataProvider
    public Object[][] emailValidloginData() {
        return new Object[][]{
                {"husseinhadidy1@outlook.com", "hihussein"}
        };
    }

    @BeforeGroups("invalidSignUpTests")
    public void beforeInvalidSignUpTests() throws InterruptedException
    {
        loginScreen.beforeInvalid();
    }
    @Test (dataProvider= "validloginData" ,priority = 1)
    public void validoginCases(String userName, String password) throws InterruptedException
    {
        loginScreen.clickContinueButton();
        loginScreen.clickOnLoginButton();
        loginScreen.login(userName, password);
        explicitWait(By.xpath(loginScreen.userProfileXPath));
        Assert.assertTrue(driver.findElementByXPath(loginScreen.userProfileXPath).isDisplayed());
        loginScreen.logout();
    }

    @Test (dataProvider= "invalidloginData" ,priority = 2, groups = "invalidSignUpTests")
    public void invalidloginCases(String userName, String password) throws InterruptedException
    {
         loginScreen.invalidLogin(userName, password);
         explicitWait(By.xpath(loginScreen.invalidUsernameOrPassword));
         Assert.assertTrue(driver.findElementByXPath(loginScreen.invalidUsernameOrPassword).isDisplayed());
    }

    @DataProvider
    public Object[][] forgotpasswordData() {
        return new Object[][]{
                {"ziad.wareth@gmail.com"}
        };
    }
    @Test (priority = 3, dataProvider = "forgotpasswordData")
    public void forgotPassword(String usernameOrEmail) throws InterruptedException
    {
        driver.launchApp();
        loginScreen.forgotPassword(usernameOrEmail);
    }

    @Test(priority = 4, dataProvider = "emailValidloginData")
    public void emailLoginCase(String email, String password) throws InterruptedException
    {
        driver.launchApp();
        loginScreen.clickContinueButton();
        loginScreen.clickOnLoginButton();
        loginScreen.login(email, password);
        explicitWait(By.xpath(loginScreen.userProfileXPath));
        Assert.assertTrue(driver.findElementByXPath(loginScreen.userProfileXPath).isDisplayed());
    }

}