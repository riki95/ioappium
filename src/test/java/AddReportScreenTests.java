import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class AddReportScreenTests {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        driver = CapabilitiesSetter.DriverCreator();
    }

    @Test
    public void undoReport() throws InterruptedException{
        TimeUnit.SECONDS.sleep(5); // Wait for app to open
        LoginScreenTests.doLogin(driver);

        TimeUnit.SECONDS.sleep(1); // Wait for app to open
        WebElement add_button = driver.findElementByAccessibilityId("button-add");
        add_button.click();

        add_button.click();
        Assert.assertEquals(add_button.getText(), "+");
    }

    @After
    public void tearDown() {
        //driver.quit();
    }
}
