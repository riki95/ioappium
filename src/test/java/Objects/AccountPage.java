package Objects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {
    private AndroidDriver driver;

    public AccountPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement getLogoutButton() {
        try {
            new WebDriverWait(driver, 7)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("logout-button")));
            return driver.findElementByAccessibilityId("logout-button");

        }
        catch (Exception e) { return null; }
    }

    public WebElement getResetButton() {
        try {
            new WebDriverWait(driver, 7)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("reset-button")));
            return driver.findElementByAccessibilityId("reset-button");

        }
        catch (Exception e) { return null; }
    }

}
