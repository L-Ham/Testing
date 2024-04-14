import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginScreenTest extends TestBase{
    LoginScreen loginScreen;
    @BeforeTest
    public void loginSetup()
    {
        loginScreen = new LoginScreen(driver);
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"Marly","1234567890"}
        };
    }

    @Test (dataProvider= "loginData" ,priority = 1)
    public void validoginCases(String userName, String password) throws InterruptedException
    {
        loginScreen.login(userName, password);
        Assert.assertTrue(driver.findElementByXPath(loginScreen.userProfileXPath).isDisplayed());
        //Logic of going back to the main screen
        System.out.println("Back to the main screen...");
    }
//
//    @Test (dataProvider = "inValidLoginData",priority = 2)
//    public void invalidLoginCases(String userName, String password) throws InterruptedException
//    {
//        System.out.println("Application started...");
//        loginScreen.login(userName, password);
//        explicitWait(By.xpath(loginScreen.userProfileXPath));
//        Assert.assertFalse(driver.findElementByXPath(loginScreen.userProfileXPath).isDisplayed());
//        System.out.println("Back to the main screen...");
//    }

}