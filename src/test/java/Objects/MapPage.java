package Objects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class MapPage {
    private AndroidDriver driver;

    public MapPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement getAddReportButton() {
        return driver.findElementByAccessibilityId("button-add");
    }

    public WebElement getConfirmReportButton() {
        return driver.findElementByAccessibilityId("button-confirm");
    }
}