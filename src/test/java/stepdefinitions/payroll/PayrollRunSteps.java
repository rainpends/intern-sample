package stepdefinitions.payroll;

import com.epam.healenium.SelfHealingDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.PayrollPage;
import stepdefinitions.login.LoginSteps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PayrollRunSteps {
    private static WebDriver delegate;
    private static PayrollPage payrollpage;
    private static LoginPage loginpage;
    private static SelfHealingDriver driver = LoginSteps.getDriver();

    @Given("I am on the login page")
    public void onLoginPage() {
        delegate = new ChromeDriver();
        driver = SelfHealingDriver.create(delegate);
        loginpage = new LoginPage(driver);
        payrollpage = new PayrollPage(driver);
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
        //driver.quit();
    }

}
