import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RecoverUsernameTest extends TestBase {

    RecoverUsernamePage recoverUsernamePage;

    @BeforeTest
    public void setUp() {
        driver.manage().deleteAllCookies();
        recoverUsernamePage = new RecoverUsernamePage(driver);
        driver.get("https://accounts.reddit.com/username");
    }

    @DataProvider
    public Object[][] getInValidData() {
        return new Object[][]
                {
                        {"hussein" }, //invalid email
                        {"hussein@" } //invalid email

                };
    }

    @Test (dataProvider = "getInValidData", priority = 1)
    public void invalidRecoverUsernameTestCases(String email)
    {
        recoverUsernamePage.enterEmail(email);
        recoverUsernamePage.clickEmailMeButton();
        explicitWait(1, recoverUsernamePage.errorInvalidEmailLocator);
        Assert.assertTrue(driver.findElement(recoverUsernamePage.errorInvalidEmailLocator).getText().equals("Please fix your email to continue"));
        recoverUsernamePage.clearEmail();
    }

   @Test (priority = 2)
    public void validRecoverUsernameTestCases() throws InterruptedException {
       recoverUsernamePage.enterEmail("husseinhadidy1@gmail.com");
       recoverUsernamePage.clickEmailMeButton();
       Thread.sleep(60000);
       Assert.assertTrue(driver.findElement(recoverUsernamePage.successMessageLocator).getText().equals("Check your email"));

   }

   @Test (priority = 3)
    public void hyperlinksTest()
   {
       String Main = driver.getWindowHandle();
       implicitWait(5);
       recoverUsernamePage.clickGetHelp();
       driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
       implicitWait(5);
       Assert.assertTrue(driver.getCurrentUrl().contains("https://support.reddithelp.com/"));
       driver.switchTo().window(Main);
       recoverUsernamePage.clickLoginButton();
       implicitWait(5);
       Assert.assertTrue(driver.getCurrentUrl().contains("/account/login/"));
       driver.navigate().back();
       recoverUsernamePage.clickSignUpButton();
       implicitWait(5);
       Assert.assertTrue(driver.getCurrentUrl().contains("/account/register/"));
       driver.navigate().back();

   }

}
