import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterPageTest extends TestBase
{
    RegisterPage registerPage;
    LoginPage loginPage;


    @BeforeTest
    public void setUp()
    {
        driver.manage().deleteAllCookies();
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        driver.get("https://reddit-bylham.me/register");
    }
    @DataProvider
    public Object[][] getValidData() {
        return new Object[][]
                {
                        {"sheriHhh@gmail.com","herd643", "hihussein"}
                };
    }

    @DataProvider
    public Object[][] getRandomUserValidData()
    {
        return new Object[][]
                {
                        {"sehsadia@yahoo.com","hihussein"}
                };
    }

    @DataProvider
    public Object[][] getTakenUsernamesData() {
        return new Object[][]
                {
                        {"david"},
                        {"hussein"},
                        {"Marly"}
                };
    }
    @DataProvider
    public Object[][] getInValidData() {
        return new Object[][]
                {
                        {"hussein"},
                        {"@"},
                        {"hotmail"},
                        {"."}

                };
    }

    @Test (priority = 1, dataProvider = "getValidData")
    public void validRegisterTestCases(String email, String username, String password) throws InterruptedException {
        Thread.sleep(2000);
        registerPage.enterNewUserEmail(email);
        registerPage.enterUsernameAndPassword(username, password);
        explicitWait(10,registerPage.userProfileLocator);
        String usernameCheck = loginPage.clickProfilePageGetName();
        Assert.assertEquals( usernameCheck,"u/"+username);
        loginPage.logOut();
        loginPage.login(username, password);
        explicitWait(10,registerPage.userProfileLocator);
        String usernameCheckAgain = loginPage.clickProfilePageGetName();
        Assert.assertEquals(usernameCheckAgain,"u/"+username);
        driver.navigate().to("https://www.reddit-bylham.me/register/");
    }

    @Test (priority = 2, dataProvider = "getRandomUserValidData")
    public void validRandomUsernameTestCases(String email, String password) throws InterruptedException {
        Thread.sleep(2000);
        registerPage.enterNewUserEmail(email);
        String randomUsername = registerPage.enterRandomUsernameAndPassword(password);
        explicitWait(10,registerPage.userProfileLocator);
        String usernameCheck = loginPage.clickProfilePageGetName();
        Assert.assertEquals(usernameCheck,"u/"+randomUsername);
        loginPage.logOut();
        loginPage.login(randomUsername, password);
        explicitWait(10,registerPage.userProfileLocator);
        String usernameCheckAgain = loginPage.clickProfilePageGetName();
        Assert.assertEquals(usernameCheckAgain,"u/"+randomUsername);
    }
    @Test (priority = 3, dataProvider = "getTakenUsernamesData")
    public void invalidTestCasesRegistration(String usernameTaken) throws InterruptedException {
        Thread.sleep(2000);
        driver.navigate().to("https://www.reddit-bylham.me/register/");
        registerPage.enterNewUserEmail("Hussein@gmail.com");
        String checkErrorMessage = registerPage.enterAlreadyTakenUsername(usernameTaken);
        Assert.assertEquals(checkErrorMessage,"That username is already taken");
    }

    @BeforeGroups (groups = {"invalidRegisterEmailCases"})
    public void beforeGroups()
    {
        driver.get("https://www.reddit-bylham.me/register/");
    }
    @Test (priority = 4, dataProvider = "getInValidData", groups = {"invalidRegisterEmailCases"})
    public void invalidRegisterEmailCases(String email) throws InterruptedException
    {
        Thread.sleep(2000);
        registerPage.enterNewUserEmail(email);
        explicitWait(10,registerPage.errorInvalidEmailLocator);
        Assert.assertEquals(driver.findElement(registerPage.errorInvalidEmailLocator).getText(), "Please fix your email to continue");
    }

}




