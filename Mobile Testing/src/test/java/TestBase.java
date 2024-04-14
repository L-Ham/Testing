import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {

    protected AndroidDriver<MobileElement> driver;

    @BeforeTest
    public void setup() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3a");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        desiredCapabilities.setCapability("appium:disableIdLocatorAutocompletion", true);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.0.0");
        desiredCapabilities.setCapability("appPackage", "com.example.reddit_bel_ham");
        desiredCapabilities.setCapability("appActivity", "com.example.reddit_bel_ham.MainActivity");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723"), desiredCapabilities);
    }




}
