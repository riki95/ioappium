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

public class AddReportScreenTests {

    private AndroidDriver driver;
    String username = "test@test.test";
    String password = "testtest";

    @Before
    public void setUp() throws MalformedURLException {
        driver = CapabilitiesSetter.DriverCreator();
    }

    @Test
    public void undoReport() {
        HomePage homepage = new HomePage(driver);
        homepage.doLogin(username, password);

        MapPage mapPage = new MapPage(driver);
        mapPage.clicAddReportButton();
        mapPage.clicUndoReportButton();
    }

    @Test
    public void addReport() {
        HomePage homepage = new HomePage(driver);
        homepage.doLogin(username, password);

        MapPage mapPage = new MapPage(driver);
        mapPage.clicAddReportButton();
        mapPage.clicConfirmReportButton();

        AddReportPage addReportPage = new AddReportPage(driver);
        addReportPage.sendInputTitle("titolo");
        driver.hideKeyboard();

        addReportPage.sendInputDescr("descrizione");
        driver.hideKeyboard();

        addReportPage.clicButtonSend();

        addReportPage.clicConfirmReportButton();
        String successText = addReportPage.getSuccessText();
        addReportPage.clicConfirmReportButton();

        Assert.assertEquals(successText, "Segnalazione effettuata con successo!");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
