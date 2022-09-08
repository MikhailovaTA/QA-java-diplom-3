package pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PasswordRecoveryElements {

    //кнопка Войти
    @FindBy(how = How.XPATH, using = ".//*[@class='Auth_link__1fOlj'][text()='Войти']")
    private SelenideElement goToSignIn;

    public void clickSingInButton() {
        goToSignIn.click();
    }
}
