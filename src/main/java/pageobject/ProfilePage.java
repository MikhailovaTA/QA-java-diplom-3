package pageobject;

import config.DataUser;
import config.RegistrationMethods;
import org.apache.http.HttpStatus;
import pageobject.ProfileElements;
import pageobject.RegistrationElements;
import pageobject.SignInElements;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static config.Url.*;

public class ProfilePage {
    public void signIn(String email, String password) {
        SignInElements signInElements = open(SIGH_IN_URL, SignInElements.class);
        signInElements.login(email, password);
        webdriver().shouldHave(url(BASE_URL));
    }

    public void checkIsSignedIn() {
        ProfileElements profileElements = open(ACCOUNT_URL, ProfileElements.class);
        profileElements.hasLogOutButton();
    }

    public void logout() {
        ProfileElements profileElements = open(ACCOUNT_URL, ProfileElements.class);
        profileElements.clickLogOutButton();
        webdriver().shouldHave(url(SIGH_IN_URL));
    }

    public void registration(String email, String password, String name) {
        RegistrationElements registrationElements = open(REGISTRATION_URL, RegistrationElements.class);
        registrationElements.login(email, password, name);
        webdriver().shouldHave(url(SIGH_IN_URL));
    }
}
