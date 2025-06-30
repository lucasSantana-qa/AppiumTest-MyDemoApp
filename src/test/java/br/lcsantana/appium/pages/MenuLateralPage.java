package br.lcsantana.appium.pages;

import br.lcsantana.appium.utils.Utils;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

import static br.lcsantana.appium.core.DriverFactory.getDriver;

public class MenuLateralPage {

    public void fazerLogin() {
        Utils.swipe(0.01, 0.9);

        Utils.esperarElemento(MobileBy.AccessibilityId("Login Menu Item"));

        getDriver().findElement(MobileBy.AccessibilityId("Login Menu Item")).click();

        Utils.esperarElemento(By.id("com.saucelabs.mydemoapp.android:id/loginTV"));

        getDriver().findElement(By.id("com.saucelabs.mydemoapp.android:id/nameET")).sendKeys("bod@example.com");
        getDriver().findElement(By.id("com.saucelabs.mydemoapp.android:id/passwordET")).sendKeys("10203040");

        getDriver().findElement(MobileBy.AccessibilityId("Tap to login with given credentials")).click();
    }

    public void abrirMenuLateral() {
        Utils.swipe(0.01, 0.9);
    }

    public void resetAppState() {
        Utils.click(By.xpath("//android.widget.TextView[@text='Reset App State']"));
        Utils.esperarElemento(By.id("com.saucelabs.mydemoapp.android:id/parentPanel"));
        Utils.click(By.id("android:id/button1"));
        Utils.esperarElemento(By.xpath("//*[@text='App State has been reset.']"));
        Utils.click(By.id("android:id/button1"));
    }
}
