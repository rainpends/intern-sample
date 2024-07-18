package stepdefinitions.adjustment;

import com.epam.healenium.SelfHealingDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.EmployeesPage;
import pages.LoginPage;
import pages.PayrollPage;
import stepdefinitions.login.LoginSteps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdjustmentSteps {
    private static WebDriver delegate;
    private static PayrollPage payrollpage;
    private static LoginPage loginpage;
    private static EmployeesPage employeesPage;
    private static SelfHealingDriver driver = LoginSteps.getDriver();

    @Given("I am on the login page")
    public void onLoginPage() {
        delegate = new ChromeDriver();
        driver = SelfHealingDriver.create(delegate);
        loginpage = new LoginPage(driver);
        payrollpage = new PayrollPage(driver);
        employeesPage = new EmployeesPage(driver);
        loginpage.navigateTo();
    }

    @When("I enter username {string} and password {string}")
    public void enterUsernamePassword(String username, String password) {
        loginpage.enterUsername(username);
        loginpage.enterPassword(password);
    }

    @And("I click the login button")
    public void clickLoginButton() {
        loginpage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void loginSuccess() {
        assertTrue(loginpage.isLoggedIn());
    }

    @Given("I am on the payrolls page")
    public void payrollPage() {
        assertTrue(payrollpage.onPayrolls());
    }

    @When("I create a new payroll run for {string} with type {string} for the pay group {string}")
    public void createPayrollRun(String Payrolldate, String runType, String payGroup) {
        payrollpage.createPayrollRun(Payrolldate, runType, payGroup);
        payrollpage.savePayroll();
    }

    @And("I add a one time adjustment for employee {string} of type {string} named {string} with code {string}, amount {string}, and remark {string}")
    public void addNewAdjRecord(String empId, String adjustmentType, String name, String code, String amount, String remark) throws InterruptedException {
        payrollpage.clickAdjustments(empId);
        payrollpage.addNewAdjustmentRecord(adjustmentType, name, code, amount, remark);
        assertTrue(payrollpage.isAdjustmentDisplayed());
        payrollpage.closeAdjustmentModal();
        payrollpage.next();
        payrollpage.saveAndProcessPayroll();
    }

    @Then("I should get the payroll summary table")
    public void isTableDisplayed() {
        assertTrue(payrollpage.isSummaryTableDisplayed());
        payrollpage.goToPayrollList();
        //driver.quit();
    }

    @When("I go to the employees page")
    public void goToEmployees() {
        payrollpage.goToEmployees();
    }

    @And("I add a recurring adjustment for employee {string} of type {string} named {string} with code {string}, amount {string}, remark {string}, and date {string}")
    public void addNewRecurringAdj(String empId, String adjustmentType, String name, String code, String amount, String remark, String date) throws InterruptedException {
        employeesPage.clickAdjustments(empId);
        employeesPage.addNewAdjustmentRecord(adjustmentType, name, code, amount, remark, date);
        employeesPage.goToPayrollList();
    }

    @And("I create a payroll run for {string} with type {string} for the pay group {string}")
    public void createRecurringPayrollRun(String Payrolldate, String runType, String payGroup) {
        payrollpage.createPayrollRun(Payrolldate, runType, payGroup);
        payrollpage.savePayroll();
    }

    @And("I see the recurring adjustment for employee {string}")
    public void validateRecurringAdj(String empId) throws InterruptedException {
        payrollpage.clickAdjustments(empId);
        assertTrue(payrollpage.isAdjustmentDisplayedDefault());
        payrollpage.closeAdjustmentModal();
        payrollpage.next();
        payrollpage.saveAndProcessPayroll();
    }
}
