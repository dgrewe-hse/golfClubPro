package de.hse.golfclubmanagement.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", // Path to the feature files
        glue = "de.hse.golfclubmanagement.steps", // Package containing step definitions
        plugin = { "pretty", "html:target/cucumber-report.html", "json:target/cucumber-report.json" }, // Verbose output
        monochrome = true)
public class GolfCourseCucumberIT {

}
