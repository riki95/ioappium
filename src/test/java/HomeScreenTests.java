import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Objects.HomePage;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class HomeScreenTests {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        driver = CapabilitiesSetter.DriverCreator();
    }

    @Test
    public void demoButtonWorks() {
        HomePage homepage = new HomePage(driver);
        homepage.getTextBelow().click();
        homepage.getDemoButton().click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}