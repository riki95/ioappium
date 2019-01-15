import Objects.AccountPage;
import Objects.AppPage;
import Objects.HomePage;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LogoutTests {

    private AndroidDriver driver;

    String username = "test@test.test";
    String password = "testtest";

    @Before
    public void setUp() throws MalformedURLException {
        driver = CapabilitiesSetter.DriverCreator();
    }

    @Test
    public void checkLogoutWorks() throws InterruptedException {
        HomePage homepage = new HomePage(driver);
        homepage.doLogin(username, password);

        new AppPage(driver).getAccountButton().click();
        AccountPage accountPage = new AccountPage(driver);


        TimeUnit.SECONDS.sleep(5);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
