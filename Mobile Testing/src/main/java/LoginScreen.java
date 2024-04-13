import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LoginScreen extends ScreenBase

{

    MobileElement loginButton;

    MobileElement username;
    String usernameXPath="//android.view.View[@content-desc=\"Log in\n" +
            "By continuing, you agree to our User Agreement and acknowlege that you understand the Privacy Policy\n" +
            "OR\"]/android.widget.EditText[1]";
    MobileElement password;
    String passwordXPath="//android.view.View[@content-desc=\"Log in\n" +
            "By continuing, you agree to our User Agreement and acknowlege that you understand the Privacy Policy\n" +
            "OR\"]/android.widget.EditText[2]";


    MobileElement continueButton;
    String continueButtonAccessibilityId="Continue";

    MobileElement userProfile;
    String userProfileXPath= "MobileElement profileIcon=driver.findElementByXPath(\"\\t\\n\" +\n" +
            "\"//android.widget.FrameLayout[@resource-id=\\\"android:id/content\\\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[4]\");\n" +
            "\n";
    public LoginScreen(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public void login(String username, String password) throws InterruptedException
    {
        loginButton=driver.findElementByAccessibilityId("Log in");
        Clicking(loginButton);
        this.username=driver.findElementByXPath(usernameXPath);
        Clicking(this.username);
        sendText(this.username, username);
        this.password=driver.findElementByXPath(passwordXPath);
        Clicking(this.password);
        sendText(this.password, password);
        continueButton=driver.findElementByAccessibilityId(continueButtonAccessibilityId);
        Clicking(continueButton);
        //userProfile=driver.findElementByXPath(userProfileXPath);
    }


}
