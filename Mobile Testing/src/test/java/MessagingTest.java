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
import org.testng.annotations.Test;

public class MessagingTest extends TestBase {

    Messaging messaging;
    LoginScreen loginScreen;
    WebDriverWait wait;
    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void messagingSetup() {
        messaging = new Messaging(driver);
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
    public void sendMessageExistingThreadTest() throws InterruptedException {
        test = extent.createTest("Sending a Message to an Existing Thread Test");
        loginScreen.clickContinueButton();
        loginScreen.clickOnLoginButton();
        loginScreen.login("itssosoyall", "123456789");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loginScreen.userProfileXPath)));
        messaging.navigateToInboxTab();
        Thread.sleep(2000);
        boolean result = messaging.sendMessageExistingThread("jeniffer", "Heeyyy jeennnyyyyy");
        test.log(result ? Status.PASS : Status.FAIL, "Test Result");
        Assert.assertTrue(result);
        Thread.sleep(2000);
        messaging.logout("itssosoyall");
    }

    @Test(priority = 2)
    public void sendNewMessageTest() throws InterruptedException {
        test = extent.createTest("Sending a New Message Test");
        loginScreen.login("itssosoyall", "123456789");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loginScreen.userProfileXPath)));
        messaging.navigateToInboxTab();
        Thread.sleep(2000);
        boolean result = messaging.sendNewMessage("dani", "Hello", "Ahla messaging mel cross wl back teams");
        test.log(result ? Status.PASS : Status.FAIL, "Test Result");
        Assert.assertTrue(result);
        Thread.sleep(2000);
        messaging.logout("itssosoyall");
    }

    @Test(priority = 3)
    public void receiverNotFoundTest() throws InterruptedException {
        test = extent.createTest("Receiver Not Found Test");
        loginScreen.login("itssosoyall", "123456789");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loginScreen.userProfileXPath)));
        messaging.navigateToInboxTab();
        Thread.sleep(2000);
        boolean result = messaging.sendMessageNonExistentUser("nonexistent", "Hello", "Ahla messaging mel cross wl back teams");
        test.log(result ? Status.PASS : Status.FAIL, "Test Result");
        Assert.assertTrue(result);
        messaging.clickExit();
        Thread.sleep(2000);
messaging.logout("itssosoyall");

    }

    @Test(priority = 4)
    public void checkMessageArrivalTest() throws InterruptedException {
        test = extent.createTest("Check Message Arrival Test");
        loginScreen.login("jeniffer", "123456789");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loginScreen.userProfileXPath)));
        messaging.navigateToInboxTab();
        Thread.sleep(2000);
        boolean result = messaging.checkMessageArrival("itssosoyall", "Heeyyy jeennnyyyyy");
        test.log(result ? Status.PASS : Status.FAIL, "Test Result");
        Assert.assertTrue(result);
        messaging.logout("jeniffer");
    }

    @Test(priority = 5)
    public void checkMessage2ArrivalTest() throws InterruptedException {
        test = extent.createTest("Check Message Arrival Test");
        loginScreen.login("dani", "12345678");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loginScreen.userProfileXPath)));
        messaging.navigateToInboxTab();
        Thread.sleep(2000);
        boolean result = messaging.checkMessageArrival("itssosoyall", "Ahla messaging mel cross wl back teams");
        test.log(result ? Status.PASS : Status.FAIL, "Test Result");
        Assert.assertTrue(result);
        messaging.logout("dani");
    }

}
