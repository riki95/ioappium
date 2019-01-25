package Objects;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class AccountPage {
    private AndroidDriver driver;

    public AccountPage(AndroidDriver driver) {
        this.driver = driver;
    }

    private WebElement getLogoutButton() {
        return ElementFinder.byId(driver, "logout-button");
    }

    public String getEmail() {
        return ElementFinder.byId(driver, "account-email").getText();
    }

    public void doLogout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);

        ElementFinder.goToBottom(driver);
        getLogoutButton().click();
        ElementFinder.getConfirmButton(driver).click();
    }
}
