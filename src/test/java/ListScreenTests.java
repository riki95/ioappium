import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class ListScreenTests {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        driver = CapabilitiesSetter.DriverCreator();
    }

    @Test
    public void checkTitleNameInListEqualToSingleReportScreen() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5); // Wait for app to open

        WebElement textBelow = driver.findElementByAccessibilityId("text-below");
        textBelow.click();

        WebElement demoButton = driver.findElementByAccessibilityId("demo-button");
        demoButton.click();

        WebElement listButton = driver.findElementByXPath("//*[@text='Lista']");
        listButton.click();

        WebElement firstElement = driver.findElementByAccessibilityId("title-report");
        String titleInList = firstElement.getText();
        firstElement.click();

        WebElement singleElement = driver.findElementByAccessibilityId("title-singlereport");
        String singleElementTitle = singleElement.getText();

        Assert.assertEquals(titleInList, singleElementTitle);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
