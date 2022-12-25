package ru.yandex.scooter.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class MainPage {
    WebDriver driver;
    By yandexLogo = By.className("Header_LogoYandex__3TSOI");
    By scooterLogo = By.className("Header_LogoScooter__3lsAR");
    By orderButtonHeader = By.xpath(".//div[@class='Header_Nav__AGCXC']//button[@class='Button_Button__ra12g']");
    By orderButtonMiddle = By.xpath(".//div[@class='Home_FinishButton__1_cWm']//button");
    By orderStatus = By.className("Header_Link__1TAG7");
    By impotentQuestions = By.className("accordion__button");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickYandexLogo(){
        driver.findElement(yandexLogo).click();
    }
    public void clickScooterLogo(){
        driver.findElement(scooterLogo).click();
    }
    public void clickOrderButtonHeader(){
        driver.findElement(orderButtonHeader).click();
    }
    public void clickOrderButtonMiddle(){
        driver.findElement(orderButtonMiddle).click();
    }
    public void clickOrderStatus(){
        driver.findElement(orderStatus).click();
    }
}