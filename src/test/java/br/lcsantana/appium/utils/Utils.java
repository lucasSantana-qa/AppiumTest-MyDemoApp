package br.lcsantana.appium.utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static br.lcsantana.appium.core.DriverFactory.getDriver;

public class Utils {

    public static void esperarElemento(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(),5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void swipe(double inicio, double fim) {
        Dimension size = getDriver().manage().window().getSize();

        int y = size.height/2;

        int posit_init_x = (int) (size.width*inicio);
        int posit_end_x = (int) (size.width*fim);

        new TouchAction<>(getDriver()).longPress(PointOption.point(posit_init_x, y))
                .moveTo(PointOption.point(posit_end_x, y)).release().perform();
    }

    public static Boolean existeElemento(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(),5);
        return wait.until(ExpectedConditions.not(ExpectedConditions.invisibilityOfElementLocated(by)));
    }

    public static String obterTexto(By by) {
        return getDriver().findElement(by).getText();
    }

    public static void click(By by) {
        getDriver().findElement(by).click();
    }

    public static void scrollDown(double fim) {
        Dimension size = getDriver().manage().window().getSize();
        int x = size.width/2;
        int y_init = size.height;
        int y_end = (int) (size.height*fim);

        new TouchAction<>(getDriver()).longPress(PointOption.point(x, y_init))
                .moveTo(PointOption.point(x, y_end)).release().perform();

    }
}
