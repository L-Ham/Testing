import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ResetPasswordTest extends TestBase
{
    ResetPasswordPage resetPasswordPage;
    @BeforeTest
    public void setUp()
    {
        driver.manage().deleteAllCookies();
        resetPasswordPage = new ResetPasswordPage(driver);
        driver.get(recoverPasswordURL);
    }

    @Test (priority = 1)
    public void validResetPasswordTestCases()
    {
        resetPasswordPage.enterUsername("Ill_Initial_3945");
        resetPasswordPage.enterEmail("husseinhadidy1@gmail.com");
        resetPasswordPage.clickResetPasswordButton();
        explicitWait(5, resetPasswordPage.successMessageLocator);
        Assert.assertTrue(driver.findElement(resetPasswordPage.successMessageLocator).getText().equals("Thanks! If your Reddit username and email address match, you'll get an email with a link to reset your password shortly."));
    }


    @Test(priority = 2)
    public void invalidResetPasswordTestCases()
    {
        resetPasswordPage.enterUsername("Ill_Initial_3945");
        resetPasswordPage.enterEmail("usseinhadidy1gil.com");
        resetPasswordPage.clickResetPasswordButton();
        explicitWait(1, resetPasswordPage.errorInvalidEmailLocator);
        Assert.assertTrue(driver.findElement(resetPasswordPage.errorInvalidEmailLocator).getText().equals("Please fix your email to continue"));
    }

    @Test (priority = 3)
    public void testHyperlinks()
    {
        String Main = driver.getWindowHandle();
        implicitWait(5);
        resetPasswordPage.clickGetHelp();
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        implicitWait(5);
        Assert.assertTrue(driver.getCurrentUrl().contains("https://support.reddithelp.com/"));
        driver.switchTo().window(Main);
        resetPasswordPage.clickLoginButton();
        implicitWait(5);
        Assert.assertTrue(driver.getCurrentUrl().contains("/account/login/"));
        driver.navigate().back();
        resetPasswordPage.clickSignUpButton();
        implicitWait(5);
        Assert.assertTrue(driver.getCurrentUrl().contains("/register/"));
    }







}
