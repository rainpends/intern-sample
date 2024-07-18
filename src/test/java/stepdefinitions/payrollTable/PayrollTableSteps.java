package stepdefinitions.payrollTable;

import com.epam.healenium.SelfHealingDriver;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PayrollTableSteps {
    private static WebDriver delegate;
    private static SelfHealingDriver driver;
    private static PayrollPage payrollpage;
    private static PayrollSummaryPage payrollSummaryPage;
    private static ReportsLogsPage reportsLogsPage;
    private static LoginPage loginpage;

    @Given("I am on the login page")
    public void onLoginPage() {
        delegate = new ChromeDriver();
        driver = SelfHealingDriver.create(delegate);
        loginpage = new LoginPage(driver);
        payrollpage = new PayrollPage(driver);
        payrollSummaryPage = new PayrollSummaryPage(driver);
        reportsLogsPage = new ReportsLogsPage(driver);
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
        payrollpage.saveAndNext();
        payrollpage.saveAndProcessPayroll();
    }

    @Then("I should get the payroll summary table")
    public void isTableDisplayed() {
        assertTrue(payrollpage.isSummaryTableDisplayed());
        payrollpage.backToPayrollList();
        //driver.quit();
    }

    @Given("I am on the payroll list page")
    public void onPayrollPage() {
        assertTrue(payrollpage.onPayrolls());
    }

    @Then("I download the payroll summary excel")
    public void downloadTable() throws InterruptedException {
        payrollpage.goToPayrollSummary();
        payrollSummaryPage.selectPayroll();
        payrollSummaryPage.goToReportsLogs();
        reportsLogsPage.downloadReportLog();
    }
}
