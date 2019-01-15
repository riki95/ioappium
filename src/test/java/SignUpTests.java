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



    @Test
    public void checkSignupWorks() {
        new HomePage(driver).getSignUpButton().click();
        SignUpPage signUpPage = new SignUpPage(driver);

        User user = new User();
        SignUpPage signUp = new SignUpPage(driver);
        signUp.doSignUp(user.getSsn(), user.getEmail(), user.getPassword());

        Assert.assertEquals(signUpPage.getSuccessText().getText(), "Registrazione effettuata con successo!");
    }

    @Test
    public void checkWrongSn() {
        new HomePage(driver).getSignUpButton().click();
        SignUpPage signUpPage = new SignUpPage(driver);

        User user = new User();
        SignUpPage signUp = new SignUpPage(driver);
        signUp.doSignUp(ssn, user.getEmail(), user.getPassword());

        Assert.assertEquals(signUpPage.getAlreadyRegisteredText().getText(), "Utente o codice fiscale già registrato");
    }

    @Test
    public void checkWrongEmail() {
        new HomePage(driver).getSignUpButton().click();
        SignUpPage signUpPage = new SignUpPage(driver);

        User user = new User();
        SignUpPage signUp = new SignUpPage(driver);
        signUp.doSignUp(user.getSsn(), "test@test.test", user.getPassword());

        Assert.assertEquals(signUpPage.getAlreadyRegisteredText().getText(), "Utente o codice fiscale già registrato");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
