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

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class LogoutTest extends BaseTest {

    private Map<String, String> user;
    private UserOperations userOperations;

    public LogoutTest(String browser) {
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
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    public void logoutSuccess() {
        boolean isEnterTextDisplayed = open(ConstructorPage.URL, HeaderPage.class).clickAccount()
                .loginUser(user.get("email"), user.get("password"))
                .headerPage.clickAuthAccount()
                .logout()
                .isEnterTextDisplayed();

        assertTrue("Пользователь не вышел из аккаунта", isEnterTextDisplayed);
    }
}
