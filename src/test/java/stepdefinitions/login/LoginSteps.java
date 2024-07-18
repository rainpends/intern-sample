package stepdefinitions.login;

import com.epam.healenium.SelfHealingDriver;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import static org.junit.Assert.assertTrue;

public class LoginSteps {
    private WebDriver delegate;
    private LoginPage loginpage;
    private static SelfHealingDriver driver;

    @Given("I am on the login page")
    public void onLoginPage() {
        delegate = new ChromeDriver();
        driver = SelfHealingDriver.create(delegate);
        loginpage = new LoginPage(driver);
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
        driver.quit();
    }

    public static SelfHealingDriver getDriver() {
        return driver;
    }
}
