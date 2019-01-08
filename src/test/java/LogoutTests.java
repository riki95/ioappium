import Objects.HomePage;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class LogoutTests {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        driver = CapabilitiesSetter.DriverCreator();
    }

    @Test
    public void checkLogoutWorks() throws InterruptedException {
        HomePage homepage = new HomePage(driver);
        homepage.doLogin();

        driver.findElementByXPath("//*[@text='Account']").click();
        driver.findElementByAccessibilityId("logout-button").click();
        driver.findElementByXPath("//*[@text='OK']").click();

        //Once logged out, check that I'm in Homepage
        TimeUnit.SECONDS.sleep(3); // Wait for app to open
        WebElement textBelow = driver.findElementByAccessibilityId("text-below");
        Assert.assertEquals("SCORRI PER PIÙ INFORMAZIONI ", textBelow.getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
