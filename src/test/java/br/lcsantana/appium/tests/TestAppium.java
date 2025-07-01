package br.lcsantana.appium.tests;

import br.lcsantana.appium.core.BaseTest;
import br.lcsantana.appium.pages.CarrinhoPage;
import br.lcsantana.appium.pages.MenuLateralPage;
import br.lcsantana.appium.pages.ProdutoPage;
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
    ProdutoPage prPage = new ProdutoPage();
    CarrinhoPage crPage = new CarrinhoPage();

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
        prPage.adicionarProdutoNoCarrinho();
        prPage.acessarCarrinho();

        Assertions.assertEquals("Sauce Labs Backpack", Utils.obterTexto(By.xpath("//*[@text='Sauce Labs Backpack']")));
        Assertions.assertEquals(crPage.getPrecoProduto(), crPage.getPrecoCarrinho());
        Assertions.assertEquals("1", crPage.getQtdProduto());
        MatcherAssert.assertThat(crPage.getQtdProdutoCarrinho(), Matchers.containsString("1 "));
    }
}