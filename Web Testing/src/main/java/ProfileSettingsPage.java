import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class ProfileSettingsPage extends PageBase{
    ProfileSettingsPage(WebDriver driver)
    {
        super(driver);
    }
    By profileTabLocator = By.id("tab-Profile");
    By displayNameTextBoxLocator = By.id("dn12");
    By aboutTextboxLocator = By.id("text3");

    By addSocialLinkButtonLocator = By.xpath("//*[@id=\"sociundefined\"]");

    By addCustomURLButtonLocator = By.xpath("//*[@id=\"main-container\"]/div[2]/div/section/div/li[1]");
    By addInstagramLocator;
    By addTwitterLocator;
    By addRedditLocator;
    By addTikTokLocator;
    By addUsernameLocator= By.id("input1");
    By addDisplayTextLocator= By.id("input2");

    By saveSocialLinkButtonLocator = By.id("button7");
    By closeSocialLinkButtonLocator = By.xpath("//*[@id=\"main-container\"]/div[2]/div/section/header/div/div[2]/button");
    WebElement profileTab;
    WebElement displayNameTextBox;
    WebElement aboutTextBox;

    WebElement addSocialLinkButton;

    WebElement addInstagramLink;

    WebElement addTwitterLink;

    WebElement addRedditLink;

    WebElement addTikTokLink;

    WebElement addUsername;

    WebElement addDisplayText;

    WebElement saveSocialLinkButton;

    WebElement closeSocialLinkButton;

    WebElement addCustomURLButton;



    public void openProfileTab()
    {
        profileTab = driver.findElement(profileTabLocator);
        Clicking(profileTab);
    }

    public void changeDisplayName(String displayName)
    {
        explicitWait(10, displayNameTextBoxLocator);
        displayNameTextBox = driver.findElement(displayNameTextBoxLocator);
        displayNameTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        displayNameTextBox.sendKeys(Keys.BACK_SPACE);
        sendText(displayNameTextBox, displayName);
        openProfileTab();
    }

    public void changeAbout(String about)
    {
        aboutTextBox = driver.findElement(aboutTextboxLocator);
        aboutTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        aboutTextBox.sendKeys(Keys.BACK_SPACE);
        sendText(aboutTextBox, about);
        openProfileTab();
    }

    public void addInstagramLink(String username, String displayText)
    {
        addSocialLinkButton = driver.findElement(addSocialLinkButtonLocator);
        Clicking(addSocialLinkButton);
        addInstagramLink=driver.findElement(addInstagramLocator);
        Clicking(addInstagramLink);
        addUsernameLocator = By.id("input1");
        addDisplayTextLocator = By.id("input2");
        sendText(driver.findElement(addUsernameLocator), username);
        sendText(driver.findElement(addDisplayTextLocator), displayText);
        Clicking(driver.findElement(saveSocialLinkButtonLocator));
        Clicking(driver.findElement(closeSocialLinkButtonLocator));
    }

    public void addTwitterLink(String username, String displayText)
    {
        addSocialLinkButton = driver.findElement(addSocialLinkButtonLocator);
        Clicking(addSocialLinkButton);
        addTwitterLink = driver.findElement(addTwitterLocator);
        Clicking(addTwitterLink);
        addUsernameLocator = By.id("input1");
        addDisplayTextLocator = By.id("input2");
        sendText(driver.findElement(addUsernameLocator), username);
        sendText(driver.findElement(addDisplayTextLocator), displayText);
        Clicking(driver.findElement(saveSocialLinkButtonLocator));
        Clicking(driver.findElement(closeSocialLinkButtonLocator));
    }

    public void addRedditLink(String username, String displayText)
    {
        addSocialLinkButton = driver.findElement(addSocialLinkButtonLocator);
        Clicking(addSocialLinkButton);
        addRedditLink = driver.findElement(addRedditLocator);
        Clicking(addRedditLink);
        addUsernameLocator = By.id("input1");
        addDisplayTextLocator = By.id("input2");
        sendText(driver.findElement(addUsernameLocator), username);
        sendText(driver.findElement(addDisplayTextLocator), displayText);
        Clicking(driver.findElement(saveSocialLinkButtonLocator));
        Clicking(driver.findElement(closeSocialLinkButtonLocator));
    }

    public void addTikTokLink(String username, String displayText)
    {
        addSocialLinkButton = driver.findElement(addSocialLinkButtonLocator);
        Clicking(addSocialLinkButton);
        addTikTokLink = driver.findElement(addTikTokLocator);
        Clicking(addTikTokLink);
        addUsernameLocator = By.id("input1");
        addDisplayTextLocator = By.id("input2");
        sendText(driver.findElement(addUsernameLocator), username);
        sendText(driver.findElement(addDisplayTextLocator), displayText);
        Clicking(driver.findElement(saveSocialLinkButtonLocator));
        Clicking(driver.findElement(closeSocialLinkButtonLocator));
    }

    public void addCustomURL(String username, String displayText)
    {
        addSocialLinkButton = driver.findElement(addSocialLinkButtonLocator);
        Clicking(addSocialLinkButton);
        addCustomURLButton = driver.findElement(addCustomURLButtonLocator);
        Clicking(addCustomURLButton);
        addUsernameLocator = By.id("input1");
        addDisplayTextLocator = By.id("input2");
        sendText(driver.findElement(addUsernameLocator), username);
        sendText(driver.findElement(addDisplayTextLocator), displayText);
        Clicking(driver.findElement(saveSocialLinkButtonLocator));
        Clicking(driver.findElement(closeSocialLinkButtonLocator));
    }


}
