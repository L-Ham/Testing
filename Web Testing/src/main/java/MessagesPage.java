import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MessagesPage extends PageBase {

    public MessagesPage(WebDriver driver)
    {
        super(driver);
    }

    By sentTabLocator = By.cssSelector("[data-testid='message-header-sent']");
    By sendANewMessageButtonLocator = By.cssSelector("[data-testid='message-header-send']");
    By toUsernameLocator = By.xpath("//*[@id=\"main-container\"]/div/div/div[2]/form/div[2]/div/div/input");
    By messageSubjectLocator = By.xpath("//*[@id=\"main-container\"]/div/div/div[2]/form/div[4]/div/div/textarea");
    By messageTextLocator = By.cssSelector("[data-testid = 'message-input-subject--send']");
    By sendButtonLocator = By.xpath("//*[@id=\"main-container\"]/div/div/div[2]/form/button");
    By notificationMessageLocator = By.cssSelector("[data-testid='toaster-123@@#324sd']");

    By notificationsButton = By.cssSelector("[data-testid='action-button-low-##33443@@-geso']");
    By unreadId=By.id("noresults");

    By replyButton = By.cssSelector("[data-testid='message-send-reply']");
    By replyMessage=By.xpath("(//*[@id='main-container']/div/div/div[2]/div[2]/div/div/form/div/textarea)[last()]");

    By replyMessagesSendButton = By.cssSelector("[data-testid='message-send-read']");
    By unsendButton = By.cssSelector("[data-testid='message-unsend']");
    void goToSendMessages() throws InterruptedException {
        Thread.sleep(7000);
        explicitWait(15, notificationsButton);
        driver.get("https://reddit-bylham.me/message/send");
    }

    void goToSentMessages()
    {
        explicitWait(15, notificationsButton);
        driver.get("https://reddit-bylham.me/message/inbox/all");
    }

    String goToUnreadMessages() throws InterruptedException {
        driver.get("https://reddit-bylham.me/message/inbox/unread");
        Thread.sleep(4000);
        driver.get("https://reddit-bylham.me/message/inbox/all");
        Thread.sleep(4000);
        driver.get("https://reddit-bylham.me/message/inbox/unread");
        explicitWait(15, unreadId);
        return driver.findElement(unreadId).getText();
    }

    String sendNewMessage(String toUsername, String messageText,String messageSubject) throws InterruptedException {
        Thread.sleep(5000);
        explicitWait(15, sendANewMessageButtonLocator);
        Clicking(driver.findElement(sendANewMessageButtonLocator));
        explicitWait(15, toUsernameLocator);
        WebElement toUsernameElement = driver.findElement(toUsernameLocator);
        toUsernameElement.sendKeys(toUsername);
        WebElement messageSubjectElement = driver.findElement(messageSubjectLocator);
        messageSubjectElement.sendKeys(messageSubject);
        WebElement messageTextElement = driver.findElement(messageTextLocator);
        messageTextElement.sendKeys(messageText);
        WebElement sendButtonElement = driver.findElement(sendButtonLocator);
        Clicking(sendButtonElement);
        explicitWait(15,notificationMessageLocator);
        WebElement notificationAddRuleElement = driver.findElement(notificationMessageLocator);
        return notificationAddRuleElement.getText();
    }

    String checkMessageInSentMessages(String messageText) throws InterruptedException
    {
        Thread.sleep(5000);
        String pageSource = driver.getPageSource();
        if(pageSource.contains(messageText))
        {
            return messageText;
        }
        else
        {
            return "Message not found";
        }
    }

    String replyToMessage(String messageText) throws InterruptedException
    {
        explicitWait(15, replyButton);
        List<WebElement> elements = driver.findElements(replyButton);
        WebElement lastElement = elements.get(elements.size() - 1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lastElement);
        lastElement.click();
        explicitWait(15, replyMessage);
        WebElement messageElement = driver.findElement(replyMessage);
        messageElement.sendKeys(messageText);
        Thread.sleep(2000);
        List<WebElement> elementsNew = driver.findElements(replyMessagesSendButton);
        WebElement lastElementNew = elementsNew.get(elementsNew.size() - 1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lastElementNew);
        lastElementNew.click();
        Thread.sleep(4000);
        System.out.println("AAAAAAAAAAAAAAAAAA");
        driver.get("https://reddit-bylham.me/message/sent");
        Thread.sleep(4000);
        String pageSource = driver.getPageSource();
        if(pageSource.contains(messageText))
        {
            return messageText;
        }
        else
        {
            return "Message not found";
        }
    }

    String unsendMessage(String messageText) throws InterruptedException
    {
        explicitWait(15, unsendButton);
        List<WebElement> elements = driver.findElements(unsendButton);
        WebElement lastElement = elements.get(elements.size() - 1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lastElement);
        lastElement.click();
        driver.get("https://reddit-bylham.me/message/sent");
        Thread.sleep(7000);
        String pageSource = driver.getPageSource();
        if(pageSource.contains(messageText))
        {
            return "Message not deleted";
        }
        else
        {
            return "Message deleted";
        }
    }


}
