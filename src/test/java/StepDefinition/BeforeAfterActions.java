package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.example.enums.Browser;
import org.example.thread.ThreadLocalDriver;

public class BeforeAfterActions {

    @BeforeAll
    public static void before_all()
    {
        ThreadLocalDriver.createDriver(Browser.CHROME);
    }

    @AfterAll
    public static void after_all()
    {
        ThreadLocalDriver.closeDriver();
    }
}
