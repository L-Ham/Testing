import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}
