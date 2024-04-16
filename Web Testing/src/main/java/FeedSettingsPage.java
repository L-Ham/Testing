import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FeedSettingsPage extends PageBase{

    FeedSettingsPage(WebDriver driver)
    {
        super(driver);
    }

    By feedTabLocator = By.id("tab-Feed settings");
    WebElement feedTab;

    By isMature= By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/div/div/button");
By enableFeedRecommendations=By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div[2]/div/div/button");
By autoplayMedia = By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div/div[4]/div[2]/div/div/button");
By reduceAnimations= By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div/div[5]/div[2]/div/div/button");
By communityThemes= By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div/div[6]/div[2]/div/div/button");
By openPostsInNewTab= By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div/div[9]/div[2]/div/div/button");
By defaultToMarkdowns= By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div/div[11]/div[2]/div/div/button");

By sortContentButtonLocator = By.id("r17");
WebElement sortContentButton;
By sortContentLocator;


    By globalViewButtonLocator= By.id("r18");
    WebElement globalView;
    By globalViewLocator;
WebElement sortContent;
    public void openFeedTab()
    {
        feedTab = driver.findElement(feedTabLocator);
        Clicking(feedTab);
    }

    public void isMature()
    {
        Clicking(driver.findElement(isMature));
    }

    public void enableFeedRecommendations()
    {
        Clicking(driver.findElement(enableFeedRecommendations));
    }

    public void autoplayMedia()
    {
        Clicking(driver.findElement(autoplayMedia));
    }

    public void reduceAnimations()
    {
        Clicking(driver.findElement(reduceAnimations));
    }

    public void communityThemes()
    {
        Clicking(driver.findElement(communityThemes));
    }

    public void openPostsInNewTab()
    {
        Clicking(driver.findElement(openPostsInNewTab));
    }

    public void defaultToMarkdowns()
    {
        Clicking(driver.findElement(defaultToMarkdowns));
    }

    public void sortContent(String content) throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        sortContentButton = driver.findElement(sortContentButtonLocator);
        Clicking(sortContentButton);
        Thread.sleep(2000);
        if (content.equalsIgnoreCase("Hot"))
        {
            sortContentLocator= By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div/div[7]/div[2]/div/div/div/div/div[2]/button[1]");
        }
        else if (content.equalsIgnoreCase("New"))
        {
            sortContentLocator= By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div/div[7]/div[2]/div/div/div/div/div[2]/button[2]");
        }
        else if (content.equalsIgnoreCase("Top"))
        {
            sortContentLocator= By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div/div[7]/div[2]/div/div/div/div/div[2]/button[3]");
        }
        else
        {
            sortContentLocator= By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div/div[7]/div[2]/div/div/div/div/div[2]/button[4]");
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(sortContentLocator));
        Clicking(driver.findElement(sortContentLocator));
    }

    public void globalView(String view) throws InterruptedException
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        globalView = driver.findElement(globalViewButtonLocator);
        Clicking(globalView);
        Thread.sleep(2000);
        if (view.equalsIgnoreCase("Card"))
        {
            globalViewLocator= By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div/div[8]/div[2]/div/div/div/div/div[2]/button[1]");
        }
        else if (view.equalsIgnoreCase("Classic"))
        {
            globalViewLocator= By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div/div[8]/div[2]/div/div/div/div/div[2]/button[2]");
        }
        else
        {
            globalViewLocator= By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div/div[8]/div[2]/div/div/div/div/div[2]/button[3]");
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(globalViewLocator));
        Clicking(driver.findElement(globalViewLocator));

    }

}
