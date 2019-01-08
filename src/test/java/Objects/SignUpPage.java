package Objects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {
    private AndroidDriver driver;

    public SignUpPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement getSsnInput() {
        try {
            new WebDriverWait(driver, 7)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("ssn-signup")));
            return driver.findElementByAccessibilityId("ssn-signup");

        }
        catch (Exception e) { return null; }
    }

    public WebElement getEmailInput() {
        try {
            new WebDriverWait(driver, 7)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("signup-email")));
            return driver.findElementByAccessibilityId("signup-email");

        }
        catch (Exception e) { return null; }
    }

    public WebElement getPasswordInput() {
        try {
            new WebDriverWait(driver, 7)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("signup-password")));
            return driver.findElementByAccessibilityId("signup-password");

        }
        catch (Exception e) { return null; }
    }

    public WebElement getConfirmButton() {
        try {
            new WebDriverWait(driver, 7)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("signup-confirmbutton")));
            return driver.findElementByAccessibilityId("signup-confirmbutton");

        }
        catch (Exception e) { return null; }
    }

    public WebElement getSignUpButton() {
        try {
            new WebDriverWait(driver, 7)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("signup-button")));
            return driver.findElementByAccessibilityId("signup-button");

        }
        catch (Exception e) { return null; }
    }

    public WebElement getSuccessText() {
        try {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//*[@text='Registrazione effettuata con successo!']")));
            return driver.findElementByXPath("//*[@text='Registrazione effettuata con successo!']");

        }
        catch (Exception e) { return null; }
    }

    public WebElement getAlreadyRegisteredText() {
        try {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//*[@text='Utente o codice fiscale già registrato']")));
            return driver.findElementByXPath("//*[@text='Utente o codice fiscale già registrato']");

        }
        catch (Exception e) { return null; }
    }
}
