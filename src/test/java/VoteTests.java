import Objects.*;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.util.List;

public class VoteTests {

    private AndroidDriver driver;
    String username = "test@test.test";
    String password = "testtest";
    String location = "Cabella Ligure";
    String completeLocation = "Cabella Ligure, Province of Alessandria, Italy";

    String username_reports = "report-votes@test.test";
    String password_reports = "password";
    String location_reports = "Ronco Scrivia";
    String completeLocation_reports = "Ronco Scrivia, Metropolitan City of Genoa, Italy";

    @Before
    public void setUp() throws MalformedURLException {
        driver = CapabilitiesSetter.DriverCreator();
    }

    private void goToTestLocation(String username, String password, String location, String completeLocation) {
        new HomePage(driver).doLogin(username, password);
        new MapPage(driver).goToLocation(location, completeLocation);
    }

    private void loginReportAccountAndMakeReportThenLogout() throws InterruptedException {
        goToTestLocation(username_reports, password_reports, location_reports, completeLocation_reports);
        new MapPage(driver).clickAndAddReport("test", "test");
        AccountPage accountPage = new AccountPage(driver);
        accountPage.goToAccountPage();
        accountPage.doLogout();
    }

    public void openNewReport() {
        ListPage listPage = new ListPage(driver);
        listPage.goToList();
        listPage.getFirstListElement().click();
    }

    @Test
    public void checkVoteMyReportNotWorks() {
        goToTestLocation(username, password, location, completeLocation);
        new MapPage(driver).clickAndAddReport("test", "test");
        openNewReport();

        String result = new SingleReportPage(driver).votePositive();
        Assert.assertEquals(result, "No Button");
    }

    @Test
    public void checkVoteOtherReportWorks() throws InterruptedException {
        loginReportAccountAndMakeReportThenLogout(); // Make the report with another user before testing it

        goToTestLocation(username, password, location_reports, completeLocation_reports);
        new MapPage(driver).updateMakers();

        openNewReport();
        String result = new SingleReportPage(driver).votePositive();
        Assert.assertEquals(result, "Vote ok");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
