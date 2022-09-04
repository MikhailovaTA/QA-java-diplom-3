import config.DataUser;
import config.RegistrationMethods;
import org.apache.http.HttpStatus;
import pageobject.ProfileElements;
import pageobject.RegistrationElements;
import pageobject.SingInElements;

import static com.codeborne.selenide.Selenide.open;
import static config.Url.*;

public class AccountUtils {
    public static void signIn(String email, String password) {
        SingInElements singInElements = open(SIGH_IN_URL, SingInElements.class);
        singInElements.login(email, password);
    }

    public static void checkIsSignedIn() {
        ProfileElements profileElements = open(ACCOUNT_URL, ProfileElements.class);
        profileElements.hasLogOutButton();
    }

    public static void logout() {
        ProfileElements profileElements = open(ACCOUNT_URL, ProfileElements.class);
        profileElements.clickLogOutButton();
    }

    public static void deleteAccount(String email, String password) {
        String accessToken = RegistrationMethods.authorizationUser(new DataUser(email, password, null));
        RegistrationMethods.deleteUser(accessToken, HttpStatus.SC_ACCEPTED);
    }

    public static void registration(String email, String password, String name) {
        RegistrationElements registrationElements = open(REGISTRATION_URL, RegistrationElements.class);
        registrationElements.login(email, password, name);
    }
}
