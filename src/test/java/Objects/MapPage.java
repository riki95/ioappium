package Objects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class MapPage {
    private AndroidDriver driver;

    public MapPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement getAddReportButton() {
        try {
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("button-add")));
            return driver.findElementByAccessibilityId("button-add");
        }
        catch (Exception e) { return null; }
    }

    public WebElement getConfirmReportButton() {
        try {
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("button-confirm")));
            return driver.findElementByAccessibilityId("button-confirm");
        }
        catch (Exception e) { return null; }
    }

    public void clicAddReportButton() {
        getAddReportButton().click();
    }

    public void clicUndoReportButton() {
        getAddReportButton().click();
    }

    public void clicConfirmReportButton() {
        getConfirmReportButton().click();
    }

    public void enterTestMarker() throws InterruptedException {
        clicTestMarker();
    }

    private void clicTestMarker() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(MobileBy.xpath("(//*[@contentDescription='Google Maps']/*[@class='android.view.View'])[1]")).click();
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(MobileBy.xpath("//*[@class='android.view.ViewGroup' and ./*[@class='android.view.ViewGroup' and ./*[@contentDescription='button-add']]]")).click();
    }

    //TODO - In test
    public void goToLocation(String testLocation) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys(testLocation);
        TimeUnit.SECONDS.sleep(3);
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Casale Monferrato, Province of Alessandria, Italy']")));
        driver.findElement(By.xpath("//*[@text='Casale Monferrato, Province of Alessandria, Italy']")).click();
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.xpath("//*[@text='Update']")).click();
        TimeUnit.SECONDS.sleep(3);

        new TouchAction<>(driver).tap(PointOption.point(533, 906)).perform();
        new TouchAction<>(driver).tap(PointOption.point(533, 906)).perform();
        TimeUnit.SECONDS.sleep(1);

        new TouchAction<>(driver).tap(PointOption.point(480, 760)).perform();
        new TouchAction<>(driver).tap(PointOption.point(480, 760)).perform();

        TimeUnit.SECONDS.sleep(1);

        new TouchAction<>(driver).tap(PointOption.point(470, 560)).perform();
        new TouchAction<>(driver).tap(PointOption.point(470, 560)).perform();

        TimeUnit.SECONDS.sleep(1);

        new TouchAction<>(driver).tap(PointOption.point(488, 588)).perform();
        new TouchAction<>(driver).tap(PointOption.point(488, 588)).perform();




    }
}