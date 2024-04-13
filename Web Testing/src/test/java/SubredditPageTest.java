import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class SubredditPageTest  extends TestBase {
    private SubredditPage subredditPage;
    private LoginPage loginPage;
    @BeforeTest
    public void getSubredditPage() {
        subredditPage = new SubredditPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void createPostTest() throws InterruptedException{
        loginPage.login("Ill_Initial_3945", "/m4!2QHj!saysm4");
        Thread.sleep(5000);
        subredditPage.openSubreddit("https://www.reddit.com/r/AmItheAsshole/");
        subredditPage.clickCreatePostButton();
        Thread.sleep(3000);
        subredditPage.setPostTitle("AITA test title for subreddit page test");
        Thread.sleep(3000);
        subredditPage.setPostTextbox("Test Text to ensure the post is created successfully, Character requirements is not met so i will copy the subreddit description here: A catharsis for the frustrated moral philosopher in all of us, and a place to finally find out if you were wrong in an argument that's been bothering you. Tell us about any non-violent conflict you have experienced; give us both sides of the story, and find out if you're right, or you're the asshole. See our ~~*Best Of*~~ Most Controversial!");
        Thread.sleep(3000);
        subredditPage.clickSpoilerButton();
        Thread.sleep(3000);
        subredditPage.clickNSFWButton();
        Thread.sleep(3000);
        subredditPage.clickSaveDraftButton();
        Thread.sleep(3000);
        loginPage.backToLogin();
    }

    @Test
    public void filterPostTest() throws InterruptedException{
        loginPage.login("Ill_Initial_3945", "/m4!2QHj!saysm4");
        Thread.sleep(5000);
        subredditPage.openSubreddit("https://www.reddit.com/r/AmItheAsshole/");
        Thread.sleep(3000);
        subredditPage.setPostFilter("Top");
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("top"));
        subredditPage.setPostFilter("New");
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("new"));
        subredditPage.setPostFilter("Rising");
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("rising"));
        subredditPage.setPostFilter("Hot");
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("hot"));
        subredditPage.setPostView("Compact");
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("compactView"));
        subredditPage.setPostView("Card");
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("cardView"));
    }

    @Test
    public void clickNotificationTest() throws InterruptedException{
        loginPage.login("Ill_Initial_3945", "/m4!2QHj!saysm4");
        Thread.sleep(5000);
        subredditPage.openSubreddit("https://www.reddit.com/r/AmItheAsshole/");
        Thread.sleep(3000);
        subredditPage.clickNotificationButton();
        Thread.sleep(3000);
    }
}
