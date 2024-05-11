import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchingPage extends PageBase {
    public SearchingPage(WebDriver driver) {
        super(driver);
    }

    By searchBoxInput = By.xpath("//*[@id=\"SearchInput\"]");
    By relevanceButton = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div/div[2]/div[1]/div[1]/div/div/div/div[1]/button");
    By newButton = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div/div[2]/div[1]/div[1]/div/div/div/div[2]/ul/li[3]");
    By communitiesTab=By.xpath("//*[@id=\"main-container\"]/div/div[1]/div/div[1]/div[1]/div/div/div/span[2]/a");
    By commentsTab=By.xpath("//*[@id=\"main-container\"]/div/div[1]/div/div[1]/div[1]/div/div/div/span[3]/a");
    By peopleTab=By.xpath("//*[@id=\"main-container\"]/div/div[1]/div/div[1]/div[1]/div/div/div/span[5]/a");

public void search(String searchInput) throws InterruptedException {
        explicitWait(15, searchBoxInput);
        WebElement searchBoxInputElement = driver.findElement(searchBoxInput);
        searchBoxInputElement.clear();
        sendText(searchBoxInputElement, searchInput);
        searchBoxInputElement.submit();
        explicitWait(15, relevanceButton);
        WebElement relevanceButtonElement = driver.findElement(relevanceButton);
        Clicking(relevanceButtonElement);
        explicitWait(15, newButton);
        WebElement newButtonElement = driver.findElement(newButton);
        Clicking(newButtonElement);
        Thread.sleep(10000);
}

public String searchPost()
{
    String textFound = driver.getPageSource();
    if (textFound.contains("TestingPost"))
    {
        return "Post is found";
    }
    else
    {
        return "Post is not found";
    }
}

public String searchCommunity() throws InterruptedException {
    explicitWait(15, communitiesTab);
    WebElement communitiesTabElement = driver.findElement(communitiesTab);
    Clicking(communitiesTabElement);
    Thread.sleep(500);
    String textFound = driver.getPageSource();
    if (textFound.contains("CommunityHadidy"))
    {
        return "Community is found";
    }
    else
    {
        return "Community is not found";
    }
}

String searchComment() throws InterruptedException {
    explicitWait(15, commentsTab);
    WebElement commentsTabElement = driver.findElement(commentsTab);
    Clicking(commentsTabElement);
    Thread.sleep(5000);
    String textFound = driver.getPageSource();
    if (textFound.contains("Comment 1"))
    {
        return "Comment is found";
    }
    else
    {
        return "Comment is not found";
    }
}

String searchPeople() throws InterruptedException
{
    explicitWait(15, peopleTab);
    WebElement peopleTabElement = driver.findElement(peopleTab);
    Clicking(peopleTabElement);
    Thread.sleep(5000);
    String textFound = driver.getPageSource();
    if (textFound.contains("fahdseddik")) {
        return "People is found";
    } else {
        return "People is not found";
    }
}






}
