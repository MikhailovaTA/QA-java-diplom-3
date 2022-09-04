package pageobject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selectors.byClassName;

public class MainPageElements {

    //«Войти в аккаунт» на главной
    @FindBy(how = How.XPATH, using = ".//*[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg'][text()='Войти в аккаунт']")
    public SelenideElement singInButtonOnMainPage;

    public void clickSingInButtonOnMainPage(){
        singInButtonOnMainPage.click();
    }

    //кнопка Личный кабинет
    @FindBy(how = How.XPATH, using = ".//*[@class='AppHeader_header__linkText__3q_va ml-2'][text()='Личный Кабинет']")
    public SelenideElement personalAreaButton;

    public void clickOnPersonalAreaButton(){
        personalAreaButton.click();
    }

    @FindBy(how = How.XPATH, using = ".//*[@class='AppHeader_header__logo__2D0X2']")
    public SelenideElement logoButton;

    public void clickLogoButton(){
        logoButton.click();
    }

    public void clickConstructorButton(){
        Selenide.$$(byClassName("AppHeader_header__link__3D_hX")).get(0).click();
    }

    public void clickBunButton(){
        Selenide.$$(byClassName("tab_tab__1SPyG")).get(0).click();
    }

    public void clickSouseButton(){
        Selenide.$$(byClassName("tab_tab__1SPyG")).get(1).click();
    }

    public void clickFillingButton(){
        Selenide.$$(byClassName("tab_tab__1SPyG")).get(2).click();
    }
}
