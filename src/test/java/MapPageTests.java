import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;

import java.net.MalformedURLException;

public class MapPageTests {

    private AndroidDriver driver;

    String username = "test@test.test";
    String password = "testtest";

    @Before
    public void setUp() throws MalformedURLException {
        driver = CapabilitiesSetter.DriverCreator();
    }

}