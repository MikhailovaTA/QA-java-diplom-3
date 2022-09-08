package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selectors.byClassName;

public class MainPageElements {

    //«Войти в аккаунт» на главной
    @FindBy(how = How.XPATH, using = ".//*[text()='Войти в аккаунт']")
    private SelenideElement singInButtonOnMainPage;

    //кнопка Личный кабинет
    @FindBy(how = How.XPATH, using = ".//*[text()='Личный Кабинет']")
    private SelenideElement personalAreaButton;

    @FindBy(how = How.XPATH, using = ".//*[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement logoButton;

    @FindBy(how = How.XPATH, using = ".//*[contains(@class, 'text_type')][text()='Начинки']")
    private SelenideElement fillingText;

    @FindBy(how = How.XPATH, using = ".//*[contains(@class, 'text_type')][text()='Соусы']")
    private SelenideElement souseText;

    @FindBy(how = How.XPATH, using = ".//*[contains(@class, 'text_type')][text()='Булки']")
    private SelenideElement bunText;

    public void clickSingInButtonOnMainPage(){
        singInButtonOnMainPage.click();
    }

    public void clickOnPersonalAreaButton(){
        personalAreaButton.click();
    }

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

    public void checkFillingText(){
        fillingText.shouldBe(Condition.visible);
    }

    public void checkSouseText(){
        souseText.shouldBe(Condition.visible);
    }

    public void checkBunText(){
        bunText.shouldBe(Condition.visible);
    }
}
