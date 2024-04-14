import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScreenBase {
    protected AndroidDriver<MobileElement> driver;

    public ScreenBase(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public static void Clicking(MobileElement element)
    {
        element.click();
    }

    public static void sendText(MobileElement element, String text)
    {
        element.sendKeys(text);
    }
    public void explicitWait( By locator)
    {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
