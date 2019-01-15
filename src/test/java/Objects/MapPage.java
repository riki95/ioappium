package Objects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
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

    public void clicAddReportButton() {
        getAddReportButton().click();
    }

    public void clicUndoReportButton() {
        getAddReportButton().click();
    }

    public void clicConfirmReportButton() {
        getConfirmReportButton().click();
    }
}