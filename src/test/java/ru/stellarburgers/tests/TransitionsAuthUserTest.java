package ru.stellarburgers.tests;

import com.UserOperations;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.stellarburgers.pageobject.ConstructorPage;
import ru.stellarburgers.pageobject.PersonalAccountPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TransitionsAuthUserTest extends BaseTest {

    private Map<String, String> user;
    private UserOperations userOperations;

    public TransitionsAuthUserTest(String browser) {
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
    @DisplayName("Переход по клику на «Личный кабинет»")
    public void goToPersonalAccountSuccess() {
        PersonalAccountPage personalAccountPage = open(ConstructorPage.URL, ConstructorPage.class).clickLoginToAccount()
                .loginUser(user.get("email"), user.get("password"))
                .headerPage.clickAuthAccount();

        String name = personalAccountPage.getName();
        String login = personalAccountPage.getLogin();

        assertEquals("Имя не соответствует пользователю", user.get("name"), name);
        assertEquals("Login не соответствует пользователю", user.get("email"), login);
    }

    @Test
    @DisplayName("Переход по клику на «Конструктор»")
    public void transitionFromPersonalAccountToConstructorSuccess() {
        PersonalAccountPage personalAccountPage = open(ConstructorPage.URL, ConstructorPage.class).clickLoginToAccount()
                .loginUser(user.get("email"), user.get("password"))
                .headerPage.clickAuthAccount();

        String name = personalAccountPage.getName();
        String login = personalAccountPage.getLogin();

        boolean isPlaceAnOrderDisplayed = personalAccountPage.headerPage.clickConstructor().isPlaceAnOrderButtonDisplayed();

        assertEquals("Имя не соответствует пользователю", user.get("name"), name);
        assertEquals("Login не соответствует пользователю", user.get("email"), login);

        assertTrue("Пользователь не перешел на страницу конструктора", isPlaceAnOrderDisplayed);
    }

    @Test
    @DisplayName("Переход по клику на логотип Stellar Burgers")
    public void transitionByClickingOnTheLogoSuccess() {
        PersonalAccountPage personalAccountPage = open(ConstructorPage.URL, ConstructorPage.class).clickLoginToAccount()
                .loginUser(user.get("email"), user.get("password"))
                .headerPage.clickAuthAccount();

        String name = personalAccountPage.getName();
        String login = personalAccountPage.getLogin();

        boolean isPlaceAnOrderDisplayed = personalAccountPage.headerPage.clickLogo().isPlaceAnOrderButtonDisplayed();

        assertEquals("Имя не соответствует пользователю", user.get("name"), name);
        assertEquals("Login не соответствует пользователю", user.get("email"), login);

        assertTrue("Пользователь не перешел на страницу конструктора", isPlaceAnOrderDisplayed);
    }
}
