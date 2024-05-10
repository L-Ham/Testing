import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubredditCreationAndFlowTest extends TestBase
{
    LoginPage loginPage;
    SubredditCreationAndFlow subredditCreationPage;

    SubredditMainPage subredditMainPage;
    @BeforeTest
    public void startUp()
    {
        loginPage = new LoginPage(driver);
        subredditCreationPage = new SubredditCreationAndFlow(driver);
        subredditMainPage = new SubredditMainPage(driver);
        loginPage.login("hadidy", "12345678");
    }

    @DataProvider(name = "community")
    public Object[][] getData() {
        return new Object[][]
                {
                        {"CommunityHadidyy","Title from hadidy", "hadidyyyyy"}
                };
    }

    @Test(priority = 1, dataProvider = "community")
    public void createNewSubreddit(String communityName, String title, String text) throws InterruptedException {
        subredditCreationPage.createCommunity(communityName);
        //explicitWait(20,SubredditCreationAndFlow.add);
        Assert.assertEquals(driver.getCurrentUrl(), "https://reddit-bylham.me/r/"+communityName);
    }

    @Test(priority = 2, dependsOnMethods = "createNewSubreddit", dataProvider = "community")
    public void createPostToFeedAndRedirection(String communityName, String title, String text) throws InterruptedException {
        subredditCreationPage.addTextPost(title, text);
        explicitWait(20,SubredditCreationAndFlow.createPostButton);
        Assert.assertEquals(driver.getCurrentUrl(), "https://reddit-bylham.me/r/"+communityName);
    }
    @Test(priority = 3, dependsOnMethods = "createPostToFeedAndRedirection", dataProvider = "community")
    public void checkPostInFeed(String communityName, String title, String text) throws InterruptedException
    {
       String postStatus = subredditCreationPage.checkPostInFeed(title, text);
       Assert.assertEquals(postStatus, "Post is in feed");
    }

    @Test(priority = 4, dependsOnMethods = "checkPostInFeed")
    public void clickOnPost() throws InterruptedException
    {
        subredditCreationPage.clickOnPost();
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://reddit-bylham.me/r/newCommunityTestALo");
    }

    @Test(priority = 5, dependsOnMethods = "clickOnPost")
    public void addComment()
    {
       String commentText = subredditCreationPage.addComment();
       Assert.assertEquals(commentText, "This is a comment! WOHO!");
    }

    @Test(priority = 6, dependsOnMethods = "addComment")
    public void savePost() throws InterruptedException
    {
        String status = subredditCreationPage.savePost();
        Assert.assertEquals(status,"Saved");
    }

    @Test(priority = 7, dependsOnMethods = "savePost", dataProvider = "community")
     public void checkSavedTest(String communityName, String title, String text) throws InterruptedException {
        String postStatus = subredditCreationPage.checkSavedPost(text);
        Assert.assertEquals(postStatus, "Post is in saved feed");

    }

    @Test(priority = 8, dataProvider = "community")
    public void invalidCommunityName(String communityName, String title, String text) throws InterruptedException
    {
        driver.navigate().to("https://reddit-bylham.me");
        subredditCreationPage.createCommunity(communityName);
        Assert.assertEquals(driver.getCurrentUrl(), "https://reddit-bylham.me/");
    }

    @Test(priority = 9, dataProvider = "community")
    public void schedulePost(String communityName, String title, String text) throws InterruptedException
    {
        String notificationStatus = subredditCreationPage.checkNotifications(text);
        Assert.assertEquals(notificationStatus, "Notification is received");

    }







}
