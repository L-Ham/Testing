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

    // Activity Notifications
    By usernameMentionsCheckboxLocator = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/span[1]/div/div[2]/div/button");
    By commentsCheckboxLocator = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/span[2]/div/div[2]/div/button");
    By upvotesOnPostsCheckboxLocator = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/span[3]/div/div[2]/div/button");
    By upvotesOnCommentsCheckboxLocator = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/span[4]/div/div[2]/div/button");
    By RepliesToCommentsCheckboxLocator = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/span[5]/div/div[2]/div/button");
    By activityOnCommentCheckboxLocator = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/span[6]/div/div[2]/div/button");
    By activityOnChatPostsCheckboxLocator = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/span[7]/div/div[2]/div/button");
    By newFollowersCheckboxLocator = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/span[8]/div/div[2]/div/button");
    By awardsReceivedCheckboxLocator = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/span[9]/div/div[2]/div/button");
    By postsFollowedCheckboxLocator = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/span[10]/div/div[2]/div/button");
    By commentsFollowedCheckboxLocator = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/span[11]/div/div[2]/div/button");


    WebElement notificationsTab;
    // Messages Notifications Elements
    WebElement privateMessagesCheckbox;
    WebElement chatMessagesCheckbox;
    WebElement chatRequestsCheckbox;

    // Activity Notifications Elements
    WebElement usernameMentionsCheckbox;
    WebElement commentsCheckbox;
    WebElement upvotesOnPostsCheckbox;
    WebElement upvotesOnCommentsCheckbox;
    WebElement RepliesToCommentsCheckbox;
    WebElement activityOnCommentCheckbox;
    WebElement activityOnChatPostsCheckbox;
    WebElement newFollowersCheckbox;
    WebElement awardsReceivedCheckbox;
    WebElement postsFollowedCheckbox;
    WebElement commentsFollowedCheckbox;


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

    public void changeMentionsNotifications()
    {
        usernameMentionsCheckbox = driver.findElement(usernameMentionsCheckboxLocator);
        Clicking(usernameMentionsCheckbox);
    }

    public void changeCommentsNotifications()
    {
        commentsCheckbox = driver.findElement(commentsCheckboxLocator);
        Clicking(commentsCheckbox);
    }

    public void changeUpvotesOnPostsNotifications()
    {
        upvotesOnPostsCheckbox = driver.findElement(upvotesOnPostsCheckboxLocator);
        Clicking(upvotesOnPostsCheckbox);
    }

    public void changeUpvotesOnCommentsNotifications()
    {
        upvotesOnCommentsCheckbox = driver.findElement(upvotesOnCommentsCheckboxLocator);
        Clicking(upvotesOnCommentsCheckbox);
    }

    public void changeRepliesToCommentsNotifications()
    {
        RepliesToCommentsCheckbox = driver.findElement(RepliesToCommentsCheckboxLocator);
        Clicking(RepliesToCommentsCheckbox);
    }

    public void changeActivityOnCommentNotifications()
    {
        activityOnCommentCheckbox = driver.findElement(activityOnCommentCheckboxLocator);
        Clicking(activityOnCommentCheckbox);
    }

    public void changeActivityOnChatPostsNotifications()
    {
        activityOnChatPostsCheckbox = driver.findElement(activityOnChatPostsCheckboxLocator);
        Clicking(activityOnChatPostsCheckbox);
    }

    public void changeNewFollowersNotifications()
    {
        newFollowersCheckbox = driver.findElement(newFollowersCheckboxLocator);
        Clicking(newFollowersCheckbox);
    }

    public void changeAwardsReceivedNotifications()
    {
        awardsReceivedCheckbox = driver.findElement(awardsReceivedCheckboxLocator);
        Clicking(awardsReceivedCheckbox);
    }

    public void changePostsFollowedNotifications()
    {
        postsFollowedCheckbox = driver.findElement(postsFollowedCheckboxLocator);
        Clicking(postsFollowedCheckbox);
    }

    public void changeCommentsFollowedNotifications()
    {
        commentsFollowedCheckbox = driver.findElement(commentsFollowedCheckboxLocator);
        Clicking(commentsFollowedCheckbox);
    }


}
