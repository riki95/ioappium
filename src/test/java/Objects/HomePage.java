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
        return ElementFinder.byId(driver, "demo-button");
    }

    public WebElement getLoginEmailInput() {
        return ElementFinder.byId(driver, "login-email");
    }

    public WebElement getLoginPasswordInput() {
        return ElementFinder.byId(driver, "login-password");
    }

    public WebElement getLoginButton() {
        return ElementFinder.byId(driver, "login-button");
    }

    public WebElement getSignUpButton() {
        return ElementFinder.byId(driver, "login-button");
    }

    public String getSignUpButtonText() {
        return getSignUpButton().getText();
    }

    public void goToDemo() {
        getLoginEmailInput(); //Just used to wait the app to open
        ElementFinder.goToBottom(driver);
        getDemoButton().click();
    }

    public SignUpPage goToSignUp() {
        getSignUpButton().click();
        return new SignUpPage(driver);
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