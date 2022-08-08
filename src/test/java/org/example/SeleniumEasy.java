package org.example;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.CaptureElement;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.github.javafaker.Faker;
import org.example.enums.Browser;
import org.example.thread.ThreadLocalDriver;
import org.javatuples.Decade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@Listeners({org.example.listener.ListenerTest.class})

public class SeleniumEasy {

    @BeforeMethod(alwaysRun = true)
    public void initializeDriver() {
        ThreadLocalDriver.createDriver(Browser.CHROME);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        ThreadLocalDriver.closeDriver();

    }

    public void ss(String name)//NOTE:Capturing the entire page with specified name
    {
        Shutterbug.shootPage(ThreadLocalDriver.getDriver()).withName(name).save();
    }

    @Test
    public void SimpleFormDemo() throws InterruptedException, IOException {

        System.out.println("\n Driver Object : " + ThreadLocalDriver.getDriver());

        ThreadLocalDriver.getDriver().get("https://demo.seleniumeasy.com/basic-first-form-demo.html");

        ss("withpopup");
        ThreadLocalDriver.getDriver().findElement(By.xpath("//a[@title='Close']")).click();

        //NOTE:Capturing the entire page with specified name
        ss("afterpopup");
        Faker faker = new Faker();
        String name = faker.name().fullName();
        ThreadLocalDriver.getDriver().findElement(By.xpath("//input[@id='user-message']")).sendKeys(name);
        ThreadLocalDriver.getDriver().findElement(By.xpath("//button[text()='Show Message']")).click();
        String message = ThreadLocalDriver.getDriver().findElement(By.xpath("//span[@id='display']")).getText();

        //NOTE:Screenshots comparison
        Shutterbug.shootPage(ThreadLocalDriver.getDriver()).equals("screenshots/withpopup.png", 0.1);

        //NOTE:Compare screenshot taken with the expected one with specified deviation rate
        // and create new image with differences highlighted
        Shutterbug.shootPage(ThreadLocalDriver.getDriver())
                .equalsWithDiff("screenshots/afterpopup.png", "C://Bhaumik//", 0.0);

        //NOTE:Take screenshot and specify location to save to:C://Bhaumik//
        Shutterbug.shootPage(ThreadLocalDriver.getDriver()).withName("Saved inside resource").save("C://Bhaumik//");
        System.out.println();
        System.out.println(message);
        System.out.println(message.contains(name));
        //assertThat(Arrays.stream(message.split(":"))).contains(name);
        ThreadLocalDriver.getDriver().navigate().to("https://demo.seleniumeasy.com/jquery-download-progress-bar-demo.html");
        WebDriverWait wait = new WebDriverWait(ThreadLocalDriver.getDriver(), Duration.ofSeconds(20));

        ThreadLocalDriver.getDriver().findElement(By.xpath("//button[@id='downloadButton']")).click();
        wait.until(visibilityOfElementLocated(By.xpath("//div[@class='progress-label']")))
                .getText().equalsIgnoreCase("Complete!");
        Shutterbug.wait(visibilityOfElementLocated(By.xpath("//div[text()='Complete!']")), 20)
                .shootPage(ThreadLocalDriver.getDriver(), Capture.FULL).withName("Wait for element").save();

        //NOTE: Wait for condition before taking screenshot
        wait.until(visibilityOfElementLocated(By.xpath("//button[text()='Close']")))
                .click();
    }

    @Test //Take screenshot and scroll in both directions (Will make full page screenshot in Chrome):
    public void ScrollScreenshotDemo() throws InterruptedException {

        ThreadLocalDriver.getDriver().get("https://gateway-dev.carousel.eu/");

        ThreadLocalDriver.getDriver().findElement(By.xpath("//input[@name='UserName']")).sendKeys("hitesh.prajapati@pmcretail.com");
        ThreadLocalDriver.getDriver().findElement(By.xpath("//input[@name='Password']")).sendKeys("GatewayDev@2020");
        ThreadLocalDriver.getDriver().findElement(By.xpath("//button[@type='submit']")).click();
        ThreadLocalDriver.getDriver().navigate().to("https://gateway-dev.carousel.eu/Booking/Booking/BookingList");

        ThreadLocalDriver.getDriver().findElement(By.id("spnBookingListDateRange")).click();
        ThreadLocalDriver.getDriver().findElement(By.xpath("//li[text()='Last Month']")).click();
        ThreadLocalDriver.getDriver().findElement(By.id("btnSearch")).click();

        ThreadLocalDriver.getDriver().findElement(By.xpath("//span[text()=\"10\"]")).click();

        ThreadLocalDriver.getDriver().findElement(By.xpath("//li[text()='100']")).click();


        Shutterbug.shootPage(ThreadLocalDriver.getDriver(), Capture.FULL_SCROLL).withName("Full Scroll example").save();

        //NOTE: Take screenshot and scroll in both directions with half a second scrolling timeout (Will make full page screenshot in Chrome)
        // and use devicePixelRatio - for retina displays:
        Shutterbug.shootPage(ThreadLocalDriver.getDriver(), Capture.FULL_SCROLL, 500, true)
                .withName("Full Scroll half a second scrolling timeout").save();

        //Note: Take full screenshot with sticker header element
        Shutterbug.shootPage(ThreadLocalDriver.getDriver(), Capture.FULL, true).withName("sticky header element").save();

    }

    @Test
    public void WebElementScreenshots() throws InterruptedException {


        Faker fake = new Faker();
        String name = fake.name().fullName();
        ThreadLocalDriver.getDriver().get("https://demo.seleniumeasy.com/basic-first-form-demo.html");

        ThreadLocalDriver.getDriver().findElement(By.xpath("//a[@title='Close']")).click();
        ThreadLocalDriver.getDriver().findElement(By.xpath("//input[@id='user-message']")).sendKeys(name);
        WebElement MsgPlaceholder = ThreadLocalDriver.getDriver().findElement(By.xpath("//div[text()='Single Input Field']/parent::div"));
        Shutterbug.shootElement(ThreadLocalDriver.getDriver(), MsgPlaceholder).withName("MsgPlaceholder").save();
    }

    @Test
    public void ScreenshotThumbnail() {

        ThreadLocalDriver.getDriver().get("https://demo.seleniumeasy.com/basic-first-form-demo.html");
        Shutterbug.shootPage(ThreadLocalDriver.getDriver()).withName("ScreenshotThumbnail1").withThumbnail(0.1).save();
        ThreadLocalDriver.getDriver().navigate().to("https://demo.seleniumeasy.com/jquery-download-progress-bar-demo.html");
        //NOTE:Take screenshot and save thumbnail as well (with specified resize ratio):
        Shutterbug.shootPage(ThreadLocalDriver.getDriver()).withName("ScreenshotThumbnail2").withThumbnail(0.4).save();
    }

    @Test
    public void Framescreenshots() {

        ThreadLocalDriver.getDriver().get("https://www.w3schools.com/html/html_iframe.asp");
        int size = ThreadLocalDriver.getDriver().findElements(By.tagName("iframe")).size();
        System.out.println("Number of frames: " + size);
//        ThreadLocalDriver.getDriver().switchTo().frame(2);
//        ThreadLocalDriver.getDriver().findElement(By.cssSelector("iframe[src='default.asp']"));

    }

    @Test
    public void ScrollableWebElements() {
        By WebElements = By.xpath("//table[@id='example']");

        ThreadLocalDriver.getDriver().get("https://demo.seleniumeasy.com/table-data-download-demo.html");
        Shutterbug.shootElement(ThreadLocalDriver.getDriver(), WebElements, CaptureElement.HORIZONTAL_SCROLL).withName("ScrollableWebElements").save();
    }

    @Test
    public void Operationschaining() throws InterruptedException {

        ThreadLocalDriver.getDriver().get("https://demo.seleniumeasy.com/table-sort-search-demo.html");

        WebElement tablelength = ThreadLocalDriver.getDriver().findElement(By.className("dataTables_length"));

        WebElement searchbox = ThreadLocalDriver.getDriver().findElement(By.id("example_filter"));

        WebElement tableheader = ThreadLocalDriver.getDriver().findElement(By.className("thead-inverse"));

        WebElement tablebody = ThreadLocalDriver.getDriver().findElement(By.tagName("tbody"));

        WebElement logo = ThreadLocalDriver.getDriver().findElement(By.className("cbt"));

        Shutterbug.shootPage(ThreadLocalDriver.getDriver(), Capture.FULL, true)
                .blur(tablelength)
                .highlight(searchbox)
                .monochrome(logo).highlight(logo)
                .highlightWithText(tableheader, Color.blue, 3, "Highlight Table Headers", Color.blue, new Font("SansSerif", Font.BOLD, 20))
                .highlightWithText(tablebody, "This is table body")
                .withTitle("Table Sort And Search - " + new Date())
                .withName("chain operations").save();
    }

    @Test
    public void inputformwithfaker() {
        Faker fake = new Faker();
        //
        ThreadLocalDriver.getDriver().get("https://demo.seleniumeasy.com/input-form-demo.html");
        ThreadLocalDriver.getDriver().findElement(By.xpath("//input[@name='first_name']")).sendKeys(fake.name().firstName());
        ThreadLocalDriver.getDriver().findElement(By.xpath("//input[@name='last_name']")).sendKeys(fake.name().lastName());
        ThreadLocalDriver.getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(fake.internet().emailAddress());
        ThreadLocalDriver.getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys(fake.phoneNumber().phoneNumber());
        ThreadLocalDriver.getDriver().findElement(By.xpath("//input[@name='address']")).sendKeys(fake.address().fullAddress());
        ThreadLocalDriver.getDriver().findElement(By.xpath("//input[@name='city']")).sendKeys(fake.address().city());
        ThreadLocalDriver.getDriver().findElement(By.xpath("//select[@name='state']")).click();
        ThreadLocalDriver.getDriver().findElement(By.xpath("//option[text()='Alaska']")).click();
        String state = ThreadLocalDriver.getDriver().findElement(By.xpath("//option[text()='Alaska']")).getText();
        System.out.println(state);
        ThreadLocalDriver.getDriver().findElement(By.xpath("//input[@name='zip']")).sendKeys(fake.address().zipCode());
        ThreadLocalDriver.getDriver().findElement(By.xpath("//input[@name='website']")).sendKeys(fake.internet().url());
        ThreadLocalDriver.getDriver().findElement(By.xpath("//input[@value='yes']")).click();
        ThreadLocalDriver.getDriver().findElement(By.xpath("//textarea[@name='comment']")).sendKeys(fake.weather().description());
        ThreadLocalDriver.getDriver().findElement(By.xpath("//button[text()='Send ']")).click();
    }

    @Test
    public void fackerTest() {

        enum countryenum {USA, UK, INDIA, DUBAI, AUSTRIA}
        Faker javafaker = new Faker();
        Decade<String, String, String, String, String, String, String, String, String, String> names =
                new Decade<String, String, String, String, String, String, String, String, String, String>(javafaker.name().firstName(), javafaker.name().lastName(), javafaker.name().bloodGroup(), javafaker.company().name(), javafaker.weather().temperatureCelsius(), javafaker.book().publisher(), javafaker.book().author(), javafaker.ancient().hero(), javafaker.file().fileName(), javafaker.space().meteorite());
        //System.out.println(names);
        //Storing tuples in a list
        List<Object> tuples = new ArrayList<>();
        tuples = names.toList();
        //tuples.add(lnames);
        tuples.stream().forEach(e -> System.out.println("Tuples: " + e));
        System.out.println(javafaker.options().nextElement(tuples));
        System.out.println(javafaker.letterify("12AB34", true));
        System.out.println(javafaker.bothify("12AB34"));

        //Generates a String that matches the given regular expression.
        String regex = "[0-8]\\d{2}-\\d{2}-\\d{4}";
        System.out.println(javafaker.regexify(regex));

        System.out.println(javafaker.avatar());
        System.out.println(javafaker.internet().password(6, 10, true, true, true));
        System.out.println(javafaker.internet().safeEmailAddress());
    }

    @Test
    public void apacheUtils()
    {
        String browser="Teststring" ;
        boolean flag=browser.isEmpty();
        System.out.println(flag);
    }

}
