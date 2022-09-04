import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.*;
import pageobject.MainPageElements;
import pageobject.ProfileElements;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static config.Url.*;

public class ProfileElementsTests {

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

    @Before
    public void login() {
        Utils.await();
        AccountUtils.signIn(email, password);
        Utils.await();
    }

    @Test
    public void checkOpenProfile() {
        MainPageElements mainPageElements = open(BASE_URL, MainPageElements.class);
        mainPageElements.clickOnPersonalAreaButton();
        webdriver().shouldHave(url(ACCOUNT_PROFILE_URL));

        Utils.await();
        AccountUtils.logout();
    }

    @Test
    public void checkLogOutProfile() {
        MainPageElements mainPageElements = open(BASE_URL, MainPageElements.class);
        mainPageElements.clickOnPersonalAreaButton();
        webdriver().shouldHave(url(ACCOUNT_PROFILE_URL));

        ProfileElements profileElements = open(ACCOUNT_URL, ProfileElements.class);
        profileElements.clickLogOutButton();
    }

    @Test
    public void checkGoToMainPageByLogoClick() {
        MainPageElements mainPageElements = open(BASE_URL, MainPageElements.class);
        mainPageElements.clickOnPersonalAreaButton();

        mainPageElements = open(ACCOUNT_URL, MainPageElements.class);
        mainPageElements.clickLogoButton();

        webdriver().shouldHave(url(BASE_URL));

        Utils.await();
        AccountUtils.logout();
    }

    @Test
    public void checkGoToMainPageByConstructorClick() {
        MainPageElements mainPageElements = open(BASE_URL, MainPageElements.class);
        mainPageElements.clickOnPersonalAreaButton();
        mainPageElements.clickConstructorButton();

        webdriver().shouldHave(url(BASE_URL));

        Utils.await();
        AccountUtils.logout();
    }

    @Test
    public void checkGoToMenuButtonClick() {
        MainPageElements mainPageElements = open(BASE_URL, MainPageElements.class);
        mainPageElements.clickSouseButton();
        Utils.await();
        mainPageElements.clickFillingButton();
        Utils.await();
        mainPageElements.clickBunButton();
        Utils.await();

        AccountUtils.logout();
    }

    @AfterClass
    public static void clear() {
        Utils.await();
        AccountUtils.deleteAccount(email, password);
    }
}
