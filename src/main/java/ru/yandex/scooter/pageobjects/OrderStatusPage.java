package ru.yandex.scooter.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderStatusPage {
    private final WebDriver driver;
    // Кнопка "Отменить заказ"
    private final By orderCancelButton = By.xpath(".//button[text()='Отменить заказ']");
    // Кнопка "Отменить" (Посе кнопки "Отменить заказ")
    private final By orderCancelCancelButton = By.xpath(".//button[text()='Отменить']");
    private final By orderCancelled = By.className("Order_ModalHeader__3FDaJ");
    // Информация о заказе
    private final By orderInfo = By.className("Track_Value__15eEX");

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
