import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ListScreenTests {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("udid", "emulator-5554");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "8.1");
        desiredCapabilities.setCapability("deviceName", "NEXUS_5X_API_27");
        desiredCapabilities.setCapability("appPackage", "com.zenaclean");
        desiredCapabilities.setCapability("appActivity", ".MainActivity");
        desiredCapabilities.setCapability("skipUnlock","true");
        desiredCapabilities.setCapability("noReset","false");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
    }

    @Test
    public void clicButtonAndOpenModal() throws InterruptedException {
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
        //driver.quit();
    }
}
