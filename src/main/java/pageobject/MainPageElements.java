package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;

public class MainPageElements {

    //«Войти в аккаунт» на главной
    @FindBy(how = How.XPATH, using = ".//*[text()='Войти в аккаунт']")
    private SelenideElement singInButtonOnMainPage;

    //кнопка Личный кабинет
    @FindBy(how = How.XPATH, using = ".//*[text()='Личный Кабинет']")
    private SelenideElement personalAreaButton;

    @FindBy(how = How.XPATH, using = ".//*[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement logoButton;

    @FindBy(how = How.XPATH, using = ".//*[contains(@class, 'text_type_main-medium')][text()='Начинки']")
    private SelenideElement fillingText;

    @FindBy(how = How.XPATH, using = ".//*[contains(@class, 'text_type_main-medium')][text()='Соусы']")
    private SelenideElement souseText;

    @FindBy(how = How.XPATH, using = ".//*[contains(@class, 'text_type_main-medium')][text()='Булки']")
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
        clickTabButton("Булки");
    }

    public void clickSouseButton(){
        clickTabButton("Соусы");
    }

    public void clickFillingButton(){
        clickTabButton("Начинки");
    }

    public void checkFillingClicked(){
        fillingText.shouldBe(visible);
        checkTabClicked("Начинки");
    }

    public void checkSouseClicked(){
        souseText.shouldBe(visible);
        checkTabClicked("Соусы");
    }

    public void checkBunClicked(){
        bunText.shouldBe(visible);
        checkTabClicked("Булки");
    }

    private void clickTabButton(String text){
        Selenide.$(byXpath(".//*[contains(@class, 'text_type_main')][text()='"+text+"']"))
            .parent()
            .shouldNotHave(cssClass("tab_tab_type_current__2BEPc"))
            .click();
    }

    private void checkTabClicked(String text){
        Selenide.$(byXpath(".//*[contains(@class, 'text_type_main')][text()='"+text+"']"))
            .parent()
            .shouldHave(cssClass("tab_tab_type_current__2BEPc"));
        Selenide.$$(byClassName("tab_tab_type_current__2BEPc")).shouldHave(size(1));
    }
}
