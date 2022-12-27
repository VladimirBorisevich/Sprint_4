package ru.yandex.scooter.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;
    // Кнопка логотипа "Яндекс"
    private final By yandexLogo = By.className("Header_LogoYandex__3TSOI");
    //Кнопка логотипа "Самокат"
    private final By scooterLogo = By.className("Header_LogoScooter__3lsAR");
    // Кнопка "Заказать" вверху страницы
    private final By orderButtonHeader = By.xpath(".//div[@class='Header_Nav__AGCXC']//button[@class='Button_Button__ra12g']");
    // Кнопка "Заказать" посередине страницы
    private final By orderButtonMiddle = By.xpath(".//div[@class='Home_FinishButton__1_cWm']//button");
    // Кнопка "Статус заказа"
    private final By orderStatus = By.className("Header_Link__1TAG7");
    // Поле ввода заказа
    private final By orderStatusInput = By.xpath("//input[@placeholder]");
    // Кнопка "Go!"
    private final By goButton = By.xpath("//button[text()='Go!']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickYandexLogo() {
        driver.findElement(yandexLogo).click();
    }

    public void clickScooterLogo() {
        driver.findElement(scooterLogo).click();
    }

    public void clickOrderButtonHeader() {
        driver.findElement(orderButtonHeader).click();
    }

    public void clickOrderButtonMiddle() {
        driver.findElement(orderButtonMiddle).click();
    }

    public void clickOrderStatus() {
        driver.findElement(orderStatus).click();
    }

    public void setOrderStatus(String newOrderStatus) {
        driver.findElement(orderStatusInput).click();
        driver.findElement(orderStatusInput).clear();
        driver.findElement(orderStatusInput).sendKeys(newOrderStatus);
    }

    public void clickButtonGo() {
        driver.findElement(goButton).click();
    }

    public Boolean isAnswerVisible(int index) {
        By element = By.id("accordion__panel-" + index);
        return driver.findElement(element).isDisplayed();
    }

    public void clickQuestion(int index) {
        By element = By.id("accordion__heading-" + index);
        driver.findElement(element).click();
    }
}