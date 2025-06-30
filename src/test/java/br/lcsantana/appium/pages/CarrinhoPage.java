package br.lcsantana.appium.pages;

import br.lcsantana.appium.core.DriverFactory;
import org.openqa.selenium.By;

public class CarrinhoPage {

    public String getPrecoProduto() {
        return DriverFactory.getDriver().findElement(By.id("com.saucelabs.mydemoapp.android:id/priceTV")).getText();
    }

    public String getPrecoCarrinho() {
        return DriverFactory.getDriver().findElement(By.id("com.saucelabs.mydemoapp.android:id/totalPriceTV")).getText();
    }

    public String getQtdProduto() {
        return DriverFactory.getDriver().findElement(By.id("com.saucelabs.mydemoapp.android:id/noTV")).getText();
    }

    public String getQtdProdutoCarrinho() {
        return DriverFactory.getDriver().findElement(By.id("com.saucelabs.mydemoapp.android:id/itemsTV")).getText();
    }
}
