import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ModerationSettingsPage extends PageBase {
    public ModerationSettingsPage(WebDriver driver) {
        super(driver);
    }

    By banUserButton = By.xpath("//*[@id=\"main-container\"]/div/div/div/div/div/div/div/div[3]/button");
    By usernameToBanTextbox = By.xpath("//*[@id=\"main-container\"]/div/div/div/div/div/div/div/div[3]/div/section/div/label[1]/input");
    By reasonForBanTextbox = By.xpath("//*[@id=\"main-container\"]/div/div/div/div/div/div/div/div[3]/div/section/div/label[2]/input");
    By modNoteTextbox = By.xpath("//*[@id=\"main-container\"]/div/div/div/div/div/div/div/div[3]/div/section/div/label[3]/input");
    By submitBanButton = By.xpath("//*[@id=\"main-container\"]/div/div/div/div/div/div/div/div[3]/div/section/footer/div[4]/button[2]");
    By editBanButton = By.xpath("//*[@id=\"1\"]/div/div[3]/button[1]");
    By profileIconButton = By.cssSelector("[data-testid='profile-icon-button']");
    By unbanButton = By.xpath("//*[@id=\"1\"]/div[1]/div/section/footer/div[4]/button[1]");

   By notification = By.cssSelector("[data-testid='notifications-container-#98**sjkss$$']");
   By messageError = By.cssSelector("[data-testid='email-error']");

   By sortTypeButton = By.xpath("//*[@id=\"main-container\"]/div/div[2]/main/div[1]/div/div[1]/div/div[1]/button");
   By newSort=By.xpath("//*[@id=\"main-container\"]/div/div[2]/main/div[1]/div/div[1]/div/div[2]/ul/li[2]");

   By approvedTab = By.xpath("//*[@id=\"main-container\"]/div/div/div/div/div/div/div/div[2]/a[3]");
   By removeUserButton = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div/div/div/div/div[3]/div[3]/div/div[1]/div/div[2]/button[2]");
   By joinButton = By.cssSelector("[data-testid='join-button']");
   By cancelButton=By.xpath("//*[@id=\"main-container\"]/div/div/div/div/div/div/div/div[3]/div/section/footer/div[4]/button[1]");
   By moderatorsTab= By.xpath("//*[@id=\"main-container\"]/div/div/div/div/div/div/div/div[2]/a[4]");
   By inviteUserAsModeratorButton=By.xpath("//*[@id=\"main-container\"]/div/div/div/div/div/div/div/div[3]/div[1]/button[3]");
   By usernameToInvite = By.xpath("//*[@id=\"main-container\"]/div/div/div/div/div/div/div/div[3]/div[1]/div/section/div[1]/input");
   By inviteSubmissionButton = By.xpath("//*[@id=\"main-container\"]/div/div/div/div/div/div/div/div[3]/div[1]/div/section/footer/button[2]");
   By acceptInviteButton = By.xpath("//*[@id=\"root\"]/div[2]/div/section/footer/button[2]");
   By bannedDate = By.xpath("//*[@id=\"1\"]/div/div[1]/a/span[2]/span[2]");
    public void goToUserManagmentPage() {
        explicitWait(15, profileIconButton);
        driver.get("https://reddit-bylham.me/r/CommunityHadidy/about/usermanagement#");
    }

    public String getBanDate(String username)
    {
        explicitWait(20, bannedDate);
        WebElement bannedDateElement = driver.findElement(bannedDate);
        return bannedDateElement.getText();
    }

    public String banANonUser()
    {
        explicitWait(15, banUserButton);
        WebElement banUserButtonElement = driver.findElement(banUserButton);
        Clicking(banUserButtonElement);
        explicitWait(15, usernameToBanTextbox);
        WebElement usernameToBanTextboxElement = driver.findElement(usernameToBanTextbox);
        usernameToBanTextboxElement.sendKeys("not_a_user");
        WebElement reasonForBanTextboxElement = driver.findElement(reasonForBanTextbox);
        reasonForBanTextboxElement.sendKeys("spam");
        WebElement modNoteTextboxElement = driver.findElement(modNoteTextbox);
        modNoteTextboxElement.sendKeys("Dont unban him");
        WebElement submitBanButtonElement = driver.findElement(submitBanButton);
        Clicking(submitBanButtonElement);
        explicitWait(15, messageError);
        WebElement messageErrorElement = driver.findElement(messageError);
        String status= messageErrorElement.getText();
        explicitWait(15, cancelButton);
        WebElement cancelButtonElement = driver.findElement(cancelButton);
        Clicking(cancelButtonElement);
        return status;
    }
    public String banUser(String username)
    {
        explicitWait(15, banUserButton);
        WebElement banUserButtonElement = driver.findElement(banUserButton);
        Clicking(banUserButtonElement);
        explicitWait(15, usernameToBanTextbox);
        WebElement usernameToBanTextboxElement = driver.findElement(usernameToBanTextbox);
        usernameToBanTextboxElement.sendKeys(username);
        WebElement reasonForBanTextboxElement = driver.findElement(reasonForBanTextbox);
        reasonForBanTextboxElement.sendKeys("spam");
        WebElement modNoteTextboxElement = driver.findElement(modNoteTextbox);
        modNoteTextboxElement.sendKeys("Dont unban him");
        WebElement submitBanButtonElement = driver.findElement(submitBanButton);
        Clicking(submitBanButtonElement);
        explicitWait(15, editBanButton);
        return "User banned successfully";
    }

    public String banUserNotPosting(String username, String title) throws InterruptedException
    {
        driver.navigate().to("https://reddit-bylham.me/r/CommunityHadidy");
        Thread.sleep(5000);
        explicitWait(15, sortTypeButton);
        WebElement sortTypeButtonElement = driver.findElement(sortTypeButton);
        Clicking(sortTypeButtonElement);
        explicitWait(15, newSort);
        WebElement newSortElement = driver.findElement(newSort);
        Clicking(newSortElement);
        Thread.sleep(2000);
        String pageSource = driver.getPageSource();
        if (!pageSource.contains(title)) {
            return "User cannot Post!";
        } else {
            return "User Can Post!";
        }
    }

    public String unbanUser(String username)
    {
        explicitWait(15, editBanButton);
        WebElement editBanButtonElement = driver.findElement(editBanButton);
        Clicking(editBanButtonElement);
        explicitWait(15, unbanButton);
        WebElement unbanButtonElement = driver.findElement(unbanButton);
        Clicking(unbanButtonElement);
        explicitWait(15,notification);
        WebElement notificationAddRuleElement = driver.findElement(notification);
        return notificationAddRuleElement.getText();
    }

    public String removeAUserFromCommunity()
    {
        explicitWait(15,approvedTab);
        WebElement approvedTabElement = driver.findElement(approvedTab);
        Clicking(approvedTabElement);
        explicitWait(15,removeUserButton);
        WebElement removeUserButtonElement = driver.findElement(removeUserButton);
        Clicking(removeUserButtonElement);
        explicitWait(15,notification);
        WebElement notificationAddRuleElement = driver.findElement(notification);
        return notificationAddRuleElement.getText();
    }

    public String checkJoinedStatus()
    {
        driver.get("https://reddit-bylham.me/r/CommunityHadidy");
        explicitWait(15,joinButton);
        WebElement joinButtonElement = driver.findElement(joinButton);
        return joinButtonElement.getText();
    }

    public String inviteUserToCommunity(String username)
    {
        explicitWait(15,moderatorsTab);
        WebElement moderatorsTabElement = driver.findElement(moderatorsTab);
        Clicking(moderatorsTabElement);
        explicitWait(15,inviteUserAsModeratorButton);
        WebElement inviteUserAsModeratorButtonElement = driver.findElement(inviteUserAsModeratorButton);
        Clicking(inviteUserAsModeratorButtonElement);
        explicitWait(15,usernameToInvite);
        WebElement usernameToInviteElement = driver.findElement(usernameToInvite);
        usernameToInviteElement.sendKeys(username);
        explicitWait(15,inviteSubmissionButton);
        WebElement inviteSubmissionButtonElement = driver.findElement(inviteSubmissionButton);
        Clicking(inviteSubmissionButtonElement);
        explicitWait(15,notification);
        WebElement notificationAddRuleElement = driver.findElement(notification);
        return notificationAddRuleElement.getText();
    }

    public String checkInvitedModeratorIsModerator()
    {
        explicitWait(15,acceptInviteButton);
        WebElement acceptInviteButtonElement = driver.findElement(acceptInviteButton);
        Clicking(acceptInviteButtonElement);
        explicitWait(15,notification);
        WebElement notificationAddRuleElement = driver.findElement(notification);
        return notificationAddRuleElement.getText();
    }



}