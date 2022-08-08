package pageObject;

import org.example.thread.ThreadLocalDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CommonObjects {

    private By ratingbox= By.className("bold-heading");

    public WebElement ratingbox()
    {
        return ThreadLocalDriver.getDriver().findElement(ratingbox);
    }
}
