import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Objects.HomePage;

import java.net.MalformedURLException;

public class HomeScreenTests {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        driver = CapabilitiesSetter.DriverCreator();
    }

    @Test
    public void demoButtonWorks() {
        HomePage homepage = new HomePage(driver);
        homepage.goToDemo();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}