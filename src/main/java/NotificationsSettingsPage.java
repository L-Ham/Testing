import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class NotificationsSettingsPage extends PageBase{
    NotificationsSettingsPage(WebDriver driver)
    {
        super(driver);
    }
    By notificationsTabLocator = By.xpath("//*[@id=\"AppRouter-main-content\"]/div/div[1]/div/a[5]");
    // Messages Notifications
    By privateMessagesCheckboxLocator = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/span[1]/div/div[2]/div/button");
    By chatMessagesCheckboxLocator = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/span[2]/div/div[2]/div/button");
    By chatRequestsCheckboxLocator = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/span[3]/div/div[2]/div/button");

    WebElement notificationsTab;
    WebElement privateMessagesCheckbox;
    WebElement chatMessagesCheckbox;
    WebElement chatRequestsCheckbox;

    public void openNotificationsTab()
    {
        notificationsTab = driver.findElement(notificationsTabLocator);
        Clicking(notificationsTab);
    }

    public void changeMessagesNotifications()
    {
        privateMessagesCheckbox = driver.findElement(privateMessagesCheckboxLocator);
        Clicking(privateMessagesCheckbox);
        chatMessagesCheckbox = driver.findElement(chatMessagesCheckboxLocator);
        chatRequestsCheckbox = driver.findElement(chatRequestsCheckboxLocator);

        Clicking(chatMessagesCheckbox);
        Clicking(chatRequestsCheckbox);
        openNotificationsTab();
    }
}
