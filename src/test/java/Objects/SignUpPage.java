package Objects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage {
    private AndroidDriver driver;

    public SignUpPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement getSsnInput() {
        return ElementFinder.byId(driver, "ssn-signup");
    }

    public WebElement getEmailInput() {
        return ElementFinder.byId(driver, "signup-email");
    }

    public WebElement getPasswordInput() {
        return ElementFinder.byId(driver, "signup-password");
    }

    public WebElement getConfirmButton() {
        return ElementFinder.byId(driver, "signup-confirmbutton");
    }

    public WebElement getSignUpButton() {
        return ElementFinder.byId(driver, "signup-button");
    }

    public String getSuccessText() {
        return ElementFinder.byXpath(driver, "//*[@text='Registrazione effettuata con successo!']").getText();
    }

    public String getAlreadyRegisteredText() {
        return ElementFinder.byXpath(driver, "//*[@text='Utente o codice fiscale già registrato']").getText();
    }

    public WebElement getCheckbox() {
        return ElementFinder.byId(driver, "gdpr-checkbox");
    }

    public void doSignUp(String ssn, String email, String password) {
        getSsnInput().sendKeys(ssn);
        driver.hideKeyboard();

        getEmailInput().sendKeys(email);
        driver.hideKeyboard();

        getPasswordInput().sendKeys(password);
        driver.hideKeyboard();

        getConfirmButton().sendKeys(password);
        driver.hideKeyboard();

        ElementFinder.goToBottom(driver);

        getCheckbox().click();

        getSignUpButton().click();
    }
}
