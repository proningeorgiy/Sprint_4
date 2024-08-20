package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdditionalLogoYandexTest {
    InitBrowser testBrowser;

    public AdditionalLogoYandexTest() {
        testBrowser = new InitBrowser();
    }

    @Test
    public void logoYandexTest() throws Exception {
        AdditionalLogoYandex testAdditionalLogoYandex = new AdditionalLogoYandex(testBrowser.getDriver());
        testAdditionalLogoYandex.clickLogoYandex();

        Object[] windowHandles = testBrowser.getDriver().getWindowHandles().toArray();
        testBrowser.getDriver().switchTo().window((String) windowHandles[1]);

        assertEquals("Дзен", testAdditionalLogoYandex.getPageTitle("Дзен"));

        //Thread.sleep(2_000);
    }

    @After
    public void CloseBrowser() {
        testBrowser.getDriver().quit();
    }
}
