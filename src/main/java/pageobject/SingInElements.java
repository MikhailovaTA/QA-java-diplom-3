package pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SingInElements {

    //кнопка Войти
    @FindBy(how = How.XPATH, using = ".//*[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    public SelenideElement singInButton;

    //поле Email
    @FindBy(how = How.XPATH, using = ".//*[@class='text input__textfield text_type_main-default'][@type='text']")
    public SelenideElement emailField;

    //поле password
    @FindBy(how = How.XPATH, using = ".//*[@class='text input__textfield text_type_main-default'][@type='password']")
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
