package ru.yandex.scooter.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    WebDriver driver;
    By name = By.xpath(".//input[@placeholder='* Имя']");
    By surName = By.xpath(".//input[@placeholder='* Фамилия']");
    By address = By.xpath(".//input[contains(@placeholder,'Адрес')]");
    By metro = By.className("select-search__input");
    By phoneNumber = By.xpath(".//input[contains(@placeholder,'Телефон')]");
    By buttonNext = By.xpath(".//button[text()='Далее']");

    public OrderPage(WebDriver driver){
        this.driver = driver;
    }

    public void setName(String newName){
        driver.findElement(name).click();
        driver.findElement(name).clear();
        driver.findElement(name).sendKeys(newName);
    }
    public void setSurName(String newSurName){
        driver.findElement(surName).click();
        driver.findElement(surName).clear();
        driver.findElement(surName).sendKeys(newSurName);
    }
    public void setAddress(String newAddress){
        driver.findElement(address).click();
        driver.findElement(address).clear();
        driver.findElement(address).sendKeys(newAddress);
    }
    public void setPhoneNumber(String newPhoneNumber){
        driver.findElement(phoneNumber).click();
        driver.findElement(phoneNumber).clear();
        driver.findElement(phoneNumber).sendKeys(newPhoneNumber);
    }
    public void clickButtonNext(){
        driver.findElement(buttonNext).click();
    }
}
