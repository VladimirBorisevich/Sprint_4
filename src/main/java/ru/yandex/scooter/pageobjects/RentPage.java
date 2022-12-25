package ru.yandex.scooter.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RentPage {
    WebDriver driver;

    By date = By.cssSelector("div.react-datepicker__input-container>input");
    By rentTime = By.className("Dropdown-control");
    By rentTimeDays = By.className("Dropdown-option");
    By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']//button[text()='Заказать']");
    By getOrderButtonYes = By.xpath(".//button[text()='Да']");
    By orderConfirmation = By.className("Order_ModalHeader__3FDaJ");
    By orderNumber = By.className("Order_Text__2broi");

    public RentPage(WebDriver driver){
        this.driver = driver;
    }
    public String getOrderNumber(){
        return driver.findElement(orderNumber).getText().split(System.lineSeparator())[1];
    }

    public void clickDate(){
        driver.findElement(date).click();
    }
    public void clickRentTime(){
        driver.findElement(rentTime).click();
    }
    public void clickRentTimeDays(){
        driver.findElement(rentTimeDays).click();
    }
    public void clickOrderButton(){
        driver.findElement(orderButton).click();
    }
    public void clickOrderButtonYes(){
        driver.findElement(getOrderButtonYes).click();
    }
    public String getOrderConfirmation(){
        return driver.findElement(orderConfirmation).getText();
    }
}
