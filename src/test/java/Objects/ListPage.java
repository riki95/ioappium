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

    public void goToList() {
        ElementFinder.byXpath(driver, "//*[@text='Lista']").click();
    }

    public WebElement getFirstListElement() {
        return ElementFinder.byId(driver, "title-report");
    }

    public String getFirstElementText() {
        return getFirstListElement().getText();
    }

    public String getGoodNews() {
        return ElementFinder.byId(driver, "good-news-text").getText();
    }

    public void openFirstElementInList() {
        getFirstListElement().click();
    }
}
