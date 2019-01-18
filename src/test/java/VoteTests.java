import Objects.*;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

public class VoteTests {

    private AndroidDriver driver;
    String username = "test@test.test";
    String password = "testtest";
    String username2 = "report-votes@test.test";
    String password2 = "password";
    String location = "Cabella Ligure";
    String completeLocation = "Cabella Ligure, Province of Alessandria, Italy";
    String location2 = "Ronco Scrivia";
    String completeLocation2 = "Ronco Scrivia, Metropolitan City of Genoa, Italy";

    @Before
    public void setUp() throws MalformedURLException {
        driver = CapabilitiesSetter.DriverCreator();
    }

    private void loginAccount1andMakeReport() throws InterruptedException {
        goToTestLocation(username2, password2, location2, completeLocation2);
        new MapPage(driver).clickAndAddReport("test", "test");
        new AppPage(driver).goToAccountPage();
        new AccountPage(driver).doLogout();
    }

    private void goToTestLocation(String username, String password, String location, String completeLocation) {
        HomePage homepage = new HomePage(driver);
        homepage.doLogin(username, password);

        MapPage mapPage = new MapPage(driver);
        mapPage.goToLocation(location, completeLocation);
    }

    @Test
    public void checkVoteMyReportNotWorks() {
        goToTestLocation(username, password, location, completeLocation);
        new MapPage(driver).clickAndAddReport("test", "test");
        new AppPage(driver).goToList();
        new ListPage(driver).getFirstListElement().click();

        String result = new SingleReportPage(driver).votePositive();
        Assert.assertEquals(result, "No Button");
    }

    @Test
    public void checkVoteOtherReportWorks() throws InterruptedException {
        loginAccount1andMakeReport();

        goToTestLocation(username, password, location2, completeLocation2);
        MapPage mapPage = new MapPage(driver);
        mapPage.clickOnZoomButton();
        mapPage.clickOnUpdateMakersButton();

        new AppPage(driver).goToList();
        new ListPage(driver).getFirstListElement().click();
        String result = new SingleReportPage(driver).votePositive();
        Assert.assertEquals(result, "Vote ok");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
