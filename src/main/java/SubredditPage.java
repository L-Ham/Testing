import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SubredditPage extends PageBase {
    public SubredditPage(WebDriver driver)
    {
        super(driver);
    }

    By createPostButtonLocator = By.xpath("/html/body/shreddit-app/dsa-transparency-modal-provider/report-flow-provider/div/div[1]/div[1]/section/div/div[2]/span/faceplate-tracker/a");
    By postTitleLocator = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div[3]/div[1]/div[2]/div[4]/div[2]/div[1]/div[1]/textarea");
    By postTextboxLocator= By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div[3]/div[1]/div[2]/div[4]/div[2]/div[2]/div[1]/div/div[3]/div/div[1]/div/div/div");
    By spoilerButtonLocator = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div[3]/div[1]/div[2]/div[4]/div[3]/div[1]/div/button[2]");
    By NSFWButtonLocator = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div[3]/div[1]/div[2]/div[4]/div[3]/div[1]/div/button[3]");
    By saveDraftButtonLocator = By.xpath("//*[@id=\"AppRouter-main-content\"]/div/div/div[2]/div[3]/div[1]/div[2]/div[4]/div[3]/div[2]/div/div/div[2]/button");

    By postFilterLocator = By.xpath("//*[@id=\"main-content\"]/div[1]/shreddit-async-loader/div/div/shreddit-sort-dropdown");
By postViewLocator = By.xpath("//*[@id=\"main-content\"]/div[1]/shreddit-async-loader/div/shreddit-layout-event-setter/shreddit-sort-dropdown");
By notificationButtonLocator = By.xpath("/html/body/shreddit-app/dsa-transparency-modal-provider/report-flow-provider/div/div[1]/div[1]/section/div/div[2]/shreddit-subreddit-header-buttons//div/shreddit-notification-frequency-control//faceplate-dropdown-menu/button");
By postFilterOptionLocator;
    By postViewOptionLocator;
WebElement createPostButton;
    WebElement postTitle;
    WebElement postTextbox;
    WebElement spoilerButton;
    WebElement NSFWButton;
    WebElement saveDraftButton;

    WebElement postFilter;
    WebElement postView;
    WebElement notificationButton;

    public void openSubreddit(String subredditURL)
    {
        driver.navigate().to(subredditURL);
    }
    public void clickCreatePostButton()
    {
        createPostButton = driver.findElement(createPostButtonLocator);
        createPostButton.click();
    }

    public void setPostTitle(String title)
    {
        postTitle = driver.findElement(postTitleLocator);
        postTitle.sendKeys(title);
    }

    public void setPostTextbox(String text)
    {
        postTextbox = driver.findElement(postTextboxLocator);
        postTextbox.sendKeys(text);
    }

    public void clickSpoilerButton()
    {
        spoilerButton = driver.findElement(spoilerButtonLocator);
        spoilerButton.click();
    }

    public void clickNSFWButton()
    {
        NSFWButton = driver.findElement(NSFWButtonLocator);
        NSFWButton.click();
    }

    public void clickSaveDraftButton()
    {
        saveDraftButton = driver.findElement(saveDraftButtonLocator);
        saveDraftButton.click();
    }


    public void setPostFilter(String filter)
    {
        postFilter = driver.findElement(postFilterLocator);
        Clicking(postFilter);
        switch (filter) {
            case "Top" ->
                    postFilterOptionLocator = By.xpath("//*[@id=\"main-content\"]/div[1]/shreddit-async-loader/div/div/shreddit-sort-dropdown/div[3]/li[3]");
            case "New" ->
                    postFilterOptionLocator = By.xpath("//*[@id=\"main-content\"]/div[1]/shreddit-async-loader/div/div/shreddit-sort-dropdown/div[3]/li[2]");
            case "Rising" ->
                    postFilterOptionLocator = By.xpath("//*[@id=\"main-content\"]/div[1]/shreddit-async-loader/div/div/shreddit-sort-dropdown/div[3]/li[4]");
            case "Hot" ->
                    postFilterOptionLocator = By.xpath("//*[@id=\"main-content\"]/div[1]/shreddit-async-loader/div/div/shreddit-sort-dropdown/div[3]/li[1]");
        }

        WebElement postFilterOption = driver.findElement(postFilterOptionLocator);
        Clicking(postFilterOption);
    }

    public void setPostView(String view)
    {
        postView = driver.findElement(postViewLocator);
        Clicking(postView);
        switch (view) {
            case "Card" ->
                    postViewOptionLocator = By.xpath("//*[@id=\"main-content\"]/div[1]/shreddit-async-loader/div/shreddit-layout-event-setter/shreddit-sort-dropdown/div[3]/data[1]/li");
            case "Compact" ->
                    postViewOptionLocator = By.xpath("//*[@id=\"main-content\"]/div[1]/shreddit-async-loader/div/shreddit-layout-event-setter/shreddit-sort-dropdown/div[3]/data[2]/li");
        }

        WebElement postViewOption = driver.findElement(postViewOptionLocator);
        Clicking(postViewOption);

    }

    public void clickNotificationButton()
    {
        notificationButton = driver.findElement(notificationButtonLocator);
        notificationButton.click();
    }

}
