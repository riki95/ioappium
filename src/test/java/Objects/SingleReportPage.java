package Objects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingleReportPage {
    private AndroidDriver driver;

    public SingleReportPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public String getReportTitleText() {
        try {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("title-singlereport")));
            return driver.findElementByAccessibilityId("title-singlereport").getText();

        }
        catch (Exception e) { return null; }
    }
}
