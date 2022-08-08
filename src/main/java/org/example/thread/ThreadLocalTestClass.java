package org.example.thread;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ThreadLocalTestClass {

    static final ThreadLocal<WebDriver> threadLocal=new ThreadLocal();

    public static void createDriver(Browser browser)
    {
        switch (browser)
        {
            case CHROME-> {
                WebDriverManager.chromedriver().setup();
                threadLocal.set(new ChromeDriver());
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                threadLocal.set(new FirefoxDriver());
            }
            case IE -> {
                WebDriverManager.iedriver().setup();
                threadLocal.set(new InternetExplorerDriver());
            }
            case EDGE -> {
                WebDriverManager.edgedriver().setup();
                threadLocal.set(new EdgeDriver());
            }
        }
        threadLocal.get().manage().window().maximize();
    }

    public static WebDriver getDriver()
    {
        return threadLocal.get();
    }

    public static void closeWebDriver()
    {
        if(threadLocal.get() instanceof ChromeDriver)
        {
            threadLocal.get().close();
            threadLocal.get().quit();
        }else {
            threadLocal.get().quit();
        }

    }
}
