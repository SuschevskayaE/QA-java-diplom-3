package ru.stellarburgers.tests;

import com.model.User;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.stellarburgers.pageobject.ConstructorPage;
import ru.stellarburgers.pageobject.HeaderPage;
import ru.stellarburgers.pageobject.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegisterTest extends BaseTest {

    private User user;

    public RegisterTest(String browser) {
        super(browser);
    }

    @Before
    @Step("Получение пользователя")
    public void startUp() {
        user = User.getRandomUser();
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void registerSuccess() throws InterruptedException {
        LoginPage loginPage = open(ConstructorPage.URL, HeaderPage.class).clickAccount()
                .clickRegister()
                .register(user.getName(), user.getEmail(), user.getPassword());
        boolean isPlaceAnOrderDisplayed = loginPage
                .loginUser(user.getEmail(), user.getPassword())
                .isPlaceAnOrderButtonDisplayed();

        assertTrue("Пользователь не авторизовался", isPlaceAnOrderDisplayed);
    }


    @Test
    @DisplayName("Ошибка для некорректного пароля")
    public void registerPasswordInvalidFail() throws InterruptedException {
        String error = open(ConstructorPage.URL, HeaderPage.class).clickAccount()
                .clickRegister().fillingInRegistrationFields(user.getName(), user.getEmail(), "00000").clickRegister().getErrorText();

        assertEquals("Ошибка некорректная", "Некорректный пароль", error);
    }
}
