package ru.yandex.scooter.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderStatusPage {
    WebDriver driver;

    By buttonOrderCancel = By.xpath(".//button[text()='Отменить заказ']");
    By buttonOrderCancelCancel = By.xpath(".//button[text()='Отменить']");
    By orderCancelled = By.className("Order_ModalHeader__3FDaJ");
    By orderInfo = By.className("Track_Value__15eEX");

    public OrderStatusPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickButtonOrderCancel(){
        driver.findElement(buttonOrderCancel).click();
    }
    public List<WebElement> getOrderInfo(){
        return driver.findElements(orderInfo);
    }
    public void clickButtonOrderCancelCancel(){
        driver.findElement(buttonOrderCancelCancel).click();
    }
    public String getOrderCancelled(){
        return driver.findElement(orderCancelled).getText();
    }
}
