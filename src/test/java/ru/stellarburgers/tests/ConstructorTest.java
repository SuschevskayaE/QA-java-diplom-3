package ru.stellarburgers.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.stellarburgers.pageobject.ConstructorPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class ConstructorTest extends BaseTest {

    public ConstructorTest(String browser) {
        super(browser);
    }

    @Test
    @DisplayName("Переход на вкладку 'Соусы'")
    public void goToSaucesSuccess() throws InterruptedException {
        ConstructorPage constructorPage = open(ConstructorPage.URL, ConstructorPage.class).clickSauces();
        String attribute = constructorPage.burgerIngredientsAttribute("371");

        assertEquals("Переключение не произошло", 370, Integer.parseInt(attribute), 10);
    }

    @Test
    @DisplayName("Переход на вкладку 'Булки'")
    public void goToBunSuccess() throws InterruptedException {
        ConstructorPage constructorPage = open(ConstructorPage.URL, ConstructorPage.class).clickSauces().clickBun();
        String attribute = constructorPage.burgerIngredientsAttribute("40");

        assertEquals("Переключение не произошло", 40, Integer.parseInt(attribute), 10);
    }

    @Test
    @DisplayName("Переход на вкладку 'Начинки'")
    public void goToFillingSuccess() throws InterruptedException {
        ConstructorPage constructorPage = open(ConstructorPage.URL, ConstructorPage.class).clickFilling();
        String attribute = constructorPage.burgerIngredientsAttribute("960");

        assertEquals("Переключение не произошло", 960, Integer.parseInt(attribute), 10);
    }
}
