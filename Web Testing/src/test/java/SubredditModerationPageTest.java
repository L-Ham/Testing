import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubredditModerationPageTest extends TestBase
{
    SubredditModerationPage subredditModerationPage;
    LoginPage loginPage;
    @BeforeTest
    public void setUp() throws InterruptedException {
        subredditModerationPage = new SubredditModerationPage(driver);
        loginPage = new LoginPage(driver);
        loginPage.login("Rana", "12345678");
        subredditModerationPage.goToRealPPl();
    }

    @DataProvider(name = "editSubredditDescriptionData")
    public Object[][] getData()
    {
        return new Object[][]
                {
                        {"Description gdid awyy", "memebrs name gdid awyy", "viewer name gdid awyy"},
                        {"Description gdid awyy2", "memebrs name gdid awyy", "viewer name gdid awyy"},
                        {"Description gdid awyy3", "memebrs name gdid awyy", "viewer name gdid awyy"}
                };
    }

    @Test(dataProvider = "editSubredditDescriptionData", priority = 1)
    public void checkEditSubredditDescriptionTest(String newDescription, String newMembersNickName, String newViewingNickName) throws InterruptedException
    {
        subredditModerationPage.checkEditSubredditDescription(newDescription, newMembersNickName, newViewingNickName);
        String[] newSubredditDescription = subredditModerationPage.checkAfterEditingSubredditDescription();
        Assert.assertEquals(newSubredditDescription[0], newDescription);
        Assert.assertEquals(newSubredditDescription[1], newMembersNickName);
        Assert.assertEquals(newSubredditDescription[2], newViewingNickName);
        driver.navigate().back();
    }

    @DataProvider(name = "editRulesData")
    public Object[][] getRuleData() {
        return new Object[][]
                {
                        {"new rule", "comments", "full new description"}
                };
    }

    @Test(dataProvider = "editRulesData", priority = 2)
    public void checkAddSubredditRulesTest(String ruleName,String appliesTo, String ruleDescription) throws InterruptedException
    {
        String notification=subredditModerationPage.addRules(ruleName, appliesTo, ruleDescription);
        Assert.assertEquals(notification, "Rule added successfully");

    }

    @Test(priority = 3)
    public void editRulesTest() throws InterruptedException
    {
        String notification=subredditModerationPage.editRules();
        Assert.assertEquals(notification, "Rule edited successfully");
    }

    @Test(priority = 4)
    public void deleteRulesTest() throws InterruptedException
    {
        String notification=subredditModerationPage.deleteRules();
        Assert.assertEquals(notification, "Rule deleted successfully");
    }

    @Test(priority = 5)
    public void reorderTest() throws InterruptedException
    {
        String notification=subredditModerationPage.reorderRules();
        Assert.assertEquals(notification, "True");
    }

    @DataProvider(name = "RemovalReasonData")
    public Object[][] getRemovalReasonData() {
        return new Object[][]
                {
                        {"Removal Reason Title", "Removal Reason Description"}
                };
    }

    @Test(priority = 6, dataProvider = "RemovalReasonData")
    public void checkAddRemovalReasonTest(String reasonTitle, String reasonDescription) throws InterruptedException
    {
        String notification=subredditModerationPage.addRemovalReason(reasonTitle, reasonDescription);
        Assert.assertEquals(notification, "Removal reason added successfully");
        subredditModerationPage.goToRealPPl();
    }

    @Test(priority = 7)
    public void addBookmarkWidget()
    {
        String notification=subredditModerationPage.addBookmarkWidget();
        Assert.assertEquals(notification, "Bookmarks widget added successfully");
    }

    @Test(priority = 8)
    public void invalidAddBookmarkWidget()
    {
        driver.navigate().refresh();
        String notification=subredditModerationPage.invalidAddBookmarkWidget();
        Assert.assertEquals(notification, "failed to add new bookmark (Invalid URL)");
    }

    @Test (priority = 9)
    public void descriptionValidationTest() throws InterruptedException
    {
        driver.get("https://reddit-bylham.me/r/Dragon%20Oath");
        Thread.sleep(4000);
        String notification=subredditModerationPage.descriptionValidation();
        Assert.assertEquals(notification, "Community Description is present");

    }

}
