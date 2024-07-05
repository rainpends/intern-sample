package stepdefinitions.login;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import static org.junit.Assert.assertTrue;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginpage;

    @Given("I am on the login page")
    public void onLoginPage() {
        driver = new ChromeDriver();
        loginpage = new LoginPage(driver);
        loginpage.navigateTo();
    }

    @When("I enter valid username and password")
    public void enterUsernamePassword() {
        loginpage.enterUsername("Veron\\admin");
        loginpage.enterPassword("diane");
    }

    @And("I click the login button")
    public void clickLoginButton() {
        loginpage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void loginSuccess() {
        assertTrue(loginpage.isLoggedIn());
        driver.quit();
    }
}
