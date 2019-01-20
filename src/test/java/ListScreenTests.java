import Objects.AppPage;
import Objects.HomePage;
import Objects.ListPage;
import Objects.SingleReportPage;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;

public class ListScreenTests {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        driver = CapabilitiesSetter.DriverCreator();
    }

    @Test
    public void checkTitleNameInListEqualToSingleReportScreen() {
        HomePage homePage = new HomePage(driver);
        homePage.goToDemo();

        AppPage appPage = new AppPage(driver);
        appPage.goToList();

        ListPage listPage = new ListPage(driver);
        String firstElementTitle = listPage.getFirstElementText();
        listPage.openFirstElementInList();

        SingleReportPage singleReportPage = new SingleReportPage(driver);
        Assert.assertEquals(firstElementTitle, singleReportPage.getReportTitleText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
