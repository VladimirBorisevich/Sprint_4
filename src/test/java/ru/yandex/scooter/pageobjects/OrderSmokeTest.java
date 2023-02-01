package ru.yandex.scooter.pageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class OrderSmokeTest {
    private final boolean flagButton;
    private final String name;
    private final String surName;
    private final String address;
    private final String phoneNumber;
    private final int metroStation;
    private final String rentDate;
    private final int rentTimeDays;
    private WebDriver driver;

    public OrderSmokeTest(boolean flagButton, String name, String surName, String address,
                          String phoneNumber, int metroStation,
                          String rentDate, int rentTimeDays) {
        this.flagButton = flagButton;
        this.name = name;
        this.surName = surName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.metroStation = metroStation;
        this.rentDate = rentDate;
        this.rentTimeDays = rentTimeDays;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {false, "Вася", "Вася", "г. Москва", "+79999999999", 30, "09.12.2022", 1},
                {true, "Оля", "Петровна", "Москва-сити", "+71111111111", 20, "05.10.2022", 3},
                {true, "Петр", "Черный", "ул. Пушкина д. 15", "81234567890", 1, "01.01.2021", 2}
        };
    }

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void makeOrderTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOrderButton(flagButton);
        // Заполняем первую страницу заказа
        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillOrderPage(name, surName, address, phoneNumber, metroStation);
        // Заполняем вторую страницу заказа
        RentPage rentPage = new RentPage(driver);
        rentPage.fillRentPage(rentDate, rentTimeDays);
        // Проверка того, что появилось окно с подтверждением заказа
        assertThat("Должен быть текст с подтверждением заказ",
                    rentPage.isOrderConfirmationDisplayed(),
                    containsString("Заказ оформлен"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
