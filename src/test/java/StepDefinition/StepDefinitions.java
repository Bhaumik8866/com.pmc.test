package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StepDefinitions {

    WebDriver driver;

    @Given("I am at login page")
    public void i_am_at_login_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Inside Code////////");
//        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();
//        driver.get("https://www.google.co.in/");
//        driver.close();
    }

    @When("I enter valid userid and password")
    public void i_enter_valid_userid_and_password() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("It allows me to login")
    public void it_allows_me_to_login() {
        // Write code here that turns the phrase above into concrete actions

    }


    @Given("I am at google page")
    public void iAmAtGooglePage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.co.in/");
        driver.manage().window().maximize();
//        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("google");
//        driver.findElement(By.xpath("//a[@aria-label='Google apps']")).click();
//        driver.findElement(By.xpath("//a[@aria-label='Google apps']")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //driver.findElement(By.xpath("//input[@name='btnK']")).click();
        List<WebElement> s = driver.findElements(By.xpath("//a[@target='_top']"));
        HashMap<String, WebElement> map = new HashMap<>();
        for (WebElement s1 : s) {
            String name = s1.getText();
            System.out.println(name);
            map.put(name, s1);
        }
        for (Map.Entry m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
        driver.quit();
    }

    @When("I search for google in search")
    public void iSearchForGoogleInSearch() {

    }

    @Then("Get all aifferent elements present on result page")
    public void getAllAifferentElementsPresentOnResultPage() {
    }

    @Given("I am on product page")
    public void iAmOnProductPage() {
        System.out.println("Inside: I am on product page");
    }

    @And("I have added butter")
    public void iHaveAddedButter() {
        System.out.println("Inside: I have added butter");
    }

    @And("I have added milk")
    public void iHaveAddedMilk() {
        System.out.println("Inside: I have added milk");
    }

    @When("I go to cart page")
    public void iGoToCartPage() {
        System.out.println("Inside: I go to cart page");
    }

    @And("I have added bread")
    public void iHaveAddedBread() {
        System.out.println("Inside: I have added bread");
    }

    @Then("I proceed for payment")
    public void iProceedForPayment() {
        System.out.println("Inside: I proceed for payment");
    }

    @Given("I am on home page")
    public void iAmOnHomePage() {
        System.out.println("background: I am on home page");
    }

    @Given("I am on search page")
    public void iAmOnSearchPage() {
        System.out.println("Test scenario 1: I am on search page");
    }

}
