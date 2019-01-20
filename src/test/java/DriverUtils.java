import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//TODO Refactor every single getter with this functions
public class DriverUtils {
    public static WebElement elementById(AndroidDriver driver, String accessibilityId) {
        try {
            new WebDriverWait(driver, 7)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(accessibilityId)));
            return driver.findElementByAccessibilityId(accessibilityId);

        }
        catch (Exception e) { return null; }
    }

    private WebElement elementByXpath(AndroidDriver driver, String xPath) {
        try {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath(xPath)));
            return driver.findElementByXPath(xPath);
        }
        catch (Exception e) { return null; }
    }
}
