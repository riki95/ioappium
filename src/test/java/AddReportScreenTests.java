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

        TimeUnit.SECONDS.sleep(1);
        WebElement add_button = driver.findElementByAccessibilityId("button-add");
        add_button.click();

        add_button.click();
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void addReport() throws InterruptedException{
        TimeUnit.SECONDS.sleep(5); // Wait for app to open
        LoginScreenTests.doLogin(driver);

        TimeUnit.SECONDS.sleep(1);
        WebElement add_button = driver.findElementByAccessibilityId("button-add");
        add_button.click();

        TimeUnit.SECONDS.sleep(5); // Wait for app to open
        WebElement confirm_button = driver.findElementByAccessibilityId("button-confirm");
        confirm_button.click();

        TimeUnit.SECONDS.sleep(2); // Wait for app to open
        fillAddReport("titolo","descrizione");

        WebElement buttonSend = driver.findElementByAccessibilityId("button-send");
        buttonSend.click();
        buttonSend.click();

        driver.findElement(By.xpath("//*[@text='OK']")).click();

        String successText = driver.findElement(By.xpath("//*[@text='Segnalazione effettuata con successo!']")).getText();
        driver.findElement(By.xpath("//*[@text='OK']")).click();

        TimeUnit.SECONDS.sleep(2); // Wait for app to open

        Assert.assertEquals(successText, "Segnalazione effettuata con successo!");
    }

    private void fillAddReport(String title, String description) {
        WebElement inputTitle = driver.findElementByAccessibilityId("inputTitle");
        inputTitle.sendKeys(title);
        driver.hideKeyboard();

        WebElement inputDescr = driver.findElementByAccessibilityId("inputDescr");
        inputDescr.sendKeys(description);
        driver.hideKeyboard();

    }

    @After
    public void tearDown() {
        //driver.quit();
    }
}
