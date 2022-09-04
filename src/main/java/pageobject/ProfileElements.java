package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfileElements {

    @FindBy(how = How.XPATH, using = ".//*[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']")
    public SelenideElement logOutButton;

    public void hasLogOutButton() {
        logOutButton.shouldBe(Condition.visible);
    }

    public void clickLogOutButton() {
        logOutButton.click();
    }

}
