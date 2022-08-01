package org.example;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.CaptureElement;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class SeleniumEasy {

    WebDriver driver;

    public WebDriver GetWebDriverManager()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        return driver;
    }
    public void ss(WebDriver driver, String name)//NOTE:Capturing the entire page with specified name
    {
        Shutterbug.shootPage(driver).withName(name).save();
    }

    @Test
    public void SimpleFormDemo() throws InterruptedException, IOException {
        driver=GetWebDriverManager();
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");
        Thread.sleep(3000);
        ss(driver,"withpopup");
        driver.findElement(By.xpath("//a[@title='Close']")).click();

        //NOTE:Capturing the entire page with specified name
        ss(driver,"afterpopup");
        Faker faker = new Faker();
        String name=faker.name().fullName();
        driver.findElement(By.xpath("//input[@id='user-message']")).sendKeys(name);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Show Message']")).click();
        String message= driver.findElement(By.xpath("//span[@id='display']")).getText();

        //NOTE:Screenshots comparison
        Shutterbug.shootPage(driver).equals("screenshots/withpopup.png",0.1);

        //NOTE:Compare screenshot taken with the expected one with specified deviation rate
        // and create new image with differences highlighted
        Shutterbug.shootPage(driver)
                .equalsWithDiff("screenshots/afterpopup.png","C://Bhaumik//",0.0);

        //NOTE:Take screenshot and specify location to save to:C://Bhaumik//
        Shutterbug.shootPage(driver).withName("Saved inside resource").save("C://Bhaumik//");
        System.out.println();
        System.out.println(message);
        System.out.println(message.contains(name));
        //assertThat(Arrays.stream(message.split(":"))).contains(name);
        driver.navigate().to("https://demo.seleniumeasy.com/jquery-download-progress-bar-demo.html");
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.findElement(By.xpath("//button[@id='downloadButton']")).click();
        wait.until(visibilityOfElementLocated(By.xpath("//div[@class='progress-label']")))
                .getText().equalsIgnoreCase("Complete!");
        Shutterbug.wait(visibilityOfElementLocated(By.xpath("//div[text()='Complete!']")), 20)
                .shootPage(driver, Capture.FULL).withName("Wait for element").save();

        //NOTE: Wait for condition before taking screenshot
        wait.until(visibilityOfElementLocated(By.xpath("//button[text()='Close']")))
                .click();
        //driver.findElement(By.xpath("//button[text()='Close']")).click();
        driver.quit();
    }

    @Test //Take screenshot and scroll in both directions (Will make full page screenshot in Chrome):
    public void ScrollScreenshotDemo() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://gateway-dev.carousel.eu/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@name='UserName']")).sendKeys("hitesh.prajapati@pmcretail.com");
        driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("GatewayDev@2020");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);
        driver.navigate().to("https://gateway-dev.carousel.eu/Booking/Booking/BookingList");
        Thread.sleep(3000);
        driver.findElement(By.id("spnBookingListDateRange")).click();
        driver.findElement(By.xpath("//li[text()='Last Month']")).click();
        driver.findElement(By.id("btnSearch")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//span[text()=\"10\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[text()='100']")).click();
        Thread.sleep(3000);

        Shutterbug.shootPage(driver, Capture.FULL_SCROLL).withName("Full Scroll example").save();

        //NOTE: Take screenshot and scroll in both directions with half a second scrolling timeout (Will make full page screenshot in Chrome)
        // and use devicePixelRatio - for retina displays:
        Shutterbug.shootPage(driver, Capture.FULL_SCROLL ,500,true)
                .withName("Full Scroll half a second scrolling timeout").save();
        Shutterbug.shootPage(driver,Capture.FULL,true).withName("sticky header element").save();
        driver.quit();
    }
    @Test
    public void WebElementScreenshots() throws InterruptedException {


        Faker fake=new Faker();
        String name=fake.name().fullName();
        driver=GetWebDriverManager();
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@title='Close']")).click();
        driver.findElement(By.xpath("//input[@id='user-message']")).sendKeys(name);
        WebElement MsgPlaceholder= driver.findElement(By.xpath("//div[text()='Single Input Field']/parent::div"));
        Shutterbug.shootElement(driver,MsgPlaceholder).withName("MsgPlaceholder").save();
        driver.quit();
    }

    @Test
    public void ScreenshotThumbnail(){
        driver=GetWebDriverManager();
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");
        Shutterbug.shootPage(driver).withName("ScreenshotThumbnail1").withThumbnail(0.1).save();
        driver.navigate().to("https://demo.seleniumeasy.com/jquery-download-progress-bar-demo.html");
        //NOTE:Take screenshot and save thumbnail as well (with specified resize ratio):
        Shutterbug.shootPage(driver).withName("ScreenshotThumbnail2").withThumbnail(0.4).save();
        driver.quit();
    }
    @Test
    public void Framescreenshots(){
        driver=GetWebDriverManager();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/html/html_iframe.asp");
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of frames: "+size);
        driver.switchTo().frame(2);
        driver.findElement(By.cssSelector("iframe[src='default.asp']"));
//        Shutterbug.shootFrame(driver, driver
//                .findElement(By.cssSelector("frame[src='/frame_middle']")),CaptureElement.FULL_SCROLL).save();
        driver.quit();
    }
}
