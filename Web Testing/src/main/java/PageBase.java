import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {

    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    public static void Clicking(WebElement element)
    {
        element.click();
    }

    public static void sendText(WebElement element, String text)
    {
        element.sendKeys(text);
    }

    public void explicitWait(int seconds, By locator)
    {
        new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void implicitWait(int seconds)
    {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
}
