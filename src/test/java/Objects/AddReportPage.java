package Objects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class AddReportPage {
    private AndroidDriver driver;

    public AddReportPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement getInputTitle() {
        return ElementFinder.byId(driver, "inputTitle");
    }

    public WebElement getInputDescr() {
        return ElementFinder.byId(driver,"inputDescr");
    }

    public WebElement getButtonSend() {
        return ElementFinder.byId(driver, "button-send");
    }

    public void sendInputTitle(String title) {
        getInputTitle().sendKeys(title);
    }

    public void sendInputDescr(String description) {
        getInputDescr().sendKeys(description);
    }

    public void clicButtonSend() {
        getButtonSend().click();
        getButtonSend().click();
    }

    public void clickConfirmReportButton() {
        ElementFinder.getConfirmButton(driver).click();
    }

    public String getSuccessText() {
        return ElementFinder.byXpath(driver, "//*[@text='Segnalazione effettuata con successo!']").getText();
    }

    public String addReport(String title, String description) {
        sendInputTitle(title);
        driver.hideKeyboard();

        sendInputDescr(description);
        driver.hideKeyboard();

        clicButtonSend();
        clickConfirmReportButton();

        String successText = getSuccessText();
        clickConfirmReportButton();
        return successText;
    }
}
