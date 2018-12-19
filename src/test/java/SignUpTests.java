import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class SignUpTests {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        driver = CapabilitiesSetter.DriverCreator();
    }

    public static void doSignUp(AndroidDriver driver) throws InterruptedException {
        driver.findElementByAccessibilityId("signup-button").click();

        WebElement ssn = driver.findElementByAccessibilityId("ssn-signup");
        ssn.sendKeys(Secret.getSsn());
        driver.hideKeyboard();

        WebElement email = driver.findElementByAccessibilityId("signup-email");
        email.sendKeys(Secret.getEmail());
        driver.hideKeyboard();

        WebElement password = driver.findElementByAccessibilityId("signup-password");
        password.sendKeys(Secret.getPassword());
        driver.hideKeyboard();

        WebElement passwordConfirm = driver.findElementByAccessibilityId("signup-confirmbutton");
        passwordConfirm.sendKeys(Secret.getPassword());
        driver.hideKeyboard();

        driver.findElementByAccessibilityId("signup-button").click();
    }

    @Test
    public void checkSignupWorks() throws InterruptedException {
        TimeUnit.SECONDS.sleep(7); // Wait for app to open

       doSignUp(driver);

        String successText = driver.findElementByXPath("//*[@text='Registrazione effettuata con successo!']").getText();
        Assert.assertEquals(successText, "Registrazione effettuata con successo!");
    }

    @After
    public void tearDown() {
        //driver.quit();
    }
}
