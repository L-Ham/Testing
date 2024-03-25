import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class ProfileSettingsPage extends PageBase{
    ProfileSettingsPage(WebDriver driver)
    {
        super(driver);
    }
    By profileTabLocator = By.xpath("//*[@id=\"AppRouter-main-content\"]/div/div[1]/div/a[2]");
    By displayNameTextBoxLocator = By.xpath("//*[@id=\"AppRouter-main-content\"]/div/div[2]/div[1]/div[1]/div[2]/input");
    By aboutTextboxLocator = By.xpath("//*[@id=\"AppRouter-main-content\"]/div/div[2]/div[1]/div[2]/div[2]/textarea");
    WebElement profileTab;
    WebElement displayNameTextBox;
    WebElement aboutTextBox;

    public void openProfileTab()
    {
        profileTab = driver.findElement(profileTabLocator);
        Clicking(profileTab);
    }

    public void changeDisplayName(String displayName)
    {
        displayNameTextBox = driver.findElement(displayNameTextBoxLocator);
        sendText(displayNameTextBox, "");
        sendText(displayNameTextBox, displayName);
        openProfileTab();
    }

    public void changeAbout(String about)
    {
        aboutTextBox = driver.findElement(aboutTextboxLocator);
        sendText(aboutTextBox, "");
        sendText(aboutTextBox, about);
        openProfileTab();
    }
}
