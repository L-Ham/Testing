import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

//import sun.jvm.hotspot.utilities.Assert;
public class LoginScreen extends ScreenBase

{
    MobileElement continueWithEmail;
    String continueWithEmailXpath="//android.widget.Button[@content-desc=\"Continue with Email\"]";
    MobileElement loginButton;

    String loginButtonXpath="//android.view.View[@content-desc=\"Log in\"]";

    MobileElement username;
    String usernameXPath="//android.view.View[@content-desc=\"Log in\n" +
            "By continuing, you agree to our User Agreement and acknowlege that you understand the Privacy Policy\n" +
            "OR\"]/android.widget.EditText[1]";
    MobileElement password;
    String passwordXPath="//android.view.View[@content-desc=\"Log in\n" +
            "By continuing, you agree to our User Agreement and acknowlege that you understand the Privacy Policy\n" +
            "OR\"]/android.widget.EditText[2]";


    MobileElement continueButton;
    String continueButtonXpath="//android.widget.Button[@content-desc=\"Continue\"]";

    MobileElement userProfile;
    String userProfileXPath= "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[3]";

    MobileElement accounts;
    String accountsXpath="//android.view.View[@content-desc=\"u/itssosoyall\"]";

    MobileElement logoutFirst;
    String logoutFirstXpath="//android.view.View[@content-desc=\"P\n" +
            "u/itssosoyall\"]/android.widget.Button";

    MobileElement logoutSecond;

    String logoutSecondXpath="//android.view.View[@content-desc=\"u/itssosoyall\n" +
            "Logout\"]";

    String invalidUsernameOrPassword="//android.view.View[@content-desc=\"Invalid username/email or password\"]";
    MobileElement continueWithGoogle;
    String continueWithGoogleAccessibilityId="Continue with Google";

    MobileElement forgotPassword;

    String forgotPasswordXpath="//android.view.View[@content-desc=\"Forgot your password?\"]";

    MobileElement forgotPasswordUsername;
    String forgotPasswordUsernameTextboxXpath="//android.widget.EditText[@resource-id=\"email_or_username_text_field\"]";

    MobileElement resetPasswordButton;

    String resetPasswordButtonXpath="//android.widget.Button[@content-desc=\"Reset Password\"]";



    public LoginScreen(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public void clickOnLoginButton()
    {
        explicitWait(By.xpath(loginButtonXpath));
        this.loginButton=driver.findElementByXPath(loginButtonXpath);
        Clicking(loginButton);
    }

    public void login(String username, String password) throws InterruptedException
    {
        explicitWait(By.xpath(usernameXPath));
        this.username=driver.findElementByXPath(usernameXPath);
        Clicking(this.username);
        sendText(this.username, username);
        this.password=driver.findElementByXPath(passwordXPath);
        Clicking(this.password);
        sendText(this.password, password);
        driver.hideKeyboard();
        boolean isPasswordObscured = !password.equals(this.password.getText());
        System.out.println("Password is obscured: "+this.password.getText() + " " + isPasswordObscured);
        explicitWait(By.xpath(continueButtonXpath));
        continueButton=driver.findElementByXPath(continueButtonXpath);
        Clicking(continueButton);
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

    public void clickContinueButton() throws InterruptedException
    {
        explicitWait(By.xpath(continueWithEmailXpath));
        this.continueWithEmail=driver.findElementByXPath(continueWithEmailXpath);
        Clicking(continueWithEmail);
    }

    public void beforeInvalid()
    {
        explicitWait(By.xpath(usernameXPath));
        this.username=driver.findElementByXPath(usernameXPath);
        this.password=driver.findElementByXPath(passwordXPath);
        continueButton=driver.findElementByXPath(continueButtonXpath);
    }

    public void invalidLogin(String username, String password) throws InterruptedException
    {
        Clicking(this.username);
        this.username.clear();
        Clicking(this.username);
        sendText(this.username, username);
        Clicking(this.password);
        this.password.clear();
        Clicking(this.password);
        sendText(this.password, password);
        Clicking(continueButton);
        driver.hideKeyboard();
    }

    public void forgotPassword(String usernameOrEmail) throws InterruptedException
    {
        clickContinueButton();
        explicitWait(By.xpath(loginButtonXpath));
        this.loginButton=driver.findElementByXPath(loginButtonXpath);
        Clicking(loginButton);
        explicitWait(By.xpath(forgotPasswordXpath));
        forgotPassword=driver.findElementByXPath(forgotPasswordXpath);
        Clicking(forgotPassword);
        explicitWait(By.xpath(forgotPasswordUsernameTextboxXpath));
        forgotPasswordUsername=driver.findElementByXPath(forgotPasswordUsernameTextboxXpath);
        Clicking(forgotPasswordUsername);
        Clicking(forgotPasswordUsername);
        forgotPasswordUsername.clear();
        Thread.sleep(1000);
        sendText(forgotPasswordUsername, usernameOrEmail);
        Thread.sleep(1000);
        driver.hideKeyboard();
        resetPasswordButton=driver.findElementByXPath(resetPasswordButtonXpath);
        Clicking(resetPasswordButton);
    }

}
