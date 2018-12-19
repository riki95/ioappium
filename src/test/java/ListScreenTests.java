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

        // Clic on + button
        WebElement listButton = driver.findElementByXPath("//*[@text='Lista']");
        listButton.click();

        // Identify title form and input "titolo di prova"
        TimeUnit.SECONDS.sleep(5);
        WebElement titleElement = driver.findElementByXPath("//*[@text='Problema stradale']");
        String titleReport = titleElement.getAttribute("text");
        titleElement.click();

        // Identify title form and input "titolo di prova"
        TimeUnit.SECONDS.sleep(5);
        WebElement title2Element = driver.findElementByXPath("//*[@text='Problema stradale']");
        String title2Report = title2Element.getAttribute("text");

        Assert.assertEquals(titleReport, title2Report);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
