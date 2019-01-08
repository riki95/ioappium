import Objects.AppPage;
import Objects.HomePage;
import Objects.ListPage;
import Objects.SingleReportPage;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
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
        homePage.getTextBelow().click();
        homePage.getDemoButton().click();

        AppPage appPage = new AppPage(driver);
        appPage.getListButton().click();

        ListPage listPage = new ListPage(driver);
        WebElement firstElement = listPage.getFirstListElement();
        String titleInList = firstElement.getText();
        firstElement.click();

        SingleReportPage singleReportPage = new SingleReportPage(driver);

        Assert.assertEquals(titleInList, singleReportPage.getReportTitle().getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
