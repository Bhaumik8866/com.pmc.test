package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.*;
import org.apache.commons.lang.StringUtils;
import org.example.enums.Browser;
import org.example.thread.ThreadLocalDriver;
import org.testng.annotations.Test;
import pageObject.login;
import static org.assertj.core.api.Assertions.*;


public class TC11100 {


    login login=new login( ThreadLocalDriver.getDriver());

    @Given("I am on Login Page")
    @Test
    public void i_am_on_login_page() {

        ThreadLocalDriver.getDriver().get("https://gateway-dev.carousel.eu/");
    }

    @When("I login with invalid email as {string} and password as {string}")
    @Test
    public void i_login_with_invalid_email_as_and_password_as(String email, String pass) {

        login.email().sendKeys(email);
        login.password().sendKeys(pass);
        login.login().click();
    }

    @Then("I should be able to see an error message")
    @Test
    public void i_should_be_able_to_see_an_error_message() {
        StringUtils.containsAny(login.validationError().getText(),"incorrect");
        assertThat(login.validationError().getText()).isEqualToIgnoringCase("The user name or password is incorrect.");
    }


    @When("I login with email as {string} and invalid password as {string}")
    @Test
    public void i_login_with_email_as_and_invalid_password_as(String email, String pass) {
        login.email().sendKeys(email);
        login.password().sendKeys(pass);
        login.login().click();
    }

    @When("I login with valid email as {string} and valid password as {string}")
    public void i_login_with_valid_email_as_and_valid_password_as(String email, String pass) {
        login.email().sendKeys(email);
        login.password().sendKeys(pass);
        login.login().click();
    }
    @Then("I should be able to login successfully")
    public void i_should_be_able_to_login_successfully() {
        assertThat(ThreadLocalDriver.getDriver().getCurrentUrl())
                .isEqualToIgnoringCase("https://gateway-dev.carousel.eu/Home/Dashboard");
    }
}
