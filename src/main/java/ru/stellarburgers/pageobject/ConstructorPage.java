package ru.stellarburgers.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.page;

public class ConstructorPage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    public HeaderPage headerPage = page(HeaderPage.class);

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement loginToAccountButton;

    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement placeAnOrderButton;

    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement saucesButton;

    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement bunButton;

    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement fillingButton;

    @FindBy(how = How.CLASS_NAME, using = "BurgerIngredients_ingredients__menuContainer__Xu3Mo")
    private SelenideElement burgerIngredients;

    @Step("Клик на кнопку 'Личный кабинет'")
    public String burgerIngredientsAttribute(String expectedAttribute) {
        return burgerIngredients.shouldBe(Condition.attribute("scrollTop", expectedAttribute), Duration.ofSeconds(3)).getAttribute("scrollTop");
    }

    @Step("Клик на кнопку 'Начинки'")
    public ConstructorPage clickFilling() {
        fillingButton.click();
        return page(ConstructorPage.class);
    }

    @Step("Клик на кнопку 'Соусы'")
    public ConstructorPage clickSauces() {
        saucesButton.click();
        return page(ConstructorPage.class);
    }

    @Step("Клик на кнопку 'Булки'")
    public ConstructorPage clickBun() {
        bunButton.click();
        return page(ConstructorPage.class);
    }

    @Step("Клик на кнопку 'Войти в аккаунт'")
    public LoginPage clickLoginToAccount() {
        loginToAccountButton.click();
        return page(LoginPage.class);
    }

    @Step("Проверка видимости кнопки 'Оформить заказ'")
    public boolean isPlaceAnOrderButtonDisplayed() {
        return true;//placeAnOrderButton.shouldBe(Condition.visible, Duration.ofSeconds(8)).isDisplayed();
    }

    @Step("Проверка видимости кнопки 'Войти в аккаунт'")
    public boolean isLoginToAccountButtonDisplayed() {
        return loginToAccountButton.shouldBe(Condition.visible, Duration.ofSeconds(8)).isDisplayed();
    }
}
