import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountSettingsScreen extends ScreenBase {
    String avatarLocator = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[3]";
    String settingsAccessibilityId = "Settings";
    String settingsLocator = "//android.view.View[@content-desc=\"Settings\"]";
    String accountSettingsID = "settings_screen_account_settings_tile";
    String accountSettingsLocator = "//android.view.View[@content-desc=\"ACCOUNT SETTINGS\"]";

    String basicSettingsLocator = "//android.view.View[@content-desc=\"Basic Settings\"]";

    String newEmailLocator = "update_email_address_email_text_field";
    String passwordLocator = "update_email_address_password_text_field";
    String changePasswordLocator = "Change Password";
    String forgotPasswordLocator = "Forget Password";
    String saveLocator = "SAVE";
    String updateEmailButtonLocator = "account_settings_update_email_address_tile";
    String resetPasswordButtonLocator = "//android.widget.Button[@content-desc=\"Reset Password\"]";
    String currentPasswordLocator = "current_password_text_field";
    String newPasswordLocator = "new_password_text_field";
    String confirmPasswordLocator = "confirm_password_text_field";
    String invalidPasswordLocator = "//android.view.View[@content-desc=\"Invalid password\"]";
    String samePasswordLocator = "//android.view.View[@content-desc=\"New password cannot be the same as old password\"]";
    String passwordChangedLocator = "//android.view.View[@content-desc=\"Woohoo! Your password is updated.\"]";
    String manageNotificationsLocator = "Manage Notifications";
    String privateMessagesButton = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[3]";
    String chatMessagesButton = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[5]";
    String chatRequestsButton = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[7]";
String notificationsSettingsLocator="//android.view.View[@content-desc=\"Notification Settings\"]";
String mentionsButton="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[10]";
String commentsButton="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[12]";
String upvotesOnPosts="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[14]";
String upvotesOnComments="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[16]";
String repliesToComments="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[18]";
String newFollowers="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[20]";
String blockedAccounts="Manage Blocked Accounts";
String blockedAccountsLocator="//android.view.View[@content-desc=\"Blocked Accounts\"]";
String accountSearchTextbox="//android.widget.EditText";
String blockButton="//android.widget.Button[@content-desc=\"Block\"]";
String unblockButton="//android.widget.Button[@content-desc=\"Unblock\"]";

String changeGenderLocator="account_settings_change_gender_tile";
String saveGenderButton="//android.view.View[@content-desc=\"Done\"]";

    WebDriverWait wait = new WebDriverWait(driver, 10);

    public AccountSettingsScreen(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public void openSettings() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(avatarLocator)));
        Clicking(driver.findElementByXPath(avatarLocator));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(settingsLocator)));
        Clicking(driver.findElementByAccessibilityId(settingsAccessibilityId));

    }

    public void openAccountSettings() {
        openSettings();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(accountSettingsLocator)));
        Clicking(driver.findElementById(accountSettingsID));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(basicSettingsLocator)));
    }

    public void updateEmail(String newEmail, String password) {
        Clicking(driver.findElement(By.id(updateEmailButtonLocator)));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(newEmailLocator)));
        Clicking(driver.findElement(By.id(newEmailLocator)));
        sendText(driver.findElement(By.id(newEmailLocator)), newEmail);
        Clicking(driver.findElement(By.id(passwordLocator)));
        sendText(driver.findElement(By.id(passwordLocator)), password);
        Clicking(driver.findElementByAccessibilityId(saveLocator));

    }

    public void changePassword(String password, String newPassword, String confirmPassword) {
        Clicking(driver.findElementByAccessibilityId(changePasswordLocator));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(currentPasswordLocator)));
        Clicking(driver.findElementById(currentPasswordLocator));
        sendText(driver.findElementById(currentPasswordLocator), password);
        Clicking(driver.findElementById(newPasswordLocator));
        sendText(driver.findElementById(newPasswordLocator), newPassword);
        Clicking(driver.findElementById(confirmPasswordLocator));
        sendText(driver.findElementById(confirmPasswordLocator), confirmPassword);
        Clicking(driver.findElementByAccessibilityId(saveLocator));

    }

    public void manageNotifications() {
        Clicking(driver.findElementByAccessibilityId(manageNotificationsLocator));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(notificationsSettingsLocator)));
    }

    public void managePrivateMessages() {
        Clicking(driver.findElementByXPath(privateMessagesButton));
    }

    public void manageChatMessages() {
        Clicking(driver.findElementByXPath(chatMessagesButton));
    }

    public void manageChatRequests() {
        Clicking(driver.findElementByXPath(chatRequestsButton));
    }

    public void manageMentions() {
        Clicking(driver.findElementByXPath(mentionsButton));
    }

    public void manageComments() {
        Clicking(driver.findElementByXPath(commentsButton));
    }

    public void manageUpvotesOnPosts() {
        Clicking(driver.findElementByXPath(upvotesOnPosts));
    }

    public void manageUpvotesOnComments() {
        Clicking(driver.findElementByXPath(upvotesOnComments));
    }

    public void manageRepliesToComments() {
        Clicking(driver.findElementByXPath(repliesToComments));
    }

    public void manageNewFollowers() {
        Clicking(driver.findElementByXPath(newFollowers));
    }

    public void blockAccount(String username) {
        Clicking(driver.findElementByAccessibilityId(blockedAccounts));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(blockedAccountsLocator)));
        Clicking(driver.findElementByXPath(accountSearchTextbox));
        sendText(driver.findElementByXPath(accountSearchTextbox), username);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(blockButton)));
        Clicking(driver.findElementByXPath(blockButton));

    }

    public void unblockAccount(String username) {
        Clicking(driver.findElementByAccessibilityId(blockedAccounts));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(blockedAccountsLocator)));
        Clicking(driver.findElementByXPath(accountSearchTextbox));
        sendText(driver.findElementByXPath(accountSearchTextbox), username);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(unblockButton)));
        Clicking(driver.findElementByXPath(unblockButton));

    }

    public void changeGender(String gender) {
        Clicking(driver.findElementByAccessibilityId(changeGenderLocator));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(saveGenderButton)));
        Clicking(driver.findElementByAccessibilityId(gender));
        Clicking(driver.findElementByXPath(saveGenderButton));
    }



    public void forgotPassword() {
        Clicking(driver.findElementByAccessibilityId(changePasswordLocator));
        Clicking(driver.findElementByAccessibilityId(forgotPasswordLocator));
        Clicking(driver.findElementByXPath(resetPasswordButtonLocator));
    }

}
