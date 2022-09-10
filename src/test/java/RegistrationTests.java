import config.RegistrationMethods;
import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pageobject.RegistrationElements;
import pageobject.ProfilePage;

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
        //utils.Utils.setFireFox();
        RestAssured.baseURI = BASE_URL;
        registrationElements = open(REGISTRATION_URL, RegistrationElements.class);
        email = RandomStringUtils.randomAlphabetic(10) + "@mail.ru";
        password = RandomStringUtils.randomAlphabetic(8);
        name = RandomStringUtils.randomAlphabetic(8);
    }

    @Test
    public void checkRegistration() {
        registrationElements.login(email, password, name);

        new ProfilePage().signIn(email, password);

        new ProfilePage().checkIsSignedIn();
    }

    @AfterClass
    public static void clear() {
         RegistrationMethods.deleteAccount(email, password);
    }
}
