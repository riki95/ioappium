import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class HomeScreenTests {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        driver = CapabilitiesSetter.DriverCreator();
    }

    @Test
    public void demoButtonWorks() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5); // Wait for app to open

        WebElement textBelow = driver.findElementByAccessibilityId("text-below");
        textBelow.click();

        WebElement demoButton = driver.findElementByAccessibilityId("demo-button");
        demoButton.click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}