import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public
class AccountSettingsPage extends PageBase
{
    public
    AccountSettingsPage(WebDriver driver)
    {
        super(driver);
    }

    By userProfileLocator = By.xpath("//*[@id='expand-user-drawer-button']/span/span/span/span/img");
    By settingsButtonLocator = By.xpath("//*[@id=\"user-drawer-content\"]/ul[3]/faceplate-tracker/li");
    By verifyEmailButtonLocator = By.xpath("//*[@id=\"AppRouter-main-content\"]/div/div[2]/div[1]/div[1]/div[1]/p/button");
    By verificationEmailTextLocator = By.xpath("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]/div[4]/div/div/div/div[1]/h2");
    By changeEmailButtonLocator = By.xpath("//*[@id=\"AppRouter-main-content\"]/div/div[2]/div[1]/div[1]/div[2]/div/button");
    By confirmPasswordTextboxLocator = By.xpath("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]/div[4]/div/div/div/div[2]/div[1]/input");
    By newEmailTextboxLocator = By.xpath("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]/div[4]/div/div/div/div[2]/div[2]/input");
    By saveEmailButtonLocator = By.xpath("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]/div[4]/div/div/div/div[2]/div[3]/button");
    By invalidEmailTextLocator = By.xpath("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]/div[4]/div/div/div/div[2]/div[2]/p");
    By confirmationEmailButtonLocator = By.xpath("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]/div[4]/div/div/div/div[2]/div/button");
    By userDropDownLocator = By.xpath("//*[@id=\"USER_DROPDOWN_ID\"]");
    By logoutButtonLocator = By.xpath("/html/body/div[3]/div/div/button[5]");
    By changePasswordButtonLocator = By.xpath("//*[@id=\"AppRouter-main-content\"]/div/div[2]/div[1]/div[2]/div[2]/div/button");
    By oldPasswordLocator = By.xpath("/html/body/div/div/div[2]/div/form/fieldset[1]/input");
    By newPasswordLocator = By.id("password");
    By confirmNewPasswordLocator = By.id("password2");
    By logoutEverywhereButtonLocator = By.xpath("/html/body/div/div/div[2]/div/form/fieldset[4]/div/label/div");
    By savePasswordButtonLocator = By.xpath("/html/body/div/div/div[2]/div/form/fieldset[5]/button");
    By changeGenderButtonLocator = By.xpath("//*[@id=\"AppRouter-main-content\"]/div/div[2]/div[1]/div[3]/div[2]/div/div/div[1]/button");
    By genderOptionLocator;
    By counrtyDropDownLocator = By.id("country");
    By countryOptionLocator;
    WebElement userProfile;
    WebElement settingsButton;
    WebElement verifyEmailButton;
    WebElement changeEmailButton;
    WebElement newEmailTextBox;
    WebElement confirmPasswordTextBox;
    WebElement saveEmailButton;
    WebElement logoutButton;
    WebElement changePasswordButton;
    WebElement oldPasswordTextBox;
    WebElement newPasswordTextBox;
    WebElement confirmPassword;
    WebElement logoutEverywhereButton;
    WebElement savePasswordButton;
    WebElement changeGenderButton;

    public
    void openSettings()
    {
        userProfile = driver.findElement(userProfileLocator);
        Clicking(userProfile);
        settingsButton = driver.findElement(settingsButtonLocator);
        Clicking(settingsButton);
    }

    public
    void verifyEmail()
    {
        verifyEmailButton = driver.findElement(verifyEmailButtonLocator);
        Clicking(verifyEmailButton);
    }

    public
    void changeEmail(String newEmail, String password)
    {
        changeEmailButton = driver.findElement(changeEmailButtonLocator);
        Clicking(changeEmailButton);
        newEmailTextBox = driver.findElement(newEmailTextboxLocator);
        confirmPasswordTextBox = driver.findElement(confirmPasswordTextboxLocator);
        saveEmailButton = driver.findElement(saveEmailButtonLocator);
        sendText(newEmailTextBox, newEmail);
        sendText(confirmPasswordTextBox, password);
        Clicking(saveEmailButton);
    }

    public
    void changePassword(String oldPassword, String newPassword, String confirmedPassword)
    {
        changePasswordButton = driver.findElement(changePasswordButtonLocator);
        Clicking(changePasswordButton);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(newPasswordLocator));
        oldPasswordTextBox = driver.findElement(oldPasswordLocator);
        sendText(oldPasswordTextBox, oldPassword);
        newPasswordTextBox = driver.findElement(newPasswordLocator);
        sendText(newPasswordTextBox, newPassword);
        confirmPassword = driver.findElement(confirmNewPasswordLocator);
        sendText(confirmPassword, confirmedPassword);
        logoutEverywhereButton = driver.findElement(logoutEverywhereButtonLocator);
        savePasswordButton = driver.findElement(savePasswordButtonLocator);
        Clicking(logoutEverywhereButton);
        Clicking(savePasswordButton);
    }

    public
    void logOut()
    {
        userProfile = driver.findElement(userDropDownLocator);
        Clicking(userProfile);
        logoutButton = driver.findElement(logoutButtonLocator);
        Clicking(logoutButton);
    }

    public
    void changeGender(String gender)
    {
        changeGenderButton = driver.findElement(changeGenderButtonLocator);
        Clicking(changeGenderButton);
        if (gender.equals("Man"))
            genderOptionLocator = By.xpath("/html/body/div[3]/div/button[2]");
        else
            genderOptionLocator = By.xpath("/html/body/div[3]/div/button[1]");
        WebElement genderOption = driver.findElement(genderOptionLocator);
        Clicking(genderOption);
    }

    public
    void changeCountry(String country) {
        WebElement countryDropDown = driver.findElement(counrtyDropDownLocator);
        Clicking(countryDropDown);
        countryOptionLocator = By.xpath("//*[@id='country']//option[text()='" + country + "']");

        WebElement countryOption = driver.findElement(countryOptionLocator);
        Clicking(countryOption);
    }

    public
    void backToLogin()
    {
        driver.navigate().to("https://www.reddit.com/account/login/");
    }
}
