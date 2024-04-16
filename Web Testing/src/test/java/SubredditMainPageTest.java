import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;

public class SubredditMainPageTest extends TestBase{
    SubredditMainPage subredditMainPage;
    LoginPage loginPage;
    @BeforeTest
    public void setUp()
    {
        subredditMainPage = new SubredditMainPage(driver);
        loginPage = new LoginPage(driver);
    }

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][]
                {
                        {"jeniffer", "123456789"}
                };
    }

    @Test (dataProvider = "loginData", priority = 1)
    public void checkSubredditDescriptionTest(String username, String password)
    {
        loginPage.login(username, password);
        subredditMainPage.clickOnePieceSubReddit();
        String actualDescription = subredditMainPage.checkSubredditDescription();
        String expectedDescription = "Welcome to r/OnePiece, the community for Eiichiro Oda's manga and anime series One Piece. From the East Blue to the New World, anything related to the world of One Piece belongs here! If you've just set sail with the Straw Hat Pirates, be wary of spoilers on this subreddit!";
        Assert.assertEquals(actualDescription, expectedDescription);
    }

    @Test (dependsOnMethods = "checkSubredditDescriptionTest", priority = 2)
    public void checkSubredditJoinedUnjoinedTest() throws InterruptedException
    {
       String joinStatus = subredditMainPage.checkJoined();
       Assert.assertEquals(joinStatus, "Joined");
       String unjoinStatus = subredditMainPage.checkUnjoined();
       Assert.assertEquals(unjoinStatus, "Join");
    }

    @Test (dependsOnMethods = "checkSubredditJoinedUnjoinedTest", priority = 3)
    public void checkSubredditRemovedFromCommunityListTest() throws InterruptedException
    {
        subredditMainPage.checkRemovedFromCommunityList();
        implicitWait(10);
        //System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.reddit.com/r/OnePiece/");
    }

    @Test(priority = 4)
    public void checkJoinedWhenAddedToFavouritesTest()
    {
        driver.navigate().to("https://reddit-bylham.me/r/OnePiece");
        implicitWait(10);
        String checkJoinedStatus=subredditMainPage.checkJoinedWhenAddedToFavourites();
        Assert.assertEquals(checkJoinedStatus, "Joined");
    }

    @Test(priority = 5)
    public void stillJoinedAfterRemovalFromFavouritesTest() throws InterruptedException
    {
        driver.navigate().refresh();
        implicitWait(10);
        String checkJoinedStatus=subredditMainPage.stillJoinedWhenRemovedFromFav();
        Assert.assertEquals(checkJoinedStatus, "Joined");
    }

    @Test(priority = 6)
    public void addImagePostTest() throws AWTException, InterruptedException, IOException {
        driver.navigate().to("https://reddit-bylham.me/r/OnePiece/submit");
        subredditMainPage.addImagePost();
    }

//    @Test(priority = 7)
//    public void addTextPostTest() throws InterruptedException
//    {
//        driver.navigate().to("https://reddit-bylham.me/r/OnePiece/submit");
//        subredditMainPage.addTextPost();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//        String alertText = alert.getText();
//        Assert.assertEquals(alertText,"Post created successfully");
//        alert.accept();
//        Thread.sleep(1000);
//    }

    @Test(priority = 8)
    public void checkUpVotesTest() throws InterruptedException
    {
        int[] scores = new int[2];
        driver.navigate().to("https://reddit-bylham.me/r/OnePiece");
        subredditMainPage.checkUpVotes(scores);
        Assert.assertTrue(scores[0] < scores[1]);
    }

    @Test (priority = 9)
    public void checkDownVotesTest() throws InterruptedException
    {
        int[] scores = new int[2];
        driver.navigate().to("https://reddit-bylham.me/r/OnePiece");
        subredditMainPage.checkDownVotes(scores);
        Assert.assertTrue(scores[0] > scores[1]);

    }

    @Test (priority = 10)
    public void checkMembersCountTest() throws InterruptedException
    {
        driver.navigate().to("https://reddit-bylham.me/r/OnePiece");
        String oldCount = subredditMainPage.getMembersCount();
        int oldCountNum=Integer.parseInt(oldCount);
        loginPage.clickProfilePageGetName();
        loginPage.logOut();
        loginPage.login("husseinkh", "hihussein");
        Thread.sleep(2000);
        driver.navigate().to("https://reddit-bylham.me/r/OnePiece");
        subredditMainPage.clickOnJoin();
        driver.navigate().refresh();
        Thread.sleep(2000);
        String newCount = subredditMainPage.getMembersCount();
        int newCountNum=Integer.parseInt(newCount);
        Assert.assertEquals(newCountNum, oldCountNum+1);

    }

}
