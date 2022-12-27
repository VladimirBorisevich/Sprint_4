package ru.yandex.scooter.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderStatusPage {
    WebDriver driver;
    // Кнопка "Отменить заказ"
    By orderCancelButton = By.xpath(".//button[text()='Отменить заказ']");
    // Кнопка "Отменить" (Посе кнопки "Отменить заказ")
    By orderCancelCancelButton = By.xpath(".//button[text()='Отменить']");
    By orderCancelled = By.className("Order_ModalHeader__3FDaJ");
    // Информация о заказе
    By orderInfo = By.className("Track_Value__15eEX");

    public OrderStatusPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderCancelButton() {
        driver.findElement(orderCancelButton).click();
    }

    public List<WebElement> getOrderInfo() {
        return driver.findElements(orderInfo);
    }

    public void clickOrderCancelCancelButton() {
        driver.findElement(orderCancelCancelButton).click();
    }

    public String getOrderCancelled() {
        return driver.findElement(orderCancelled).getText();
    }
}
