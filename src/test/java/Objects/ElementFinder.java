package Objects;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementFinder {
    public static WebElement byId(AndroidDriver driver, String accessibilityId) {
        try {
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(accessibilityId)));
            return driver.findElementByAccessibilityId(accessibilityId);

        }
        catch (Exception e) { return null; }
    }

    public static WebElement byXpath(AndroidDriver driver, String xPath) {
        try {
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath(xPath)));
            return driver.findElementByXPath(xPath);
        }
        catch (Exception e) { return null; }
    }

    public static WebElement getConfirmButton(AndroidDriver driver) {
        return ElementFinder.byXpath(driver,"//*[@text='OK']");
    }

    public static void goToBottom(AndroidDriver driver) {
        new TouchAction<>(driver).press(PointOption.point(538, 1100))
                .waitAction().moveTo(PointOption.point(538, 100))
                .release().perform();
    }
}
