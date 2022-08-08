package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/json-report/cucumber.html"

        },
        monochrome = true,
        features = {"src/test/resources/carousel/Gateway"},
        glue = {
                "StepDefinition",
                "com.runner"
        },
        tags = "@WIP",
        dryRun = false
)
public class TestNGRunner extends AbstractTestNGCucumberTests {


}
