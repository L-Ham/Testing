import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

public class ModerationScreen extends ScreenBase {

    public ModerationScreen(AndroidDriver<MobileElement> driver) throws InterruptedException {
        super(driver);

    }

    String optionsLeft = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]";

    String addUserToBanned = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[3]";

    String messagetoUser = "//android.view.View[@content-desc=\"Rule broken\n" +
            "Required\n" +
            "Ban length\n" +
            "Permanent\n" +
            "Custom\n" +
            "Only seen by mods\"]/android.widget.EditText[1]";

    String addUserTOBeApproved = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[3]";
    String checkMessageTextbox="//android.widget.EditText[@text=\"sehs\"]";
    MobileElement usernameToBan;
    MobileElement RuleBrokenDropDown;
    MobileElement SpamOption;
    MobileElement banButton;
    String editBanOptions= "//android.view.View[@content-desc=\"u/Rana\n" +
            "1s . Spam\"]/android.widget.Button";
    String editApprovedUser="//android.view.View[@content-desc=\"u/sehs\n" +
            "1 wk ago\"]/android.widget.Button";

    String addModeratorButton="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[3]";


    String usernameAddModerator = "//android.widget.EditText";
    String moderatoraAtFirst = "//android.view.View[@content-desc=\"u/sehs\n" +
            "1 wk ago . Full Permissions\"]/android.widget.Button";

    MobileElement userProfile;
    String userProfileXPath= "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[3]";

    MobileElement accounts;
    String accountsXpath="//android.view.View[@content-desc=\"u/hadidy\"]";

    MobileElement logoutFirst;
    String logoutFirstXpath="//android.view.View[@content-desc=\"u/hadidy\"]/android.widget.Button";

    MobileElement logoutSecond;

    String logoutSecondXpath="//android.view.View[@content-desc=\"u/hadidy\n" +
            "Logout\"]";

    public void openLeftSidePan() throws InterruptedException {
        explicitWait(By.xpath(optionsLeft));
        MobileElement optionsLeftElement = driver.findElementByXPath(optionsLeft);
        Clicking(optionsLeftElement);
        Thread.sleep(3000);
    }

    public String openCommunity() throws InterruptedException {
        Thread.sleep(2000);
        MobileElement yourCommunities = driver.findElementByAccessibilityId("Your Communities");
        Clicking(yourCommunities);
        Thread.sleep(3000);
        MobileElement community = driver.findElementByAccessibilityId("r/CommunityHadidy");
        Clicking(community);
        Thread.sleep(4000);
        return "Community is found";
    }

    public String openModTools() throws InterruptedException {
        MobileElement moderation = driver.findElementByAccessibilityId("Mod Tools");
        Clicking(moderation);
        Thread.sleep(1000);
        return "Moderation is found";
    }

    public String openBannedUsersList() throws InterruptedException {
        MobileElement modQueue = driver.findElementByAccessibilityId("Banned users");
        Clicking(modQueue);
        Thread.sleep(2000);
        explicitWait(By.xpath(addUserToBanned));
        MobileElement addUserElement = driver.findElementByXPath(addUserToBanned);
        Clicking(addUserElement);
        return "Banned List Found";
    }

    public String addBanningInfo() throws InterruptedException {
        Thread.sleep(2000);
        usernameToBan = driver.findElementByXPath("//android.view.View[@content-desc=\"Username\n" +
                "Rule broken\n" +
                "Required\n" +
                "Ban length\n" +
                "Permanent\n" +
                "Custom\n" +
                "Only seen by mods\"]/android.widget.EditText[1]");
        Clicking(usernameToBan);
        usernameToBan.sendKeys("Rana");
        RuleBrokenDropDown = driver.findElementByXPath("//android.view.View[@text=\"Select a rule\"]");
        Clicking(RuleBrokenDropDown);
        SpamOption = driver.findElementByAccessibilityId("Spam");
        Clicking(SpamOption);
        Thread.sleep(1500);
        banButton = driver.findElementByAccessibilityId("Ban");
        Clicking(banButton);
        Thread.sleep(1000);
        explicitWait(By.xpath(editBanOptions));
        return "Banned Successfully";
    }

    public String editBannedUser() throws InterruptedException
    {
        MobileElement editBan = driver.findElementByXPath(editBanOptions);
        Clicking(editBan);
        Thread.sleep(3000);
        MobileElement seeDetailsElement = driver.findElementByAccessibilityId("See details");
        Clicking(seeDetailsElement);
        Thread.sleep(2000);
        MobileElement editBanLength = driver.findElementByXPath(messagetoUser);
        Clicking(editBanLength);
        editBanLength.clear();
        editBanLength.sendKeys("Edited Successfully");
        driver.hideKeyboard();
        MobileElement saveButton = driver.findElementByAccessibilityId("Update");
        Clicking(saveButton);
        return "Edited Successfully";
    }

    public String approvedUser() throws InterruptedException
    {
        driver.navigate().back();
        Thread.sleep(2000);
        MobileElement approvedUsers = driver.findElementByAccessibilityId("Approved users");
        Clicking(approvedUsers);
        Thread.sleep(2000);
        MobileElement addUserToApproved = driver.findElementByXPath(addUserTOBeApproved);
        Clicking(addUserToApproved);
        Thread.sleep(2000);
        MobileElement usernameToApprove = driver.findElementByXPath("//android.widget.EditText");
        Clicking(usernameToApprove);
        usernameToApprove.sendKeys("sehs");
        MobileElement approveButton = driver.findElementByAccessibilityId("Add");
        Clicking(approveButton);
        return "Approved Successfully";
    }

    public String getApprovedDate() throws InterruptedException
    {
        Thread.sleep(2000);
        MobileElement approvedUserFirst= driver.findElementByAccessibilityId("u/sehs\n" +
                "1 wk ago");
        String page = driver.getPageSource();
        System.out.println(page);
        if(page.contains("u/sehs\n" +
                "1 wk ago"))
        {
            return "Wrong Date";
        }
        else
        {
            return "Right Date";
        }
    }
    public String testRedirectionToSendAMessageToAnApprovedUser() throws InterruptedException
    {
        Thread.sleep(2000);
        explicitWait(By.xpath(editApprovedUser));
        MobileElement editApprovedUserElement = driver.findElementByXPath(editApprovedUser);
        Clicking(editApprovedUserElement);
        Thread.sleep(2000);
        MobileElement seeDetailsElement = driver.findElementByAccessibilityId("Send message");
        Clicking(seeDetailsElement);
        explicitWait(By.xpath(checkMessageTextbox));
        MobileElement checkMessageTextboxElement = driver.findElementByXPath(checkMessageTextbox);
        if (checkMessageTextboxElement.getText().equals("sehs"))
        {
            return "Message redirected";
        }
        else
        {
            return "No redirection";
        }

    }

    public String inviteModerator() throws InterruptedException {
        Thread.sleep(2000);
        MobileElement moderators = driver.findElementByAccessibilityId("Moderators");
        Clicking(moderators);
        Thread.sleep(2000);
        explicitWait(By.xpath(addModeratorButton));
        MobileElement addModeratorButtonElement = driver.findElementByXPath(addModeratorButton);
        Clicking(addModeratorButtonElement);
        explicitWait(By.xpath(usernameAddModerator));
        MobileElement usernameAddModeratorElement = driver.findElementByXPath(usernameAddModerator);
        Clicking(usernameAddModeratorElement);
        usernameAddModeratorElement.sendKeys("jeniffer");
        MobileElement addModerator = driver.findElementByAccessibilityId("Add");
        Clicking(addModerator);
        explicitWait(By.xpath(addModeratorButton));
        return "Moderator is invited";
    }

    public String removeModerator() throws InterruptedException
    {
        MobileElement editableTab=driver.findElementByAccessibilityId("Editable\n" +
                "Tab 2 of 2");
        Clicking(editableTab);
        explicitWait(By.xpath(moderatoraAtFirst));
        MobileElement removeModerator = driver.findElementByXPath(moderatoraAtFirst);
        Clicking(removeModerator);
        Thread.sleep(2000);
        MobileElement removeButton = driver.findElementByAccessibilityId("Remove");
        Clicking(removeButton);
        return "Moderator is removed";

    }

    public void swipeLeft() throws InterruptedException {
        int startX = 960;
        int endX = 100;
        int y = 1030;
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1).addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, y))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(200)))
                .addAction(finger.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, y))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(sequence));
    }

    public void logout() throws InterruptedException
    {
        explicitWait(By.xpath(userProfileXPath));
        userProfile=driver.findElementByXPath(userProfileXPath);
        Clicking(userProfile);
        explicitWait(By.xpath(accountsXpath));
        accounts=driver.findElementByXPath(accountsXpath);
        Clicking(accounts);
        explicitWait(By.xpath(logoutFirstXpath));
        logoutFirst=driver.findElementByXPath(logoutFirstXpath);
        Clicking(logoutFirst);
        explicitWait(By.xpath(logoutSecondXpath));
        logoutSecond=driver.findElementByXPath(logoutSecondXpath);
        Clicking(logoutSecond);
    }

    public String checkModeratorOfSubreddit() throws InterruptedException {
        MobileElement yourCommunities = driver.findElementByAccessibilityId("Your Communities");
        Clicking(yourCommunities);
        Thread.sleep(3000);
        MobileElement community = driver.findElementByAccessibilityId("r/CommunityHadidy");
        Clicking(community);
        Thread.sleep(3000);
        MobileElement moderators = driver.findElementByAccessibilityId("Joined");
        return "Not a moderator anymore";

    }



}
