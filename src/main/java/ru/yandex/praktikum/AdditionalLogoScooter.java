package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdditionalLogoScooter {
    private WebDriver driver;

    //Логотип Самоката
    private By logoScooter = By.xpath(".//img[@alt='Scooter']");
    //Класс заголовка основной страницы
    private By mainPageHeader = By.className("Home_Header__iJKdX");
    //Верхняя кнопка заказать
    private By buttonTopOrder = By.className("Button_Button__ra12g");

    //Конструктор класса
    public AdditionalLogoScooter(WebDriver driver) {
        this.driver = driver;
    }

    //Клик по логотипу Самоката
    public void clickLogoScooter(){
        driver.findElement(logoScooter).click();
    }
    //Клик по верхней кнопке Заказать
    public void clickTopButtonOrder(){
        driver.findElement(buttonTopOrder).click();
    }
    //Наличие заголовка основной страницы
    public boolean isMainPageHeader(){
        return driver.findElement(mainPageHeader).isDisplayed();
    }
}
