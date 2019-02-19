import Objects.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

public class ApprovedReportTests {

    private AndroidDriver driver;
    String username = "test@test.test";
    String password = "testtest";

    String username_vote1 = "report-votes@test.test";
    String username_vote2 = "report-votes-2@test.test";
    String username_vote3 = "report-votes-3@test.test";
    String password_voters = "password";
    String location_reports = "Ronco Scrivia";
    String completeLocation_reports = "Ronco Scrivia, GE, Italia";

    @Before
    public void setUp() throws MalformedURLException {
        driver = CapabilitiesSetter.DriverCreator();
    }

    private void goToTestLocation(String username, String password, String location, String completeLocation) {
        new HomePage(driver).doLogin(username, password);
        new MapPage(driver).goToLocation(location, completeLocation);
    }

    private void logout()throws InterruptedException{
        AccountPage accountPage = new AccountPage(driver);
        accountPage.goToAccountPage();
        accountPage.doLogout();
    }

    private void loginReportAccountAndMakeReportThenLogout() throws InterruptedException{
        goToTestLocation(username, password, location_reports, completeLocation_reports);
        new MapPage(driver).clickAndAddReport("Test", "Test");
        logout();
    }

    public void openNewReport() {
        ListPage listPage = new ListPage(driver);
        listPage.goToList();
        listPage.getFirstListElement().click();
    }

    public void voteReportPositive(String username) throws InterruptedException{
        goToTestLocation(username, password_voters, location_reports, completeLocation_reports);
        openNewReport();
        new SingleReportPage(driver).votePositive();
        ElementFinder.getConfirmButton(driver).click();
        driver.navigate().back();
        logout();
    }

    public void voteReportNegative(String username) throws InterruptedException{
        goToTestLocation(username, password_voters, location_reports, completeLocation_reports);
        openNewReport();
        new SingleReportPage(driver).voteNegative();
        ElementFinder.getConfirmButton(driver).click();
        driver.navigate().back();
        logout();
    }

    @Test
    public void checkApprovedReportWorks() throws InterruptedException {
        loginReportAccountAndMakeReportThenLogout(); // Make the report with another user before testing it
        voteReportPositive(username_vote1);
        voteReportPositive(username_vote2);
        voteReportPositive(username_vote3);
        goToTestLocation(username, password, location_reports, completeLocation_reports);
        openNewReport();
        SingleReportPage singlePage = new SingleReportPage(driver);
        Assert.assertEquals(singlePage.getApprevedState(), "Report approvato positivamente!" );
    }

    @Test
    public void checkRejectedReportWorks() throws InterruptedException {
        loginReportAccountAndMakeReportThenLogout(); // Make the report with another user before testing it
        voteReportNegative(username_vote1);
        voteReportNegative(username_vote2);
        voteReportNegative(username_vote3);
        goToTestLocation(username, password, location_reports, completeLocation_reports);
        openNewReport();
        SingleReportPage singlePage = new SingleReportPage(driver);
        Assert.assertEquals(singlePage.getNotApprevedState(), "Report approvato negativamente!" );
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
