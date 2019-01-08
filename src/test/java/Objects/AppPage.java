package Objects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppPage {
    private AndroidDriver driver;

    public AppPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement getListButton() {
        try {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//*[@text='Lista']")));
            return driver.findElementByXPath("//*[@text='Lista']");
        }
        catch (Exception e) { return null; }
    }
}