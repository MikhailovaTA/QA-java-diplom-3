import config.RegistrationMethods;
import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pageobject.MainPageElements;
import pageobject.ProfileElements;
import pageobject.ProfilePage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static config.Url.*;

public class LogoutTests {
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
    public void checkLogOutProfile() {
        new ProfilePage().signIn(email, password);

        MainPageElements mainPageElements = open(BASE_URL, MainPageElements.class);
        mainPageElements.clickOnPersonalAreaButton();
        webdriver().shouldHave(url(ACCOUNT_PROFILE_URL));

        ProfileElements profileElements = open(ACCOUNT_URL, ProfileElements.class);
        profileElements.clickLogOutButton();
    }

    @AfterClass
    public static void clear() {
         RegistrationMethods.deleteAccount(email, password);
    }
}
