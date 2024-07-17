package stepdefinitions.adjustment;

import com.epam.healenium.SelfHealingDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Adjustment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdjustmentSteps {
    private static WebDriver delegate;
    private static SelfHealingDriver driver;
    private static Adjustment payrollpage;
    private static Boolean firstScenario = false;
    private static Boolean adjustmentDisplayed = false;
    private static Boolean adjDisplayed = false;
    private static Boolean adjRowDisplayed = false;

    @Given("I am on the login page")
    public void onLoginPage() {
        delegate = new ChromeDriver();
        driver = SelfHealingDriver.create(delegate);
        payrollpage = new Adjustment(driver);
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
        payrollpage.clickNewPayrollButton( "2024", "January", "Normal Payroll", "all", "1/1/2024", "1/31/2024");
        payrollpage.selectMonth();
        payrollpage.selectPayGroup();
        payrollpage.selectRunType();
        payrollpage.setDateFrom();
        payrollpage.setDateTo();
    }

    @And("I save the payroll run")
    public void savePayrollRun() {
        payrollpage.savePayroll();
    }

    @And("I click the adjustments link for an employee")
    public void clickAdjustmentButton() {
        payrollpage.clickAdjustments();
    }

    @And("I add a new record")
    public void newRecord() throws InterruptedException {
        payrollpage.addNewRecord("Basic Adjustment", "Basic Adj1", "BA1", "133.29", "Test remark");
    }

    @And("I save the adjustment")
    public void saveAdjustment() {
        adjustmentDisplayed = payrollpage.saveAdjustment();
        assertTrue("Adjustment table not updated", adjustmentDisplayed);
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

    @And("I should logout")
    public void logout() {
        payrollpage.logout();
    }

    @When("I navigate to the employees page")
    public void goToEmployees() {
        payrollpage.employeePage();
    }

    @And("I click the adjustments link of an employee")
    public void clickAdjEmp() {
        payrollpage.clickAdjustmentEmployee();
    }

    @And("I add and save an adjustment")
    public void employeeAdjustment() throws InterruptedException {
        adjDisplayed = payrollpage.employeeAdjustment("Basic Adjustment", "Basic Adj2", "BA2", "133.29", "1/1/2024", "test remark");
        assertTrue("Adjustment table not updated", adjDisplayed);
    }

    @And("I create a new payroll run with the adjustment")
    public void payrollWithAdj() {
        payrollpage.payrollWithAdj("2024", "February", "Normal Payroll", "all", "2/1/2024", "2/29/2024");
        payrollpage.selectMonth();
        payrollpage.selectPayGroup();
        payrollpage.selectRunType();
        payrollpage.setDateFrom();
        payrollpage.setDateTo();
        payrollpage.savePayroll();
        payrollpage.clickAdjustments();
        adjRowDisplayed = payrollpage.isAdjDisplayed();
        assertTrue("Adjustment table not updated", adjRowDisplayed);
        payrollpage.saveAndProcessPayroll();
    }

    @Then("I should get the summary table")
    public void isSummaryDisplayed() {
        assertTrue(payrollpage.isTableDisplayed());
        //driver.quit();
    }
}
