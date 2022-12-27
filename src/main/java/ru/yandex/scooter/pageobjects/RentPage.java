package ru.yandex.scooter.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RentPage {
    WebDriver driver;
    // Поле "Когда привезти самокат"
    By rentDate = By.cssSelector("div.react-datepicker__input-container>input");
    // Стрелка с выпадающим списом
    By rentTime = By.className("Dropdown-arrow");
    // Список дней аренды
    By rentTimeDays = By.className("Dropdown-option");
    // Кнопка "Заказать"
    By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']//button[text()='Заказать']");
    // Кнопка "Да"
    By getOrderYesButton = By.xpath(".//button[text()='Да']");
    // Информация подтверждения заказа
    By orderConfirmation = By.className("Order_ModalHeader__3FDaJ");
    // Номер заказа
    By orderNumber = By.className("Order_Text__2broi");
    // Кнопка "Посмотреть заказ"
    By watchStatusButton = By.cssSelector(".Order_NextButton__1_rCA > button");

    public RentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setRentDate(String newRentDate) {
        driver.findElement(rentDate).click();
        driver.findElement(rentDate).clear();
        driver.findElement(rentDate).sendKeys(newRentDate);
    }

    public void clickRentTime() {
        driver.findElement(rentTime).click();
    }

    public void clickRentTimeDays(int day) {
        driver.findElements(rentTimeDays).get(day).click();
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickOrderYesButton() {
        driver.findElement(getOrderYesButton).click();
    }

    public String getOrderConfirmation() {
        return driver.findElement(orderConfirmation).getText();
    }

    public String getOrderNumber() {
        return driver.findElement(orderNumber).getText().split("\\s+")[2];
    }

    public void clickWatchStatusButton() {
        driver.findElement(watchStatusButton).click();
    }
}
