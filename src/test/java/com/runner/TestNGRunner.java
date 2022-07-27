package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {
                "pretty",
                "json:target/json-report/cucumber.json"

        },
        monochrome = true,
        features = {"src/test/resources/features/"},
        glue = {
                "StepDefinition",
                "com.runner"
        },
        tags = "",
        dryRun = false
)
public class TestNGRunner extends AbstractTestNGCucumberTests {


}
