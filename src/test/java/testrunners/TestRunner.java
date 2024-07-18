package testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/java/features/login",
                "src/test/java/features/payroll"
        },
        glue = "stepdefinitions.adjustment",
        plugin = {"pretty", "html:target/cucumber-reports"},
        tags = "@login or (@payrollrun and @oneTimeAdjustment) or (@payrollrun and @recurringAdjustment)"
)

public class TestRunner {
}
