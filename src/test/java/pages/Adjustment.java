package pages;

import com.epam.healenium.SelfHealingDriverWait;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class Adjustment {
    private String year;
    private String month;
    private String runType;
    private final WebDriver driver;
    private String fromDate;
    private String toDate;
    private String payrollGroup;

    private static long DEFAULT_WAIT = 15;
    private static final String URL = "https://payroll-staging.sprout.ph/Login.aspx";

    private static By MONTH_OPTION;
    private static By RUNTYPE_OPTION;
    private static By PAYGROUP_OPTION;
    private static By ADJUSTMENT_OPTION;
    private static By ADJ_OPTION;

    private static final By USERNAME = By.id("txtUsername");
    private static final By PASSWORD = By.id("txtPassword");
    private static final By LOGIN = By.id("btnLogin");
    private static final By COMPANY_NAME = By.id("tdcompanyName");
    private static final By PAYROLLRUNS_TABLE = By.id("ctl00_ph1_grdPayrolls");
    private static final By LOGOUT = By.id("lnkLogout");

    private static final By CREATE_PAYROLL = By.id("ph1_btnCreate");

    private static final By MONTH_DROPDOWN = By.id("ctl00_ph1_cmbMonth_DropDown");
    private static final By PAYGROUP_DROPDOWN = By.id("ctl00_ph1_cmbEmployeeTypeDynamic_DropDown");
    private static final By RUNTYPE_DROPDOWN = By.id("ctl00_ph1_cmbPayrollType_DropDown");
    private static final By ADJUSTMENT_DROPDOWN = By.id("ctl00_ph1_grdAdjustments_ctl00_ctl02_ctl03_cmbType_DropDown");
    private static final By ADJ_DROPDOWN = By.id("ctl00_ph1_grdAdj_ctl00_ctl02_ctl03_cmbType_DropDown");
    private static final By ADMIN_DROPDOWN = By.className("drop-menu");

    private static final By YEAR_INPUT = By.id("ctl00_ph1_txtYear");
    private static final By MONTH_ARROW = By.id("ctl00_ph1_cmbMonth_Arrow");
    private static final By PAYGROUP_ARROW = By.id("ctl00_ph1_cmbEmployeeTypeDynamic_Arrow");
    private static final By RUNTYPE_ARROW = By.id("ctl00_ph1_cmbPayrollType_Arrow");
    private static final By ADJUSTMENT_ARROW = By.id("ctl00_ph1_grdAdjustments_ctl00_ctl02_ctl03_cmbType_Arrow");
    private static final By ADJ_ARROW = By.id("ctl00_ph1_grdAdj_ctl00_ctl02_ctl03_cmbType_Arrow");
    private static final By FROM_DATE_INPUT = By.id("ctl00_ph1_rdpFrom_dateInput");
    private static final By TO_DATE_INPUT = By.id("ctl00_ph1_rdpTo_dateInput");

    private static final By PAYROLL_EMPLOYEES_TABLE = By.id("kendoRightGridEmployees");
    private static final By ADJUSTMENT_EMPLOYEE = By.xpath("//div[@id='kendoRightGridEmployees']//table[@class='k-grid-table k-table k-table-md k-selectable']/tbody/tr[1]/td[2]/a");
    private static final By ADJUSTMENT_MODAL = By.id("RadWindowWrapper_ctl00_ph1_winEmployeeData");
    private static final By ADJUSTMENT_FRAME = By.name("winEmployeeData");
    private static final By ADD_NEW_RECORD = By.id("ctl00_ph1_grdAdjustments_ctl00_ctl02_ctl00_InitInsertButton");
    private static final By ADJUSTMENT_FORM = By.className("rgEditForm");
    private static final By ADJUSTMENT_NAME = By.id("ctl00_ph1_grdAdjustments_ctl00_ctl02_ctl03_txtName");
    private static final By ADJUSTMENT_CODE = By.id("ctl00_ph1_grdAdjustments_ctl00_ctl02_ctl03_txtCode");
    private static final By ADJUSTMENT_AMOUNT = By.id("ctl00_ph1_grdAdjustments_ctl00_ctl02_ctl03_txtAmount");
    private static final By ADJUSTMENT_REMARKS = By.id("ctl00_ph1_grdAdjustments_ctl00_ctl02_ctl03_txtRemarks");
    private static final By SAVE_ADJUSTMENT = By.id("ctl00_ph1_grdAdjustments_ctl00_ctl02_ctl03_lnkItemUpdate");
    private static final By ADJUSTMENT_ROW = By.id("ctl00_ph1_grdAdjustments_ctl00__0");
    private static final By CLOSE_ADJUSTMENT_MODAL = By.cssSelector("a.rwCloseButton");

    private static final By EMPLOYEES = By.cssSelector("a[href='Employees.aspx']");
    private static final By ADJUSTMENT_LINK = By.cssSelector("a[href='EmployeeAdjustments.aspx?ID=1']");
    private static final By ADD_ADJUSTMENT_RECORD = By.id("ctl00_ph1_grdAdj_ctl00_ctl02_ctl00_InitInsertButton");
    private static final By ADJ_NAME = By.id("ctl00_ph1_grdAdj_ctl00_ctl02_ctl03_AdjustmentName");
    private static final By ADJ_CODE = By.id("ctl00_ph1_grdAdj_ctl00_ctl02_ctl03_AdjustmentCode");
    private static final By ADJ_AMNT = By.id("ctl00_ph1_grdAdj_ctl00_ctl02_ctl03_AdjustmentAmount");
    private static final By ADJ_REM = By.id("ctl00_ph1_grdAdj_ctl00_ctl02_ctl03_AdjustmentRemarks");
    private static final By ADJ_DATE = By.id("ctl00_ph1_grdAdj_ctl00_ctl02_ctl03_AdjustmentDate_dateInput");
    private static final By SAVE_ADJ = By.id("ctl00_ph1_grdAdj_ctl00_ctl02_ctl03_lnkItemUpdate");
    private static final By ADJ_ROW = By.id("ctl00_ph1_grdAdj_ctl00__0");

    private static final By PAYROLL_MENU = By.id("mnuPayrolls");

    private static final By SAVE_SETUP = By.id("ph1_btnSave");
    private static final By NEXT = By.id("ph1_btnNext");

    private static final By SAVE_DIV = By.id("ph1_SaveDiv");
    private static final By SAVE_AND_PROCESS = By.xpath("//div[@id='ph1_SaveDiv']/div[@class='dropdown-content']/input[contains(@value, 'SAVE & PROCESS')]");

    private static final By SUMMARY_TABLE = By.id("ctl00_ph1_ctl00_ph1_grdPayrollPanel");
    private static final By LOADING = By.xpath("//div[@class='raDiv']");
    private static final By TABLE_LOADING = By.id("kendoRightGridLoader");
    private static final By EMPLOYEE_TABLE = By.id("ctl00_ph1_grdEmployees");

    public Adjustment(WebDriver driver) {
        this.driver = driver;
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

    public void clickNewPayrollButton(String year, String month, String runType, String payrollGroup, String fromDate, String toDate) {
        this.year = year;
        this.month = month;
        this.runType = runType;
        this.payrollGroup = payrollGroup;
        this.fromDate = fromDate;
        this.toDate = toDate;
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
        if (payrollGroup.equals("all")) {
            PAYGROUP_OPTION = By.xpath("//input[contains(@class,'rcbCheckAllItemsCheckBox')]");
            waitForElement(PAYGROUP_OPTION, DEFAULT_WAIT, "visible");
            clickElement(PAYGROUP_OPTION);
        }
        else {
            PAYGROUP_OPTION = By.xpath("//div[@id='ctl00_ph1_cmbEmployeeTypeDynamic_DropDown']/div[@class='rcbScroll rcbWidth']/ul[@class='rcbList']/li[@class='rcbItem']//descendant::label[contains(text(),'" + payrollGroup + "')]");
            waitForElement(PAYGROUP_OPTION, DEFAULT_WAIT, "visible");
            clickElement(PAYGROUP_OPTION);
        }
        waitForElement(LOADING, DEFAULT_WAIT, "invisible");
    }

    public void selectRunType() {
        RUNTYPE_OPTION = By.xpath("//div[@id='ctl00_ph1_cmbPayrollType_DropDown']/div[@class='rcbScroll rcbWidth']/ul[@class='rcbList']/li[text()='"+runType+"']");
        clickElement(RUNTYPE_ARROW);
        waitForElement(RUNTYPE_OPTION, DEFAULT_WAIT, "visible");
        clickElement(RUNTYPE_OPTION);
        waitForElement(LOADING, DEFAULT_WAIT, "invisible");
    }

    public void setDateFrom() {
        enterText(FROM_DATE_INPUT, fromDate);
    }

    public void setDateTo() {
        enterText(TO_DATE_INPUT, toDate);
    }

    public void savePayroll() {
        waitForElement(LOADING, 5, "invisible");
        clickElement(SAVE_SETUP);
    }

    public void clickAdjustments() {
        waitForElement(LOADING, 5, "invisible");
        scrollToBottom();
        waitForElement(PAYROLL_EMPLOYEES_TABLE, DEFAULT_WAIT, "visible");
        waitForElement(TABLE_LOADING, DEFAULT_WAIT, "invisible");
        clickElement(ADJUSTMENT_EMPLOYEE);
    }

    public void addNewRecord(String adjustmentType, String name, String code, String amount, String remarks) throws InterruptedException {
        ADJUSTMENT_OPTION = By.xpath("//div[@id='ctl00_ph1_grdAdjustments_ctl00_ctl02_ctl03_cmbType_DropDown']/div[@class='rcbScroll rcbWidth']/ul[@class='rcbList']/li[text()='"+adjustmentType+"']");
        waitForElement(LOADING, 5, "invisible");
        waitForElement(ADJUSTMENT_MODAL, 5, "visible");
        driver.switchTo().frame(driver.findElement(ADJUSTMENT_FRAME));
        clickElement(ADD_NEW_RECORD);
        waitForElement(LOADING, 5, "invisible");
        waitForElement(ADJUSTMENT_FORM, 5, "visible");
        clickElement(ADJUSTMENT_ARROW);
        waitForElement(ADJUSTMENT_DROPDOWN, DEFAULT_WAIT, "visible");
        waitForElement(ADJUSTMENT_OPTION, DEFAULT_WAIT, "visible");
        clickElement(ADJUSTMENT_OPTION);
        waitForElement(LOADING, DEFAULT_WAIT, "invisible");
        enterText(ADJUSTMENT_NAME, name);
        enterText(ADJUSTMENT_CODE, code);
        enterText(ADJUSTMENT_AMOUNT, amount);
        enterText(ADJUSTMENT_REMARKS, remarks);
    }

    public boolean saveAdjustment() {
        waitForElement(LOADING, DEFAULT_WAIT, "invisible");
        clickElement(SAVE_ADJUSTMENT);
        waitForElement(LOADING, DEFAULT_WAIT, "invisible");
        return isElementDisplayed(ADJUSTMENT_ROW);
    }

    public void employeePage() {
        waitForElement(LOADING, DEFAULT_WAIT, "invisible");
        clickElement(EMPLOYEES);
    }

    public void clickAdjustmentEmployee() {
        waitForElement(LOADING, DEFAULT_WAIT, "invisible");
        waitForElement(EMPLOYEE_TABLE, DEFAULT_WAIT, "visible");
        clickElement(ADJUSTMENT_LINK);
    }

    public boolean employeeAdjustment(String adjustmentType, String name, String code, String amount, String date, String remarks) throws InterruptedException {
        ADJ_OPTION = By.xpath("//div[@id='ctl00_ph1_grdAdj_ctl00_ctl02_ctl03_cmbType_DropDown']/div[@class='rcbScroll rcbWidth']/ul[@class='rcbList']/li[text()='"+adjustmentType+"']");
        waitForElement(LOADING, DEFAULT_WAIT, "invisible");
        clickElement(ADD_ADJUSTMENT_RECORD);
        waitForElement(LOADING, 5, "invisible");
        waitForElement(ADJUSTMENT_FORM, 5, "visible");
        scrollToBottom();
        clickElement(ADJ_ARROW);
        waitForElement(ADJ_DROPDOWN, DEFAULT_WAIT, "visible");
        waitForElement(ADJ_OPTION, DEFAULT_WAIT, "visible");
        clickElement(ADJ_OPTION);
        waitForElement(LOADING, DEFAULT_WAIT, "invisible");
        enterText(ADJ_NAME, name);
        enterText(ADJ_CODE, code);
        enterText(ADJ_AMNT, amount);
        enterText(ADJ_DATE, date);
        enterText(ADJ_REM, remarks);
        waitForElement(LOADING, DEFAULT_WAIT, "invisible");
        clickElement(SAVE_ADJ);
        waitForElement(LOADING, DEFAULT_WAIT, "invisible");
        return isElementDisplayed(ADJ_ROW);
    }

    public void payrollWithAdj(String year, String month, String runType, String payrollGroup, String fromDate, String toDate) {
        this.year = year;
        this.month = month;
        this.runType = runType;
        this.payrollGroup = payrollGroup;
        this.fromDate = fromDate;
        this.toDate = toDate;
        waitForElement(LOADING, 5, "invisible");
        clickElement(PAYROLL_MENU);
        waitForElement(LOADING, 5, "invisible");
        clickElement(CREATE_PAYROLL);
    }

    public void saveAndProcessPayroll() {
        driver.switchTo().defaultContent();
        waitForElement(LOADING, DEFAULT_WAIT, "invisible");
        clickElement(CLOSE_ADJUSTMENT_MODAL);
        waitForElement(LOADING, 5, "invisible");
        waitForElement(NEXT, 5, "visible");
        clickElement(NEXT);
        waitForElement(LOADING, 5, "invisible");
        clickElement(SAVE_DIV);
        waitForElement(SAVE_AND_PROCESS, 5, "visible");
        clickElement(SAVE_AND_PROCESS);
    }

    public boolean isTableDisplayed() {
        return isElementDisplayed(SUMMARY_TABLE);
    }

    public boolean isAdjDisplayed() {
        driver.switchTo().frame(driver.findElement(ADJUSTMENT_FRAME));
        return isElementDisplayed(ADJUSTMENT_ROW);
    }

    public void logout() {
        waitForElement(LOADING, 5, "invisible");
        clickElement(ADMIN_DROPDOWN);
        waitForElement(LOGOUT, DEFAULT_WAIT, "visible");
        clickElement(LOGOUT);
        waitForElement(LOADING, DEFAULT_WAIT, "invisible");
    }

    public void waitForElement(By locator, long seconds, String waitType) {
        SelfHealingDriverWait wait = new SelfHealingDriverWait(driver, Duration.ofSeconds(seconds));
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

    public void scrollToBottom() {
        JavascriptExecutor jsx = (JavascriptExecutor) this.driver;
        jsx.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }


}
