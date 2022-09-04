import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ObjectCondition;
import config.DataUser;
import config.RegistrationMethods;
import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pageobject.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static config.Url.*;

public class SignInTests {

    private static String email;
    private static String password;
    private static String name;

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = BASE_URL;
        email = RandomStringUtils.randomAlphabetic(10) + "@mail.ru";
        password = RandomStringUtils.randomAlphabetic(8);
        name = RandomStringUtils.randomAlphabetic(8);
        AccountUtils.registration(email, password, name);
        Utils.await();
    }

    @Test
    public void singInThroughTheMainPage() {
        MainPageElements mainPageElements = open(BASE_URL, MainPageElements.class);
        mainPageElements.clickSingInButtonOnMainPage();
        webdriver().shouldHave(url(SIGH_IN_URL));

        SingInElements singInElements = open(SIGH_IN_URL, SingInElements.class);
        singInElements.login(email, password);
    }

    @Test
    public void singInPersonalArea() {
        SingInElements singInElements = open(SIGH_IN_URL, SingInElements.class);
        singInElements.login(email, password);
    }

    @Test
    public void singInLoginPage() {
        RegistrationElements registrationElements = open(REGISTRATION_URL, RegistrationElements.class);
        registrationElements.clickSingInButton();
        webdriver().shouldHave(url(SIGH_IN_URL));

        SingInElements singInElements = open(SIGH_IN_URL, SingInElements.class);
        singInElements.login(email, password);
    }

    @Test
    public void singInPasswordRecovery() {
        PasswordRecoveryElements passwordRecoveryElements = open(RECOVERY_PASSWORD_URL, PasswordRecoveryElements.class);
        passwordRecoveryElements.clickSingInButton();
        webdriver().shouldHave(url(SIGH_IN_URL));

        SingInElements singInElements = open(SIGH_IN_URL, SingInElements.class);
        singInElements.login(email, password);
    }

    @After
    public void checkAndLogout() {
        Utils.await();
        AccountUtils.checkIsSignedIn();
        AccountUtils.logout();
        Utils.await();
    }

    @AfterClass
    public static void clear() {
        AccountUtils.deleteAccount(email, password);
    }
}
