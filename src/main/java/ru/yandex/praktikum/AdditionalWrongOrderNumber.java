package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdditionalWrongOrderNumber {
    private WebDriver driver;

    //Кнопка Статус заказа
    private By buttonOrderStatus = By.className("Header_Link__1TAG7");
    //Поле для ввода номера заказа
    private By orderNumber = By.cssSelector(".Header_Input__xIoUq");
    //Кнопка Go!
    private By buttonGo = By.xpath(".//button[text()='Go!']");
    //Элемент с сообщением, что такого заказа нет
    private By orderNotFound = By.cssSelector(".Track_NotFound__6oaoY");

    //Конструктор класса
    public AdditionalWrongOrderNumber(WebDriver driver) {
        this.driver = driver;
    }

    //Клик по кнопке Статус заказа
    public void clickButtonOrderStatus(){
        driver.findElement(buttonOrderStatus).click();
    }
    //Заполнить номер заказа
    public void setOrderNumber(String orderNumber){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(driver.findElement(this.orderNumber)));

        driver.findElement(this.orderNumber).sendKeys(orderNumber);
    }
    //Клик по кнопке Go!
    public void clickButtonGo(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(buttonGo)));

        driver.findElement(buttonGo).click();
    }
    //Наличие элемента с сообщением, что такого заказа нет
    public boolean isOrderNotFound(){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(driver.findElement(orderNotFound)));

        return driver.findElement(orderNotFound).isDisplayed();
    }
}
