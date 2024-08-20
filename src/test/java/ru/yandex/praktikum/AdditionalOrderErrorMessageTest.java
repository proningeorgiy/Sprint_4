package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdditionalOrderErrorMessageTest {
    InitBrowser testBrowser;

    public AdditionalOrderErrorMessageTest() {
        testBrowser = new InitBrowser();
    }

    @Test
    public void orderErrorMessageTest() throws Exception {
        AdditionalOrderErrorMessage testAdditionalOrderErrorMessage = new AdditionalOrderErrorMessage(testBrowser.getDriver());
        testAdditionalOrderErrorMessage.clickTopButtonOrder();
        testAdditionalOrderErrorMessage.clickButtonNext();
        testAdditionalOrderErrorMessage.setAdressOrder("12");

        assertEquals(true, testAdditionalOrderErrorMessage.isNameError());
        assertEquals(true, testAdditionalOrderErrorMessage.isSurnameError());
        assertEquals(true, testAdditionalOrderErrorMessage.isAdressOrderError());
        assertEquals(true, testAdditionalOrderErrorMessage.isMetroStationError());
        assertEquals(true, testAdditionalOrderErrorMessage.isPhoneError());


        //Thread.sleep(2_000);
    }

    @After
    public void CloseBrowser() {
        testBrowser.getDriver().quit();
    }
}
