package ru.yandex.scooter.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
    private final WebDriver driver;
    // Поле "Имя"
    private final By name = By.xpath(".//input[@placeholder='* Имя']");
    // Поле "Фамилия"
    private final By surName = By.xpath(".//input[@placeholder='* Фамилия']");
    // Поле "Адрес"
    private final By address = By.xpath(".//input[contains(@placeholder,'Адрес')]");
    // Кнопка "Метро" с выпадающим списком
    private final By metroButton = By.className("select-search__input");
    // Список станций метро
    private final By metroStation = By.className("select-search__row");
    // Поле "Номер телефона"
    private final By phoneNumber = By.xpath(".//input[contains(@placeholder,'Телефон')]");
    // Кнопка "Далее"
    private final By nextButton = By.xpath(".//button[text()='Далее']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String newName) {
        driver.findElement(name).click();
        driver.findElement(name).clear();
        driver.findElement(name).sendKeys(newName);
    }

    public void setSurName(String newSurName) {
        driver.findElement(surName).click();
        driver.findElement(surName).clear();
        driver.findElement(surName).sendKeys(newSurName);
    }

    public void setAddress(String newAddress) {
        driver.findElement(address).click();
        driver.findElement(address).clear();
        driver.findElement(address).sendKeys(newAddress);
    }

    public void setPhoneNumber(String newPhoneNumber) {
        driver.findElement(phoneNumber).click();
        driver.findElement(phoneNumber).clear();
        driver.findElement(phoneNumber).sendKeys(newPhoneNumber);
    }

    public void clickButtonMetro() {
        driver.findElement(metroButton).click();
    }

    public void setMetro(int index) {
        WebElement element = driver.findElements(metroStation).get(index);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void clickButtonNext() {
        WebElement element = driver.findElement(nextButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void fillOrderPage(String name, String surName, String address, String phoneNumber, int metroStation) {
        this.setName(name);
        this.setSurName(surName);
        this.setAddress(address);
        this.setPhoneNumber(phoneNumber);
        this.clickButtonMetro();
        this.setMetro(metroStation);
        this.clickButtonNext();
    }
}
