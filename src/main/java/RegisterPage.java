import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage extends PageBase
{
public RegisterPage (WebDriver driver)
    {
        super(driver);
    }

    By loginButtonLocator = By.xpath("/html/body/div/main/div[1]/div/div[2]/form/div[4]/a");
    By googleButtonLocator = By.xpath("/html/body/div/div/div[2]");

    By userAgreementLocator = By.xpath("/html/body/div/main/div[1]/div/div[2]/form/p/a[1]");

    By privacyPolicyLocator = By.xpath("/html/body/div/main/div[1]/div/div[2]/form/p/a[2]");

    By registerEmailTextBoxLocator = By.id("regEmail");
    By continueButtonLocator = By.xpath("/html/body/div/main/div[1]/div/div[2]/form/fieldset[2]/button");

    By errorInvalidEmailLocator = By.xpath("/html/body/div/main/div[1]/div/div[2]/form/fieldset[1]/div");

    By errorUsernameAlreadyTaken = By.xpath("/html/body/div[1]/main/div[2]/div/div/div[2]/div[1]/form/fieldset[1]/div");

    By usernameTextBoxLocator = By.id("regUsername");
    By passwordTextBoxLocator = By.id("regPassword");

    By SignUpButtonLocator = By.xpath("/html/body/div[1]/main/div[2]/div/div/div[3]/button");



    WebElement loginButton;
    WebElement googleButton;

    WebElement userAgreement;

    WebElement privacyPolicy;

    WebElement registerEmailTextBox;

    WebElement continueButton;

    WebElement usernameTextBox;

    WebElement passwordTextBox;

    WebElement SignUpButton;

    public void clickLoginButton()
    {
        loginButton = driver.findElement(loginButtonLocator);
        Clicking(loginButton);
    }

    public String clickGoogleButton()
    {
        // switch to frame of google button first using switchToFrame method

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


    public void enterNewUserEmail(String email)
    {

        registerEmailTextBox = driver.findElement(registerEmailTextBoxLocator);
        sendText(registerEmailTextBox, email);
        continueButton = driver.findElement(continueButtonLocator);
        Clicking(continueButton);
    }

    public void enterUsernameAndPassword(String username, String password)
    {
        usernameTextBox = driver.findElement(usernameTextBoxLocator);
        passwordTextBox = driver.findElement(passwordTextBoxLocator);
        sendText(usernameTextBox, username);
        sendText(passwordTextBox, password);
        SignUpButton = driver.findElement(SignUpButtonLocator);
        Clicking(SignUpButton);
    }

    public void enterAlreadyTakenUsername()
    {
        usernameTextBox = driver.findElement(usernameTextBoxLocator);
        sendText(usernameTextBox, "Ill_Initial_3945");
    }

    public void clearEmailTextbox()
    {
        registerEmailTextBox = driver.findElement(registerEmailTextBoxLocator);
        registerEmailTextBox.clear();
    }

    public void clickUserAgreement()
    {
        userAgreement = driver.findElement(userAgreementLocator);
        Clicking(userAgreement);
    }

    public void clickPrivacyPolicy()
    {
        privacyPolicy = driver.findElement(privacyPolicyLocator);
        Clicking(privacyPolicy);
    }


}
