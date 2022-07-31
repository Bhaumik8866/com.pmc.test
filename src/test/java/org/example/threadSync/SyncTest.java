package org.example.threadSync;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SyncTest {


    WebDriver driver;
    //DriverInit getdriver=new DriverInit();
    int i=0;

    public void count()
    {
        i++;
        System.out.println(i);
    }
    synchronized public WebDriver webdriverinit()
    {
       WebDriverManager.chromedriver().setup();
        return driver=new ChromeDriver();
    }

    @Test
    public void test1()
    {
        //driver=getdriver.driverinit();
        driver=webdriverinit();
        driver.get("https://www.google.co.in/");
        count();

    }

    @Test
    public void test2()
    {
        //driver=getdriver.driverinit();
        //WebDriverManager.chromedriver().setup();
       // driver=webdriverinit();
        driver.get("https://www.google.co.in/");
        System.out.println(driver.findElement(By.xpath("//a[text()='Gmail']")).getText());
        count();
        //driver.quit();
    }

    @Test
    public void test3()
    {
        //driver=getdriver.driverinit();
       // WebDriverManager.chromedriver().setup();
       // driver=webdriverinit();
        driver.get("https://www.google.co.in/");
        System.out.println(driver.findElement(By.xpath("//a[text()='Images']")).getText());
        count();
        driver.quit();
    }
}
