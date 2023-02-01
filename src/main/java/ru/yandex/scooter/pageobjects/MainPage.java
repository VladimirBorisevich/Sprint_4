package ru.yandex.scooter.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;
    // Кнопка "Заказать" вверху страницы
    private final By orderButtonHeader = By.xpath(".//div[@class='Header_Nav__AGCXC']//button[@class='Button_Button__ra12g']");
    // Кнопка "Заказать" посередине страницы
    private final By orderButtonMiddle = By.xpath(".//div[@class='Home_FinishButton__1_cWm']//button");

    private final By questionButton = By.xpath(".//div[@class='accordion__button']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderButton(boolean flag) {
        if (flag) {
            driver.findElement(orderButtonHeader).click();
        } else {
            WebElement element = driver.findElement(orderButtonMiddle);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            element.click();
        }
    }

    public Boolean isAnswerVisible(int index) {
        By element = By.id("accordion__panel-" + index);
        new WebDriverWait(driver, 1)
                .until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElement(element).isDisplayed();
    }

    public void clickQuestion(int index) {
        driver.findElements(questionButton).get(index).click();
    }

    public String getAnswerText(int index) {
        By element = By.xpath(".//div[@id='accordion__panel-" + index + "']/p");
        return driver.findElement(element).getText();
    }

    public String getQuestionText(int index) {
        return driver.findElements(questionButton).get(index).getText();
    }
}