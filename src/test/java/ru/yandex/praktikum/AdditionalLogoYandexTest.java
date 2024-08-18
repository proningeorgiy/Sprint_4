package ru.yandex.praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AdditionalLogoYandexTest {
    @Test
    public void logoYandexTest()  throws Exception {
        InitBrowser TestBrowser = new InitBrowser();

        AdditionalLogoYandex TestAdditionalLogoYandex = new AdditionalLogoYandex(TestBrowser.getDriver());
        TestAdditionalLogoYandex.clickLogoYandex();

        Object[] windowHandles=TestBrowser.getDriver().getWindowHandles().toArray();
        TestBrowser.getDriver().switchTo().window((String) windowHandles[1]);

        assertEquals("Дзен", TestAdditionalLogoYandex.getPageTitle("Дзен"));

        Thread.sleep(2_000);

        TestBrowser.getDriver().quit();
    }
}
