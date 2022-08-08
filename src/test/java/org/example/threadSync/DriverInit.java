package org.example.threadSync;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverInit {

    WebDriver driver;

    public WebDriver driverinit() {
        WebDriverManager.chromedriver().setup();
        return driver = new ChromeDriver();
    }

    ;

    enum browser {CHROME}
}
