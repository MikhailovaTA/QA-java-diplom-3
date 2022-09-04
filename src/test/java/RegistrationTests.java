import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pageobject.RegistrationElements;

import static com.codeborne.selenide.Selenide.open;
import static config.Url.BASE_URL;
import static config.Url.REGISTRATION_URL;

public class RegistrationTests {

    private static String email;
    private static String password;
    private static String name;
    private static RegistrationElements registrationElements;

    @BeforeClass
    public static void setUp() {
        //Utils.setFireFox();
        RestAssured.baseURI = BASE_URL;
        registrationElements = open(REGISTRATION_URL, RegistrationElements.class);
        email = RandomStringUtils.randomAlphabetic(10) + "@mail.ru";
        password = RandomStringUtils.randomAlphabetic(8);
        name = RandomStringUtils.randomAlphabetic(8);
    }

    @Test
    public void checkRegistration() {
        registrationElements.login(email, password, name);
        Utils.await();
        AccountUtils.signIn(email, password);
        Utils.await();
        AccountUtils.checkIsSignedIn();
    }

    @AfterClass
    public static void clear() {
        AccountUtils.deleteAccount(email, password);
    }
}
