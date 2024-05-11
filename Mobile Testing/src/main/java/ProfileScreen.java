import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfileScreen extends ScreenBase{

    public ProfileScreen(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    String userProfileXPath= "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[3]";
    WebDriverWait wait = new WebDriverWait(driver, 10);

    public void openUserProfile(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(userProfileXPath)));
        Clicking(driver.findElementByXPath(userProfileXPath));
        Clicking(driver.findElementByAccessibilityId("Profile"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc=\"itssosoyall\"]")));
    }

    public void openEditProfile(){
        Clicking(driver.findElementByAccessibilityId("Edit"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Edit Profile\"]")));

    }

    public void addBanner() throws InterruptedException {
        Clicking(driver.findElementByXPath("//android.widget.ScrollView/android.widget.Button[1]"));
        Thread.sleep(2000);
        Clicking(driver.findElementByXPath("(//android.widget.ImageView[@resource-id=\"com.google.android.providers.media.module:id/icon_thumbnail\"])[1]"));
    }

    public void addProfilePicture() throws InterruptedException {
        Clicking(driver.findElementByXPath("//android.widget.ScrollView/android.widget.Button[2]"));
        Thread.sleep(2000);
        Clicking(driver.findElementByXPath("(//android.widget.ImageView[@resource-id=\"com.google.android.providers.media.module:id/icon_thumbnail\"])[1]"));
    }

    public boolean addDisplayName(String displayName) {
        Clicking(driver.findElementByXPath("///android.widget.ScrollView/android.widget.EditText[1]"));
        sendText(driver.findElementByXPath("//android.widget.ScrollView/android.widget.EditText[1]"), displayName);
        driver.hideKeyboard();
        Clicking(driver.findElementByAccessibilityId("Save"));
        return driver.findElementByXPath("//android.view.View[@content-desc=\"" + displayName + "\"]").isDisplayed();
    }

    public boolean addBio(String bio) {
        Clicking(driver.findElementByXPath("//android.widget.ScrollView/android.widget.EditText[2]"));
        sendText(driver.findElementByXPath("//android.widget.ScrollView/android.widget.EditText[2]"), bio);
        driver.hideKeyboard();
        Clicking(driver.findElementByAccessibilityId("Save"));
        return driver.findElementByXPath("//android.view.View[@content-desc=\"" + bio + "\"]").isDisplayed();
    }
}
