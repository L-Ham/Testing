import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PrivacySettingsPage extends PageBase {
    PrivacySettingsPage(WebDriver driver) {
        super(driver);
    }

    By privacyTabLocator = By.id("tab-Safety & Privacy");
    WebElement privacyTab;

    By privacyFAQLinkLocator = By.xpath("//*[@id=\"tabsDiv\"]/div[2]/div/p/span/a");
    WebElement privacyFAQLink;

    By blockUserTextBoxLocator = By.id("blockUserInput2");
    WebElement blockUserTextBox;

    By blockUserButtonLocator = By.id("blockUserInput12");
    WebElement blockUserButton;

    By muteCommunityTextBoxLocator = By.id("blockUserInput3");
    WebElement muteCommunityTextBox;

    By muteCommunityButtonLocator = By.id("blockUserInput13");
    WebElement muteCommunityButton;

    By showUpInResultsButton = By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div/div[5]/div[2]/div/div/button");
    By personalizedAdsButton = By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div/div[6]/div[2]/div/div/button");

    By isAlcoholButton= By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div/div[8]/div[2]/div/div/button");
    By isDatingButton=By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div/div[9]/div[2]/div/div/button");
    By isGamblingButton=By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div/div[10]/div[2]/div/div/button");
    By isPregnancyButton=By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div/div[11]/div[2]/div/div/button");
    By isWeightLossButton=By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div/div[12]/div[2]/div/div/button");
    By twoFactorAuthButton=By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div/div[14]/div[2]/div/div/button");

    public void openPrivacyTab() {
        privacyTab = driver.findElement(privacyTabLocator);
        Clicking(privacyTab);
    }

    public void openPrivacyFAQ() {
        privacyFAQLink = driver.findElement(privacyFAQLinkLocator);
        explicitWait(10, privacyFAQLinkLocator);
        Clicking(privacyFAQLink);
    }

    public void blockUser(String username) {
        blockUserTextBox = driver.findElement(blockUserTextBoxLocator);
        blockUserTextBox.sendKeys(username);
        blockUserButton = driver.findElement(blockUserButtonLocator);
        Clicking(blockUserButton);
    }


    public void unblockUser(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> usernameElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='mb-2 flex items-center']//span[@class='inline-block flex-col']/span")));
        for (WebElement element : usernameElements) {
            if (element.getText().trim().equals(username)) {
                WebElement unblockButton = wait.until(ExpectedConditions.elementToBeClickable(element.findElement(By.xpath("./ancestor::div[@class='mb-2 flex items-center']//button[@id='blockUserInput32']"))));
                Clicking(unblockButton);
                return;
            }
        }
    }

    public void muteCommunity(String communityName) {
        muteCommunityTextBox = driver.findElement(muteCommunityTextBoxLocator);
        muteCommunityTextBox.sendKeys(communityName);
        muteCommunityButton = driver.findElement(muteCommunityButtonLocator);
        Clicking(muteCommunityButton);
    }

    public void unmuteCommunity(String communityName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> communityElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='mb-2 flex items-center']//span[@class='inline-block flex-col']/span")));
        for (WebElement element : communityElements) {
            if (element.getText().trim().equals(communityName)) {
                WebElement unmuteButton = wait.until(ExpectedConditions.elementToBeClickable(element.findElement(By.xpath("./ancestor::div[@class='mb-2 flex items-center']//button[@id='blockUserInput33']"))));
                Clicking(unmuteButton);
                return;
            }
        }
    }

    public void showUpInResults() {
        Clicking(driver.findElement(showUpInResultsButton));
    }

    public void personalizedAds() {
        Clicking(driver.findElement(personalizedAdsButton));
    }

    public void isAlcohol() {
        Clicking(driver.findElement(isAlcoholButton));
    }

    public void isDating() {
        Clicking(driver.findElement(isDatingButton));
    }

    public void isGambling() {
        Clicking(driver.findElement(isGamblingButton));
    }

    public void isPregnancy() {
        Clicking(driver.findElement(isPregnancyButton));
    }

    public void isWeightLoss() {
        Clicking(driver.findElement(isWeightLossButton));
    }

    public void twoFactorAuth() {
        Clicking(driver.findElement(twoFactorAuthButton));
    }




}
