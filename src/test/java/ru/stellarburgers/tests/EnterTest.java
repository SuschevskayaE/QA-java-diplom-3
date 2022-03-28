package ru.stellarburgers.tests;

import com.UserOperations;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.stellarburgers.pageobject.ConstructorPage;
import ru.stellarburgers.pageobject.HeaderPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class EnterTest extends BaseTest {

    private Map<String, String> user;
    private UserOperations userOperations;

    public EnterTest(String browser) {
        super(browser);
    }

    @Before
    @Step("Регистрация пользователя")
    public void startUp() {
        userOperations = new UserOperations();
        user = userOperations.register();
    }

    @After
    @Step("Удаление пользователя")
    public void tearDown() {
        userOperations.delete();
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginToAccountOnMainPageSuccess() {
        boolean isPlaceAnOrderDisplayed = open(ConstructorPage.URL, ConstructorPage.class).clickLoginToAccount()
                .loginUser(user.get("email"), user.get("password"))
                .isPlaceAnOrderButtonDisplayed();

        assertTrue("Пользователь не авторизовался", isPlaceAnOrderDisplayed);
    }


    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginToAccountOnHeaderPageSuccess() {
        boolean isPlaceAnOrderDisplayed = open(ConstructorPage.URL, HeaderPage.class).clickAccount()
                .loginUser(user.get("email"), user.get("password"))
                .isPlaceAnOrderButtonDisplayed();

        assertTrue("Пользователь не авторизовался", isPlaceAnOrderDisplayed);
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginToAccountOnRegisterPageSuccess() {
        boolean isPlaceAnOrderDisplayed = open(ConstructorPage.URL, HeaderPage.class).clickAccount()
                .clickRegister().clickEnter()
                .loginUser(user.get("email"), user.get("password"))
                .isPlaceAnOrderButtonDisplayed();

        assertTrue("Пользователь не авторизовался", isPlaceAnOrderDisplayed);
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginToAccountOnRestorePasswordPageSuccess() {
        boolean isPlaceAnOrderDisplayed = open(ConstructorPage.URL, HeaderPage.class).clickAccount()
                .clickRestorePassword().clickEnter()
                .loginUser(user.get("email"), user.get("password"))
                .isPlaceAnOrderButtonDisplayed();

        assertTrue("Пользователь не авторизовался", isPlaceAnOrderDisplayed);
    }

}
