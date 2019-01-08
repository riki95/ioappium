import Objects.AppPage;
import Objects.HomePage;
import Objects.ListPage;
import Objects.SingleReportPage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class ListScreenTests {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        driver = CapabilitiesSetter.DriverCreator();
    }

    @Test
    public void checkTitleNameInListEqualToSingleReportScreen() throws InterruptedException {
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
