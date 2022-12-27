package ru.yandex.scooter.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
    WebDriver driver;
    // Поле "Имя"
    By name = By.xpath(".//input[@placeholder='* Имя']");
    // Поле "Фамилия"
    By surName = By.xpath(".//input[@placeholder='* Фамилия']");
    // Поле "Адрес"
    By address = By.xpath(".//input[contains(@placeholder,'Адрес')]");
    // Кнопка "Метро" с выпадающим списком
    By metroButton = By.className("select-search__input");
    // Список станций метро
    By metroStation = By.className("select-search__row");
    // Поле "Номер телефона"
    By phoneNumber = By.xpath(".//input[contains(@placeholder,'Телефон')]");
    // Кнопка "Далее"
    By nextButton = By.xpath(".//button[text()='Далее']");

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
        driver.findElement(nextButton).click();
    }
}
