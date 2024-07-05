package testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/payroll",
        glue = "stepdefinitions.payroll",
        plugin = {"pretty", "html:target/cucumber-reports"}
)

public class TestRunner {
}
