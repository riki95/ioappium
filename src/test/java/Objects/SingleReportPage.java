package Objects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingleReportPage {
    private AndroidDriver driver;

    public SingleReportPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public String getReportTitleText() {
        return ElementFinder.byId(driver, "title-singlereport").getText();
    }

    public String votePositive() {
        try {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("vote-up")));
            driver.findElementByAccessibilityId("vote-up").click();
            ElementFinder.getConfirmButton(driver);
            return "Vote ok";
        }
        catch (Exception e) { return "No Button"; }
    }
}
