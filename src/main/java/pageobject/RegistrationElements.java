package pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.nio.charset.Charset;

public class RegistrationElements {

    //кнопка Войти в аккаунт
    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg")
    public SelenideElement signInButton;

    //кнопка Зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//*[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    public SelenideElement registrationButton;

    //поле Имя
    @FindBy(how = How.XPATH, using = ".//*[@class='input__placeholder text noselect text_type_main-default'][text()='Имя']")
    public SelenideElement nameField;

    //поле Email
    @FindBy(how = How.XPATH, using = ".//*[@class='input__placeholder text noselect text_type_main-default'][text()='Email']")
    public SelenideElement emailField;

    //поле Пароль
    @FindBy(how = How.XPATH, using = ".//*[@class='text input__textfield text_type_main-default'][@type='password']")
    public SelenideElement passwordField;

    //кнопка Зарегистрироваться на форме регистрации
    @FindBy(how = How.XPATH, using = ".//*[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa'][text()='Зарегистрироваться']")
    public SelenideElement registrationButtonInRegistrationForm;

    //Ошибка при неверном пароле
    @FindBy(how = How.XPATH, using = ".//*[@class='input__error text_type_main-default'][text()='Некорректный пароль']")
    public SelenideElement errorMessage;

    //кнопка Войти в разделе регистрации
    @FindBy(how = How.XPATH, using = ".//*[@class='Auth_link__1fOlj'][text()='Войти']")
    public SelenideElement goToSignIn;

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

}
