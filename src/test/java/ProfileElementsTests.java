import config.RegistrationMethods;
import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.*;
import pageobject.MainPageElements;
import pageobject.ProfilePage;

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
        //utils.Utils.setFireFox();
        RestAssured.baseURI = BASE_URL;
        email = RandomStringUtils.randomAlphabetic(10) + "@mail.ru";
        password = RandomStringUtils.randomAlphabetic(8);
        name = RandomStringUtils.randomAlphabetic(8);
        new ProfilePage().registration(email, password, name);
    }

    @Before
    public void login() {
        new ProfilePage().signIn(email, password);
    }

    @Test
    public void checkOpenProfile() {
        MainPageElements mainPageElements = open(BASE_URL, MainPageElements.class);
        mainPageElements.clickOnPersonalAreaButton();
        webdriver().shouldHave(url(ACCOUNT_PROFILE_URL));
    }

    @Test
    public void checkGoToMainPageByLogoClick() {
        MainPageElements mainPageElements = open(BASE_URL, MainPageElements.class);
        mainPageElements.clickOnPersonalAreaButton();

        mainPageElements = open(ACCOUNT_URL, MainPageElements.class);
        mainPageElements.clickLogoButton();

        webdriver().shouldHave(url(BASE_URL));
    }

    @Test
    public void checkGoToMainPageByConstructorClick() {
        MainPageElements mainPageElements = open(BASE_URL, MainPageElements.class);
        mainPageElements.clickOnPersonalAreaButton();
        mainPageElements.clickConstructorButton();

        webdriver().shouldHave(url(BASE_URL));
    }

    @Test
    public void checkGoToMenuButtonClick(){
        MainPageElements mainPageElements = open(BASE_URL, MainPageElements.class);
        mainPageElements.clickSouseButton();
        mainPageElements.checkSouseClicked();


        mainPageElements.clickFillingButton();
        mainPageElements.checkFillingClicked();

        mainPageElements.clickBunButton();
        mainPageElements.checkBunClicked();
    }

    @After
    public  void logout(){
        new ProfilePage().logout();
    }

    @AfterClass
    public static void clear() {
         RegistrationMethods.deleteAccount(email, password);
    }
}
