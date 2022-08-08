package org.example.listener;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.thread.ThreadLocalDriver;
import org.example.thread.ThreadLocalTestClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.DateFormat;
import java.util.Date;

public class ListenerTest implements ITestListener {
    public static Logger log = (Logger) LogManager.getLogger();

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Test is started: " + result.getMethod().getMethodName());


    }

    @Override
    public void onTestSuccess(ITestResult result) {
        final String screenshotPath = System.getProperty("user.dir").concat("/screenshots/Pass/");
        System.out.println("Test Successfull : Listeners");
        log.info("Test is Finished: " + result.getMethod().getMethodName());
        System.out.println("\n Driver Object : " + ThreadLocalDriver.getDriver());
        System.out.println("\n Method Name : " + result.getMethod().getMethodName());
        Shutterbug.shootPage(ThreadLocalDriver.getDriver())
                .withName(result.getMethod().getMethodName() + "_" + DateFormatUtils.format(new Date(), "yyyy_MM_dd HH_mm_sss"))
                .save(screenshotPath);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        final String sspath=System.getProperty("user.dir").concat("/screenshots/Fail/");
        Shutterbug.shootPage(ThreadLocalDriver.getDriver())
                        .withName(result.getMethod().getMethodName()+" "+ DateFormatUtils.format(new Date(),"yyy_MM_dd HH_mm_sss"))
                                .save(sspath);

        log.error("Test is Failed: " + result.getMethod().getMethodName());
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
