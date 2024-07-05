package stepdefinitions.payroll;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PayrollRun;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PayrollRunSteps {
    private static WebDriver driver;
    private static PayrollRun payrollpage;
    private static Boolean firstScenario = false;

    @Given("I am on the login page")
    public void onLoginPage() {
        driver = new ChromeDriver();
        payrollpage = new PayrollRun(driver, "2024", "September", "Normal Payroll", "9/15/2024");
        payrollpage.navigateTo();
    }

    @When("I enter valid credentials")
    public void enterUsernamePassword() {
        payrollpage.enterUsername("Raini\\admin");
        payrollpage.enterPassword("rainier");
    }

    @And("I click the login button")
    public void clickLoginButton() {
        payrollpage.clickLoginButton();
    }

    @Then("I should be logged in")
    public void loginSuccess() {
       firstScenario = payrollpage.isLoggedIn();
       assertTrue("Scenario 1 failed", firstScenario);
    }

    @Given("I am on the payrolls page")
    public void payrollPage() {
        if(!firstScenario) {
            throw new RuntimeException("Scenario 1 failed, skipping Scenario 2");
        }
        assertTrue(payrollpage.onPayrolls());
    }

    @When("I create a new payroll run")
    public void createPayrollRun() {
        payrollpage.clickNewPayrollButton();
    }

    @And("I set the payroll run setup")
    public void setMonth() {
//        payrollpage.selectYear();
        payrollpage.selectMonth();
        payrollpage.selectPayGroup();
        payrollpage.selectRunType();
        payrollpage.setDateTo();
    }

    @And("I click the save and next button")
    public void savePayrollRun() {
        payrollpage.savePayroll();
    }

    @And("I save and process the payroll")
    public void saveAndProcessPayroll() {
        payrollpage.saveAndProcessPayroll();
    }

    @Then("I should get the payroll summary table")
    public void isTableDisplayed() {
        assertTrue(payrollpage.isTableDisplayed());
        //driver.quit();
    }
}
