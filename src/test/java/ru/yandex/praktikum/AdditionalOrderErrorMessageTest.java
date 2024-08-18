package ru.yandex.praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdditionalOrderErrorMessageTest {
    @Test
    public void orderErrorMessageTest()  throws Exception {
        InitBrowser TestBrowser = new InitBrowser();

        AdditionalOrderErrorMessage TestAdditionalOrderErrorMessage = new AdditionalOrderErrorMessage(TestBrowser.getDriver());
        TestAdditionalOrderErrorMessage.clickTopButtonOrder();
        TestAdditionalOrderErrorMessage.clickButtonNext();
        TestAdditionalOrderErrorMessage.setAdressOrder("12");

        assertEquals(true, TestAdditionalOrderErrorMessage.isNameError());
        assertEquals(true, TestAdditionalOrderErrorMessage.isSurnameError());
        assertEquals(true, TestAdditionalOrderErrorMessage.isAdressOrderError());
        assertEquals(true, TestAdditionalOrderErrorMessage.isMetroStationError());
        assertEquals(true, TestAdditionalOrderErrorMessage.isPhoneError());


        Thread.sleep(2_000);

        TestBrowser.getDriver().quit();
    }
}
