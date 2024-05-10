import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MessagesPageTest extends TestBase
{
    MessagesPage messagesPage;
    LoginPage loginPage;

    @BeforeTest
    public void getMessagesPage() throws InterruptedException {
        messagesPage = new MessagesPage(driver);
        loginPage = new LoginPage(driver);
        loginPage.login("jeniffer", "123456789");
        messagesPage.goToSendMessages();

    }

    @DataProvider
    public Object[][] getValidData()
    {
        return new Object[][]
                {
                        {"sehs", "Greetingss", "Hello, how aree you sehs?"}
                };
    }

    @Test(dataProvider = "getValidData", priority = 1)
    public void sendMessage(String username, String messageText, String messageSubject) throws InterruptedException
    {
        String messageNotification=messagesPage.sendNewMessage(username, messageText, messageSubject);
        Assert.assertEquals(messageNotification, "Message sent succesfully");
    }


    @Test( dependsOnMethods= "sendMessage", dataProvider = "getValidData" ,priority = 2)
    public void checkMessageInSentMessages(String username, String messageText, String messageSubject) throws InterruptedException {
        loginPage.clickOnLogOut();
        //driver.get("https://reddit-bylham.me/login");
        loginPage.login("sehs", "12345678");
        messagesPage.goToSentMessages();
        String message=messagesPage.checkMessageInSentMessages(messageText);
        Assert.assertEquals(message, messageText);
    }

    @Test (priority = 3)
    public void checkUnreadTab() throws InterruptedException {
        String message=messagesPage.goToUnreadMessages();
        Assert.assertEquals(message, "there doesn't seem to be anything here");
    }

    @Test (priority = 4)
    public void replyToMessage() throws InterruptedException
    {
        driver.navigate().to("https://reddit-bylham.me/message/inbox/all");
        String checkMessage = messagesPage.replyToMessage("I replyed back!");
        Assert.assertEquals(checkMessage, "I replyed back!");
    }
    @Test (priority = 5)
    public void unsendMessage() throws InterruptedException
    {
        driver.navigate().to("https://reddit-bylham.me/message/sent");
        String checkMessage = messagesPage.unsendMessage("I replyed back!");
        Assert.assertEquals(checkMessage, "Message deleted");
    }


}