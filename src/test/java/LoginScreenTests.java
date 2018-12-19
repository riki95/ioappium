import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class LoginScreenTests {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        driver = CapabilitiesSetter.DriverCreator2();
    }

    @Test
    public void checkLoginWorks() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5); // Wait for app to open

        WebElement text_input = driver.findElementByAccessibilityId("login-email");
        text_input.sendKeys(Secret.getEmail());
        driver.hideKeyboard();

        WebElement password_input = driver.findElementByAccessibilityId("login-password");
        password_input.sendKeys(Secret.getPassword());
        driver.hideKeyboard();

        TimeUnit.SECONDS.sleep(2);
        WebElement login_button = driver.findElementByAccessibilityId("login-button");
        login_button.click();
        login_button.click();

        WebElement listButton = driver.findElementByXPath("//*[@text='Lista']");
        Assert.assertEquals(listButton.getText(), "Lista");
    }

    @After
    public void tearDown() {
        //driver.quit();
    }
}
