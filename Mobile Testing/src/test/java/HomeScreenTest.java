import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomeScreenTest extends TestBase {
    HomeScreen homeScreen;
    LoginScreen loginScreen;
    WebDriverWait wait;
    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void homeSetup() {
        homeScreen = new HomeScreen(driver);
    }

    @BeforeTest
    public void loginSetup() {
        loginScreen = new LoginScreen(driver);
    }

    @BeforeMethod
    public void waitSetup() {
        wait = new WebDriverWait(driver, 10);
    }

    @BeforeTest
    public void setupExtentReports() {
        extent = new ExtentReports();
        extent.attachReporter(new ExtentHtmlReporter("extent-report.html"));
    }

    @AfterTest
    public void tearDownExtentReports() {
        extent.flush();
    }



    @Test(priority = 1)
    public void changePostsViewTest() throws InterruptedException {
        test = extent.createTest("Change Posts View Test");
        loginScreen.clickContinueButton();
        loginScreen.clickOnLoginButton();
        loginScreen.login("itssosoyall", "123456789");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loginScreen.userProfileXPath)));
        homeScreen.changePostsToPopular();
        homeScreen.changePostsToHome();
        loginScreen.logout();
        test.log(Status.PASS, "Test Passed");
    }

//    @Test(priority = 2)
//    public void navigationTest() throws InterruptedException {
//        test = extent.createTest("Navigation Test");
//        loginScreen.login("sehs", "12345678");
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loginScreen.userProfileXPath)));
//        homeScreen.navigateToCommunitiesTab();
//        homeScreen.navigateToChatTab();
//        homeScreen.navigateToInboxTab();
//        homeScreen.navigateToHomeTab();
//        loginScreen.logout();
//        test.log(Status.PASS, "Test Passed");
//    }

    @Test(priority = 3)
    public void createCommunityTest() throws InterruptedException {
        test = extent.createTest("Create Community Test");
        loginScreen.login("itssosoyall", "123456789");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loginScreen.userProfileXPath)));
        homeScreen.openSidebar();
        homeScreen.createCommunity("Testing1", "Private",Boolean.TRUE);
        test.log(Status.PASS, "Test Passed");
    }

    @Test(priority = 4)
    public void createPostTest() throws InterruptedException {
        test = extent.createTest("Create Post Test");
        homeScreen.createFirstPostCommunity("Testing1", "Test Title",Boolean.TRUE,Boolean.TRUE,"This is a test post");
        test.log(Status.PASS, "Test Passed");
    }




}
