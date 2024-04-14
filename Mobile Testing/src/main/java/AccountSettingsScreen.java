import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountSettingsScreen extends ScreenBase

{
String avatarLocator="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[3]";
String settingsAccessibilityId="Settings";
String settingsLocator="//android.view.View[@content-desc=\"Settings\"]";
String accountSettingsID="settings_screen_account_settings_tile";
String accountSettingsLocator="//android.view.View[@content-desc=\"ACCOUNT SETTINGS\"]";

String basicSettingsLocator="//android.view.View[@content-desc=\"Basic Settings\"]";

String newEmailLocator="//android.view.View[@content-desc=\"u/david\n" +
        "david@gmail.com\n" +
        "Be sure to verify your new email address\n" +
        "We'll send an email with a link to verity your update to your new email address.\"]/android.widget.EditText[1]";

String passwordLocator="//android.view.View[@content-desc=\"u/david\n" +
        "david@gmail.com\n" +
        "Be sure to verify your new email address\n" +
        "We'll send an email with a link to verity your update to your new email address.\"]/android.widget.EditText[2]";

String forgotPasswordLocator="Forget Password";
String saveEmailLocator="SAVE";
String updateEmailPage="//android.view.View[@content-desc=\"Update email address\"]";
String updateEmailButtonLocator="account_settings_update_email_address_tile";
String resetPasswordButtonLocator="//android.widget.Button[@content-desc=\"Reset Password\"]";

    WebDriverWait wait = new WebDriverWait(driver, 10);
    public AccountSettingsScreen(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public void openSettings()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(avatarLocator)));
        Clicking(driver.findElementByXPath(avatarLocator));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(settingsLocator)));
        Clicking(driver.findElementByAccessibilityId(settingsAccessibilityId));

    }

    public void openAccountSettings()
    {
        openSettings();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(accountSettingsLocator)));
        Clicking(driver.findElementById(accountSettingsID));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(basicSettingsLocator)));
    }

    public void updateEmail(String newEmail, String password)
    {
        Clicking(driver.findElement(By.id(updateEmailButtonLocator)));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(newEmailLocator)));
        driver.findElement(By.xpath(newEmailLocator)).sendKeys(newEmail);
        driver.findElement(By.xpath(passwordLocator)).sendKeys(password);
        //Clicking(driver.findElementByAccessibilityId(saveEmailLocator));
    }

}
