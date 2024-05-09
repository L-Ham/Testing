import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomeScreenTest extends TestBase{
    HomeScreen homeScreen;
    LoginScreen loginScreen;

    WebDriverWait wait;
    @BeforeTest
    public void homeSetup()
    {
        homeScreen = new HomeScreen(driver);
    }

    @BeforeTest
    public void loginSetup()
    {
        loginScreen = new LoginScreen(driver);
    }

    @BeforeMethod
    public void waitSetup()
    {
        wait = new WebDriverWait(driver, 10);
    }

    @DataProvider
    public Object[][] validloginData() {
        return new Object[][]{
                {"Marly", "123456789"}
        };
    }
    @Test (dataProvider= "validloginData" ,priority = 1)
    public void changePostsViewTest(String username, String password) throws InterruptedException
    {
        loginScreen.clickContinueButton();
        loginScreen.clickOnLoginButton();
        loginScreen.login(username, password);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loginScreen.userProfileXPath)));
        homeScreen.changePostsToPopular();
        homeScreen.changePostsToHome();
        loginScreen.logout();
    }

    @Test (dataProvider = "validloginData", priority = 2)
    public void navigationTest(String username, String password) throws InterruptedException
    {
        loginScreen.login(username, password);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loginScreen.userProfileXPath)));
        homeScreen.navigateToCommunitiesTab();
        homeScreen.navigateToChatTab();
        homeScreen.navigateToInboxTab();
        homeScreen.navigateToHomeTab();

    }

    @Test
    public void scrollTest() throws InterruptedException {
        loginScreen.clickContinueButton();
        loginScreen.clickOnLoginButton();
        loginScreen.login("sehs", "12345678");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loginScreen.userProfileXPath)));
        homeScreen.scroll();

    }


}
