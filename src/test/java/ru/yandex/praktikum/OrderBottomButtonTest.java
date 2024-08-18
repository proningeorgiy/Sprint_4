package ru.yandex.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Objects;

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

    public OrderBottomButtonTest(String name, String surname, String adressOrder, String metroStation,
                                 String phone, String dateOrder, String daysOrder, String colour, String comments, boolean isOrderConfirmMessage){
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
    }

    @Parameterized.Parameters
    public static Object[][] FAQs() {
        return new Object[][] {
                {"Петр", "Петров", "Тестовая улица", "Митино", "89037418523", "29-е августа 2024", "двое суток", "черный жемчуг", "Тестовые комментарии 3", true},
                {"Сидор", "Сидоров", "Тестовая площадь", "Кожуховская", "89169632587", "21-е августа 2024", "пятеро суток", "серая безысходность", "Тестовые комментарии 4", true},
        };
    }

    @Test
    public void bottomButtonOrderTest()  throws Exception {
        InitBrowser TestBrowser = new InitBrowser();

        MainPageObj TestMainPageObj = new MainPageObj(TestBrowser.getDriver());
        TestMainPageObj.clickBottomButtonOrder();

        OrderPageObj TestOrderPageObj = new OrderPageObj(TestBrowser.getDriver());
        TestOrderPageObj.setName(name);
        TestOrderPageObj.setSurname(surname);
        TestOrderPageObj.setAdressOrder(adressOrder);
        TestOrderPageObj.selectMetroStation(metroStation);
        TestOrderPageObj.setPhone(phone);
        TestOrderPageObj.clickButtonNext();
        TestOrderPageObj.setDateOrder(dateOrder);
        TestOrderPageObj.selectDaysOrder(daysOrder);

        if(Objects.equals(colour, "черный жемчуг"))
            TestOrderPageObj.clickColourBlack();
        else if (Objects.equals(colour, "серая безысходность")) {
            TestOrderPageObj.clickColourGray();
        }

        TestOrderPageObj.setComments(comments);
        TestOrderPageObj.clickButtonOrder();
        TestOrderPageObj.clickButtonYes();

        assertEquals(isOrderConfirmMessage, TestOrderPageObj.isOrderConfirmMessage());

        Thread.sleep(2_000);

        TestBrowser.getDriver().quit();
    }
}
