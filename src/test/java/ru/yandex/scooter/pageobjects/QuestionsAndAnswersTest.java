package ru.yandex.scooter.pageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class QuestionsAndAnswersTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        WebElement element = driver.findElement(By.cssSelector(".Home_FAQ__3uVm4"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    @Test
    public void checkAnswerVisibilityOne() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickQuestion(0);
        assertTrue(mainPage.isAnswerVisible(0));
    }

    @Test
    public void checkAnswerVisibilityTwo() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickQuestion(1);
        assertTrue(mainPage.isAnswerVisible(1));
    }

    @Test
    public void checkAnswerVisibilityThree() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickQuestion(2);
        assertTrue(mainPage.isAnswerVisible(2));
    }

    @Test
    public void checkAnswerVisibilityFour() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickQuestion(3);
        assertTrue(mainPage.isAnswerVisible(3));
    }

    @Test
    public void checkAnswerVisibilityFive() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickQuestion(4);
        assertTrue(mainPage.isAnswerVisible(4));
    }

    @Test
    public void checkAnswerVisibilitySix() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickQuestion(5);
        assertTrue(mainPage.isAnswerVisible(5));
    }

    @Test
    public void checkAnswerVisibilitySeven() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickQuestion(6);
        assertTrue(mainPage.isAnswerVisible(6));
    }

    @Test
    public void checkAnswerVisibilityNine() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickQuestion(7);
        assertTrue(mainPage.isAnswerVisible(7));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
