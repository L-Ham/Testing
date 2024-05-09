import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;


import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

public class HomeScreen extends ScreenBase {

    public HomeScreen(AndroidDriver<MobileElement> driver) {
        super(driver);
    }


    String homeLocator = "//android.widget.Button[@content-desc=\"Home\"]";
    String popularLocator = "//android.widget.Button[@content-desc=\"Popular\"]";
    String menuLocator = "///android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]";
    String moderatingButton = "//android.view.View[@content-desc=\"Moderating\"]";
    WebDriverWait wait = new WebDriverWait(driver, 10);

    String communitiesTabLocator = "//android.view.View[@content-desc=\"Communities\n" +
            "Tab 2 of 5\"]";
    String communitiesTabConfirm="(//android.view.View[@content-desc=\"Communities\"])[2]";
    String chatTabLocator = "//android.view.View[@content-desc=\"Chat\n" +
            "Tab 4 of 5\"]";
    String chatTabConfirm="(//android.view.View[@content-desc=\"Chat\"])[2]";
    String inboxTabLocator = "//android.view.View[@content-desc=\"Inbox\n" +
            "Tab 5 of 5\"]";
    String activityTabLocator="//android.view.View[@content-desc=\"Activity\n" +
            "Tab 1 of 2\"]";
    String messagesTabLocator="//android.view.View[@content-desc=\"Messages\n" +
            "Tab 2 of 2\"]";

    String homeTabLocator = "//android.view.View[@content-desc=\"Home\n" +
            "Tab 1 of 5\"]";
    public void changePostsToPopular() {
    Clicking(driver.findElementByAccessibilityId("Home"));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Popular\"]")));
    Clicking(driver.findElementByXPath("//android.view.View[@content-desc=\"Popular\"]"));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Trending Today\"]")));
    }

    public void changePostsToHome() {
    Clicking(driver.findElementByAccessibilityId("Popular"));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Home\"]")));
    Clicking(driver.findElementByXPath("//android.view.View[@content-desc=\"Home\"]"));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(homeLocator)));
    }

    public void deleteRecentlyVisitedCommunity(String communityName)
    {

    }

    public void clearAllRecentlyVisitedCommunities()
    {

    }

    public void favCommunityFromMod (String communityName)
    {
        Clicking(driver.findElementByXPath(homeLocator));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(moderatingButton)));
        Clicking(driver.findElementByXPath(moderatingButton));

    }

    public void favCommunityFromMyCommunities (String communityName)
    {

    }

    public void navigateToCommunitiesTab()
    {
        Clicking(driver.findElementByXPath(communitiesTabLocator));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(communitiesTabConfirm)));
    }

    public void navigateToChatTab()
    {
        Clicking(driver.findElementByXPath(chatTabLocator));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(chatTabConfirm)));
    }

    public void navigateToInboxTab()
    {
        Clicking(driver.findElementByXPath(inboxTabLocator));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(activityTabLocator)));
        Clicking(driver.findElementByXPath(messagesTabLocator));
        Clicking(driver.findElementByXPath(activityTabLocator));
    }

    public void navigateToHomeTab()
    {
        Clicking(driver.findElementByXPath(homeTabLocator));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(homeLocator)));
    }





    public void scroll()
    {
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.5);
        int starty = (int) (size.height * 0.8);
        int endy = (int) (size.height * 0.25);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1).addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startx, starty))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(200)))
                .addAction(finger.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), startx, endy))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(sequence));
    }


}
