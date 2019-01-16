import Objects.AccountPage;
import Objects.AppPage;
import Objects.HomePage;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

public class AccountPageTests {

    private AndroidDriver driver;

    String username = "test@test.test";
    String password = "testtest";

    @Before
    public void setUp() throws MalformedURLException {
        driver = CapabilitiesSetter.DriverCreator();
    }

    @Test
    public void checkAccountPageShowsCorrectEmail() {
        HomePage homepage = new HomePage(driver);
        homepage.doLogin(username, password);

        new AppPage(driver).goToAccountPage();
        AccountPage accountPage = new AccountPage(driver);

        Assert.assertEquals(accountPage.getEmailText(), username);
    }

    @Test
    public void checkLogoutWorks() {
        HomePage homepage = new HomePage(driver);
        homepage.doLogin(username, password);

        new AppPage(driver).goToAccountPage();
        AccountPage accountPage = new AccountPage(driver);
        accountPage.doLogout();

        accountPage.clicConfirmLogout();
        Assert.assertEquals(homepage.getSignUpButtonText(), "REGISTRATI");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
