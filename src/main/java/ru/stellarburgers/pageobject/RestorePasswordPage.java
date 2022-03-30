package ru.stellarburgers.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RestorePasswordPage {

    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    private SelenideElement emailInput;

    @FindBy(how = How.XPATH, using = ".//button[text()='Восстановить']")
    private SelenideElement restoreButton;

    @FindBy(how = How.XPATH, using = ".//button[text()='Сохранить']")
    private SelenideElement saveButton;

    @FindBy(how = How.XPATH, using = ".//input[@name='Введите новый пароль']")
    private SelenideElement newPasswordInput;

    @FindBy(how = How.XPATH, using = ".//label[text()='Введите код из письма']/following-sibling::input")
    private SelenideElement codeInput;

    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement enterButton;

    @Step("Восстановление пароля")
    public LoginPage restorePassword(String email, String newPassword, String code) {
        emailInput.sendKeys(email);
        restoreButton.click();
        newPasswordInput.shouldBe(Condition.visible).sendKeys(newPassword);
        codeInput.sendKeys(code);
        saveButton.click();
        return page(LoginPage.class);
    }

    @Step("Клик на кнопку 'Войти'")
    public LoginPage clickEnter() {
        enterButton.click();
        return page(LoginPage.class);
    }
}
