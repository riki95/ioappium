import Objects.*;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;

import java.net.MalformedURLException;


public class SearchReportsInLocation {

    String badLocation = "New York";
    String goodLocation = "Genova";
    String completeBadLocation = "New York, Stati Uniti";
    String completeGoodLocation = "Genova, GE, Italia";
    String goodNews = "Buone notizie!";

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        driver = CapabilitiesSetter.DriverCreator();
    }

    @Test
    public void checkReportAbsenceInNewLocation() {
        HomePage homePage = new HomePage(driver);
        homePage.goToDemo();

        MapPage mapPage =  new MapPage(driver);
        mapPage.goToLocation(badLocation, completeBadLocation);
        mapPage.clickOnUpdateMakersButton();

        ListPage listPage = new ListPage(driver);
        listPage.goToList();

        Assert.assertEquals(goodNews, listPage.getGoodNewsText());
    }

    @Test
    public void checkReportInNewLocation() {
        HomePage homePage = new HomePage(driver);
        homePage.goToDemo();

        MapPage mapPage =  new MapPage(driver);
        mapPage.goToLocation(goodLocation, completeGoodLocation);
        mapPage.clickOnUpdateMakersButton();

        ListPage listPage = new ListPage(driver);
        listPage.goToList();
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