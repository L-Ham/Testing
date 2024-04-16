import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class NotificationsSettingsPage extends PageBase{
    NotificationsSettingsPage(WebDriver driver)
    {
        super(driver);
    }
    By notificationsTabLocator = By.id("tab-Notifications");
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

// Recommendations Notifications
    By trendingPostsCheckboxLocator = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/span[1]/div/div[2]/div/button");
    By communityRecommendationsCheckboxLocator = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/span[2]/div/div[2]/div/button");
    By reRedditCheckboxLocator = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/span[3]/div/div[2]/div/button");
    By featuredContentCheckboxLocator = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[3]/span[4]/div/div[2]/div/button");
    //Updates Notifications
    By announcementsCheckboxLocator = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/span[1]/div/div[2]/div/button");
    By cakeDayCheckboxLocator = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/span[2]/div/div[2]/div/button");
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

    // Recommendations Notifications Elements
    WebElement trendingPostsCheckbox;
    WebElement communityRecommendationsCheckbox;
    WebElement reRedditCheckbox;
    WebElement featuredContentCheckbox;

    // Updates Notifications Elements
    WebElement announcementsCheckbox;
    WebElement cakeDayCheckbox;



    public void openNotificationsTab()
    {
        notificationsTab = driver.findElement(notificationsTabLocator);
        Clicking(notificationsTab);
    }

    public void changePrivateMessagesNotifications()
    {
        privateMessagesCheckbox = driver.findElement(privateMessagesCheckboxLocator);
        Clicking(privateMessagesCheckbox);
    }

    public void changeChatMessagesNotifications()
    {
        chatMessagesCheckbox = driver.findElement(chatMessagesCheckboxLocator);
        Clicking(chatMessagesCheckbox);
    }

    public void changeChatRequestsNotifications()
    {
        chatRequestsCheckbox = driver.findElement(chatRequestsCheckboxLocator);
        Clicking(chatRequestsCheckbox);
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

    public void changeTrendingPostsNotifications()
    {
        trendingPostsCheckbox = driver.findElement(trendingPostsCheckboxLocator);
        Clicking(trendingPostsCheckbox);
    }

    public void changeCommunityRecommendationsNotifications()
    {
        communityRecommendationsCheckbox = driver.findElement(communityRecommendationsCheckboxLocator);
        Clicking(communityRecommendationsCheckbox);
    }

    public void changeReRedditNotifications()
    {
        reRedditCheckbox = driver.findElement(reRedditCheckboxLocator);
        Clicking(reRedditCheckbox);
    }

    public void changeFeaturedContentNotifications()
    {
        featuredContentCheckbox = driver.findElement(featuredContentCheckboxLocator);
        Clicking(featuredContentCheckbox);
    }

    public void changeAnnouncementsNotifications()
    {
        announcementsCheckbox = driver.findElement(announcementsCheckboxLocator);
        Clicking(announcementsCheckbox);
    }

    public void changeCakeDayNotifications()
    {
        cakeDayCheckbox = driver.findElement(cakeDayCheckboxLocator);
        Clicking(cakeDayCheckbox);
    }



}
