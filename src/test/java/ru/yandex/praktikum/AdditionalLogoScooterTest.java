package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdditionalLogoScooterTest {
    InitBrowser testBrowser;

    public AdditionalLogoScooterTest() {
        testBrowser = new InitBrowser();
    }

    @Test
    public void logoScooterTest() throws Exception {

        AdditionalLogoScooter testAdditionalLogoScooter = new AdditionalLogoScooter(testBrowser.getDriver());
        testAdditionalLogoScooter.clickTopButtonOrder();
        testAdditionalLogoScooter.clickLogoScooter();

        assertEquals(true, testAdditionalLogoScooter.isMainPageHeader());
    }

    @After
    public void CloseBrowser() {
        testBrowser.getDriver().quit();
    }
}
