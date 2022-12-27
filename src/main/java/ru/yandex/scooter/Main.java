package ru.yandex.scooter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.scooter.pageobjects.MainPage;
import ru.yandex.scooter.pageobjects.OrderPage;

public class Main {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        //WebDriver driver = new ChromeDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPage = new MainPage(driver);
        mainPage.clickOrderButtonHeader();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.setName("Дуэйн");
        orderPage.setSurName("Скала");
        orderPage.setAddress("Джейсон");
        orderPage.setPhoneNumber("+79999999999");
        orderPage.clickButtonMetro();
        orderPage.setMetro(3);
        orderPage.clickButtonNext();

        driver.quit();
    }
}
