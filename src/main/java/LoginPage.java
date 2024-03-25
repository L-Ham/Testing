import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageBase
{
    public LoginPage (WebDriver driver)
    {
        super(driver);
        driver.get("https://www.reddit.com/account/login/");
    }

    By usernameTextBoxLocator = By.id("loginUsername");
    By passwordTextBoxLocator = By.id("loginPassword");

    By innerLoginButtonLocator = By.xpath("//*[@id=\"login-button\"]");
    By loginButtonLocator = By.xpath("/html/body/div/main/div[1]/div/div[2]/form/fieldset[5]/button");

    By errorInvalidCredentialsLocator = By.xpath("/html/body/div/main/div[1]/div/div[2]/form/fieldset[1]/div");

    By userProfileLocator = By.xpath("//*[@id='expand-user-drawer-button']/span/span/span/span/img");

    By logoutButtonLocator = By.xpath("//*[@id=\"logout-list-item\"]/div");
    WebElement userProfile;

    WebElement innerLoginButton;

    WebElement errorInvalidCredentials;

    WebElement logoutButton;
    WebElement usernameTextBox;
    WebElement passwordTextBox;

    WebElement loginButton;


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
