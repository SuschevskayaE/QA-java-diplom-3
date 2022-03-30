package ru.stellarburgers.pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class HeaderPage {

    @FindBy(how = How.XPATH, using = ".//a[@href='/account']")
    private SelenideElement accountButton;

    @FindBy(how = How.XPATH, using = ".//a[@href='/']/p[text() = 'Конструктор']")
    private SelenideElement constructorButton;

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logoButton;

    @Step("Клик на кнопку 'Личный кабинет'")
    public LoginPage clickAccount() {
        accountButton.click();
        return page(LoginPage.class);
    }

    @Step("Клик на кнопку 'Личный кабинет'")
    public PersonalAccountPage clickAuthAccount() {
        accountButton.click();
        return page(PersonalAccountPage.class);
    }

    @Step("Клик на кнопку 'Конструктор'")
    public ConstructorPage clickConstructor() {
        constructorButton.click();
        return page(ConstructorPage.class);
    }

    @Step("Клик на логотип'")
    public ConstructorPage clickLogo() {
        logoButton.click();
        return page(ConstructorPage.class);
    }
}
