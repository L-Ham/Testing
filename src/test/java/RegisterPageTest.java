import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterPageTest extends TestBase
{
    RegisterPage registerPage;

    @BeforeTest
    public void setUp()
    {
        driver.manage().deleteAllCookies();
        registerPage = new RegisterPage(driver);
        driver.get("https://www.reddit.com/account/register/");
    }
    @DataProvider
    public Object[][] getValidData() {
        return new Object[][]
                {
                        {"husseinhadidy1@gmail.com","husseingdid", "hello123456"}
                };
    }
    @DataProvider
    public Object[][] getInValidData() {
        return new Object[][]
                {
                        {"hussein"}
                };
    }

    @Test (priority = 1)
    public void googleButtonTest() throws InterruptedException
    {
        String MainHandle = registerPage.clickGoogleButton();
        implicitWait(5);
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("https://accounts.google.com/"));
        driver.switchTo().window(MainHandle);
        driver.navigate().to("https://www.reddit.com/account/register/");
   }

    @Test (priority = 2, dataProvider = "getValidData")
    public void validRegisterTestCases(String email, String username, String password)
    {
        registerPage.enterNewUserEmail(email);
        implicitWait(5);
        registerPage.enterUsernameAndPassword(username, password);
        implicitWait(5);
        driver.navigate().to("https://www.reddit.com/account/register/");
    }
    @Test (priority = 3)
    public void invalidAlreadyTakenUser()
    {
        registerPage.enterNewUserEmail("husseinhadidy1@gmail.com");
        implicitWait(5);
        registerPage.enterAlreadyTakenUsername();
        explicitWait(1, registerPage.errorUsernameAlreadyTaken);
        Assert.assertTrue(driver.findElement(registerPage.errorUsernameAlreadyTaken).getText().equals("That username is already taken"));
        driver.navigate().to("https://www.reddit.com/account/register/");
    }
    @Test (priority = 4, dataProvider = "getInValidData")
    public void invalidRegisterEmailCases(String email) throws InterruptedException
    {
        registerPage.clearEmailTextbox();
        registerPage.enterNewUserEmail(email);
        explicitWait(5, registerPage.errorInvalidEmailLocator);
        Assert.assertTrue(driver.findElement(registerPage.errorInvalidEmailLocator).getText().equals("Please fix your email to continue"));
        Thread.sleep(1000);
    }

   @Test (priority = 5)
    public void userAgreementAndPrivacyPolicy() throws InterruptedException {
        String Main = driver.getWindowHandle();
        registerPage.clickUserAgreement();
        implicitWait(5);
        Thread.sleep(5000);
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.redditinc.com/policies/user-agreement"));
        driver.switchTo().window(Main);
        registerPage.clickPrivacyPolicy();
        implicitWait(5);
        Thread.sleep(5000);
        driver.switchTo().window(driver.getWindowHandles().toArray()[2].toString());
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.reddit.com/policies/privacy-policy"));
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());

    }

    @Test (priority = 6)
    public void goToLogin()
    {
        registerPage.clickLoginButton();
        implicitWait(5);
        implicitWait(5);
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.reddit.com/account/login/"));
    }





}




