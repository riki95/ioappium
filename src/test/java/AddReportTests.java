import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class AddReportTests {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        driver = CapabilitiesSetter.DriverCreator();
    }

    @Test
    public void clicButtonAndOpenModal() throws InterruptedException{
        TimeUnit.SECONDS.sleep(5); // Wait for app to open

        // Clic on + button
        WebElement addReportButton = driver.findElementByXPath("//*[@text='+']");
        addReportButton.click();

        // Wait for modal to open and then identify title
        TimeUnit.SECONDS.sleep(5);
        String titleText = driver.findElement(By.xpath("//*[@text='Titolo']")).getAttribute("text");

        Assert.assertEquals("Titolo", titleText);
    }

    //Test not working due to bad usage of IDs on React
    @Test
    public void addNewReport() throws InterruptedException{
        TimeUnit.SECONDS.sleep(5); // Wait for app to open

        // Clic on + button
        WebElement addReportButton = driver.findElementByXPath("//*[@text='+']");
        addReportButton.click();

        // Identify title form and input "titolo di prova"
        TimeUnit.SECONDS.sleep(5);
        WebElement titleInput = driver.findElementByAccessibilityId("inputTitle");
        //titleInput.clear();
        titleInput.sendKeys("titolo di prova");
        driver.hideKeyboard();

        TimeUnit.SECONDS.sleep(5);
        // Identify description form and input "descrizione di prova"
        WebElement descriptionInput = driver.findElementByAccessibilityId("inputDescr");
        //descriptionInput.clear();
        //TimeUnit.SECONDS.sleep(1);
        descriptionInput.sendKeys("descrizione di prova");
        driver.hideKeyboard();

        // Clic on "Invia", wait for popup and check "ok"
        TimeUnit.SECONDS.sleep(5);
        //WebElement buttonSend = driver.findElementByAccessibilityId("buttonSend");
        WebElement buttonSend = driver.findElementByXPath("//*[@text='Invia']");
        buttonSend.click();
        buttonSend.click();
        TimeUnit.SECONDS.sleep(5);

        WebElement okButton = driver.findElementByXPath("//*[@text='OK']");
        String okText = okButton.getText();
        Assert.assertEquals(okText, "OK");

    }

    @After
    public void tearDown() {
        //driver.quit();
    }
}
