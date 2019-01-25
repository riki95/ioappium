package Objects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MapPage {
    private AndroidDriver driver;

    public MapPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement getAddReportButton() {
        return ElementFinder.byId(driver, "button-add");
    }

    public WebElement getConfirmReportButton() {
        return ElementFinder.byId(driver, "button-confirm");
    }

    public WebElement getSearchBar() {
        return ElementFinder.byXpath(driver, "//*[@class='android.widget.EditText']");
    }

    public void clickOnZoomButton() {
        ElementFinder.byId(driver, "zoom-button").click();
    }

    public void clickOnUpdateMakersButton() {
        ElementFinder.byId(driver, "update-markers-button").click();
    }

    public void clickOnResult(String completeLocation) {
        ElementFinder.byXpath(driver, "//*[@text='" + completeLocation + "']").click();
    }

    public void goToLocation(String location, String completeLocation) {
        getSearchBar().sendKeys(location);
        clickOnResult(completeLocation);
    }

    public String clickAndAddReport(String title, String descr) {
        getAddReportButton().click();
        getConfirmReportButton().click();
        return new AddReportPage(driver).addReport(title, descr);
    }

    public void updateMakers() {
        clickOnZoomButton();
        clickOnUpdateMakersButton();
    }

    public void clickAddAndUndo() {
        getAddReportButton().click();
        getAddReportButton().click();
    }
}