import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AccountSettingsPageTest extends TestBase {
    private AccountSettingsPage accountSettingsPage;
    private LoginPage loginPage;

    @BeforeTest
    public void getAccountSettingsPage() {
        accountSettingsPage = new AccountSettingsPage(driver);
        loginPage = new LoginPage(driver);
    }
    @DataProvider
    public Object[][] getValidData()
    {
        return new Object[][]
                {
                        {"sarraamuhammadd@gmail.com", "^##)_qg/r=yeP2*"},
                        {"/m4!2QHj!saysm4","/m4!2QHj!saysm423"}
                };
    }

    @DataProvider
    public Object[][] getInValidData()
    {
        return new Object[][]
                {
                        {"husseinhadidy1@gmail.com", "^##)_qg/r=yeP2*"} ,        //old email
                        {"sarraamuhammadd@gmail.com", "^##)_qg/r=yeP2*^##2*"}, //wrong password
                        {"/m4!2QHj!saysm4","/m4!2QHj!saysm4"} //matching password
                };
    }

    @Test
    public void verifyEmailTest() {
        loginPage.login("Ill_Initial_3945", "/m4!2QHj!saysm4");
        implicitWait(5);
        accountSettingsPage.openSettings();
        implicitWait(5);
        accountSettingsPage.driver.findElement(accountSettingsPage.confirmationEmailButtonLocator).click();
        implicitWait(5);
        loginPage.backToLogin();
    }

    @Test (dataProvider = "getInValidData", priority = 1)
    public void invalidChangeEmailTestCases(String email, String password) {
        loginPage.login("Ill_Initial_3945", "/m4!2QHj!saysm4");
        implicitWait(5);
        accountSettingsPage.openSettings();
        implicitWait(5);
        accountSettingsPage.changeEmail(email, password);
        implicitWait(5);
        Assert.assertTrue(driver.findElement(accountSettingsPage.invalidEmailTextLocator).isDisplayed());
        implicitWait(5);
        accountSettingsPage.logOut();
        implicitWait(5);
        loginPage.backToLogin();
    }

    @Test (dataProvider = "getValidData", priority = 2)
    public void validChangeEmailTestCases(String email, String password) {
        loginPage.login("Ill_Initial_3945", "/m4!2QHj!saysm4");
        implicitWait(5);
        accountSettingsPage.openSettings();
        implicitWait(5);
        accountSettingsPage.changeEmail(email, password);
        implicitWait(5);
        accountSettingsPage.logOut();
        implicitWait(5);
        loginPage.backToLogin();
    }

    @Test (dataProvider = "getInValidData", priority = 3)
    public void invalidChangePasswordTestCases(String oldPassword, String newPassword) {
        loginPage.login("Ill_Initial_3945", "/m4!2QHj!saysm4");
        implicitWait(5);
        accountSettingsPage.openSettings();
        implicitWait(5);
        accountSettingsPage.changePassword(oldPassword, newPassword, newPassword);
        implicitWait(5);
        Assert.assertTrue(driver.findElement(accountSettingsPage.invalidEmailTextLocator).isDisplayed());
        implicitWait(5);
        accountSettingsPage.logOut();
        implicitWait(5);
        loginPage.backToLogin();
    }

    @Test (dataProvider = "getValidData", priority = 2)
    public void validChangePasswordTestCases(String oldPassword, String newPassword) {
        loginPage.login("Ill_Initial_3945", "/m4!2QHj!saysm4");
        implicitWait(5);
        accountSettingsPage.openSettings();
        implicitWait(5);
        accountSettingsPage.changePassword(oldPassword, newPassword, newPassword);
        implicitWait(5);
        accountSettingsPage.logOut();
        implicitWait(5);
        loginPage.backToLogin();
    }

    @Test
    public void changeGenderToWomanTest() {
        loginPage.login("Marly", "1234567890");
        explicitWait(5, accountSettingsPage.userProfileLocator);
        accountSettingsPage.openSettings();
        explicitWait(5, accountSettingsPage.changeGenderButtonLocator);
        accountSettingsPage.changeGender("Woman");
        implicitWait(5);
    }

    @Test
    public void changeGenderToManTest() {
        loginPage.login("Ill_Initial_3945", "/m4!2QHj!saysm4");
        implicitWait(5);
        accountSettingsPage.openSettings();
        implicitWait(5);
        accountSettingsPage.changeGender("Man");
        implicitWait(5);
    }

    @Test
    public void changeLanguageTest() {
        loginPage.login("Marly", "1234567890");
        implicitWait(5);
        accountSettingsPage.openSettings();
        implicitWait(5);
        accountSettingsPage.changeLanguage("English");
        implicitWait(5);
    }

    @Test
    public void changeCountryTest() {
        loginPage.login("Ill_Initial_3945", "/m4!2QHj!saysm4");
        implicitWait(5);
        accountSettingsPage.openSettings();
        implicitWait(5);
        accountSettingsPage.changeCountry("Germany");
        implicitWait(5);
    }




}
