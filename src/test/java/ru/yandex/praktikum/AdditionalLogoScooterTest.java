package ru.yandex.praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdditionalLogoScooterTest {
    @Test
    public void logoScooterTest()  throws Exception {
        InitBrowser TestBrowser = new InitBrowser();

        AdditionalLogoScooter TestAdditionalLogoScooter = new AdditionalLogoScooter(TestBrowser.getDriver());
        TestAdditionalLogoScooter.clickTopButtonOrder();
        TestAdditionalLogoScooter.clickLogoScooter();

        assertEquals(true, TestAdditionalLogoScooter.isMainPageHeader());

        Thread.sleep(2_000);

        TestBrowser.getDriver().quit();
    }
}
