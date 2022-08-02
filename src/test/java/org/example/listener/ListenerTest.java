package org.example.listener;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.security.Timestamp;
import java.util.Date;

public class ListenerTest implements ITestListener {
    static WebDriver driver;
    Date timestamp= new Date();


    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println("Test Successfull : Listeners");
        // driver= (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
       // Shutterbug.shootPage(driver).withName(result.getMethod().getMethodName()+"_"+timestamp).save();


    }

    @Override
    public void onTestFailure(ITestResult result) {

//        try {
//            driver= (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
//            Shutterbug.shootPage(driver).withName(result.getMethod().getMethodName()+"_"+timestamp);
//        } catch (NoSuchFieldException e) {
//            throw new RuntimeException(e);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
