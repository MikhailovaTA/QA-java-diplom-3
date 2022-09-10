package pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignInElements {

    //кнопка Войти
    @FindBy(how = How.XPATH, using = ".//*[contains(@class, 'button_button__33qZ0')][text()='Войти']")
    public SelenideElement singInButton;

    //поле Email
    @FindBy(how = How.XPATH, using = ".//*[contains(@class, 'input__textfield')][@type='text']")
    public SelenideElement emailField;

    //поле password
    @FindBy(how = How.XPATH, using = ".//*[contains(@class, 'input__textfield')][@type='password']")
    public SelenideElement passwordField;

    public void clickSignInButton(){
        singInButton.click();
    }
    public void setEmailField(String email) {
        emailField.setValue(email);
    }

    public void setPasswordField(String password) {
        passwordField.setValue(password);
    }

    public void login(String email, String password){
        setEmailField(email);
        setPasswordField(password);

        clickSignInButton();
    }

}
