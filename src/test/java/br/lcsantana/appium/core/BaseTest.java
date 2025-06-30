package br.lcsantana.appium.core;

import br.lcsantana.appium.pages.MenuLateralPage;
import br.lcsantana.appium.utils.Utils;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

import static br.lcsantana.appium.core.DriverFactory.*;

public class BaseTest {

    MenuLateralPage mlPage = new MenuLateralPage();

    @BeforeEach
    public void setup() {
        Utils.esperarElemento(MobileBy.AccessibilityId("App logo and name"));
        mlPage.abrirMenuLateral();
        mlPage.resetAppState();
    }

    @AfterEach
    public void resetApp() {
        getDriver().resetApp();
    }

    @AfterAll
    public static void teardown() {
        killDriver();
    }
}
