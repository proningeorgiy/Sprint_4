package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageObj {
    private WebDriver driver;

    //Поле с вопросом в FAQ
    private By question;
    //Поле с ответом в FAQ
    private By answer;

    //Верхняя кнопка заказать
    private By buttonTopOrder = By.className("Button_Button__ra12g");
    //Нижняя кнопка заказать
    private By buttonBottomOrder = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");

    //Конструктор класса для заказа
    public MainPageObj(WebDriver driver) {
        this.driver = driver;
    }

    //Конструктор класса для FAQ
    public MainPageObj(WebDriver driver, String ID) {
        this.driver = driver;
        this.question = By.id("accordion__heading-" + ID);
        this.answer = By.id("accordion__panel-" + ID);
    }

    //Получение текста вопроса
    public String getQuestion() {
        return driver.findElement(question).getText();
    }

    //Получение текста ответа
    public String getAnswer() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(driver.findElement(answer)));

        return driver.findElement(answer).getText();
    }

    //Клик на вопрос
    public void clickQuestion() {
        driver.findElement(question).click();
    }

    //Клик по верхней кнопке Заказать
    public void clickTopButtonOrder() {
        driver.findElement(buttonTopOrder).click();
    }

    //Клик по нижней кнопке Заказать
    public void clickBottomButtonOrder() {
        driver.findElement(buttonBottomOrder).click();
    }
}
