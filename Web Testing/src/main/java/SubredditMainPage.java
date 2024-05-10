import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;

public class SubredditMainPage extends PageBase{

    public SubredditMainPage (WebDriver driver)
    {
        super(driver);
    }

    By subredditDescription = By.xpath("//*[@id=\"right-sidebar-container\"]/aside/div/div[1]/div[2]/div");

    By subredditName = By.xpath("//*[@id=\"right-sidebar-container\"]/aside/div/div[1]/div[1]/h2");

    By subredditJoinButton = By.xpath("//*[@id=\"main-container\"]/div/div[1]/section/div/div[2]/div/div/button");

    By dragonOAthSubReddit = By.xpath("//*[@id=\"sidebar-container\"]/div/nav/div[5]/a[1]");

    By menuItemAddToFav = By.cssSelector("[data-testid='overflow-control-button']");

    By addToFavOption = By.cssSelector("[data-testid='item-container']");

    By removeFavOption = By.cssSelector("[data-testid='text-container']");

    By addToFavFromSidePanel=By.xpath("//*[@id=\"sidebar-container\"]/div/nav/div[5]/a[1]/button");

    By addImageTab=By.xpath("//button[contains(@class, 'post-creation-form__tab') and contains(., 'Images & Video')]\n");

    By addTitleTextBox=By.xpath("//textarea[contains(@class, 'box-border') and contains(@class, 'block')]");

    By uploadImage=By.xpath("//button[contains(@class, 'post-creation-upload_btn') and contains(text(), 'Upload')]\n");

    By postButton=By.xpath("//button[contains(@class, 'post-creation-form-footer__primaryBtn') and contains(@class, 'font')]");

    By addPostText= By.xpath("//textarea[contains(@class, 'font') and            contains(@class, 'size-full') and            contains(@class, 'min-h-[122px]')]");

    By upVoteButton= By.cssSelector("[data-testid='upvote-t3_1bmnuhw']");

    By downVoteButton= By.cssSelector("[data-testid='downvote-t3_1bmnuhw']");
    By scoreButton= By.cssSelector("[data-testid='score-t3_1bmnuhw']");
    By membersCount = By.xpath("//*[@id=\"right-sidebar-container\"]/aside/div/div[1]/div[3]/div[1]/span[1]/strong/div");

    By postNSFWButton = By.xpath("//button[contains(@class, 'inline-flex') and contains(@class, 'h-8') and span/span[contains(@class, 'text-xs') and contains(text(), 'View NSFW content')]]");
    public void clickdragonOAthSubReddit()
    {
        explicitWait(15, dragonOAthSubReddit);
        WebElement dragonOAthSubRedditElement = driver.findElement(dragonOAthSubReddit);
        Clicking(dragonOAthSubRedditElement);
    }
    public String checkSubredditDescription()
    {
        explicitWait(10, subredditDescription);
        WebElement subredditDescriptionElement = driver.findElement(subredditDescription);
        return subredditDescriptionElement.getText();
    }

    public String checkJoined()
    {
        explicitWait(10, subredditJoinButton);
        WebElement subredditJoinButtonElement = driver.findElement(subredditJoinButton);
        return subredditJoinButtonElement.getText();
    }

    public String checkUnjoined() throws InterruptedException {
        explicitWait(10, subredditJoinButton);
        WebElement subredditJoinButtonElement = driver.findElement(subredditJoinButton);
        Clicking(subredditJoinButtonElement);
        while(!Objects.equals(subredditJoinButtonElement.getText(), "Join"))
        {
            //Do nothing
        }
        return subredditJoinButtonElement.getText();
    }

    public String clickOnJoin()
    {
        explicitWait(10, subredditJoinButton);
        WebElement subredditJoinButtonElement = driver.findElement(subredditJoinButton);
        Clicking(subredditJoinButtonElement);
        return subredditJoinButtonElement.getText();
    }

    public void checkRemovedFromCommunityList()
    {
        driver.navigate().refresh();
        explicitWait(10, dragonOAthSubReddit);
        WebElement onePieceSubRedditElement = driver.findElement(dragonOAthSubReddit);
        Clicking(onePieceSubRedditElement);
    }

    public String checkJoinedWhenAddedToFavourites()
    {
        explicitWait(10, menuItemAddToFav);
        WebElement menuItemAddToFavElement = driver.findElement(menuItemAddToFav);
        Clicking(menuItemAddToFavElement);
        explicitWait(10, addToFavOption);
        WebElement addToFavOptionElement = driver.findElement(addToFavOption);
        Clicking(addToFavOptionElement);
        WebElement JoinButton = driver.findElement(subredditJoinButton);
        while (!Objects.equals(JoinButton.getText(), "Joined"))
        {
            //Do nothing
        }
        Clicking(menuItemAddToFavElement);
        return JoinButton.getText();
    }

    public String stillJoinedWhenRemovedFromFav() throws InterruptedException {
       // Thread.sleep(4000);
        explicitWait(10, addToFavFromSidePanel);
        WebElement addToFavFromSideElement = driver.findElement(addToFavFromSidePanel);
        Clicking(addToFavFromSideElement);
        explicitWait(10,menuItemAddToFav);
        WebElement menuItemAddToFavElement = driver.findElement(menuItemAddToFav);
        Clicking(menuItemAddToFavElement);
        driver.navigate().refresh();
//        explicitWait(10, addToFavOption);
//        WebElement addToFavOptionElement = driver.findElement(addToFavOption);
        explicitWait(20, subredditJoinButton);
        WebElement JoinButton = driver.findElement(subredditJoinButton);
        return JoinButton.getText();
    }

    public void addTextPost() throws InterruptedException
    {
        explicitWait(10, addTitleTextBox);
        WebElement addTitleTextBoxElement = driver.findElement(addTitleTextBox);
        sendText(addTitleTextBoxElement, "This is a test post");
        Thread.sleep(2000);
        WebElement addPostTextElement = driver.findElement(addPostText);
        sendText(addPostTextElement, "HI ENG HISAAAA!!");
        WebElement postButtonElement = driver.findElement(postButton);
        Thread.sleep(2000);
        Clicking(postButtonElement);

    }

    public void clickPostNSFWButton()
    {
        explicitWait(10, postNSFWButton);
        WebElement postNSFWButtonElement = driver.findElement(postNSFWButton);
        Clicking(postNSFWButtonElement);
    }

    public void addImagePost() throws AWTException, InterruptedException, IOException {
        explicitWait(30, addImageTab);
        WebElement addImageTabElement = driver.findElement(addImageTab);
        Clicking(addImageTabElement);
        explicitWait(10, uploadImage);
        WebElement uploadImageElement = driver.findElement(uploadImage);
        Clicking(uploadImageElement);
        Runtime.getRuntime().exec("\"C:\\Users\\husse\\OneDrive\\Desktop\\All Courses\\Software Engineering\\imageUpload.exe\"").waitFor();
        Thread.sleep(3000);
        explicitWait(10, postButton);
    }

    public void checkUpVotes(int[] values) throws InterruptedException
    {
        explicitWait(10, upVoteButton);
        WebElement upVoteButtonElement = driver.findElement(upVoteButton);
        WebElement scoreButtonElement = driver.findElement(scoreButton);
        String score = scoreButtonElement.getText();
        values[0] = Integer.parseInt(score);
        Clicking(upVoteButtonElement);
        while (Objects.equals(scoreButtonElement.getText(), score))
        {
            //Do nothing
        }
        String newScore = scoreButtonElement.getText();
        values[1] = Integer.parseInt(newScore);
    }

    public void checkDownVotes(int[] values) throws InterruptedException
    {
        explicitWait(10, downVoteButton);
        WebElement downVoteButtonElement = driver.findElement(downVoteButton);
        WebElement scoreButtonElement = driver.findElement(scoreButton);
        String score = scoreButtonElement.getText();
        values[0] = Integer.parseInt(score);
        Clicking(downVoteButtonElement);
        while (Objects.equals(scoreButtonElement.getText(), score))
        {
            //Do nothing
        }
        String newScore = scoreButtonElement.getText();
        values[1] = Integer.parseInt(newScore);
    }

    public String getMembersCount()
    {
        explicitWait(10, membersCount);
        WebElement membersCountElement = driver.findElement(membersCount);
        return membersCountElement.getText();
    }




}
