package ru.stellarburgers.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.stellarburgers.pageobject.ConstructorPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class TransitionsTest extends BaseTest {

    public TransitionsTest(String browser) {
        super(browser);
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет»")
    public void goToPersonalAccountSuccess() {

        boolean isEnterTextDisplayed = open(ConstructorPage.URL, ConstructorPage.class).clickLoginToAccount().isEnterTextDisplayed();

        assertTrue("Пользователь не вошел в аккаунт", isEnterTextDisplayed);
    }

    @Test
    @DisplayName("Переход по клику на «Конструктор»")
    public void transitionFromPersonalAccountToConstructorSuccess() {
        boolean isLoginToAccountButtonDisplayed = open(ConstructorPage.URL, ConstructorPage.class).clickLoginToAccount()
                .headerPage.clickConstructor().isLoginToAccountButtonDisplayed();

        assertTrue("Пользователь не перешел на страницу конструктора", isLoginToAccountButtonDisplayed);
    }

    @Test
    @DisplayName("Переход по клику на логотип Stellar Burgers")
    public void transitionByClickingOnTheLogoSuccess() {
        boolean isLoginToAccountButtonDisplayed = open(ConstructorPage.URL, ConstructorPage.class).clickLoginToAccount()
                .headerPage.clickLogo().isLoginToAccountButtonDisplayed();

        assertTrue("Пользователь не перешел на страницу конструктора", isLoginToAccountButtonDisplayed);
    }
}
