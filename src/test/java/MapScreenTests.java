import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class MapScreenTests {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        driver = CapabilitiesSetter.DriverCreator();
    }

    @Test
    public void clickOnMarkerWorks() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5); // Wait for app to open

        WebElement marker = driver.findElementByXPath("//android.view.View[@content-desc=\"Google Map\"]/android.view.View[2]");
        marker.click();
    }

    @After
    public void tearDown() {
        //drive
    }
}