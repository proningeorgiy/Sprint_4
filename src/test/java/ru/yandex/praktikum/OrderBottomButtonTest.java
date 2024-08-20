package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderBottomButtonTest {
    private final String name;
    private final String surname;
    private final String adressOrder;
    private final String metroStation;
    private final String phone;
    private final String dateOrder;
    private final String daysOrder;
    private final String colour;
    private final String comments;
    private final boolean isOrderConfirmMessage;
    InitBrowser testBrowser;

    public OrderBottomButtonTest(String name, String surname, String adressOrder, String metroStation,
                                 String phone, String dateOrder, String daysOrder, String colour, String comments, boolean isOrderConfirmMessage) {
        this.name = name;
        this.surname = surname;
        this.adressOrder = adressOrder;
        this.metroStation = metroStation;
        this.phone = phone;
        this.dateOrder = dateOrder;
        this.daysOrder = daysOrder;
        this.colour = colour;
        this.comments = comments;
        this.isOrderConfirmMessage = isOrderConfirmMessage;

        testBrowser = new InitBrowser();
    }

    @Parameterized.Parameters
    public static Object[][] FAQs() {
        return new Object[][]{
                {"Петр", "Петров", "Тестовая улица", "Митино", "89037418523", "29-е августа 2024", "двое суток", "черный жемчуг", "Тестовые комментарии 3", true},
                {"Сидор", "Сидоров", "Тестовая площадь", "Кожуховская", "89169632587", "21-е августа 2024", "пятеро суток", "серая безысходность", "Тестовые комментарии 4", true},
        };
    }

    @Test
    public void bottomButtonOrderTest() throws Exception {
        MainPageObj testMainPageObj = new MainPageObj(testBrowser.getDriver());
        testMainPageObj.clickBottomButtonOrder();

        OrderPageObj testOrderPageObj = new OrderPageObj(testBrowser.getDriver());
        testOrderPageObj.setOrderData(name, surname, adressOrder, metroStation, phone, dateOrder, daysOrder, colour, comments);
        testOrderPageObj.clickButtonOrder();
        testOrderPageObj.clickButtonYes();

        assertEquals(isOrderConfirmMessage, testOrderPageObj.isOrderConfirmMessage());

        //Thread.sleep(2_000);
    }

    @After
    public void CloseBrowser() {
        testBrowser.getDriver().quit();
    }
}
