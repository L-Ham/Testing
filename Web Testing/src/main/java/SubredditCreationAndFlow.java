import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SubredditCreationAndFlow extends PageBase {

    public SubredditCreationAndFlow(WebDriver driver)
    {
        super(driver);
    }
    By createCommunityButtonLocator = By.xpath("//*[@id=\"sidebar-container\"]/div/nav/div[5]/div");
    By communityName = By.cssSelector("[data-testid='sdvgebhn']");
    By createCommunitySubmitLocator = By.cssSelector("[data-testid='wornebisrbkwnbnikb']");
    static By createPostButton = By.cssSelector("[data-testid='create-post-button']");
    By firstPost = By.xpath("//*[@id=\"main-container\"]/div/div[2]/main/div[2]/a");
    By addTitleTextBox=By.xpath("//textarea[contains(@class, 'box-border') and contains(@class, 'block')]");

    By postButton=By.xpath("//button[contains(@class, 'post-creation-form-footer__primaryBtn') and contains(@class, 'font')]");

    By addPostText= By.xpath("//textarea[contains(@class, 'font') and            contains(@class, 'size-full') and            contains(@class, 'min-h-[122px]')]");

    By addComment = By.xpath("//button[contains(text(), 'Add a comment')]");
    By addCommentTextArea = By.xpath("//textarea");
    By commentButton = By.xpath("//*[@id=\"main-container\"]/div/div/div[1]/div[3]/div/div[2]/div/div[2]/div/button[1]");

    By shareCommentButton = By.xpath("//*[@id=\"main-container\"]/div/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[2]/div/div/button");
    By commentText=By.xpath("//*[@id=\"main-container\"]/div/div/div[1]/div[3]/div[2]/div[2]/div[1]/div[2]/div/div/div/div");

    By postOptions = By.xpath("//*[@id=\"main-container\"]/div/div/div[1]/div[1]/div[1]/div[2]/button");
    By saveButton = By.xpath("//ul[@class='m-0 p-0']/li[1]");
    By notificationsButton = By.cssSelector("[data-testid='action-button-low-##33443@@-geso']");
    By firstNotification = By.xpath("//*[@id=\"header-container\"]/header/nav/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/a");


    void createCommunity (String CommunityName) throws InterruptedException
    {
        explicitWait(15, createCommunityButtonLocator);
        WebElement firstCreateCommunityButton = driver.findElement(createCommunityButtonLocator);
        Clicking(firstCreateCommunityButton);
        explicitWait(15, communityName);
        WebElement communityNameElement = driver.findElement(communityName);
        communityNameElement.sendKeys(CommunityName);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // wait for up to 15 seconds
        wait.until(ExpectedConditions.elementToBeClickable(createCommunitySubmitLocator));
        WebElement createCommunitySubmit = driver.findElement(createCommunitySubmitLocator);
        Clicking(createCommunitySubmit);
        Thread.sleep(4000);
    }

    public void addTextPost(String title, String text) throws InterruptedException
    {
        explicitWait(20, createPostButton);
        Clicking(driver.findElement(createPostButton));
        explicitWait(10, addTitleTextBox);
        WebElement addTitleTextBoxElement = driver.findElement(addTitleTextBox);
        sendText(addTitleTextBoxElement, title);
        Thread.sleep(2000);
        WebElement addPostTextElement = driver.findElement(addPostText);
        sendText(addPostTextElement, text);
        WebElement postButtonElement = driver.findElement(postButton);
        Thread.sleep(2000);
        Clicking(postButtonElement);

    }

    public String checkPostInFeed(String postText, String postTitle) throws InterruptedException
    {
        explicitWait(20, firstPost);
        WebElement firstPostElement = driver.findElement(firstPost);
        //Clicking(firstPostElement);
        Thread.sleep(3000);
        String pageSource = driver.getPageSource();
        //System.out.println(pageSource);
        if (pageSource.contains(postText)) {
            return "Post is in feed";
        } else {
            return "Post is not in feed";
        }
    }

    public void clickOnPost() throws InterruptedException
    {
        explicitWait(20, firstPost);
        WebElement firstPostElement = driver.findElement(firstPost);
        Clicking(firstPostElement);
        explicitWait(20, addComment);
    }

    public String addComment()
    {
        explicitWait(15, addComment);
        WebElement addCommentElement = driver.findElement(addComment);
        Clicking(addCommentElement);
        explicitWait(15, addCommentTextArea);
        WebElement addCommentTextAreaElement = driver.findElement(addCommentTextArea);
        sendText(addCommentTextAreaElement, "This is a comment! WOHO!");
        WebElement commentButtonElement = driver.findElement(commentButton);
        Clicking(commentButtonElement);
        driver.navigate().refresh();
        explicitWait(15, shareCommentButton);
        WebElement commentTextElement = driver.findElement(commentText);
        String commentText = commentTextElement.getText();
        System.out.println(commentText);
        return commentText;
    }

    public String savePost() throws InterruptedException
    {
        explicitWait(15, postOptions);
        WebElement postOptionsElement = driver.findElement(postOptions);
        Clicking(postOptionsElement);
        explicitWait(15, saveButton);
        Thread.sleep(2000);
        int attempts = 0;
        final int MAX_ATTEMPTS = 5;
        WebElement firstListItem = null;
        while (attempts < MAX_ATTEMPTS) {
            try {
                firstListItem = driver.findElement(saveButton);
                firstListItem.click();

                break; // Break out of the loop if successful
            } catch (StaleElementReferenceException e) {
                attempts++;
                System.out.println("Stale element reference exception. Retrying...");
            }
        }
        Thread.sleep(4000);
        Clicking(postOptionsElement);
        explicitWait(15, saveButton);
        return  "Saved";
    }

    public String checkSavedPost(String postText) throws InterruptedException {
        driver.get("https://reddit-bylham.me/user/hadidy/saved");
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(3000);
        String pageSource = driver.getPageSource();
        //System.out.println(pageSource);
        if (pageSource.contains(postText)) {
            return "Post is in saved feed";
        } else {
            return "Post is not in saved feed";
        }


    }

    public String checkNotifications(String postText) throws InterruptedException
    {
        explicitWait(15, notificationsButton);
        WebElement notificationsButtonElement = driver.findElement(notificationsButton);
        Clicking(notificationsButtonElement);
        explicitWait(15, firstNotification);
        WebElement firstNotificationElement = driver.findElement(firstNotification);
        Clicking(firstNotificationElement);
        explicitWait(15, postOptions);
        String pageSource = driver.getPageSource();
        if (pageSource.contains(postText))
        {
            return "Notification is received";
        }
        else
        {
            return "Notification isnot received";
        }
    }


}
