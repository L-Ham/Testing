import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignUpScreen extends ScreenBase{

        MobileElement continueWithEmail;
        MobileElement email;
        String emailXPath="//android.view.View[@content-desc=\"Hi new friend,\n" +
                "Welcome to Reddit byLham!\n" +
                "By continuing, you agree to our User Agreement and acknowlege that you understand the Privacy Policy\"]/android.widget.EditText[1]";
        String continueWithEmailXpath="//android.widget.Button[@content-desc=\"Continue with Email\"]";
        MobileElement password;
        String passwordXPath="//android.view.View[@content-desc=\"Hi new friend,\n" +
                "Welcome to Reddit byLham!\n" +
                "By continuing, you agree to our User Agreement and acknowlege that you understand the Privacy Policy\"]/android.widget.EditText[2]";

        String passwordXpathInvalid="//android.view.View[@content-desc=\"Hi new friend,\n" +
                "Welcome to Reddit byLham!\n" +
                "By continuing, you agree to our User Agreement and acknowlege that you understand the Privacy Policy\n" +
                "Please enter a valid email address\"]/android.widget.EditText[2]";

        String userProfileXPath= "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[3]";

        MobileElement continueButton;
        String continueButtonXpath="//android.widget.Button[@content-desc=\"Continue\"]";

        MobileElement username;
        String usernameXPath="//android.widget.EditText";

        MobileElement manButton;

        String manButtonXPath="//android.widget.Button[@content-desc=\"Man\"]";

        MobileElement womanButton;

        String womanButtonXPath="//android.widget.Button[@content-desc=\"Woman\"]";

        MobileElement preferNotToSayButton;

        String preferNotToSayButtonXPath="//android.widget.Button[@content-desc=\"I prefer not to say\"]";

        String invalidEmailAndPasswordXPath="//android.view.View[@content-desc=\"Hi new friend,\n" +
                "Welcome to Reddit byLham!\n" +
                "By continuing, you agree to our User Agreement and acknowlege that you understand the Privacy Policy\n" +
                "Please enter a valid email address\n" +
                "Password must be at least 8 characters\"]";

        String userAlreadyTakenXpath="//android.view.View[@content-desc=\"Create your username\n" +
                "Most redditors use an anonymous username. \n" +
                " You wont be able to change it later.\n" +
                "Username already taken! Try another\n" +
                "Need inspiration? Try these usernames:\"]";

        public SignUpScreen(AndroidDriver<MobileElement> driver) {
                super(driver);
        }

        public void signUpStart(String email, String password) throws InterruptedException
        {
                explicitWait(By.xpath(continueWithEmailXpath));
                this.continueWithEmail=driver.findElementByXPath(continueWithEmailXpath);
                Clicking(continueWithEmail);
                explicitWait(By.xpath(emailXPath));
                this.email=driver.findElementByXPath(emailXPath);
                Clicking(this.email);
                sendText(this.email, email);
                driver.hideKeyboard();
                this.password=driver.findElementByXPath(passwordXPath);
                Clicking(this.password);
                sendText(this.password, password);
                boolean isPasswordObscured = !password.equals(this.password.getText());
                System.out.println("Password is obscured: "+this.password.getText() + " " + isPasswordObscured);
                explicitWait(By.xpath(continueButtonXpath));
                continueButton=driver.findElementByXPath(continueButtonXpath);
                Clicking(continueButton);
        }

        public void signContinued(String username) throws InterruptedException
        {
                explicitWait(By.xpath(usernameXPath));
                this.username=driver.findElementByXPath(usernameXPath);
                Clicking(this.username);
                sendText(this.username, username);
                explicitWait(By.xpath(continueButtonXpath));
                continueButton=driver.findElementByXPath(continueButtonXpath);
                Clicking(continueButton);
        }
        public void chooseGender(String gender) throws InterruptedException
        {
                driver.hideKeyboard();
                if(gender.equals("Man"))
                {
                        explicitWait(By.xpath(manButtonXPath));
                        manButton=driver.findElementByXPath(manButtonXPath);
                        Clicking(manButton);
                }
                else if (gender.equals("Woman"))
                {
                        explicitWait(By.xpath(womanButtonXPath));
                        womanButton=driver.findElementByXPath(womanButtonXPath);
                        Clicking(womanButton);
                }
                else
                {
                        explicitWait(By.xpath(preferNotToSayButtonXPath));
                        preferNotToSayButton=driver.findElementByXPath(preferNotToSayButtonXPath);
                        Clicking(preferNotToSayButton);
                }
                Thread.sleep(1000);
        }

        public void clickContinueButton() throws InterruptedException
        {
                explicitWait(By.xpath(continueWithEmailXpath));
                this.continueWithEmail=driver.findElementByXPath(continueWithEmailXpath);
                Clicking(continueWithEmail);
        }

        public void invalidSignupSetup() throws InterruptedException
        {
                explicitWait(By.xpath(emailXPath));
                this.email=driver.findElementByXPath(emailXPath);
                explicitWait(By.xpath(passwordXPath));
                this.password=driver.findElementByXPath(passwordXPath);
        }

        public void invalidSignup(String email, String password) throws InterruptedException
        {
                Clicking(this.email);
                this.email.clear();
                Clicking(this.email);
                sendText(this.email, email);
                Clicking(this.password);
                this.password.clear();
                Clicking(this.password);
                sendText(this.password, password);
        }
        public void clickContinueFirstScreen()
        {
                explicitWait(By.xpath(continueButtonXpath));
                continueButton=driver.findElementByXPath(continueButtonXpath);
                Clicking(continueButton);
        }
        public void userAlreadyTaken(String username)
        {
                explicitWait(By.xpath(usernameXPath));
                this.username=driver.findElementByXPath(usernameXPath);
                Clicking(this.username);
                sendText(this.username, username);
        }

}
