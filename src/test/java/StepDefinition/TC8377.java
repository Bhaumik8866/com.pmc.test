package StepDefinition;
import io.cucumber.java.en.*;
import org.example.enums.Credentials;
import org.example.thread.ThreadLocalDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObject.CommonObjects;
import pageObject.login;

import java.time.Duration;


public class TC8377 {

    login lp=new login(ThreadLocalDriver.getDriver());
    WebDriverWait wait=new WebDriverWait(ThreadLocalDriver.getDriver(), Duration.ofSeconds(2000));
    CommonObjects com=new CommonObjects();
    @Given("User is logged into Gateway using Carousel Admin credentials")
    @Test
    public void user_is_logged_into_gateway_using_carousel_admin_credentials() {
    ThreadLocalDriver.getDriver().get("https://gateway-dev.carousel.eu/");
    System.out.println(Credentials.MAULI.getCredentials().get(0));
    lp.email().sendKeys(Credentials.MAULI.getCredentials().get(0));
    lp.password().sendKeys(Credentials.MAULI.getCredentials().get(1));
    lp.login().click();
    }

    @When("I navigate to Address Book > Collection Address page")
    @Test
    public void i_navigate_to_address_book_collection_address_page() {
    wait.until(ExpectedConditions.visibilityOfElementLocated((By) ThreadLocalDriver.getDriver().findElement((By) com.ratingbox())));
    }

    @When("I click Add from Collection Address page")
    @Test
    public void i_click_add_from_collection_address_page() {
    }

    @When("I add collection address for random account from following")
    @Test
    public void i_add_collection_address_for_random_account_from_following() {
    }

    @When("I search and select address for random postcode from following")
    @Test
    public void i_search_and_select_address_for_random_postcode_from_following() {
    }

    @When("I enter mandatory address details")
    @Test
    public void i_enter_mandatory_address_details() {
    }

    @When("I save collection address")
    @Test
    public void i_save_collection_address() {
    }

    @Then("The address should be saved successfully")
    @Test
    public void the_address_should_be_saved_successfully() {
    }
}
