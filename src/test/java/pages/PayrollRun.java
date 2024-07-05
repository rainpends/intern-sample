package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PayrollRun {
    private final String year;
    private final String month;
    private final String runType;
    private final WebDriver driver;
    private final String toDate;

    private static long DEFAULT_WAIT = 15;
    private static final String URL = "https://payroll-staging.sprout.ph/Login.aspx";

    private static By MONTH_OPTION;
    private static By RUNTYPE_OPTION;

    private static final By USERNAME = By.id("txtUsername");
    private static final By PASSWORD = By.id("txtPassword");
    private static final By LOGIN = By.id("btnLogin");
    private static final By COMPANY_NAME = By.id("tdcompanyName");
    private static final By PAYROLLRUNS_TABLE = By.id("ctl00_ph1_grdPayrolls");

    private static final By CREATE_PAYROLL = By.id("ph1_btnCreate");

    private static final By MONTH_DROPDOWN = By.id("ctl00_ph1_cmbMonth_DropDown");
    private static final By PAYGROUP_DROPDOWN = By.id("ctl00_ph1_cmbEmployeeTypeDynamic_DropDown");
    private static final By RUNTYPE_DROPDOWN = By.id("ctl00_ph1_cmbPayrollType_DropDown");

    private static final By YEAR_INPUT = By.id("ctl00_ph1_txtYear");
    private static final By MONTH_ARROW = By.id("ctl00_ph1_cmbMonth_Arrow");
    private static final By PAYGROUP_ARROW = By.id("ctl00_ph1_cmbEmployeeTypeDynamic_Arrow");
    private static final By PAYGROUP_OPTION = By.xpath("//input[contains(@class,'rcbCheckAllItemsCheckBox')]");
    private static final By RUNTYPE_ARROW = By.id("ctl00_ph1_cmbPayrollType_Arrow");
    private static final By TO_DATE_INPUT = By.id("ctl00_ph1_rdpTo_dateInput");

    private static final By SAVE_SETUP = By.id("ph1_btnSave");
    private static final By NEXT = By.id("ph1_btnNext");

    private static final By SAVE_DIV = By.id("ph1_SaveDiv");
    private static final By SAVE_AND_PROCESS = By.xpath("//div[@id='ph1_SaveDiv']/div[@class='dropdown-content']/input[contains(@value, 'SAVE & PROCESS')]");

    private static final By SUMMARY_TABLE = By.id("ctl00_ph1_ctl00_ph1_grdPayrollPanel");
    private static final By LOADING = By.xpath("//div[@class='raDiv']");

    public PayrollRun(WebDriver driver, String year, String month, String runType, String toDate) {
        this.driver = driver;
        this.year = year;
        this.month = month;
        this.runType = runType;
        this.toDate = toDate;
    }

    public void navigateTo() {
        driver.get(URL);
    }

    public void enterUsername(String username) {
        enterText(USERNAME, username);
    }

    public void enterPassword(String password) {
        enterText(PASSWORD, password);
    }

    public void clickLoginButton() {
        clickElement(LOGIN);
    }

    public boolean isLoggedIn() {
        return isElementDisplayed(COMPANY_NAME);
    }

    public void clickNewPayrollButton() {
        waitForElement(LOADING, 5, "invisible");
        clickElement(CREATE_PAYROLL);
    }

    public boolean onPayrolls() {
        return isElementDisplayed(PAYROLLRUNS_TABLE);
    }

//    public void selectYear() {
//        enterText(YEAR_INPUT, year);
//        waitForElement(LOADING, DEFAULT_WAIT, "invisible");
//    }

    public void selectMonth() {
        MONTH_OPTION = By.xpath("//div[@id='ctl00_ph1_cmbMonth_DropDown']/div[@class='rcbScroll rcbWidth']/ul[@class='rcbList']/li[text()='"+month+"']");
        clickElement(MONTH_ARROW);
        waitForElement(MONTH_OPTION, DEFAULT_WAIT, "visible");
        clickElement(MONTH_OPTION);
        waitForElement(LOADING, DEFAULT_WAIT, "invisible");
    }

    public void selectPayGroup() {
        clickElement(PAYGROUP_ARROW);
        waitForElement(PAYGROUP_OPTION, DEFAULT_WAIT, "visible");
        clickElement(PAYGROUP_OPTION);
        waitForElement(LOADING, DEFAULT_WAIT, "invisible");
    }

    public void selectRunType() {
        RUNTYPE_OPTION = By.xpath("//div[@id='ctl00_ph1_cmbPayrollType_DropDown']/div[@class='rcbScroll rcbWidth']/ul[@class='rcbList']/li[text()='"+runType+"']");
        clickElement(RUNTYPE_ARROW);
        waitForElement(RUNTYPE_OPTION, DEFAULT_WAIT, "visible");
        clickElement(RUNTYPE_OPTION);
        waitForElement(LOADING, DEFAULT_WAIT, "invisible");
    }

    public void setDateTo() {
        enterText(TO_DATE_INPUT, toDate);
    }

    public void savePayroll() {
        clickElement(SAVE_SETUP);
        waitForElement(NEXT, 5, "visible");
        clickElement(NEXT);
    }

    public void saveAndProcessPayroll() {
        waitForElement(LOADING, 5, "invisible");
        clickElement(SAVE_DIV);
        waitForElement(SAVE_AND_PROCESS, 5, "visible");
        clickElement(SAVE_AND_PROCESS);
    }

    public boolean isTableDisplayed() {
        return isElementDisplayed(SUMMARY_TABLE);
    }

    public void waitForElement(By locator, long seconds, String waitType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        switch (waitType) {
            case "visible":
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                break;
            case "invisible":
                wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
                break;
            default:
                throw new IllegalArgumentException("Invalid wait type");
        }
    }

    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    public void enterText(By locator, String txt) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(txt);
    }

    public boolean isElementDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

}
