import Objects.Secret;
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

    public static void doSignUp(AndroidDriver driver, String ssnText, String emailText) throws InterruptedException {
        driver.findElementByAccessibilityId("signup-button").click();

        WebElement ssn = driver.findElementByAccessibilityId("ssn-signup");
        ssn.sendKeys(ssnText);
        driver.hideKeyboard();

        WebElement email = driver.findElementByAccessibilityId("signup-email");
        email.sendKeys(emailText);
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

        doSignUp(driver, Secret.getSsn(), Secret.getEmail());

        String successText = driver.findElementByXPath("//*[@text='Registrazione effettuata con successo!']").getText();
        Assert.assertEquals(successText, "Registrazione effettuata con successo!");
    }

    @Test
    public void checkWrongSn() throws InterruptedException {
        TimeUnit.SECONDS.sleep(7); // Wait for app to open

        doSignUp(driver, Secret.getSsn(), Secret.getEmail());

        String successText = driver.findElementByXPath("//*[@text='Utente o codice fiscale già registrato']").getText();
        Assert.assertEquals(successText, "Utente o codice fiscale già registrato");
    }

    @Test
    public void checkWrongEmail() throws InterruptedException {
        TimeUnit.SECONDS.sleep(7); // Wait for app to open

        doSignUp(driver, "abcdtf00a00d000g", Secret.getEmail());

        String successText = driver.findElementByXPath("//*[@text='Utente o codice fiscale già registrato']").getText();
        Assert.assertEquals(successText, "Utente o codice fiscale già registrato");
    }

    @After
    public void tearDown() {
        //driver.quit();
    }
}
