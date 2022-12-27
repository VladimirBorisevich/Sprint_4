package ru.yandex.scooter.pageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class OrderSmokeTest {
    WebDriver driver;
    String orderNumber;

    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");

    }

    @Test
    public void makeOrderTest() {

        MainPage mainPage = new MainPage(driver);
        mainPage.clickOrderButtonHeader();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.setName("Дуэйн");
        orderPage.setSurName("Скала");
        orderPage.setAddress("Джейсон");
        orderPage.setPhoneNumber("+79999999999");
        orderPage.clickButtonMetro();
        orderPage.setMetro(30);
        orderPage.clickButtonNext();

        RentPage rentPage = new RentPage(driver);
        rentPage.setRentDate("08.06.2022");
        rentPage.clickRentTime();
        rentPage.clickRentTimeDays(0);
        rentPage.clickOrderButton();
        rentPage.clickOrderYesButton();
        //System.out.println(rentPage.getOrderConfirmation());
        orderNumber = rentPage.getOrderNumber();
        rentPage.clickWatchStatusButton();

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
