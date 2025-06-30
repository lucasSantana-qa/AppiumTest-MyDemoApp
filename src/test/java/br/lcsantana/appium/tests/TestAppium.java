package br.lcsantana.appium.tests;

import br.lcsantana.appium.core.BaseTest;
import br.lcsantana.appium.core.DriverFactory;
import br.lcsantana.appium.pages.MenuLateralPage;
import br.lcsantana.appium.utils.Utils;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Feature;
import io.qameta.allure.junit5.AllureJunit5;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

@ExtendWith(AllureJunit5.class)
public class TestAppium extends BaseTest {

    MenuLateralPage mlPage = new MenuLateralPage();

    @Test
    @Feature("Login")
    public void testLoginComSucesso() {
        mlPage.fazerLogin();
        mlPage.abrirMenuLateral();
        Assertions.assertTrue(Utils.existeElemento(MobileBy.AccessibilityId("Logout Menu Item")));
        Assertions.assertEquals("Log Out", Utils.obterTexto(MobileBy.AccessibilityId("Logout Menu Item")));
    }

    @Test
    @Feature("Compras item")
    public void testComprarItem() {
        Utils.click(By.xpath("//*[@text='Sauce Labs Backpack']/preceding-sibling::*"));
        Utils.esperarElemento(MobileBy.AccessibilityId("Displays available colors of selected product"));
        Utils.scrollDown(0.1);
        Utils.esperarElemento(MobileBy.AccessibilityId("Tap to add product to cart"));
        Utils.click(MobileBy.AccessibilityId("Tap to add product to cart"));
        Utils.esperarElemento(By.xpath("//*[@text='1']"));
        Utils.click(By.xpath("//*[@text='1']"));
        Utils.esperarElemento(By.xpath("//*[@text='My Cart']"));

        String priceProduct = DriverFactory.getDriver().findElement(By.id("com.saucelabs.mydemoapp.android:id/priceTV")).getText();
        String totalPrice = DriverFactory.getDriver().findElement(By.id("com.saucelabs.mydemoapp.android:id/totalPriceTV")).getText();

        String qtdProduct = DriverFactory.getDriver().findElement(By.id("com.saucelabs.mydemoapp.android:id/noTV")).getText();
        String qtdItemCart = DriverFactory.getDriver().findElement(By.id("com.saucelabs.mydemoapp.android:id/itemsTV")).getText();

        Assertions.assertEquals("Sauce Labs Backpack", Utils.obterTexto(By.xpath("//*[@text='Sauce Labs Backpack']")));
        Assertions.assertEquals(priceProduct, totalPrice);
        Assertions.assertEquals("1", qtdProduct);
        MatcherAssert.assertThat(qtdItemCart, Matchers.containsString("1"));
    }
}