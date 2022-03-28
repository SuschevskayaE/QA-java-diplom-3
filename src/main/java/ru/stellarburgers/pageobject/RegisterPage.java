package ru.stellarburgers.pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


import static com.codeborne.selenide.Selenide.page;

public class RegisterPage {

    @FindBy(how = How.XPATH, using = ".//label[text()='Имя']/following-sibling::input")
    private SelenideElement nameInput;

    @FindBy(how = How.XPATH, using = ".//label[text()='Email']/following-sibling::input")
    private SelenideElement emailInput;

    @FindBy(how = How.XPATH, using = ".//label[text()='Пароль']/following-sibling::input")
    private SelenideElement passwordInput;

    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registerButton;

    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement enterButton;

    @FindBy(how = How.CLASS_NAME, using = "input__error")
    private SelenideElement errorText;

    @Step("Заполнение формы регистрации")
    public LoginPage register(String name, String email, String password) {
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        registerButton.click();
        return page(LoginPage.class);
    }

    @Step("Заполнение формы регистраци с ошибками")
    public RegisterPage fillingInRegistrationFields(String name, String email, String password) {
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        return page(RegisterPage.class);
    }

    @Step("Клик на кнопку 'Зарегистрироваться'")
    public RegisterPage clickRegister() {
        registerButton.click();
        return page(RegisterPage.class);
    }


    @Step("Клик на кнопку 'Войти'")
    public LoginPage clickEnter() {
        enterButton.click();
        return page(LoginPage.class);
    }

    @Step("Получить текст ошибки")
    public String getErrorText() {
        return errorText.getText();
    }
}
