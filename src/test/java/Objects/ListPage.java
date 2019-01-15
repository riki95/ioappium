package Objects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListPage {
    private AndroidDriver driver;

    public ListPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement getFirstListElement() {
        try {
            new WebDriverWait(driver, 7)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("title-report")));
            return driver.findElementByAccessibilityId("title-report");

        }
        catch (Exception e) { return null; }
    }

    public String getFirstElementText() {
        return getFirstListElement().getText();
    }

    public void clicFirstElementInList() {
        getFirstListElement().click();
    }
}
