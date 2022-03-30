package ru.stellarburgers.pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class PersonalAccountPage {

    public HeaderPage headerPage = page(HeaderPage.class);

    @FindBy(how = How.XPATH, using = ".//label[text()='Имя']/following-sibling::input")
    private SelenideElement nameInput;

    @FindBy(how = How.XPATH, using = ".//label[text()='Логин']/following-sibling::input")
    private SelenideElement loginInput;

    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement logoutButton;

    @Step("Клик на кнопку 'Выход'")
    public LoginPage logout() {
        logoutButton.click();
        return page(LoginPage.class);
    }

    @Step("Получить имя")
    public String getName() {
        return nameInput.getValue();
    }

    @Step("Получить логин")
    public String getLogin() {
        return loginInput.getValue();
    }

}
