package Objects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private AndroidDriver driver;

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement getDemoButton() {
        try {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("demo-button")));
            return driver.findElementByAccessibilityId("demo-button");

        }
        catch (Exception e) { return null; }
    }

    public WebElement getLoginEmailInput() {
        try {
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("login-email")));
            return driver.findElementByAccessibilityId("login-email");

        }
        catch (Exception e) { return null; }
    }

    public WebElement getLoginPasswordInput() {
        try {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("login-password")));
            return driver.findElementByAccessibilityId("login-password");

        }
        catch (Exception e) { return null; }
    }

    public WebElement getLoginButton() {
        try {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("login-button")));
            return driver.findElementByAccessibilityId("login-button");

        }
        catch (Exception e) { return null; }
    }

    public WebElement getSignUpButton() {
        try {
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("signup-button")));
            return driver.findElementByAccessibilityId("signup-button");

        }
        catch (Exception e) { return null; }
    }

    public String getSignUpButtonText() {
        return getSignUpButton().getText();
    }

    public void goToDemo() {
        getLoginEmailInput(); //Just used to wait the app to open
        goToBottom();
        getDemoButton().click();
    }

    public SignUpPage goToSignUp() {
        getSignUpButton().click();
        return new SignUpPage(driver);
    }

    public void goToBottom() {
        new TouchAction<>(driver).press(PointOption.point(538, 1400))
                .waitAction().moveTo(PointOption.point(538, 100))
                .release().perform();
    }


    public void doLogin(String username, String password) {
        getLoginEmailInput().sendKeys(username);
        driver.hideKeyboard();

        getLoginPasswordInput().sendKeys(password);
        driver.hideKeyboard();

        WebElement login_button = getLoginButton();
        login_button.click();
        login_button.click();
    }
}