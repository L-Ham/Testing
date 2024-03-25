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

    By registerEmailTextBoxLocator = By.id("regEmail");
    By continueButtonLocator = By.xpath("/html/body/div/main/div[1]/div/div[2]/form/fieldset[2]/button");

    By errorInvalidEmailLocator = By.xpath("/html/body/div/main/div[1]/div/div[2]/form/fieldset[1]/div");

    WebElement registerEmailTextBox;
    WebElement continueButton;

    WebElement errorInvalidEmail;

    public void enterNewUserEmail(String email)
    {

        registerEmailTextBox = driver.findElement(registerEmailTextBoxLocator);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(continueButtonLocator));
        continueButton = driver.findElement(continueButtonLocator);
        sendText(registerEmailTextBox, email);
        Clicking(continueButton);
    }

    public void assertInvalidEmail()
    {
        errorInvalidEmail = driver.findElement(errorInvalidEmailLocator);
        assert errorInvalidEmail.getText().contains("That email is invalid");
    }

    public void clearEmailTextbox()
    {
        registerEmailTextBox = driver.findElement(registerEmailTextBoxLocator);
        registerEmailTextBox.clear();
    }


}
