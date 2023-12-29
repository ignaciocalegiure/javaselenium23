package org.test.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SingletonDriver {
    private static WebDriver driver;

    private SingletonDriver() {
        ChromeOptions options = new ChromeOptions();
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444"),options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {new SingletonDriver();}
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
