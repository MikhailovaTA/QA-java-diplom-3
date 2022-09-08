import config.RegistrationMethods;
import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pageobject.*;
import pageobject.ProfilePage;

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
        //utils.Utils.setFireFox();
        RestAssured.baseURI = BASE_URL;
        email = RandomStringUtils.randomAlphabetic(10) + "@mail.ru";
        password = RandomStringUtils.randomAlphabetic(8);
        name = RandomStringUtils.randomAlphabetic(8);
        new ProfilePage().registration(email, password, name);

    }

    @Test
    public void singInThroughTheMainPage() {
        MainPageElements mainPageElements = open(BASE_URL, MainPageElements.class);
        mainPageElements.clickSingInButtonOnMainPage();
        webdriver().shouldHave(url(SIGH_IN_URL));

        SignInElements signInElements = open(SIGH_IN_URL, SignInElements.class);
        signInElements.login(email, password);
        webdriver().shouldHave(url(BASE_URL));
    }

    @Test
    public void singInPersonalArea() {
        SignInElements signInElements = open(SIGH_IN_URL, SignInElements.class);
        signInElements.login(email, password);
        webdriver().shouldHave(url(BASE_URL));
    }

    @Test
    public void singInLoginPage() {
        RegistrationElements registrationElements = open(REGISTRATION_URL, RegistrationElements.class);
        registrationElements.clickSingInButton();
        webdriver().shouldHave(url(SIGH_IN_URL));

        SignInElements signInElements = open(SIGH_IN_URL, SignInElements.class);
        signInElements.login(email, password);
        webdriver().shouldHave(url(BASE_URL));

    }

    @Test
    public void singInPasswordRecovery() {
        PasswordRecoveryElements passwordRecoveryElements = open(RECOVERY_PASSWORD_URL, PasswordRecoveryElements.class);
        passwordRecoveryElements.clickSingInButton();
        webdriver().shouldHave(url(SIGH_IN_URL));

        SignInElements signInElements = open(SIGH_IN_URL, SignInElements.class);
        signInElements.login(email, password);
        webdriver().shouldHave(url(BASE_URL));
    }

    @After
    public void checkAndLogout() {
        new ProfilePage().checkIsSignedIn();
        new ProfilePage().logout();
    }

    @AfterClass
    public static void clear() {
         RegistrationMethods.deleteAccount(email, password);
    }
}
