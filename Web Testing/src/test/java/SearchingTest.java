import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchingTest extends TestBase{

    SubredditModerationPage subredditModerationPage;
    LoginPage loginPage;
    SearchingPage searchingPage;
    @BeforeTest
    public void setUp() throws InterruptedException {
        subredditModerationPage = new SubredditModerationPage(driver);
        searchingPage = new SearchingPage(driver);
        loginPage = new LoginPage(driver);
        loginPage.login("Rana", "12345678");
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    void searchPosts() throws InterruptedException
    {
        searchingPage.search("post");
        Thread.sleep(2000);
        String status = searchingPage.searchPost();
        Assert.assertEquals(status, "Post is found");
    }

    @Test (priority = 2)
    void searchCommunities() throws InterruptedException
    {
        searchingPage.search("Commu");
        String status= searchingPage.searchCommunity();
        Assert.assertEquals(status, "Community is found");
    }

    @Test(priority = 3)
    void searchComment() throws InterruptedException
    {
        searchingPage.search("Comment");
        String status = searchingPage.searchComment();
        Assert.assertEquals(status, "Comment is found");
    }

    @Test(priority = 4)
    void searchPeople() throws InterruptedException
    {
        searchingPage.search("fahd");
        String status = searchingPage.searchPeople();
        Assert.assertEquals(status, "People is found");
    }
}
