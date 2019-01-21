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
        try {
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("button-add")));
            return driver.findElementByAccessibilityId("button-add");
        }
        catch (Exception e) { return null; }
    }

    public WebElement getConfirmReportButton() {
        try {
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("button-confirm")));
            return driver.findElementByAccessibilityId("button-confirm");
        }
        catch (Exception e) { return null; }
    }

    public WebElement getSearchBar() {
        try {
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//*[@class='android.widget.EditText']")));
            return driver.findElement(By.xpath("//*[@class='android.widget.EditText']"));


        }
        catch (Exception e) { return null; }
    }

    public void clickOnZoomButton() {
        try {
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("zoom-button")));
            driver.findElementByAccessibilityId("zoom-button").click();
        }
        catch (Exception e) { }
    }

    public void clickOnUpdateMakersButton() {
        try {
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("update-markers-button")));
            driver.findElementByAccessibilityId("update-markers-button").click();
        }
        catch (Exception e) { }
    }

    public void clickOnResult(String completeLocation) {
        try {
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//*[@text='" + completeLocation + "']")));
            driver.findElement(MobileBy.xpath("//*[@text='" + completeLocation + "']")).click();
        }
        catch (Exception e) { }
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