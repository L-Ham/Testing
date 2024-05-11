import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChattingPageTest extends TestBase
{
    ChattingPage chattingPage;
    LoginPage loginPage;
    @BeforeTest
    public void setUp() throws InterruptedException {
        chattingPage = new ChattingPage(driver);
        loginPage = new LoginPage(driver);
        loginPage.login("ChatTrial", "12345678");
        chattingPage.initiateAReceiver();
    }

    @Test(priority = 1)
    public void openChatAndSendTest() throws InterruptedException {
        Thread.sleep(2000);
        chattingPage.prepareReceived();
        Thread.sleep(2000);
        String status = chattingPage.openChatAndSend("HelloYaBashaaa1");
        Assert.assertEquals(status, "Message is sent");
    }

    @Test(priority = 2)
    public void checkReceived() throws InterruptedException {
        String status = chattingPage.checkReceived();
        Assert.assertEquals(status, "Message is received");
    }
}
