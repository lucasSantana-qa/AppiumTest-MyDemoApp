package br.lcsantana.appium.core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory implements Propriedades{

    protected static AndroidDriver<MobileElement> driver;

    public static AndroidDriver<MobileElement> getDriver() {
        if (driver == null) {
            if (exec == TipoExecucao.LOCAL) {
                initDriverLocal();
            }
            if (exec == TipoExecucao.CLOUD) {
                initDriverCloud();
            }
        }
        return driver;
    }

    public static void killDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private static void initDriverLocal() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Pixel_4");
        cap.setCapability("automationName", "uiautomator2");
        cap.setCapability("platformName", "Android");
        cap.setCapability("appPackage", "com.saucelabs.mydemoapp.android");
        cap.setCapability("appActivity", "com.saucelabs.mydemoapp.android.view.activities.SplashActivity");
        cap.setCapability(MobileCapabilityType.APP, "C:\\QA\\Appium\\MyDemoApp-AppiumTest\\src\\test\\resources\\mda-2.2.0-25.apk");

        driver = new AndroidDriver<>(setUrl("http://127.0.0.1:4723/wd/hub"), cap);
    }

    private static void initDriverCloud() {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:app", "storage:filename=mda-2.2.0-25.apk");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        if (exec == TipoExecucao.LOCAL) {
            sauceOptions.setCapability("accessKey", Dotenv.load().get("SAUCELABS_ACCESSKEY"));
            sauceOptions.setCapability("username", Dotenv.load().get("SAUCELABS_USERNAME"));
        }
        if (exec == TipoExecucao.CLOUD) {
            sauceOptions.setCapability("accessKey", System.getenv("SAUCELABS_ACCESSKEY"));
            sauceOptions.setCapability("username", System.getenv("SAUCELABS_USERNAME"));
        }
        caps.setCapability("sauce:options", sauceOptions);

        driver = new AndroidDriver<>(setUrl("https://oauth-lucassantan017-441b2:470cbf95-57e5-4857-805f-b328ca7b1d75@ondemand.us-west-1.saucelabs.com:443/wd/hub"), caps);
    }

    private static URL setUrl(String url) {
        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Erro ao requisitar URL " + url);
        }
    }
}
