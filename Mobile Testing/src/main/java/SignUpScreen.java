import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignUpScreen extends ScreenBase{

        MobileElement continueWithEmail;
        MobileElement email;
        String emailXPath="//android.view.View[@content-desc=\"Hi new friend,\n" +
                "Welcome to Reddit byLham!\n" +
                "By continuing, you agree to our User Agreement and acknowlege that you understand the Privacy Policy\"]/android.widget.EditText[1]";
        String continueWithEmailAccessibilityId="Continue with Email";
        MobileElement password;
        String passwordXPath="//android.view.View[@content-desc=\"Hi new friend,\n" +
                "Welcome to Reddit byLham!\n" +
                "By continuing, you agree to our User Agreement and acknowlege that you understand the Privacy Policy\"]/android.widget.EditText[2]";

        String userProfileXPath= "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[3]";

        MobileElement continueButton;
        String continueButtonAccessibilityId="Continue";

        MobileElement username;
        String usernameXPath="//android.widget.EditText";

        MobileElement manButton;

        String manButtonXPath="//android.widget.Button[@content-desc=\"Man\"]";

        MobileElement womanButton;

        String womanButtonXPath="//android.widget.Button[@content-desc=\"Woman\"]";

        MobileElement preferNotToSayButton;

        String preferNotToSayButtonXPath="//android.widget.Button[@content-desc=\"I prefer not to say\"]";
        public SignUpScreen(AndroidDriver<MobileElement> driver) {
                super(driver);
        }

        public void signUpStart(String email, String password) throws InterruptedException
        {
                Thread.sleep(1000);
                this.continueWithEmail=driver.findElementByAccessibilityId(continueWithEmailAccessibilityId);
                Thread.sleep(1000);
                Clicking(continueWithEmail);
                this.email=driver.findElementByXPath(emailXPath);
                Clicking(this.email);
                sendText(this.email, email);
                this.password=driver.findElementByXPath(passwordXPath);
                Clicking(this.password);
                sendText(this.password, password);
                boolean isPasswordObscured = !password.equals(this.password.getText());
                System.out.println("Password is obscured: "+this.password.getText() + " " + isPasswordObscured);
                continueButton=driver.findElementByAccessibilityId(continueButtonAccessibilityId);
                Clicking(continueButton);
                Thread.sleep(2000);
        }

        public void signContinued(String username) throws InterruptedException
        {
                Thread.sleep(2000);
                this.username=driver.findElementByXPath(usernameXPath);
                Clicking(this.username);
                sendText(this.username, username);
                Thread.sleep(2000);
                continueButton=driver.findElementByAccessibilityId(continueButtonAccessibilityId);
                Clicking(continueButton);
        }
        public void chooseGender(String gender) throws InterruptedException
        {
                driver.hideKeyboard();
                if(gender.equals("Man"))
                {
                        manButton=driver.findElementByXPath(manButtonXPath);
                        Clicking(manButton);
                }
                else if (gender.equals("Woman"))
                {
                        womanButton=driver.findElementByXPath(womanButtonXPath);
                        Clicking(womanButton);
                }
                else
                {
                        preferNotToSayButton=driver.findElementByXPath(preferNotToSayButtonXPath);
                        Clicking(preferNotToSayButton);
                }
                Thread.sleep(1000);

        }



}
