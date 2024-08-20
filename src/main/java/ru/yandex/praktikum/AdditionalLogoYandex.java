package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdditionalLogoYandex {
    private WebDriver driver;

    //Логотип Яндекс
    private By logoYandex = By.xpath(".//img[@alt='Yandex']");

    //Конструктор класса
    public AdditionalLogoYandex(WebDriver driver) {
        this.driver = driver;
    }

    //Клик по логотипу Яндекс
    public void clickLogoYandex() {
        driver.findElement(logoYandex).click();
    }

    //Получение названия страницы
    public String getPageTitle(String PageTitle) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleIs(PageTitle));

        return driver.getTitle();
    }
}
