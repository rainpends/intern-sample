package pages;

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase{

    private static final By USERNAME_INPUT = By.id("txtUsername");
    private static final By PASSWORD_INPUT = By.id("txtPassword");
    private static final By LOGIN_BTN = By.id("btnLogin");
    private static final By COMPANY_NAME = By.id("tdcompanyName");
    private static final By PAYROLLRUNS_TABLE = By.id("ctl00_ph1_grdPayrolls");

    public LoginPage(SelfHealingDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        enterText(USERNAME_INPUT, username);
    }

    public void enterPassword(String password) {
        enterText(PASSWORD_INPUT, password);
    }

    public void clickLoginButton() {
        clickElement(LOGIN_BTN);
    }

    public boolean isLoggedIn() {
        return isElementDisplayed(COMPANY_NAME);
    }

}
