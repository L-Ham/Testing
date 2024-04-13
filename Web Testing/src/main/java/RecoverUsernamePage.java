
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RecoverUsernamePage extends PageBase
{
    public RecoverUsernamePage(WebDriver driver)
    {
        super(driver);
    }



    By getHelpLocator = By.xpath("//*[@id=\"usernameRecovery\"]/div/div/a");

    By loginButtonLocator = By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/a[1]");

    By signUpButtonLocator = By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/a[2]");
    By emailTextBoxLocator = By.id("email");
    By recoverButtonLocator = By.xpath("//*[@id=\"usernameRecovery\"]/div/fieldset[2]/button");

    By successMessageLocator = By.xpath("//*[@id=\"usernameRecovery\"]/div/fieldset[2]/div/span");

    By errorInvalidEmailLocator = By.xpath("//*[@id=\"usernameRecovery\"]/div/fieldset[1]/div");

    WebElement emailTextBox;

    WebElement recoverButton;

    WebElement getHelp;

    WebElement loginButton;

    public void clickGetHelp()
    {
        getHelp = driver.findElement(getHelpLocator);
        Clicking(getHelp);
    }

    public void clickLoginButton()
    {
        loginButton = driver.findElement(loginButtonLocator);
        Clicking(loginButton);
    }

    public void clickSignUpButton()
    {
        WebElement signUpButton = driver.findElement(signUpButtonLocator);
        Clicking(signUpButton);
    }

    public void enterEmail(String email)
    {
        emailTextBox = driver.findElement(emailTextBoxLocator);
        emailTextBox.sendKeys(email);
    }

    public void clickEmailMeButton()
    {
        recoverButton = driver.findElement(recoverButtonLocator);
        Clicking(recoverButton);
    }

    public void clearEmail() {
        emailTextBox = driver.findElement(emailTextBoxLocator);
        emailTextBox.clear();
    }

}
