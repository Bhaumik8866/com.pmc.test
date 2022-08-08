package pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.thread.ThreadLocalDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class login {

    private By email= By.xpath("//input[@id='UserName']");

    private By password=By.xpath("//input[@id='Password']");
    private By login=By.xpath("//button[@type='submit']");

    private By validationError=By.xpath("//div[@class='validation-summary-errors']");

    public login(WebDriver driver) {
        ThreadLocalDriver.setDriver(driver);
    }

    public WebElement email()
    {
        return ThreadLocalDriver.getDriver().findElement(email);
    }

    public WebElement password()
    {
        return ThreadLocalDriver.getDriver().findElement(password);
    }
    public WebElement login()
    {
        return ThreadLocalDriver.getDriver().findElement(login);
    }
    //private By validationError=By.xpath("//div[@class='validation-summary-errors']");
    public WebElement validationError()
    {
        return ThreadLocalDriver.getDriver().findElement(validationError);
    }
}
