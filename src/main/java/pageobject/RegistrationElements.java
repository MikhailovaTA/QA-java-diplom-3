package pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.text;

public class RegistrationElements {

    //кнопка Зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//*[contains(@class, 'button_button__33qZ0')]")
    private SelenideElement registrationButton;

    //поле Имя
    @FindBy(how = How.XPATH, using = ".//*[contains(@class, 'input__placeholder')][text()='Имя']")
    private SelenideElement nameField;

    //поле Email
    @FindBy(how = How.XPATH, using = ".//*[contains(@class, 'input__placeholder')][text()='Email']")
    private SelenideElement emailField;

    //поле Пароль
    @FindBy(how = How.XPATH, using = ".//*[contains(@class, 'input__textfield')][@type='password']")
    private SelenideElement passwordField;

    //Ошибка при неверном пароле
    @FindBy(how = How.XPATH, using = ".//*[contains(@class, 'input__error')][text()='Некорректный пароль']")
    private SelenideElement errorMessage;

    //кнопка Войти в разделе регистрации
    @FindBy(how = How.XPATH, using = ".//*[contains(@class, 'Auth_link')][text()='Войти']")
    private SelenideElement goToSignIn;

    public void setEmail(String email) {
        emailField.parent().lastChild().setValue(email);
    }

    public void setPassword(String password) {
        passwordField.setValue(password);
    }

    public void setName(String name) {
        nameField.parent().lastChild().setValue(name);
    }

    public void clickRegistrationButton() {
        registrationButton.click();
    }

    public void clickSingInButton() {
        goToSignIn.scrollTo().click();
    }

    public void login(String email, String password, String name){
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegistrationButton();
    }

    public void checkErrorMessage(String errorText){
        errorMessage.shouldHave(text(errorText));
    }
}
