import config.DataUser;
import config.RegistrationMethods;
import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pageobject.RegistrationElements;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static config.Url.BASE_URL;
import static config.Url.REGISTRATION_URL;

public class RegistrationNegativeTests {
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
        password = RandomStringUtils.randomAlphabetic(5);
        name = RandomStringUtils.randomAlphabetic(8);
    }

    @Test
    public void checkErrorRegistration(){
        registrationElements.login(email, password, name);
        registrationElements.errorMessage.shouldHave(text("Некорректный пароль"));
    }
}
