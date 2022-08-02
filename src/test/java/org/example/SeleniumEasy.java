package org.example;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.CaptureElement;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.javatuples.Decade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@Listeners({ org.example.listener.ListenerTest.class})

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

        //Note: Take full screenshot with sticker header element
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

    @Test
    public void ScrollableWebElements()
    {
        By WebElements=By.xpath("//table[@id='example']");
        driver=GetWebDriverManager();
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/table-data-download-demo.html");
        Shutterbug.shootElement(driver, WebElements, CaptureElement.HORIZONTAL_SCROLL).withName("ScrollableWebElements").save();
        driver.quit();
    }

    @Test
    public void Operationschaining() throws InterruptedException {
        driver=GetWebDriverManager();
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/table-sort-search-demo.html");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement tablelength=driver.findElement(By.className("dataTables_length"));
//        js.executeScript("arguments[0].setAttribute('style', 'border-style: dashed; border-color: blue')", tablelength);
//        Thread.sleep(3000);

        WebElement searchbox=driver.findElement(By.id("example_filter"));
//        js.executeScript("arguments[0].setAttribute('style', 'border-style: dashed; border-color: blue')", searchbox);
//        Thread.sleep(3000);

        WebElement tableheader=driver.findElement(By.className("thead-inverse"));
//        js.executeScript("arguments[0].setAttribute('style', 'border-style: dashed; border-color: blue')", tableheader);
//        Thread.sleep(3000);

        WebElement tablebody=driver.findElement(By.tagName("tbody"));
//        js.executeScript("arguments[0].setAttribute('style', 'border-style: dashed; border-color: blue')", tablebody);
//        Thread.sleep(3000);

        WebElement logo=driver.findElement(By.className("cbt"));
//        js.executeScript("arguments[0].setAttribute('style', 'border-style: dashed; border-color: blue')", logo);
//        Thread.sleep(3000);

        Shutterbug.shootPage(driver,Capture.FULL,true)
                .blur(tablelength)
                .highlight(searchbox)
                .monochrome(logo).highlight(logo)
                .highlightWithText(tableheader, Color.blue, 3, "Highlight Table Headers",Color.blue, new Font("SansSerif", Font.BOLD, 20))
                .highlightWithText(tablebody, "This is table body")
                .withTitle("Table Sort And Search - " + new Date())
                .withName("chain operations").save();
        driver.quit();
    }

    @Test
    public void inputformwithfaker()
    {
        Faker fake=new Faker();
        driver=GetWebDriverManager();
        //driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/input-form-demo.html");
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(fake.name().firstName());
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(fake.name().lastName());
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(fake.internet().emailAddress());
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(fake.phoneNumber().phoneNumber());
        driver.findElement(By.xpath("//input[@name='address']")).sendKeys(fake.address().fullAddress());
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys(fake.address().city());
        driver.findElement(By.xpath("//select[@name='state']")).click();
        driver.findElement(By.xpath("//option[text()='Alaska']")).click();
        String state=driver.findElement(By.xpath("//option[text()='Alaska']")).getText();
        System.out.println(state);
        driver.findElement(By.xpath("//input[@name='zip']")).sendKeys(fake.address().zipCode());
        driver.findElement(By.xpath("//input[@name='website']")).sendKeys(fake.internet().url());
        driver.findElement(By.xpath("//input[@value='yes']")).click();
        driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys(fake.weather().description());
        driver.findElement(By.xpath("//button[text()='Send ']")).click();
        driver.quit();
    }

    @Test
    public void fackerTest()
    {
        enum countryenum {USA,UK,INDIA,DUBAI,AUSTRIA}
        Faker javafaker=new Faker();
        Decade<String,String,String,String,String,String,String,String,String,String> names=
                new Decade<String,String,String,String,String,String,String,String,String,String>(javafaker.name().firstName(),javafaker.name().lastName(),javafaker.name().bloodGroup(),javafaker.company().name(), javafaker.weather().temperatureCelsius(),javafaker.book().publisher(),javafaker.book().author(),javafaker.ancient().hero(),javafaker.file().fileName(),javafaker.space().meteorite());
        //System.out.println(names);
        //Storing tuples in a list
        List<Object> tuples=new ArrayList<>();
        tuples=names.toList();
        //tuples.add(lnames);
        tuples.stream().forEach(e->System.out.println("Tuples: "+e));
        System.out.println(javafaker.options().nextElement(tuples));
        System.out.println(javafaker.letterify("12AB34",true));
        System.out.println(javafaker.bothify("12AB34"));

        //Generates a String that matches the given regular expression.
        String regex="[0-8]\\d{2}-\\d{2}-\\d{4}";
        System.out.println(javafaker.regexify(regex));

        System.out.println(javafaker.avatar());
        System.out.println(javafaker.internet().password(6,10,true,true,true));
        System.out.println(javafaker.internet().safeEmailAddress());
    }
}
