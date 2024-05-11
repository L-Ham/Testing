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

public class HomeScreen extends ScreenBase {

    public HomeScreen(AndroidDriver<MobileElement> driver) {
        super(driver);
    }


    String homeLocator = "//android.widget.Button[@content-desc=\"Home\"]";
    String sideBarLocator = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]";
    String moderatingTabLocator = "Moderating";
    String myCommunitiesTabLocator = "//android.view.View[@content-desc=\"Your Communities\"]";
    String createCommunitiesLocator="//android.view.View[@content-desc=\"Create a community\"]";
    String communityNameTextboxLocator="//android.widget.EditText";
    String communityTypeLocator="community_type_selector";
    String privateCommunityLocator="//android.view.View[@content-desc=\"Private\n" +
            "Only approved users can view and submit to this community\"]";
    String publicCommunityLocator="//android.view.View[@content-desc=\"Public\n" +
            "Anyone can view, post and comment to this community\"]";
    String restrictedCommunityLocator="//android.view.View[@content-desc=\"Restricted\n" +
            "Only approved users can view, but anyone can submit to this community\"]";

    String plus18ButtonLocator="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[6]";

    String createCommunityButtonLocator="//android.widget.Button[@content-desc=\"Create community\"]";

    WebDriverWait wait = new WebDriverWait(driver, 10);

    String communitiesTabLocator = "//android.view.View[@content-desc=\"Communities\n" +
            "Tab 2 of 5\"]";
    String communitiesTabConfirm="//android.view.View[@content-desc=\"Communities\"]";
    String chatTabLocator = "//android.view.View[@content-desc=\"Chat\n" +
            "Tab 4 of 5\"]";
    String chatTabConfirm="//android.view.View[@content-desc=\"Chat\"]";
    String inboxTabLocator = "//android.view.View[@content-desc=\"Inbox\n" +
            "Tab 5 of 5\"]";
    String activityTabLocator="//android.view.View[@content-desc=\"Activity\n" +
            "Tab 1 of 2\"]";
    String messagesTabLocator="//android.view.View[@content-desc=\"Messages\n" +
            "Tab 2 of 2\"]";

    String homeTabLocator = "//android.view.View[@content-desc=\"Home\n" +
            "Tab 1 of 5\"]";

    String communityPostTitleLocator = "//android.widget.ScrollView/android.widget.EditText[1]";
    String addTagsLocator = "Add tags (optional)";
    String spoilerTagLocator = "//android.view.View[@content-desc=\"Add tags\n" +
            "Universal tags\n" +
            "Spoiler\n" +
            "Tag posts that may ruin a surprise\n" +
            "Brand affiliate\n" +
            "Made for a brand or business\"]/android.view.View[2]";
    String  brandAffiliateLocator = "//android.view.View[@content-desc=\"Add tags\n" +
            "Universal tags\n" +
            "Spoiler\n" +
            "Tag posts that may ruin a surprise\n" +
            "Brand affiliate\n" +
            "Made for a brand or business\"]/android.view.View[3]";

    String spoilerLocator = "SPOILER";
    String brandAffiliateTagLocator = "BRAND AFFILIATE";
    String postBodyLocator="//android.widget.ScrollView/android.widget.EditText[2]";
    String exitTagsLocator="//android.view.View[@content-desc=\"Add tags\n" +
            "Universal tags\n" +
            "Spoiler\n" +
            "Tag posts that may ruin a surprise\n" +
            "Brand affiliate\n" +
            "Made for a brand or business\"]/android.view.View[1]";

    String rulesLocator = "RULES";
    //String communityRules="Community Rules";
    String exitRulesButtonLocator = "//android.widget.Button";
    String postButtonLocator = "Post";
    String favoriteCommunitiesLocator = "//android.view.View[@content-desc=\"Favorites\"]";
    String backToHomeLocator = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.Button[1]";
    String backToHomeLocator2="//android.widget.Button[@content-desc=\"Back\"]";
    String favMyCommunitiesLocator = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]";

    String createPostHomeLocator="//android.view.View[@content-desc=\"Create\n" +
            "Tab 3 of 5\"]";
    String favCommunityLocator = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[4]/android.view.View[2]";
    public boolean changePostsToPopular() {
    Clicking(driver.findElementByAccessibilityId("Home"));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Popular\"]")));
    Clicking(driver.findElementByXPath("//android.view.View[@content-desc=\"Popular\"]"));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Trending Today\"]")));
    if(driver.findElementByXPath("//android.view.View[@content-desc=\"Trending Today\"]").isDisplayed()) {
        return true;
    }
    return false;
    }

    public boolean changePostsToHome() {
    Clicking(driver.findElementByAccessibilityId("Popular"));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Home\"]")));
    Clicking(driver.findElementByXPath("//android.view.View[@content-desc=\"Home\"]"));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(homeLocator)));
    if(driver.findElementByXPath(homeLocator).isDisplayed()) {
        return true;
    }
    return false;
    }

    public void deleteRecentlyVisitedCommunity(String communityName)
    {

    }

    public void clearAllRecentlyVisitedCommunities()
    {

    }

    public boolean favCommunityFromMod (String communityName) throws InterruptedException {
        openSidebar();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(moderatingTabLocator)));
        Clicking(driver.findElementByXPath(moderatingTabLocator));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(favCommunityLocator)));
        Clicking(driver.findElementByXPath(favCommunityLocator));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(favoriteCommunitiesLocator)));
        Clicking(driver.findElementByXPath(favoriteCommunitiesLocator));
        Thread.sleep(2000);
        if(driver.findElementByXPath("(//android.view.View[@content-desc=\"r/"+communityName+"\"])[1]").isDisplayed())
        {
            return true;
        }
        return false;
    }

    public boolean favCommunityFromMyCommunities (String communityName) throws InterruptedException {
        openSidebar();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(myCommunitiesTabLocator)));
        Clicking(driver.findElementByXPath(myCommunitiesTabLocator));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(favMyCommunitiesLocator)));
        Clicking(driver.findElementByXPath(favMyCommunitiesLocator));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(favoriteCommunitiesLocator)));
        Clicking(driver.findElementByXPath(favoriteCommunitiesLocator));
        Thread.sleep(2000);
        if(driver.findElementByXPath("(//android.view.View[@content-desc=\"r/"+communityName+"\"])[1]").isDisplayed())
        {
            return true;
        }
        return false;
    }

    public boolean unfavCommunity(String communityName) throws InterruptedException {
        openSidebar();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(favoriteCommunitiesLocator)));
        Clicking(driver.findElementByXPath(favoriteCommunitiesLocator));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@content-desc=\"r/"+communityName+"\"])[1]")));
        Clicking(driver.findElementByXPath("(//android.view.View[@content-desc=\"r/"+communityName+"\"])[1]"));
        Thread.sleep(2000);
        if(driver.findElementByXPath("(//android.view.View[@content-desc=\"r/"+communityName+"\"])[1]") == null)
        {
            return true;
        }
        return false;
    }


//    public void checkRules()
//    {
//        Clicking(driver.findElementByAccessibilityId(rulesLocator));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(communityRules)));
//        Clicking(driver.findElementByXPath(exitRulesButtonLocator));
//    }

    public boolean createCommunity(String communityName, String communityType, Boolean plus18)
    {
        openSidebar();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(myCommunitiesTabLocator)));
        Clicking(driver.findElementByXPath(myCommunitiesTabLocator));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(createCommunitiesLocator)));
        Clicking(driver.findElementByXPath(createCommunitiesLocator));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(communityNameTextboxLocator)));
        Clicking(driver.findElementByXPath(communityNameTextboxLocator));
        sendText(driver.findElementByXPath(communityNameTextboxLocator), communityName);

//        Clicking(driver.findElementById(communityTypeLocator));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(privateCommunityLocator)));
//        switch (communityType) {
//            case "Private":
//                Clicking(driver.findElementByXPath(privateCommunityLocator));
//                break;
//            case "Public":
//                Clicking(driver.findElementByXPath(publicCommunityLocator));
//                break;
//            case "Restricted":
//                Clicking(driver.findElementByXPath(restrictedCommunityLocator));
//                break;
//        }

        if(plus18)
        {
            Clicking(driver.findElementByXPath(plus18ButtonLocator));
        }

        Clicking(driver.findElementByXPath(createCommunityButtonLocator));


        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(communityPostTitleLocator)));
        return driver.findElementByXPath(communityPostTitleLocator).isDisplayed();

    }

    public boolean createFirstPostCommunity(String communityName,String postTitle,Boolean spoiler, Boolean brandAffiliate, String postBody) throws InterruptedException {
        Clicking(driver.findElementByXPath(communityPostTitleLocator));
        sendText(driver.findElementByXPath(communityPostTitleLocator), postTitle);
        Clicking(driver.findElementByAccessibilityId(addTagsLocator));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(spoilerTagLocator)));
        if(spoiler || brandAffiliate)
        {
            if (spoiler)
            {
                Clicking(driver.findElementByXPath(spoilerTagLocator));
            }
            if (brandAffiliate)
            {
                Clicking(driver.findElementByXPath(brandAffiliateLocator));
            }
            Clicking(driver.findElementByXPath(exitTagsLocator));
        }
        //check presence of spoiler tag

        //check presence of brand affiliate tag

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(postBodyLocator)));

        Clicking(driver.findElementByXPath(postBodyLocator));
        sendText(driver.findElementByXPath(postBodyLocator), postBody);
        Clicking(driver.findElementByAccessibilityId(postButtonLocator));
        Thread.sleep(2000);
        return driver.findElementByXPath("//android.view.View[@content-desc=\"r/" + communityName + "\"]").isDisplayed();
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

    public void openSidebar()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sideBarLocator)));
        Clicking(driver.findElementByXPath(sideBarLocator));
    }

    public void closeSidebar()
    {
        Dimension size = driver.manage().window().getSize();
        int x=950;
        int y=860;
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1).addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(200)))
                .addAction(finger.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), x, y))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(sequence));

    }

    public boolean createPostToCommunity(String communityName, String Title, String PostContent) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(createPostHomeLocator)));
        Clicking(driver.findElementByXPath(createPostHomeLocator));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ScrollView/android.widget.EditText[1]")));
        Clicking(driver.findElementByXPath("//android.widget.ScrollView/android.widget.EditText[1]"));
        sendText(driver.findElementByXPath("//android.widget.ScrollView/android.widget.EditText[1]"), Title);
        Clicking(driver.findElementByXPath("//android.widget.ScrollView/android.widget.EditText[2]"));
        sendText(driver.findElementByXPath("//android.widget.ScrollView/android.widget.EditText[2]"), PostContent);
        Clicking(driver.findElementByAccessibilityId("Next"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText")));
        Clicking(driver.findElementByXPath("//android.widget.EditText"));
        sendText(driver.findElementByXPath("//android.widget.EditText"), communityName);
        Thread.sleep(1000);
        Clicking(driver.findElement(By.xpath("//*[contains(@xpath, communityName)]")));
        Thread.sleep(1000);
        Clicking(driver.findElementByAccessibilityId("Post"));
        Thread.sleep(2000);
        return driver.findElement(By.xpath("//android.view.View[contains(@content-desc, 'Post created successfully')]")) != null;
    }

    public boolean createPostToBannedCommunity(String communityName, String Title, String PostContent) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(createPostHomeLocator)));
        Clicking(driver.findElementByXPath(createPostHomeLocator));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ScrollView/android.widget.EditText[1]")));
        Clicking(driver.findElementByXPath("//android.widget.ScrollView/android.widget.EditText[1]"));
        sendText(driver.findElementByXPath("//android.widget.ScrollView/android.widget.EditText[1]"), Title);
        Clicking(driver.findElementByXPath("//android.widget.ScrollView/android.widget.EditText[2]"));
        sendText(driver.findElementByXPath("//android.widget.ScrollView/android.widget.EditText[2]"), PostContent);
        Clicking(driver.findElementByAccessibilityId("Next"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText")));
        Clicking(driver.findElementByXPath("//android.widget.EditText"));
        sendText(driver.findElementByXPath("//android.widget.EditText"), communityName);
        Thread.sleep(1000);
        Clicking(driver.findElement(By.xpath("//*[contains(@xpath, communityName)]")));
        Thread.sleep(1000);
        Clicking(driver.findElementByAccessibilityId("Post"));
        Thread.sleep(2000);
        return driver.findElement(By.xpath("//android.view.View[contains(@content-desc, 'You are banned from this community')]")) != null;
    }

    public boolean joinCommunity(String communityName) throws InterruptedException {
        navigateToCommunitiesTab();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Communities\"]")));
        Thread.sleep(2000);
        Clicking(driver.findElement(By.xpath("(//android.widget.ImageView[contains(@content-desc, '" + communityName + "')])[1]")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@content-desc=\"Join\"]")));
        Clicking(driver.findElementByXPath("//android.widget.Button[@content-desc=\"Join\"]"));
        Thread.sleep(2000);
        return driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Joined\"]")) != null;

    }

    public boolean leaveCommunity(String communityName) throws InterruptedException {
        navigateToCommunitiesTab();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Communities\"]")));
        Thread.sleep(2000);
        Clicking(driver.findElement(By.xpath("(//android.widget.ImageView[contains(@content-desc, '" + communityName + "')])[1]")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@content-desc=\"Leave\"]")));
        Clicking(driver.findElementByXPath("//android.widget.Button[@content-desc=\"Leave\"]"));
        Thread.sleep(2000);
        return driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Join\"]")) != null;

    }

    public boolean upVote() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc=\"7005\"]")));
        Clicking(driver.findElementByXPath("//android.view.View[@content-desc=\"7005\"]"));
        Thread.sleep(2000);
        return driver.findElement(By.xpath("//android.view.View[@content-desc=\"7006\"]")) != null;
    }

    public boolean downVote() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc=\"7006\"]")));
        Clicking(driver.findElementByXPath("//android.view.View[@content-desc=\"7006\"]"));
        Thread.sleep(2000);
        return driver.findElement(By.xpath("//android.view.View[@content-desc=\"7004\"]")) != null;
    }

    public boolean commentOnPost(String comment) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc=\"zoz test\"]")));
        Clicking(driver.findElementByXPath("//android.view.View[@content-desc=\"zoz test\"]"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Add a comment\"]")));
        Clicking(driver.findElementByXPath("//android.view.View[@content-desc=\"Add a comment\"]"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText")));
        Clicking(driver.findElementByXPath("//android.widget.EditText"));
        sendText(driver.findElementByXPath("//android.widget.EditText"), comment);
        Clicking(driver.findElementByAccessibilityId("Post"));
        Thread.sleep(2000);
        for(int i=0;i<6;i++)
        {
            scrolldown();
            Thread.sleep(1000);
        }
        return driver.findElement(By.xpath("//android.view.View[contains(@content-desc, '" + comment + "')]")) != null;

    }

    public boolean redirect() throws InterruptedException {
        while(driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"YouTube\n" +
                "يمكنك الاستمتاع بالفيديوهات والموسيقى التي تحبها وتحميل المحتوى الأصلي ومشاركته بكامله مع أصدقائك وأفراد عائلتك والعالم أجمع على YouTube.\"]") == null)
        {
            scrolldown();
        }

        Clicking(driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"YouTube\n" +
                "يمكنك الاستمتاع بالفيديوهات والموسيقى التي تحبها وتحميل المحتوى الأصلي ومشاركته بكامله مع أصدقائك وأفراد عائلتك والعالم أجمع على YouTube.\"]"));
        Thread.sleep(2000);
        return driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"YouTube\"]") != null;
    }








    public void scrolldown()
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

    public void scrollUp()
    {
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.5);
        int starty = (int) (size.height * 0.25);
        int endy = (int) (size.height * 0.8);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1).addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startx, starty))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(200)))
                .addAction(finger.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), startx, endy))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(sequence));
    }




}
