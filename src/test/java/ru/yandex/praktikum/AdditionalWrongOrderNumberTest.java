package ru.yandex.praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdditionalWrongOrderNumberTest {
    @Test
    public void wrongOrderNumberTest()  throws Exception {
        InitBrowser TestBrowser = new InitBrowser();

        AdditionalWrongOrderNumber TestAdditionalWrongOrderNumber = new AdditionalWrongOrderNumber(TestBrowser.getDriver());
        TestAdditionalWrongOrderNumber.clickButtonOrderStatus();
        TestAdditionalWrongOrderNumber.setOrderNumber("12345");
        TestAdditionalWrongOrderNumber.clickButtonGo();

        assertEquals(true, TestAdditionalWrongOrderNumber.isOrderNotFound());

        Thread.sleep(2_000);

        TestBrowser.getDriver().quit();
    }
}
