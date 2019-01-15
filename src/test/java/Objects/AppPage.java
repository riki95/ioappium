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

    public WebElement getMapButton() {
        try {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//*[@text='Mappa']")));
            return driver.findElementByXPath("//*[@text='Mappa']");
        }
        catch (Exception e) { return null; }
    }

    public WebElement getListButton() {
        try {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//*[@text='Lista']")));
            return driver.findElementByXPath("//*[@text='Lista']");
        }
        catch (Exception e) { return null; }
    }

    public WebElement getAccountButton() {
        try {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//*[@text='Account']")));
            return driver.findElementByXPath("//*[@text='Account']");
        }
        catch (Exception e) { return null; }
    }

    public void goToList() {
        getListButton().click();
    }

    public String getListButtonText() {
        return getListButton().getText();
    }

    public void goToAccountPage() {
        getAccountButton().click();
    }
}