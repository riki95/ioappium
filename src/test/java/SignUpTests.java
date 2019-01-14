import Objects.HomePage;
import Objects.User;
import Objects.SignUpPage;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;

public class SignUpTests {

    private AndroidDriver driver;
    String ssn = "PPPPPP00P00P000P";

    @Before
    public void setUp() throws MalformedURLException {
        driver = CapabilitiesSetter.DriverCreator();
    }

    public static void doSignUp(AndroidDriver driver, SignUpPage signUpPage, String ssn, String email, String password) {
        signUpPage.getSsnInput().sendKeys(ssn);
        driver.hideKeyboard();

        signUpPage.getEmailInput().sendKeys(email);
        driver.hideKeyboard();

        signUpPage.getPasswordInput().sendKeys(password);
        driver.hideKeyboard();

        signUpPage.getConfirmButton().sendKeys(password);
        driver.hideKeyboard();

        signUpPage.getCheckbox().click();

        signUpPage.getSignUpButton().click();
    }

    @Test
    public void checkSignupWorks() {
        new HomePage(driver).getSignUpButton().click();
        SignUpPage signUpPage = new SignUpPage(driver);

        User user = new User();
        doSignUp(driver, signUpPage, user.getSsn(), user.getEmail(), user.getPassword());

        Assert.assertEquals(signUpPage.getSuccessText().getText(), "Registrazione effettuata con successo!");
    }

    @Test
    public void checkWrongSn() {
        new HomePage(driver).getSignUpButton().click();
        SignUpPage signUpPage = new SignUpPage(driver);

        User user = new User();
        doSignUp(driver, signUpPage, ssn, user.getEmail(), user.getPassword());

        Assert.assertEquals(signUpPage.getAlreadyRegisteredText().getText(), "Utente o codice fiscale già registrato");
    }

    @Test
    public void checkWrongEmail() {
        new HomePage(driver).getSignUpButton().click();
        SignUpPage signUpPage = new SignUpPage(driver);

        User user = new User();
        doSignUp(driver, signUpPage, user.getSsn(), "test@test.test", user.getPassword());

        Assert.assertEquals(signUpPage.getAlreadyRegisteredText().getText(), "Utente o codice fiscale già registrato");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
