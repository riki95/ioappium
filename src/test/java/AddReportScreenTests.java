import Objects.AddReportPage;
import Objects.HomePage;
import Objects.MapPage;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;

public class AddReportScreenTests {

    private AndroidDriver driver;
    String username = "test@test.test";
    String password = "testtest";

    @Before
    public void setUp() throws MalformedURLException {
        driver = CapabilitiesSetter.DriverCreator();
    }

    @Test
    public void checkUndoReportWorks() {
        HomePage homepage = new HomePage(driver);
        homepage.doLogin(username, password);

        MapPage mapPage = new MapPage(driver);
        mapPage.clicAddReportButton();
        mapPage.clicUndoReportButton();
    }

    @Test
    public void checkAddReportWorks() {
        HomePage homepage = new HomePage(driver);
        homepage.doLogin(username, password);

        MapPage mapPage = new MapPage(driver);
        String result = mapPage.clickAndAddReport("test", "test");

        Assert.assertEquals(result, "Segnalazione effettuata con successo!");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
