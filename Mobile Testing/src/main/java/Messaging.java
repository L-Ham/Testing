import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

public class Messaging extends ScreenBase {

    public Messaging(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    String activityTabLocator="//android.view.View[@content-desc=\"Activity\n" +
            "Tab 1 of 2\"]";
    String inboxTabLocator = "//android.view.View[@content-desc=\"Inbox\n" +
            "Tab 5 of 5\"]";
    String messagesTabLocator="//android.view.View[@content-desc=\"Messages\n" +
            "Tab 2 of 2\"]";

    String moreOptionsLocator="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[3]";
    WebDriverWait wait = new WebDriverWait(driver, 10);
    String newMessageLocator="New message";

    String receiverNotFoundLocator = "//android.view.View[@content-desc=\"Receiver not found\"]";
    String userProfileXPath="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[4]";


    MobileElement messageThread;
    MobileElement replyTextbox;

    MobileElement moreOptionsButton;
    MobileElement newMessageButton;
    MobileElement userProfile;


    public void navigateToInboxTab(){
        Clicking(driver.findElementByXPath(inboxTabLocator));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(activityTabLocator)));
        Clicking(driver.findElementByXPath(messagesTabLocator));


    }

    public boolean sendMessageExistingThread(String username, String message) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[contains(@content-desc, '" + username + "')]")));
        messageThread = driver.findElement(By.xpath("//android.view.View[contains(@content-desc, '" + username + "')]"));
        Clicking(messageThread);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc='Reply to the Message']")));
        replyTextbox = driver.findElementByAccessibilityId("Reply to the Message");
        Clicking(replyTextbox);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText")));
        Clicking(driver.findElementByXPath("//android.widget.EditText"));
        sendText(driver.findElementByXPath("//android.widget.EditText"), message);
        Clicking(driver.findElementByAccessibilityId("SEND"));
        Thread.sleep(2000);
        clickBack();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[contains(@content-desc, '" + message + "')]")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[contains(@content-desc, '" + username + "')]")));

        if(driver.findElementByXPath("//android.view.View[contains(@content-desc, '" + message + "')]").isDisplayed() && driver.findElementByXPath("//android.view.View[contains(@content-desc, '" + username + "')]").isDisplayed())
        {
            return true;
        }
        return false;
    }



    public boolean sendNewMessage(String username,String subject, String message) throws InterruptedException {
        moreOptionsButton = driver.findElementByXPath(moreOptionsLocator);
        Clicking(moreOptionsButton);
        newMessageButton = driver.findElementByAccessibilityId(newMessageLocator);
        Clicking(newMessageButton);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ScrollView/android.widget.EditText[1]")));
        Clicking(driver.findElementByXPath("//android.widget.ScrollView/android.widget.EditText[1]"));
        sendText(driver.findElementByXPath("//android.widget.ScrollView/android.widget.EditText[1]"), username);
        Clicking(driver.findElementByXPath("//android.widget.ScrollView/android.widget.EditText[2]"));
        sendText(driver.findElementByXPath("//android.widget.ScrollView/android.widget.EditText[2]"), subject);
        Clicking(driver.findElementByXPath("//android.widget.ScrollView/android.widget.EditText[3]"));
        sendText(driver.findElementByXPath("//android.widget.ScrollView/android.widget.EditText[3]"), message);
        Clicking(driver.findElementByAccessibilityId("SEND"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[contains(@content-desc, '" + message + "')]")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[contains(@content-desc, '" + username + "')]")));

        if(driver.findElementByXPath("//android.view.View[contains(@content-desc, '" + message + "')]").isDisplayed() && driver.findElementByXPath("//android.view.View[contains(@content-desc, '" + username + "')]").isDisplayed())
        {
            return true;
        }
        return false;
    }

    public boolean sendMessageNonExistentUser(String username,String subject, String message) throws InterruptedException {
        moreOptionsButton = driver.findElementByXPath(moreOptionsLocator);
        Clicking(moreOptionsButton);
        newMessageButton = driver.findElementByAccessibilityId(newMessageLocator);
        Clicking(newMessageButton);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ScrollView/android.widget.EditText[1]")));
        Clicking(driver.findElementByXPath("//android.widget.ScrollView/android.widget.EditText[1]"));
        sendText(driver.findElementByXPath("//android.widget.ScrollView/android.widget.EditText[1]"), username);
        Clicking(driver.findElementByXPath("//android.widget.ScrollView/android.widget.EditText[2]"));
        sendText(driver.findElementByXPath("//android.widget.ScrollView/android.widget.EditText[2]"), subject);
        Clicking(driver.findElementByXPath("//android.widget.ScrollView/android.widget.EditText[3]"));
        sendText(driver.findElementByXPath("//android.widget.ScrollView/android.widget.EditText[3]"), message);
        Clicking(driver.findElementByAccessibilityId("SEND"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(receiverNotFoundLocator)));


if(driver.findElementByXPath(receiverNotFoundLocator).isDisplayed())        {
            return true;
        }
        return false;
    }

    public boolean checkMessageArrival(String username, String message) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[contains(@content-desc, '" + username + "')]")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[contains(@content-desc, '" + message + "')]")));
        if (driver.findElementByXPath("//android.view.View[contains(@content-desc, '" + message + "')]").isDisplayed() && driver.findElementByXPath("//android.view.View[contains(@content-desc, '" + username + "')]").isDisplayed()) {
            return true;
        }
        return false;
    }


    public void clickBack()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@content-desc=\"Back\"]")));
        Clicking(driver.findElementByXPath("//android.widget.Button[@content-desc=\"Back\"]"));
    }

    public void clickExit()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button")));
        Clicking(driver.findElementByXPath("//android.widget.Button"));
    }

    public void logout(String username) throws InterruptedException {
        explicitWait(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[4]"));
        userProfile = driver.findElementByXPath(userProfileXPath);
        Clicking(userProfile);

        String getToLogout = "//android.view.View[contains(@content-desc, '" + username + "')]";

        explicitWait(By.xpath(getToLogout));
        Clicking(driver.findElement(By.xpath(getToLogout)));
        explicitWait(By.xpath("//android.view.View[contains(@content-desc, '" + username + "')]/android.widget.Button"));

        Clicking(driver.findElementByXPath("//android.view.View[contains(@content-desc, '" + username + "')]/android.widget.Button"));
        explicitWait(By.id("second_exit_app_button_identifier"));
        Clicking(driver.findElementById("second_exit_app_button_identifier"));
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
