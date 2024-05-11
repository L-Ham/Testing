import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChattingPage extends PageBase
{
    WebDriver receiverDriver;
    public ChattingPage(WebDriver driver)
    {
        super(driver);
        receiverDriver = new ChromeDriver();
    }

    By chatButton = By.cssSelector("[data-testid='action-button-chat']");
    By startChatButton = By.cssSelector("[data-testid='start-chat-button']");
    By chatInput = By.id("msgboxx");
    By sendButton = By.id("sendmsg");
    By usernameTextBoxLocator = By.id("regPassword-prevent4"); //login username

    By passwordTextBoxLocator = By.id("regPassword-prevent3"); //login password

    //By innerLoginButtonLocator = By.xpath("//*[@id=\"login-button\"]");
    By loginButtonLocator = By.cssSelector("[data-testid='loginbutton50']");

    public void loginToReceiver(String email, String password)
    {
        System.out.println("Logging in to receiver");
        new WebDriverWait(receiverDriver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(usernameTextBoxLocator));
        WebElement usernameTextBox = receiverDriver.findElement(usernameTextBoxLocator);
        WebElement passwordTextBox = receiverDriver.findElement(passwordTextBoxLocator);
       WebElement loginButton = receiverDriver.findElement(loginButtonLocator);
        sendText(usernameTextBox, email);
        sendText(passwordTextBox, password);
        Clicking(loginButton);
    }

    public void prepareReceived()
    {
        System.out.println("Preparing receiver");
        loginToReceiver("ChatTrial2","12345678");
        new WebDriverWait(receiverDriver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(chatButton));
        Clicking(receiverDriver.findElement(chatButton));
    }

    public void initiateAReceiver()
    {
        receiverDriver.get("https://reddit-bylham.me/login");
        receiverDriver.manage().window().maximize();
    }

    public String openChatAndSend(String wordToBeSent) throws InterruptedException
    {
        explicitWait(15, chatButton);
        Clicking(driver.findElement(chatButton));
        explicitWait(15, chatInput);
        WebElement chatInputElement = driver.findElement(chatInput);
        sendText(chatInputElement, wordToBeSent);
        Clicking(driver.findElement(sendButton));
        Thread.sleep(3000);
        return "Message is sent";

    }
    public String checkReceived() throws InterruptedException {
        Thread.sleep(3000);
        String text = receiverDriver.getPageSource();
        if(text.contains("HelloYaBashaaa1"))
        {
            return "Message is received";
        }
        else
        {
            return "Message is not received";
        }
    }



}
