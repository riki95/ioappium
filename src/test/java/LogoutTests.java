import Objects.AccountPage;
import Objects.AppPage;
import Objects.HomePage;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

public class LogoutTests {

    private AndroidDriver driver;

    String username = "test@test.test";
    String password = "testtest";

    @Before
    public void setUp() throws MalformedURLException {
        driver = CapabilitiesSetter.DriverCreator();
    }

    @Test
    public void checkLogoutWorks() throws InterruptedException {
        HomePage homepage = new HomePage(driver);
        homepage.doLogin(username, password);

        new AppPage(driver).goToAccountPage();
        AccountPage accountPage = new AccountPage(driver);

        //Scroll down to Logout Button and Clic

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
