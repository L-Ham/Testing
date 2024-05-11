import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SubredditModerationPage extends PageBase{

    public SubredditModerationPage(WebDriver driver)
    {
        super(driver);
    }
    By realPPLSubreddit = By.xpath("//*[@id=\"header-container\"]/div/div/div[1]/div/nav/div[5]/a[1]");

    By editSubredditDescription = By.xpath("//*[@id=\"right-sidebar-container-12322134\"]/aside/div/div[1]/button");
    By membersNickNameRead =  By.cssSelector("[data-testid='community-members-p-1']");
    By membersNicknameTextBox = By.id("membersNickname");
    By viewingNickNameRead= By.cssSelector("[data-testid='community-members-p-2']");
    By viewingNicknameTextBox = By.id("viewingNickname");
    By CommunityDescriptionRead = By.cssSelector("[data-testid='community-description-inner-div']");
    By CommunityDescriptionTextBox = By.id("communityDescription");
    By submitButton = By.cssSelector("[data-testid='submit-button']");
    By createPostButton = By.cssSelector("[data-testid='create-post-button']");

    By rulesEditButton = By.xpath("//*[@id=\"right-sidebar-container-12322134\"]/aside/div/div[2]/button");

    By addRuleButton= By.xpath("//*[@id=\"main-container\"]/div/div/div[1]/div[2]/button[2]");
    By ruleTextBox = By.xpath("//*[@id=\"main-container\"]/div/div/div[1]/div[4]/section/div/label[1]/textarea");
    By radioButtonTypeGroup=By.cssSelector("div[aria-label='RULE_KIND_PICKER'] input[type='radio']");
    By ruleDescriptionTextBox = By.xpath("//*[@id=\"main-container\"]/div/div/div[1]/div[4]/section/div/div/textarea");

    By submitRuleButton = By.xpath("//*[@id=\"main-container\"]/div/div/div[1]/div[4]/section/footer/button[1]");

    By deleteRuleSubmit = By.xpath("//*[@id=\"main-container\"]/div/div/div[1]/div[4]/section/footer/button[3]");
    By notificationAddRule = By.cssSelector("[data-testid='notifications-container-#98**sjkss$$']");

    By singleRuleEditButton = By.xpath("//*[@id=\"main-container\"]/div/div/div[2]/div[1]/span[3]/button[1]");

    By reorderButton=By.xpath("//*[@id=\"main-container\"]/div/div/div[1]/div[2]/button[1]");

    By sourceRule = By.xpath("//*[@id=\"main-container\"]/div/div/div[2]/div[1]/span[2]");
    By targetRule=By.xpath("//*[@id=\"main-container\"]/div/div/div[2]/div[2]/span[2]");
    By reorderSaveButton = By.xpath("//*[@id=\"main-container\"]/div/div/div[1]/div[2]/button[2]");

    By removalReasonsTab=By.xpath("//*[@id=\"main-container\"]/div/div/div[1]/div[1]/div[2]/a[2]");
    By addRemovalReasonButton=By.xpath("//*[@id=\"main-container\"]/div/div/div[1]/div[2]/button");
    By removalReasonTitleTextBox=By.xpath("//*[@id=\"main-container\"]/div/div/div[1]/div[3]/section/div/label/input");
    By reasonMessageTextBox=By.xpath("//*[@id=\"main-container\"]/div/div/div[1]/div[3]/section/div/textarea");

    By addNewReasonSubmit= By.xpath("//*[@id=\"main-container\"]/div/div/div[1]/div[3]/section/footer/button[1]");
    By editWidgetButton = By.xpath("//button[contains(@class, 'commset-button-small') and contains(@class, 'commset-button-primary') and contains(@class, 'commset-button') and contains(@class, 'mt-5') and contains(@class, 'inline-flex') and contains(@class, 'w-full') and contains(@class, 'items-center') and contains(@class, 'justify-center')]");
    By addBookMarkButton=By.xpath("//*[@id=\"right-sidebar-container-12322134\"]/div/div/button[2]");
    By bookmarkTitleTextBox=By.id("widgetName");
    By bookmarkDescriptionTextBox=By.id("description");
    By bookmarkNameTextBox=By.id("bookmarkName");
    By bookmarkURLTextBox=By.id("url");
    By changeCommunitySettingsButton = By.xpath("//button[@aria-label='edit community appearance']");
    By addBannerButton=By.xpath("//*[@id=\"right-sidebar-container\"]/aside/div/div[16]/div[3]/div[2]/ul/li[2]");
    By addBannerImage = By.xpath("//*[@id=\"right-sidebar-container\"]/aside/div/div[16]/div[3]/div[2]/input");

    void goToRealPPl() throws InterruptedException {
        Thread.sleep(3000);
        driver.navigate().to("https://reddit-bylham.me/r/RealPPL");
    }
    void checkEditSubredditDescription(String newDescription, String newMembersNickName, String newViewingNickName) throws InterruptedException {
        explicitWait(15,editSubredditDescription);
        WebElement editSubredditDescriptionElement = driver.findElement(editSubredditDescription);
        explicitWait(15, editSubredditDescription);
        Clicking(editSubredditDescriptionElement);
        explicitWait(15, CommunityDescriptionTextBox);
        WebElement CommunityDescriptionTextBoxElement = driver.findElement(CommunityDescriptionTextBox);
        CommunityDescriptionTextBoxElement.clear();
        CommunityDescriptionTextBoxElement.sendKeys(newDescription);
        Thread.sleep(1500);
        WebElement membersNicknameTextBoxElement = driver.findElement(membersNicknameTextBox);
        membersNicknameTextBoxElement.clear();
        membersNicknameTextBoxElement.sendKeys(newMembersNickName);
        Thread.sleep(1500);
        WebElement viewingNicknameTextBoxElement = driver.findElement(viewingNicknameTextBox);
        viewingNicknameTextBoxElement.clear();
        viewingNicknameTextBoxElement.sendKeys(newViewingNickName);
        Thread.sleep(1500);
        WebElement submitButtonElement = driver.findElement(submitButton);
        Clicking(submitButtonElement);
        driver.navigate().refresh();
    }

    public String[] checkAfterEditingSubredditDescription()
    {
        explicitWait(15,createPostButton);
        WebElement createPostElement = driver.findElement(createPostButton);
        Clicking(createPostElement);
        explicitWait(15, CommunityDescriptionRead);
        WebElement CommunityDescriptionReadElement = driver.findElement(CommunityDescriptionRead);
        String newDescription = CommunityDescriptionReadElement.getText();
        WebElement membersNickNameReadElement = driver.findElement(membersNickNameRead);
        String newMembersNickName = membersNickNameReadElement.getText();
        WebElement viewingNickNameReadElement = driver.findElement(viewingNickNameRead);
        String newViewingNickName = viewingNickNameReadElement.getText();
        return new String[]{newDescription, newMembersNickName, newViewingNickName};
    }

    String addRules(String newRule, String appliesTo, String ruleDescription) throws InterruptedException {
        explicitWait(15,rulesEditButton);
        String mainWindowHandle = driver.getWindowHandle();
        WebElement rulesEditButtonElement = driver.findElement(rulesEditButton);
        Clicking(rulesEditButtonElement);
        Thread.sleep(1500);
        for(String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        explicitWait(15,addRuleButton);
        WebElement addRuleButtonElement = driver.findElement(addRuleButton);
        Clicking(addRuleButtonElement);
        explicitWait(15,ruleTextBox);
        WebElement ruleTextBoxElement = driver.findElement(ruleTextBox);
        ruleTextBoxElement.sendKeys(newRule);
        List<WebElement> radioButtons = driver.findElements(radioButtonTypeGroup);
        for (WebElement radioButton : radioButtons) {
            if (radioButton.getAttribute("value").equals(appliesTo)) {
                radioButton.click();
                break;
            }
        }
        Thread.sleep(1000);
        WebElement ruleDescriptionTextBoxElement = driver.findElement(ruleDescriptionTextBox);
        ruleDescriptionTextBoxElement.sendKeys(ruleDescription);
        Thread.sleep(1000);
        WebElement submitRuleButtonElement = driver.findElement(submitRuleButton);
        Clicking(submitRuleButtonElement);
        explicitWait(15,notificationAddRule);
        WebElement notificationAddRuleElement = driver.findElement(notificationAddRule);
        return notificationAddRuleElement.getText();
    }

    String editRules() throws InterruptedException {
        explicitWait(15,singleRuleEditButton);
        WebElement singleRuleEditButtonElement = driver.findElement(singleRuleEditButton);
        Clicking(singleRuleEditButtonElement);
        Thread.sleep(1500);
        explicitWait(15,ruleTextBox);
        WebElement ruleTextBoxElement = driver.findElement(ruleTextBox);
        ruleTextBoxElement.clear();
        ruleTextBoxElement.sendKeys("edited rule1");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(notificationAddRule));
        WebElement submitRuleButtonElement = driver.findElement(submitRuleButton);
        Clicking(submitRuleButtonElement);
        explicitWait(15,notificationAddRule);
        WebElement notificationAddRuleElement = driver.findElement(notificationAddRule);
        return notificationAddRuleElement.getText();
    }

    String deleteRules() throws InterruptedException {
        explicitWait(15,singleRuleEditButton);
        WebElement singleRuleEditButtonElement = driver.findElement(singleRuleEditButton);
        Clicking(singleRuleEditButtonElement);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(notificationAddRule));
        WebElement deleteRuleElement = driver.findElement(deleteRuleSubmit);
        Clicking(deleteRuleElement);
        explicitWait(15,notificationAddRule);
        WebElement notificationAddRuleElement = driver.findElement(notificationAddRule);
        return notificationAddRuleElement.getText();
    }

    String reorderRules() throws InterruptedException
    {
        explicitWait(15,reorderButton );
        WebElement reorderButtonElement = driver.findElement(reorderButton);
        Clicking(reorderButtonElement);
        explicitWait(15,sourceRule);
        WebElement sourceRuleElement = driver.findElement(sourceRule);
        String sourceRuleText = sourceRuleElement.getText();
        WebElement targetRuleElement = driver.findElement(targetRule);
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.clickAndHold(sourceRuleElement).moveToElement(targetRuleElement).release().build().perform();
        explicitWait(15,reorderSaveButton);
        WebElement reorderSaveButtonElement = driver.findElement(reorderSaveButton);
        Clicking(reorderSaveButtonElement);
        explicitWait(15,sourceRule);
        Thread.sleep(2000);
        if(sourceRuleText.equals(targetRuleElement.getText()))
        {
            return "True";
        }
        else
        {
            return "False";
        }
    }

    String addRemovalReason(String removalReasonTitle, String removalReasonText)
    {
        explicitWait(15,removalReasonsTab);
        WebElement removalReasonsTabElement = driver.findElement(removalReasonsTab);
        Clicking(removalReasonsTabElement);
        explicitWait(15,addRemovalReasonButton);
        WebElement addRemovalReasonButtonElement = driver.findElement(addRemovalReasonButton);
        Clicking(addRemovalReasonButtonElement);
        explicitWait(15,removalReasonTitleTextBox);
        WebElement removalReasonTitleElement = driver.findElement(removalReasonTitleTextBox);
        removalReasonTitleElement.sendKeys(removalReasonTitle);
        WebElement removalReasonTextBoxElement = driver.findElement(reasonMessageTextBox);
        removalReasonTextBoxElement.sendKeys(removalReasonText);
        WebElement addNewReasonSubmitElement = driver.findElement(addNewReasonSubmit);
        Clicking(addNewReasonSubmitElement);
        explicitWait(15,notificationAddRule);
        WebElement notificationAddRuleElement = driver.findElement(notificationAddRule);
        return notificationAddRuleElement.getText();
    }

    String addBookmarkWidget()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(notificationAddRule));
        explicitWait(15,editWidgetButton);
        WebElement editWidgetButtonElement = driver.findElement(editWidgetButton);
        Clicking(editWidgetButtonElement);
        explicitWait(15,addBookMarkButton);
        WebElement addBookMarkButtonElement = driver.findElement(addBookMarkButton);
        Clicking(addBookMarkButtonElement);
        explicitWait(15,bookmarkTitleTextBox);
        WebElement bookmarkTitleTextBoxElement = driver.findElement(bookmarkTitleTextBox);
        bookmarkTitleTextBoxElement.sendKeys("Bookmark Title");
        WebElement bookmarkDescriptionTextBoxElement = driver.findElement(bookmarkDescriptionTextBox);
        bookmarkDescriptionTextBoxElement.sendKeys("Bookmark Description");
        WebElement bookmarkNameTextBoxElement = driver.findElement(bookmarkNameTextBox);
        bookmarkNameTextBoxElement.sendKeys("Bookmark Name");
        WebElement bookmarkURLTextBoxElement = driver.findElement(bookmarkURLTextBox);
        bookmarkURLTextBoxElement.sendKeys("https://www.google.com");
        bookmarkNameTextBoxElement.sendKeys(Keys.ENTER);
        explicitWait(15,notificationAddRule);
        return driver.findElement(notificationAddRule).getText();
    }

    String invalidAddBookmarkWidget()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(notificationAddRule));
        explicitWait(15,editWidgetButton);
        WebElement editWidgetButtonElement = driver.findElement(editWidgetButton);
        Clicking(editWidgetButtonElement);
        explicitWait(15,addBookMarkButton);
        WebElement addBookMarkButtonElement = driver.findElement(addBookMarkButton);
        Clicking(addBookMarkButtonElement);
        explicitWait(15,bookmarkTitleTextBox);
        WebElement bookmarkTitleTextBoxElement = driver.findElement(bookmarkTitleTextBox);
        bookmarkTitleTextBoxElement.sendKeys("Bookmark Title");
        WebElement bookmarkDescriptionTextBoxElement = driver.findElement(bookmarkDescriptionTextBox);
        bookmarkDescriptionTextBoxElement.sendKeys("Bookmark Description");
        WebElement bookmarkNameTextBoxElement = driver.findElement(bookmarkNameTextBox);
        bookmarkNameTextBoxElement.sendKeys("Bookmark Name");
        WebElement bookmarkURLTextBoxElement = driver.findElement(bookmarkURLTextBox);
        bookmarkURLTextBoxElement.sendKeys("Invalid");
        bookmarkNameTextBoxElement.sendKeys(Keys.ENTER);
        explicitWait(15,notificationAddRule);
        return driver.findElement(notificationAddRule).getText();
    }

    String addBannerImage()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(notificationAddRule));
        explicitWait(15,changeCommunitySettingsButton);
        WebElement changeCommunitySettingsButtonElement = driver.findElement(changeCommunitySettingsButton);
        Clicking(changeCommunitySettingsButtonElement);
        explicitWait(15,addBannerButton);
        WebElement addBannerButtonElement = driver.findElement(addBannerButton);
        Clicking(addBannerButtonElement);
        explicitWait(15,addBannerImage);
        WebElement addBannerImageElement = driver.findElement(addBannerImage);
        Clicking(addBannerImageElement);

        explicitWait(15,notificationAddRule);
        return driver.findElement(notificationAddRule).getText();
    }

    public String descriptionValidation() throws InterruptedException
    {
        String pageData = driver.getPageSource();
        if(pageData.contains("Members"))
        {
            return "Community Description is present";
        }
        else
        {
            return "Community Description is not present";
        }
    }

}
