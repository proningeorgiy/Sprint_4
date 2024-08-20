package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdditionalOrderErrorMessage {
    private WebDriver driver;

    //Верхняя кнопка заказать
    private By buttonTopOrder = By.className("Button_Button__ra12g");
    //Сообщение об ошибке в поле Имя
    private By nameError = By.xpath(".//div[text()='Введите корректное имя']");
    //Сообщение об ошибке в поле Фамилия
    private By surnameError = By.xpath(".//div[text()='Введите корректную фамилию']");
    //Адрес
    private By adressOrder = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Сообщение об ошибке в поле Адрес
    private By adressOrderError = By.xpath(".//div[text()='Введите корректный адрес']");
    //Станция метро
    private By metroStationError = By.xpath(".//div[text()='Выберите станцию']");
    //Сообщение об ошибке в поле Телефон
    private By phoneError = By.xpath(".//div[text()='Введите корректный номер']");
    //Кнопка Далее
    private By buttonNext = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button");

    //Конструктор класса
    public AdditionalOrderErrorMessage(WebDriver driver) {
        this.driver = driver;
    }

    //Клик по верхней кнопке Заказать
    public void clickTopButtonOrder() {
        driver.findElement(buttonTopOrder).click();
    }

    //Клик по кнопке Далее
    public void clickButtonNext() {
        driver.findElement(buttonNext).click();
    }

    //Заполнить Адрес
    public void setAdressOrder(String adressOrder) {
        driver.findElement(this.adressOrder).sendKeys(adressOrder);
    }

    //Наличие сообщения об ошибке для поля Имя
    public boolean isNameError() {
        return driver.findElement(nameError).isDisplayed();
    }

    //Наличие сообщения об ошибке для поля Фамилия
    public boolean isSurnameError() {
        return driver.findElement(surnameError).isDisplayed();
    }

    //Наличие сообщения об ошибке для поля Адрес
    public boolean isAdressOrderError() {
        return driver.findElement(adressOrderError).isDisplayed();
    }

    //Наличие сообщения об ошибке для списка со станциями метро
    public boolean isMetroStationError() {
        return driver.findElement(metroStationError).isDisplayed();
    }

    //Наличие сообщения об ошибке для поля Телефон
    public boolean isPhoneError() {
        return driver.findElement(phoneError).isDisplayed();
    }
}
