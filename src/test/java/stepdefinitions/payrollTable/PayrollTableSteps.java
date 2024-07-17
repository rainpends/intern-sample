package stepdefinitions.payrollTable;

import com.epam.healenium.SelfHealingDriver;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PayrollTable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PayrollTableSteps {
    private static WebDriver delegate;
    private static SelfHealingDriver driver;
    private static PayrollTable payrollpage;
    private static Boolean firstScenario = false;

    @Given("I am on the login page")
    public void onLoginPage() {
        delegate = new ChromeDriver();
        driver = SelfHealingDriver.create(delegate);
        payrollpage = new PayrollTable(driver);
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

    @When("I create a new payroll run for {string} with type {string} for the pay group {string}")
    public void createPayrollRun(String Payrolldate, String runType, String payGroup) {
        payrollpage.createPayrollRun(Payrolldate, runType, payGroup);
        payrollpage.savePayroll();
        payrollpage.saveAndProcessPayroll();
    }

    @Then("I should get the payroll summary table")
    public void isTableDisplayed() {
        assertTrue(payrollpage.isTableDisplayed());
        payrollpage.backToList();
        //driver.quit();
    }

    @Given("I am on the payroll list page")
    public void onPayrollPage() {
        assertTrue(payrollpage.onPayrolls());
    }

    @Then("I download the payroll summary excel")
    public void downloadTable() throws InterruptedException {
        payrollpage.exportExcel();
    }
}
