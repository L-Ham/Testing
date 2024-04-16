import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class RegisterPage extends PageBase
{
public RegisterPage (WebDriver driver)
    {
        super(driver);
    }

    By registerEmailTextBoxLocator = By.id("regPassword-prevent2");
    By continueButtonLocator = By.cssSelector("[data-testid='resetpasswordbutton20']");

    By errorInvalidEmailLocator = By.cssSelector("[data-testid='email-error']");
    By errorUsernameAlreadyTaken = By.cssSelector("[data-testid='username-error-message100']");

    By usernameTextBoxLocator = By.id("regUsername");
    By passwordTextBoxLocator = By.id("regPassword-prevent5");

    By randomUsernameReloadLocator = By.xpath("/html/body/div/div/div/div/div[2]/div[2]/p/a");

    By randomUsernameEntryLocator = By.xpath("/html/body/div/div/div/div/div[2]/div[2]/div/div/a[1]");

    By invalidUsernameSizeLocator = By.xpath("/html/body/div[1]/main/div[2]/div/div/div[2]/div[1]/form/fieldset[1]/div");

    By shortPasswordLocator = By.xpath("//*[@id=\"registerPasswordField\"]/div[2]");
    By SignUpButtonLocator = By.cssSelector("[data-testid='signup-continued-button']");

    By userProfileLocator = By.xpath("//*[@id=\"header-container\"]/header/nav/div[3]/div[2]/button");


    WebElement registerEmailTextBox;

    WebElement continueButton;

    WebElement usernameTextBox;

    WebElement passwordTextBox;

    WebElement SignUpButton;

    WebElement randomUsernameReload;
    WebElement randomUsernameEntry;

    public void enterNewUserEmail(String email)
    {
        explicitWait(10, registerEmailTextBoxLocator);
        registerEmailTextBox = driver.findElement(registerEmailTextBoxLocator);
        sendText(registerEmailTextBox, email);
        continueButton = driver.findElement(continueButtonLocator);
        Clicking(continueButton);
    }

    public void enterUsernameAndPassword(String username, String password)
    {
        explicitWait(10, usernameTextBoxLocator);
        usernameTextBox = driver.findElement(usernameTextBoxLocator);
        passwordTextBox = driver.findElement(passwordTextBoxLocator);
        sendText(usernameTextBox, username);
        sendText(passwordTextBox, password);
        SignUpButton = driver.findElement(SignUpButtonLocator);
        Clicking(SignUpButton);
    }

    public String enterRandomUsernameAndPassword(String password)
    {
        explicitWait(10, usernameTextBoxLocator);
        usernameTextBox = driver.findElement(usernameTextBoxLocator);
        passwordTextBox = driver.findElement(passwordTextBoxLocator);
        randomUsernameReload = driver.findElement(randomUsernameReloadLocator);
        Clicking(randomUsernameReload);
        explicitWait(10, randomUsernameEntryLocator);
        randomUsernameEntry = driver.findElement(randomUsernameEntryLocator);
        Clicking(randomUsernameEntry);
        String randomUsername = randomUsernameEntry.getText();
        sendText(passwordTextBox, password);
        explicitWait(10, SignUpButtonLocator);
        SignUpButton = driver.findElement(SignUpButtonLocator);
        Clicking(SignUpButton);
        return randomUsername;
    }

    public String enterAlreadyTakenUsername(String username) throws InterruptedException {
        explicitWait(10, usernameTextBoxLocator);
        usernameTextBox = driver.findElement(usernameTextBoxLocator);
        usernameTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        usernameTextBox.sendKeys(Keys.BACK_SPACE);
        sendText(usernameTextBox, username);
        WebElement errorInvalidUsername = driver.findElement(errorUsernameAlreadyTaken);
        while(!Objects.equals(errorInvalidUsername.getText(), "That username is already taken"))
        {
            //Do nothing
        }
        Thread.sleep(1000);
        return driver.findElement(errorUsernameAlreadyTaken).getText();
    }

    public void clearUsernameTextbox()
    {
        usernameTextBox = driver.findElement(usernameTextBoxLocator);
        usernameTextBox.clear();
    }

    public void clearEmailTextbox()
    {
        registerEmailTextBox = driver.findElement(registerEmailTextBoxLocator);
        registerEmailTextBox.clear();
    }



}
