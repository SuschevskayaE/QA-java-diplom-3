package ru.stellarburgers.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    public HeaderPage headerPage = page(HeaderPage.class);

    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    private SelenideElement emailInput;

    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    private SelenideElement passwordInput;

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement enterButton;

    @FindBy(how = How.XPATH, using = ".//a[text()='Зарегистрироваться']")
    private SelenideElement registerButton;

    @FindBy(how = How.XPATH, using = ".//a[text()='Восстановить пароль']")
    private SelenideElement restorePasswordButton;

    @FindBy(how = How.XPATH, using = ".//h2[text()='Вход']")
    private SelenideElement enterText;

    @Step("Вход по имени и паролю")
    public ConstructorPage loginUser(String name, String password) {
        enterText.shouldBe(Condition.visible, Duration.ofSeconds(6));
        emailInput.sendKeys(name);
        passwordInput.sendKeys(password);
        enterButton.click();
        return page(ConstructorPage.class);
    }

    @Step("Проверка видимости заголовка")
    public boolean isEnterTextDisplayed() {
        return enterText.shouldBe(Condition.visible, Duration.ofSeconds(6)).isDisplayed();
    }

    @Step("Клик на кнопку 'Зарегистрироваться'")
    public RegisterPage clickRegister() {
        registerButton.click();
        return page(RegisterPage.class);
    }

    @Step("Клик на кнопку 'Восстановить пароль'")
    public RestorePasswordPage clickRestorePassword() {
        restorePasswordButton.click();
        return page(RestorePasswordPage.class);
    }

}
