package com.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/flightBooking.feature",
    glue = "com.example.steps",
    plugin = {
        "pretty",
        "html:target/cucumber-report.html",
        "json:target/cucumber-report.json",
        "junit:target/cucumber-report.xml"
    },
    monochrome = false,
    dryRun = false
)
public class SeleniumRunTest {
    // Cucumber test runner
}
