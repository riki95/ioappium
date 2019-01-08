import Objects.HomePage;
import Objects.Secret;
import Objects.SignUpPage;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;

public class SignUpTests {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        driver = CapabilitiesSetter.DriverCreator();
    }

    public static void doSignUp(AndroidDriver driver, SignUpPage signUpPage, String ssnText, String emailText) {

        signUpPage.getSsnInput().sendKeys(ssnText);
        driver.hideKeyboard();

        signUpPage.getEmailInput().sendKeys(emailText);
        driver.hideKeyboard();

        signUpPage.getPasswordInput().sendKeys(Secret.getPassword());
        driver.hideKeyboard();

        signUpPage.getConfirmButton().sendKeys(Secret.getPassword());
        driver.hideKeyboard();

        signUpPage.getSignUpButton().click();
    }

    @Test
    public void checkSignupWorks() {
        new HomePage(driver).getSignUpButton().click();
        SignUpPage signUpPage = new SignUpPage(driver);

        doSignUp(driver, signUpPage, Secret.getSsn(), Secret.getEmail());

        Assert.assertEquals(signUpPage.getSuccessText().getText(), "Registrazione effettuata con successo!");
    }

    @Test
    public void checkWrongSn() {
        new HomePage(driver).getSignUpButton().click();
        SignUpPage signUpPage = new SignUpPage(driver);

        doSignUp(driver, signUpPage, Secret.getSsn(), Secret.getEmail());

        Assert.assertEquals(signUpPage.getAlreadyRegisteredText().getText(), "Utente o codice fiscale già registrato");
    }

    @Test
    public void checkWrongEmail() {
        new HomePage(driver).getSignUpButton().click();
        SignUpPage signUpPage = new SignUpPage(driver);

        doSignUp(driver, signUpPage, "abcdtf00a00d000g", Secret.getEmail());

        Assert.assertEquals(signUpPage.getAlreadyRegisteredText().getText(), "Utente o codice fiscale già registrato");
    }

    @After
    public void tearDown() {
        //driver.quit();
    }
}
