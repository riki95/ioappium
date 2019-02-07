import Objects.AccountPage;
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

        AccountPage accountPage = new AccountPage(driver);
        accountPage.goToAccountPage();

        Assert.assertEquals(accountPage.getEmail(), username);
    }

    @Test
    public void checkLogoutWorks() throws InterruptedException {
        HomePage homepage = new HomePage(driver);
        homepage.doLogin(username, password);

        AccountPage accountPage = new AccountPage(driver);
        accountPage.goToAccountPage();
        accountPage.doLogout();

        Assert.assertEquals(homepage.getSignUpButtonText(), "REGISTRATI");
    }

    @Test
    public void checkCorrectBalance() {
        HomePage homepage = new HomePage(driver);
        homepage.doLogin(username, password);

        AccountPage accountPage = new AccountPage(driver);
        accountPage.goToAccountPage();

        Assert.assertEquals(accountPage.getAccountBalance(), "Saldo: 100 TOKEN");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
