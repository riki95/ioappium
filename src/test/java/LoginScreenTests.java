import Objects.AppPage;
import Objects.HomePage;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import java.net.MalformedURLException;

public class LoginScreenTests {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        driver = CapabilitiesSetter.DriverCreator();
    }

    @Test
    public void checkLoginWorks() throws InterruptedException {
        HomePage homepage = new HomePage(driver);
        homepage.doLogin();

        //Modify this when we implement users logged icon
        AppPage appPage = new AppPage(driver);
        Assert.assertEquals(appPage.getListButton().getText(), "Lista");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
