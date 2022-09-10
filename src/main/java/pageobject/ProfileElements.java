package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfileElements {

    @FindBy(how = How.XPATH, using = ".//*[contains(@class, 'Account_button__14Yp3')]")
    private SelenideElement logOutButton;

    public void hasLogOutButton() {
        logOutButton.shouldBe(Condition.visible);
    }

    public void clickLogOutButton() {
        logOutButton.click();
    }

}
