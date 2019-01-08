package Objects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class AppPage {
    private AndroidDriver driver;

    public AppPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement getListButton() {
        return driver.findElementByXPath("//*[@text='Lista']");
    }
}