package ru.yandex.scooter.pageobjects;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertTrue;

public class RentPage {
    private final WebDriver driver;
    // Поле "Когда привезти самокат"
    private final By rentDate = By.cssSelector("div.react-datepicker__input-container>input");
    // Стрелка с выпадающим списом
    private final By rentTime = By.className("Dropdown-arrow");
    // Список дней аренды
    private final By rentTimeDays = By.className("Dropdown-option");
    // Кнопка "Заказать"
    private final By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']//button[text()='Заказать']");
    // Кнопка "Да"
    private final By getOrderYesButton = By.xpath(".//button[text()='Да']");
    // Информация подтверждения заказа
    private final By orderConfirmation = By.className("Order_ModalHeader__3FDaJ");
    // Кнопка "Посмотреть заказ"
    private final By watchStatusButton = By.cssSelector(".Order_NextButton__1_rCA > button");

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

    public void clickWatchStatusButton() {
        driver.findElement(watchStatusButton).click();
    }

    public void fillRentPage(String rentDate, int rentTimeDays) {
        this.setRentDate(rentDate);
        this.clickRentTime();
        this.clickRentTimeDays(rentTimeDays);
        this.clickOrderButton();
        this.clickOrderYesButton();
        String confirmationText = this.getOrderConfirmation();
        // Проверка того, что появилось окно с подтверждением заказа
        assertTrue(driver.findElement(orderConfirmation).isDisplayed());
        MatcherAssert.assertThat(confirmationText, containsString("оформлен"));
        this.clickWatchStatusButton();
    }
}
