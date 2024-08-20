package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class OrderPageObj {
    private WebDriver driver;

    //Имя
    private By name = By.xpath(".//input[@placeholder='* Имя']");
    //Фамилия
    private By surname = By.xpath(".//input[@placeholder='* Фамилия']");
    //Адрес
    private By adressOrder = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Телефон
    private By phone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Станция метро
    private By metroStation = By.xpath(".//input[@placeholder='* Станция метро']");
    //Кнопка Далее
    private By buttonNext = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button");
    //Когда привезти
    private By dateOrder = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Срок аренды
    private By daysOrder = By.className("Dropdown-placeholder");
    //Черный цвет
    private By colourBlack = By.id("black");
    //Серый цвет
    private By colourGray = By.id("grey");
    //Комментарий
    private By comments = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка Заказать
    private By buttonOrder = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    //Кнопка Да
    private By buttonYes = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    //Сообщение Заказ оформлен
    private By orderConfirmMessage = By.xpath(".//div[text()='Заказ оформлен']");


    public OrderPageObj(WebDriver driver) {
        this.driver = driver;
    }

    //Заполнить Имя
    public void setName(String name) {
        driver.findElement(this.name).sendKeys(name);
    }

    //Заполнить Фамилию
    public void setSurname(String surname) {
        driver.findElement(this.surname).sendKeys(surname);
    }

    //Заполнить Адрес
    public void setAdressOrder(String adressOrder) {
        driver.findElement(this.adressOrder).sendKeys(adressOrder);
    }

    //Выбор станции метро
    public void selectMetroStation(String metroStation) {
        driver.findElement(this.metroStation).click();
        By metroStationName = By.xpath(".//div[text()='" + metroStation + "']");
        driver.findElement(metroStationName).click();
    }

    //Заполнить Телефон
    public void setPhone(String phone) {
        driver.findElement(this.phone).sendKeys(phone);
    }

    //Клик по кнопке Далее
    public void clickButtonNext() {
        driver.findElement(buttonNext).click();
    }

    //Указать дату
    public void setDateOrder(String dateOrder) {
        driver.findElement(this.dateOrder).click();
        By dateOrderValue = By.xpath(".//div[contains(@aria-label,'" + dateOrder + "')]");
        driver.findElement(dateOrderValue).click();
    }

    //Выбор срока аренды
    public void selectDaysOrder(String daysOrder) {
        driver.findElement(this.daysOrder).click();
        By daysOrderValue = By.xpath(".//div[text()='" + daysOrder + "']");
        driver.findElement(daysOrderValue).click();
    }

    //Выбор черного цвета
    public void clickColourBlack() {
        driver.findElement(colourBlack).click();
    }

    //Выбор серого цвета
    public void clickColourGray() {
        driver.findElement(colourGray).click();
    }

    //Выбор цвета
    public void setColour(String colour) {
        if (Objects.equals(colour, "черный жемчуг"))
            clickColourBlack();
        else if (Objects.equals(colour, "серая безысходность")) {
            clickColourGray();
        }
    }

    //Заполнить Комментарии
    public void setComments(String comments) {
        driver.findElement(this.comments).sendKeys(comments);
    }

    //Заполнение полей данными для заказа
    public void setOrderData(String name, String surname, String adressOrder, String metroStation, String phone, String dateOrder,
                             String daysOrder, String colour, String comments) {
        setName(name);
        setSurname(surname);
        setAdressOrder(adressOrder);
        selectMetroStation(metroStation);
        setPhone(phone);
        clickButtonNext();
        setDateOrder(dateOrder);
        selectDaysOrder(daysOrder);
        setColour(colour);
        setComments(comments);
    }

    //Клик по кнопке Заказать
    public void clickButtonOrder() {
        driver.findElement(buttonOrder).click();
    }

    //Клик по кнопке Да
    public void clickButtonYes() {
        driver.findElement(buttonYes).click();
    }

    //Наличие текста Заказ оформлен
    public boolean isOrderConfirmMessage() {
        return driver.findElement(orderConfirmMessage).isDisplayed();
    }
}
