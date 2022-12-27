package ru.yandex.scooter.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;
    // Кнопка "Заказать" вверху страницы
    private final By orderButtonHeader = By.xpath(".//div[@class='Header_Nav__AGCXC']//button[@class='Button_Button__ra12g']");
    // Кнопка "Заказать" посередине страницы
    private final By orderButtonMiddle = By.xpath(".//div[@class='Home_FinishButton__1_cWm']//button");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderButtonHeader() {
        driver.findElement(orderButtonHeader).click();
    }

    public void clickOrderButtonMiddle() {
        driver.findElement(orderButtonMiddle).click();
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