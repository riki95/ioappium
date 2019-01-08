package Objects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddReportPage {
    private AndroidDriver driver;

    public AddReportPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement getInputTitle() {
        try {
            new WebDriverWait(driver, 7)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("inputTitle")));
            return driver.findElementByAccessibilityId("inputTitle");
        }
        catch (Exception e) { return null; }
    }

    public WebElement getInputDescr() {
        try {
            new WebDriverWait(driver, 7)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("inputDescr")));
            return driver.findElementByAccessibilityId("inputDescr");
        }
        catch (Exception e) { return null; }
    }

    public WebElement getButtonSend() {
        try {
            new WebDriverWait(driver, 7)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("button-send")));
            return driver.findElementByAccessibilityId("button-send");
        }
        catch (Exception e) { return null; }
    }

    public WebElement getConfirmReportButton() {
        try {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//*[@text='OK']")));
            return driver.findElementByXPath("//*[@text='OK']");
        }
        catch (Exception e) { return null; }
    }

}
