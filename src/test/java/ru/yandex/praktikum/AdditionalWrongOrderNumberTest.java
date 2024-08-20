package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdditionalWrongOrderNumberTest {
    InitBrowser testBrowser;

    public AdditionalWrongOrderNumberTest() {
        testBrowser = new InitBrowser();
    }

    @Test
    public void wrongOrderNumberTest() throws Exception {
        AdditionalWrongOrderNumber testAdditionalWrongOrderNumber = new AdditionalWrongOrderNumber(testBrowser.getDriver());
        testAdditionalWrongOrderNumber.clickButtonOrderStatus();
        testAdditionalWrongOrderNumber.setOrderNumber("12345");
        testAdditionalWrongOrderNumber.clickButtonGo();

        assertEquals(true, testAdditionalWrongOrderNumber.isOrderNotFound());

        //Thread.sleep(2_000);
    }

    @After
    public void CloseBrowser() {
        testBrowser.getDriver().quit();
    }
}
