import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResetPasswordPage extends PageBase
{

    By forgotUsernameLocator = By.xpath("/html/body/div/div/div[2]/div/form[1]/div/div[1]/a");

    By getHelpLocator = By.xpath("/html/body/div/div/div[2]/div/form[1]/div/div[2]/a");

    By loginButtonLocator = By.xpath("/html/body/div/div/div[2]/div/div[2]/a[1]");

    By signUpButtonLocator = By.xpath("/html/body/div/div/div[2]/div/div[2]/a[2]");

    By usernameTextboxLocator = By.id("username");

    By emailTextboxLocator = By.id("email");


    By resetPasswordButtonLocator = By.xpath("/html/body/div/div/div[2]/div/form[1]/div/fieldset[3]/button");

    By successMessageLocator = By.xpath("/html/body/div/div/div[2]/div/form[1]/div/fieldset[3]/div/span");

    By errorInvalidEmailLocator = By.xpath("/html/body/div/div/div[2]/div/form[1]/div/fieldset[2]/div");

    WebElement usernameTextbox;

    WebElement emailTextbox;

    WebElement resetPasswordButton;
    public ResetPasswordPage(WebDriver driver)
    {
        super(driver);
    }

    public void enterUsername(String username)
    {
        usernameTextbox =  driver.findElement(usernameTextboxLocator);
        usernameTextbox.sendKeys(username);
    }

    public void enterEmail(String email)
    {
        emailTextbox = driver.findElement(emailTextboxLocator);
        emailTextbox.sendKeys(email);
    }

    public void clickResetPasswordButton()
    {
        resetPasswordButton = driver.findElement(resetPasswordButtonLocator);
        Clicking(resetPasswordButton);
    }

    public void clickForgotUsername()
    {
        WebElement forgotUsername = driver.findElement(forgotUsernameLocator);
        Clicking(forgotUsername);
    }

    public void clickGetHelp()
    {
        WebElement getHelp = driver.findElement(getHelpLocator);
        Clicking(getHelp);
    }

    public void clickLoginButton()
    {
        WebElement loginButton = driver.findElement(loginButtonLocator);
        Clicking(loginButton);
    }

    public void clickSignUpButton()
    {
        WebElement signUpButton = driver.findElement(signUpButtonLocator);
        Clicking(signUpButton);
    }

}
