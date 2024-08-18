package ru.yandex.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FAQQuestionTest {
    private final String questionID;
    private final String questionText;

    public FAQQuestionTest(String questionID, String questionText){
        this.questionID = questionID;
        this.questionText = questionText;
    }

    @Parameterized.Parameters
    public static Object[][] FAQs() {
        return new Object[][] {
                {"0", "Сколько это стоит? И как оплатить?"},
                {"1", "Хочу сразу несколько самокатов! Так можно?"},
                {"2", "Как рассчитывается время аренды?"},
                {"3", "Можно ли заказать самокат прямо на сегодня?"},
                {"4", "Можно ли продлить заказ или вернуть самокат раньше?"},
                {"5", "Вы привозите зарядку вместе с самокатом?"},
                {"6", "Можно ли отменить заказ?"},
                {"7", "Я живу за МКАДом, привезёте?"},
        };
    }

    @Test
    public void questionsTest()  throws Exception {
        InitBrowser TestBrowser = new InitBrowser();

        MainPageObj testMainPageObj = new MainPageObj(TestBrowser.getDriver(), questionID);
        testMainPageObj.clickQuestion();

        assertEquals(questionText, testMainPageObj.getQuestion());

        TestBrowser.getDriver().quit();
    }
}
