import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage extends PageBase
{
    public LoginPage (WebDriver driver)
    {
        super(driver);
        driver.get("https://www.reddit.com/account/login/");
    }

    By signUpButtonLocator   = By.xpath("/html/body/div/main/div[1]/div/div[2]/form/div[4]/a");

    By googleButtonLocator = By.xpath("/html/body/div/div/div[2]");

    By usernameTextBoxLocator = By.id("loginUsername");

    By passwordTextBoxLocator = By.id("loginPassword");

    By innerLoginButtonLocator = By.xpath("//*[@id=\"login-button\"]");
    By loginButtonLocator = By.xpath("/html/body/div/main/div[1]/div/div[2]/form/fieldset[5]/button");

    By errorInvalidCredentialsLocator = By.xpath("/html/body/div/main/div[1]/div/div[2]/form/fieldset[1]/div");

    By userProfileLocator = By.xpath("//*[@id='expand-user-drawer-button']/span/span/span/span/img");

    By logoutButtonLocator = By.xpath("//*[@id=\"logout-list-item\"]/div");

    By recoverUsernameLocator = By.xpath("/html/body/div/main/div[1]/div/div[2]/form/div[3]/a[1]");

    By recoverPasswordLocator = By.xpath("/html/body/div/main/div[1]/div/div[2]/form/div[3]/a[2]");

    WebElement signUpButton;
    WebElement recoverUsername;
    WebElement recoverPassword;
    WebElement userProfile;
    WebElement googleButton;
    WebElement logoutButton;
    WebElement usernameTextBox;
    WebElement passwordTextBox;
    WebElement loginButton;

    public void clickRecoverUsername()
    {
        recoverUsername = driver.findElement(recoverUsernameLocator);
        Clicking(recoverUsername);
    }

    public void clickRecoverPassword()
    {
        recoverPassword = driver.findElement(recoverPasswordLocator);
        Clicking(recoverPassword);
    }

    public void clickSignUpButton()
    {
        signUpButton = driver.findElement(signUpButtonLocator);
        Clicking(signUpButton);
    }

    public String clickGoogleButton()
    {
        driver.switchTo().frame(0);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(googleButtonLocator));
        String MainWindow = driver.getWindowHandle();
        googleButton = driver.findElement(googleButtonLocator);
        Clicking(googleButton);
        for (String winHandle : driver.getWindowHandles())
        {
            if(!winHandle.equals(MainWindow))
            {
                driver.switchTo().window(winHandle);
            }
        }
        return MainWindow;
    }
    public void login(String email, String password)
    {
        usernameTextBox = driver.findElement(usernameTextBoxLocator);
        passwordTextBox = driver.findElement(passwordTextBoxLocator);
        loginButton = driver.findElement(loginButtonLocator);
        sendText(usernameTextBox, email);
        sendText(passwordTextBox, password);
        Clicking(loginButton);
    }

    public void resetLoginCredentials()
    {
        usernameTextBox = driver.findElement(usernameTextBoxLocator);
        passwordTextBox = driver.findElement(passwordTextBoxLocator);
        usernameTextBox.clear();
        passwordTextBox.clear();

    }

    public void backToLogin()
    {
    driver.navigate().to("https://www.reddit.com/account/login/");
    }

    public void logOut()
    {
        userProfile = driver.findElement(userProfileLocator);
        Clicking(userProfile);
        logoutButton = driver.findElement(logoutButtonLocator);
        Clicking(logoutButton);
    }










}
