import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}
