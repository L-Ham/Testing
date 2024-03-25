import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterPageTest extends TestBase
{
    RegisterPage registerPage;

    @BeforeTest
    public void setUp()
    {
        registerPage = new RegisterPage(driver);
        driver.get("https://www.reddit.com/account/register/");
    }

    @Test
    public void validRegisterCases()
    {
        //registerPage.enterNewUserEmail("husseinhadidy1@gmail.com");
    }

    @DataProvider
    public Object[][] getInValidData() {
        return new Object[][]
                {
                        {"tg"}
                };
    }
    @Test (dataProvider = "getInValidData")
    public void invalidRegisterCases(String email)
    {

        registerPage.clearEmailTextbox();
        registerPage.enterNewUserEmail(email);
        registerPage.assertInvalidEmail();

    }
}




