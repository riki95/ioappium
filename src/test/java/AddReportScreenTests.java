import Objects.AddReportPage;
import Objects.HomePage;
import Objects.MapPage;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddReportScreenTests {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        driver = CapabilitiesSetter.DriverCreator();
    }

    @Test
    public void undoReport() {
        HomePage homepage = new HomePage(driver);
        homepage.doLogin();

        MapPage mapPage = new MapPage(driver);
        WebElement addReportButton = mapPage.getAddReportButton();
        // clic one time to add and one time to undo cause + button is replaced by undo one
        addReportButton.click();
        addReportButton.click();
    }

    @Test
    public void addReport() {
        HomePage homepage = new HomePage(driver);
        homepage.doLogin();

        MapPage mapPage = new MapPage(driver);
        mapPage.getAddReportButton().click();
        mapPage.getConfirmReportButton().click();

        AddReportPage addReportPage = new AddReportPage(driver);
        addReportPage.getInputTitle().sendKeys("titolo");
        driver.hideKeyboard();

        addReportPage.getInputDescr().sendKeys("descrizione");
        driver.hideKeyboard();

        WebElement buttonSend = addReportPage.getButtonSend();
        buttonSend.click();
        buttonSend.click();

        addReportPage.getConfirmReportButton().click();
        String successText = driver.findElement(By.xpath("//*[@text='Segnalazione effettuata con successo!']")).getText();
        addReportPage.getConfirmReportButton().click();

        Assert.assertEquals(successText, "Segnalazione effettuata con successo!");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
