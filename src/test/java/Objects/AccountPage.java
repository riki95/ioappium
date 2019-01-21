package Objects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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

    public WebElement getConfirmPassword() {
        try {
            new WebDriverWait(driver, 7)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("account-confirm-password")));
            return driver.findElementByAccessibilityId("account-confirm-password");

        }
        catch (Exception e) { return null; }
    }

    private WebElement getConfirmLogoutButton() {
        try {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//*[@text='OK']")));
            return driver.findElementByXPath("//*[@text='OK']");
        }
        catch (Exception e) { return null; }
    }

    public WebElement getEmail() {
        try {
            new WebDriverWait(driver, 7)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("account-email")));
            return driver.findElementByAccessibilityId("account-email");

        }
        catch (Exception e) { return null; }
    }

    public void goToBottom() {
        new TouchAction<>(driver).press(PointOption.point(538, 1100))
                .waitAction().moveTo(PointOption.point(538, 100))
                .release().perform();
    }

    public void doLogout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);

        goToBottom();
        getLogoutButton().click();
        getConfirmLogoutButton().click();
    }
    
    public String getEmailText() {
        return getEmail().getText();
    }
}
