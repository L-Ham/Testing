import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestBase
{
    protected WebDriver driver;

    @BeforeTest
    public void setup()
    {
        driver = new EdgeDriver();
        driver.manage().window().maximize();

    }

    public void implicitWait(int seconds)
    {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public void explicitWait(int seconds, By locator)
    {
        new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }





    @AfterTest
    public void quit()
    {
        driver.quit();
    }
}
