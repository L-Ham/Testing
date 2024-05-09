import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage extends PageBase
{
    public LoginPage (WebDriver driver)
    {
        super(driver);
        driver.get("https://reddit-bylham.me/login");
    }

    By userAgreementLocator=By.partialLinkText("User Agreement");

    By privacyPolicyLocator=By.partialLinkText("Privacy Policy");

    By signUpButtonLocator = By.xpath("/html/body/div/main/div[1]/div/div[2]/form/div[4]/a");


    By googleButtonLocator = By.xpath("/html/body/div/div/div/div[2]/div[5]/button");

    By googleEmailTextBoxLocator = By.id("identifierId");

    By googlePasswordTextBoxLocator = By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input");

    By nextButtonInGoogle= By.xpath("//*[@id=\"identifierNext\"]/div/button");

    By usernameTextBoxLocator = By.id("regPassword-prevent4"); //login username

    By passwordTextBoxLocator = By.id("regPassword-prevent3"); //login password

    //By innerLoginButtonLocator = By.xpath("//*[@id=\"login-button\"]");
    By loginButtonLocator = By.cssSelector("[data-testid='loginbutton50']");

    By errorInvalidCredentialsLocator = By.cssSelector("[data-testid='username-errorr']");

    By userProfileLocator = By.xpath("//*[@id=\"header-container\"]/header/nav/div[3]/div[2]/button");

    By usernameInProfileLocator = By.xpath("//*[@id=\"header-container\"]/header/nav/div[3]/div[2]/div/ul[1]/li[1]/a/span/span[2]/span[2]");

    By logoutButtonLocator = By.cssSelector("[data-testid='profile-menu-button-item-Log Out']");

    By recoverUsernameEmailTextBoxLocator = By.id("regPassword-prevent2");

    By sendEmailRecoverUsernameButtonLocator = By.cssSelector("[data-testid='resetpasswordbutton4']");

    By recoverMessageConfirmationLocator = By.cssSelector("[data-testid='forgotusernameformmessage']");

    By recoverPasswordEmailTextBoxLocator = By.cssSelector("[data-testid='emailinput']");

    By recoverPasswordUsernameTextBoxLocator = By.cssSelector("[data-testid='username-input-tag']");

    By sendEmailRecoverPasswordButtonLocator = By.cssSelector("[data-testid='resetpasswordbutton']");

    By recoverPasswordMessageLocator = By.cssSelector("[data-testid='resetpasswordmessage']");

    WebElement recoverPasswordEmail;

    WebElement recoverMessageConfirmation;

    WebElement recoverUsernameButton;
    WebElement privacyPolicy;

    WebElement userAgreement;

    WebElement signUpButton;
    WebElement recoverUsername;
    WebElement recoverPassword;
    WebElement userProfile;
    WebElement googleButton;
    WebElement googleEmailTextBox;

    WebElement nextButton;

    WebElement getPasswordTextBox;
    WebElement logoutButton;
    WebElement usernameTextBox;
    WebElement passwordTextBox;
    WebElement loginButton;

    public void clickGoogleButton() throws InterruptedException
    {
       explicitWait(15, googleButtonLocator);
       googleButton = driver.findElement(googleButtonLocator);
       Clicking(googleButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2)); // Wait for two windows to be present (main + new)
       String mainWindowHandle = driver.getWindowHandle();
       for (String windowHandle : driver.getWindowHandles())
       {
           if (!windowHandle.equals(mainWindowHandle)) {
               driver.switchTo().window(windowHandle);
               driver.manage().window().maximize();
               break;
           }
       }
       explicitWait(30, googleEmailTextBoxLocator);
       googleEmailTextBox = driver.findElement(googleEmailTextBoxLocator);
       sendText(googleEmailTextBox, "husshadidy11@gmail.com");
       nextButton = driver.findElement(nextButtonInGoogle);
       Clicking(nextButton);
       explicitWait(30, googlePasswordTextBoxLocator);
       getPasswordTextBox = driver.findElement(googlePasswordTextBoxLocator);
       sendText(getPasswordTextBox, "hihussein12");
       getPasswordTextBox.sendKeys(Keys.ENTER);
       driver.switchTo().window(mainWindowHandle);
    }
    public void login(String email, String password)
    {
        explicitWait(10, usernameTextBoxLocator);
        usernameTextBox = driver.findElement(usernameTextBoxLocator);
        passwordTextBox = driver.findElement(passwordTextBoxLocator);
        loginButton = driver.findElement(loginButtonLocator);
        sendText(usernameTextBox, email);
        sendText(passwordTextBox, password);
        Clicking(loginButton);
    }

    public String clickProfilePageGetName() throws InterruptedException {
        explicitWait(10, userProfileLocator);
        userProfile = driver.findElement(userProfileLocator);
        Clicking(userProfile);
        explicitWait(10, usernameInProfileLocator);
        Thread.sleep(1500);
        return driver.findElement(usernameInProfileLocator).getText();
    }

    public void clearLoginCredentials()
    {
        explicitWait(10, usernameTextBoxLocator);
        usernameTextBox = driver.findElement(usernameTextBoxLocator);
        passwordTextBox = driver.findElement(passwordTextBoxLocator);
        usernameTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        usernameTextBox.sendKeys(Keys.BACK_SPACE);
        passwordTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        passwordTextBox.sendKeys(Keys.BACK_SPACE);
    }
    public void backToLogin()
    {
    driver.navigate().to("https://www.reddit.com/account/login/");
    }

    public void logOut()
    {
        explicitWait(10, userProfileLocator);
        logoutButton = driver.findElement(logoutButtonLocator);
        Clicking(logoutButton);
    }

    public void clickPrivacyPolicy()
    {
        explicitWait(10, userAgreementLocator);
        privacyPolicy = driver.findElement(privacyPolicyLocator);
        Clicking(privacyPolicy);
    }

    public void clickUserAgreement()
    {
        explicitWait(10, userAgreementLocator);
        userAgreement = driver.findElement(userAgreementLocator);
        Clicking(userAgreement);
    }

    public String sendRecoveredUsernameEmail(String email) throws InterruptedException {
        explicitWait(10, recoverUsernameEmailTextBoxLocator);
        recoverUsername = driver.findElement(recoverUsernameEmailTextBoxLocator);
        sendText(recoverUsername, email);
        explicitWait(10, sendEmailRecoverUsernameButtonLocator);
        recoverUsernameButton = driver.findElement(sendEmailRecoverUsernameButtonLocator);
        Clicking(recoverUsernameButton);
        explicitWait(10, recoverMessageConfirmationLocator);
        Thread.sleep(2000);
        recoverMessageConfirmation = driver.findElement(recoverMessageConfirmationLocator);
        return recoverMessageConfirmation.getText();
    }

    public String sendRecoveredPasswordEmail(String email, String username) throws InterruptedException {
        explicitWait(10, recoverPasswordUsernameTextBoxLocator);
        WebElement recoverPasswordUsername = driver.findElement(recoverPasswordUsernameTextBoxLocator);
        sendText(recoverPasswordUsername, username);
        explicitWait(10, recoverPasswordEmailTextBoxLocator);
        recoverPasswordEmail = driver.findElement(recoverPasswordEmailTextBoxLocator);
        sendText(recoverPasswordEmail, email);
        explicitWait(10, sendEmailRecoverPasswordButtonLocator);
        WebElement passwordRecoverButton = driver.findElement(sendEmailRecoverPasswordButtonLocator);
        Clicking(passwordRecoverButton);
        explicitWait(10, recoverPasswordMessageLocator);
        Thread.sleep(1000);
        WebElement message = driver.findElement(recoverPasswordMessageLocator);
        return message.getText();
    }

}
