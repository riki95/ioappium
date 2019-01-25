import Objects.HomePage;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

public class LoginScreenTests {

    private AndroidDriver driver;
    String username = "test@test.test";
    String password = "testtest";

    @Before
    public void setUp() throws MalformedURLException {
        driver = CapabilitiesSetter.DriverCreator();
    }

    @Test
    public void checkLoginWorks() {
        HomePage homepage = new HomePage(driver);
        homepage.doLogin(username, password);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
