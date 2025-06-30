package br.lcsantana.appium.pages;

import br.lcsantana.appium.utils.Utils;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class ProdutoPage {

    public void adicionarProdutoNoCarrinho() {
        Utils.click(By.xpath("//*[@text='Sauce Labs Backpack']/preceding-sibling::*"));
        Utils.esperarElemento(MobileBy.AccessibilityId("Displays available colors of selected product"));
        Utils.scrollDown(0.1);
        Utils.esperarElemento(MobileBy.AccessibilityId("Tap to add product to cart"));
        Utils.click(MobileBy.AccessibilityId("Tap to add product to cart"));
    }

    public void acessarCarrinho() {
        Utils.esperarElemento(By.xpath("//*[@text='1']"));
        Utils.click(By.xpath("//*[@text='1']"));
        Utils.esperarElemento(By.xpath("//*[@text='My Cart']"));
    }
}
