package ru.stellarburgers.tests;

import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


@RunWith(Parameterized.class)
public class BaseTest {

    private String browser;

    public BaseTest(String browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters
    public static Object[][] getBrowser() {
        return new Object[][]{
                {"chrome"},
                {"yandex"},
        };
    }

    @Before
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");

        if (browser.equals("yandex")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Екатерина\\Downloads\\yandexdriver-22.3.0.2434-win\\yandexdriver.exe");
            options.setBinary("C:\\Users\\Екатерина\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        }

        WebDriver driver = new ChromeDriver(options);

    }

    @After
    public void teardown() {
        Selenide.closeWebDriver();
    }
}

