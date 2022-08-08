package org.example.thread;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class ThreadLocalDriver {
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static void createDriver(Browser browser) {
        switch (browser) {
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                threadDriver.set(new ChromeDriver());
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                threadDriver.set(new FirefoxDriver());
            }
            case IE -> {
                WebDriverManager.iedriver().setup();
                threadDriver.set(new InternetExplorerDriver());
            }
            case EDGE -> {
                WebDriverManager.edgedriver().setup();
                threadDriver.set(new EdgeDriver());
            }
        }
        threadDriver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        threadDriver.get().manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    public static void setDriver(WebDriver driver)
    {
        threadDriver.set(driver);
    }

    public static void closeDriver() {
        if (threadDriver.get() instanceof ChromeDriver) {
            threadDriver.get().close();
            threadDriver.get().quit();
        } else {
            threadDriver.get().close();
        }
    }
}
