package pages;

import com.epam.healenium.SelfHealingDriver;
import com.epam.healenium.SelfHealingDriverWait;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {
    private final SelfHealingDriver driver;

    public static final String URL = "https://payroll-staging.sprout.ph/Login.aspx";
    public static final By LOADING = By.xpath("//div[@class='raDiv']");

    public static final By PAYROLL_RUNS = By.id("mnuPayrolls");

    public static final By REPORTS = By.id("mnuReports");

    public static final By PAYROLL_REPORT_OPTION = By.id("A1");
    public static final By PAYROLL_SUMMARY_REPORT_OPTION = By.id("mnuPayrollSummary");
    public static final By MONTHLY_SUMMARY_REPORT_OPTION = By.id("mnuMonthlySummary");
    public static final By VARIANCE_REPORT_OPTION = By.id("mnuVarianceReport");
    public static final By GENERAL_LEDGER_REPORT_OPTION = By.id("mnuGeneralLedgerReport");
    public static final By PAYSLIP_REPORT_OPTION = By.id("mnuPayslipReport");
    public static final By FINAL_PAY_REPORT_OPTION = By.id("mnuFinalPayReport");
    public static final By ADJUSTMENT_REPORT_OPTION = By.id("mnuAdjustmentReport");
    public static final By YTD_REPORT_OPTION = By.id("mnuYTDReport");
    public static final By YTD_REPORT_ADJUSTMENTS_OPTION = By.id("mnuYTDAdjustmentReport");

    public static final By SSS_REPORT_OPTION = By.id("A2");
    public static final By SSS_R3_REPORT_OPTION = By.id("mnuR3Report");
    public static final By SSS_R5_REPORT_OPTION = By.id("mnuR5Report");
    public static final By SSS_LMS_REPORT_OPTION = By.id("mnuLMS");
    public static final By SSS_AMSCCL_REPORT_OPTION = By.id("A6");
    public static final By SSS_ML1_REPORT_OPTION = By.id("mnuML1");
    public static final By SSS_R1A_REPORT_OPTION = By.id("mnuR1A");

    public static final By PHILHEALTH_REPORT_OPTION = By.id("A3");
    public static final By PHILHEALTH_ER2_REPORT_OPTION = By.id("mnuER2");
    public static final By PHILHEALTH_RF1_DATA_REPORT_OPTION = By.id("mnuRF1Data");
    public static final By PHILHEALTH_RF1_PDF_REPORT_OPTION = By.id("mnuRF1Pdf");

    public static final By PAGIBIG_REPORT_OPTION = By.id("A4");
    public static final By PAGIBIG_MCRF_REPORT_OPTION = By.id("mnuMCRF");
    public static final By PAGIBIG_EXCEL_REPORT_OPTION = By.id("mnuM1Excel");
    public static final By PAGIBIG_STLRF_REPORT_OPTION = By.id("mnuSTLRF");
    public static final By PAGIBIG_STLRF_EXCEL_REPORT_OPTION = By.id("mnuSTLRFExcel");

    public static final By BIR_REPORT_OPTION = By.id("A5");
    public static final By BIR_1601C_REPORT_OPTION = By.id("mnu1601C");
    public static final By BIR_1601EQ_REPORT_OPTION = By.id("mnu1601EQ");
    public static final By BIR_1604C_REPORT_OPTION = By.id("mnu1604C");
    public static final By BIR_1604CF_REPORT_OPTION = By.id("mnu1604CF");
    public static final By BIR_2316_REPORT_OPTION = By.id("mnu2316");
    public static final By BIR_2306_REPORT_OPTION = By.id("mnu2306");
    public static final By BIR_2307_REPORT_OPTION = By.id("mnu2307");
    public static final By BIR_ANNUALIZATION_REPORT_OPTION = By.id("mnuAnnualization");
    public static final By BIR_ALPHALIST_7_REPORT_OPTION = By.id("A16");
    public static final By BIR_ALPHALIST_7_2_REPORT_OPTION = By.id("A17");

    public static final By ONEHUB_DAT_FILES = By.id("A11");
    public static final By SSS_EPF_REPORT_OPTION = By.id("mnuSSSEPF");
    public static final By SSS_CONTRIB_REPORT_OPTION = By.id("mnuSSSContri");
    public static final By PAGIBIG_DAT_REPORT_OPTION = By.id("mnuPagIbigDATRpt");
    public static final By PHILHEALTH_REMITTANCE_REPORT_OPTION = By.id("mnuReportPhilhealthRemittanceRpt");

    public static final By BPI_REPORT_OPTION = By.id("A18");
    public static final By BPI_PAGIBIG_REPORT_OPTION = By.id("mnuBPIHDMF");
    public static final By BPI_SSS_CONTRIB_REPORT_OPTION = By.id("mnuBPISSSContri");
    public static final By BPI_SSS_LOAN_REPORT_OPTION = By.id("mnuBPISSSLoan");
    public static final By BPI_SSS_MCL_REPORT_OPTION = By.id("mnuSSSMCLBPI");
    public static final By BPI_PHILHEALTH_REPORT_OPTION = By.id("mnuBPIPhilhealth");

    public static final By SECURITYBANK_REPORT_OPTION = By.id("A19");
    public static final By SECURITYBANK_PAGIBIG_REPORT_OPTION = By.id("mnuSecurityBankHDMF");
    public static final By SECURITYBANK_SSS_CONTRIB_REPORT_OPTION = By.id("mnuSecurityBankSSSContri");

    public static final By CERT_CONTRIBUTION_OPTION = By.id("A7");

    public static final By CERT_LOAN_OPTION = By.id("A8");

    public static final By STATUTORY_REPORT_OPTION = By.id("A9");

    public static final By DEMOGRAPHIC_OPTION = By.id("A10");

    public static final By SETUP = By.id("mnuProfile");

    public static final By COMPANY_SETUP_OPTION = By.id("mnuCoProfile");
    public static final By COMPANY_PROFILE_SETUP_OPTION = By.id("A13");
    public static final By COMPANY_COST_CENTERS_SETUP_OPTION = By.id("mnuCoCostCenters");
    public static final By COMPANY_GENERAL_LEDGER_SETUP_OPTION = By.id("mnuGeneralLedger");
    public static final By COMPANY_DEPARTMENTS_SETUP_OPTION = By.id("mnuCoDepts");
    public static final By COMPANY_BANKS_SETUP_OPTION = By.id("mnuCoBanks");

    public static final By PAYROLL_SETUP_OPTION = By.id("A14");
    public static final By PAYROLL_OT_RATES_SETUP_OPTION = By.id("mnuCoOTRates");
    public static final By PAYROLL_ADJ_TEMPLATES_SETUP_OPTION = By.id("mnuCoAdjustments");
    public static final By PAYROLL_COMPANY_ADJ_SETUP_OPTION = By.id("mnuCoCompAdj");

    public static final By REFERENCES_SETUP_OPTION = By.id("A15");
    public static final By REFERENCES_TAX_TABLE_SETUP_OPTION = By.id("mnuCoTax");
    public static final By REFERENCES_ANNUAL_TAX_TABLE_SETUP_OPTION = By.id("mnuCoTaxAnnual");
    public static final By REFERENCES_PHILHEALTH_SETUP_OPTION = By.id("mnuCoPhilhealth");
    public static final By REFERENCES_PAGIBIG_SETUP_OPTION = By.id("mnuHDMF");
    public static final By REFERENCES_SSS_SETUP_OPTION = By.id("mnuCoSSS");
    public static final By REFERENCES_GOVT_OR_SETUP_OPTION = By.id("mnuGovOR");

    public static final By ACCESS_CONTROL_SETUP_OPTION = By.id("A20");

    public static final By EMPLOYEES = By.id("mnuEmployees");

    public static final By USERS = By.id("mnuUsers");

    public static final By REPORTS_LOGS = By.id("mnuReportsLogs");

    public static final By ADMIN_DROPDOWN = By.className("drop-menu");
    public static final By SECURITY_PASSWORD_OPTION = By.id("lnkChangeSecurityPassword");
    public static final By CHANGE_PASSWORD_OPTION = By.id("lnkChangePassword");
    public static final By PRIVACY_POLICY_OPTION = By.cssSelector("a[href='https://sprout.ph/privacy-policy/']");
    public static final By TERMS_OF_SERVICE_OPTION = By.cssSelector("a[href='https://sprout.ph/terms-of-service/']");
    public static final By HELP_OPTION = By.cssSelector("a[href='https://sprout.zendesk.com/hc/en-us']");
    public static final By LOGOUT = By.id("lnkLogout");

    public PageBase(SelfHealingDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get(URL);
    }

    public void goToPayrollSummary() {
        waitForElement(LOADING, 5, "invisible");
        clickElement(REPORTS);
        waitForElement(PAYROLL_REPORT_OPTION, 5, "visible");
        clickElement(PAYROLL_REPORT_OPTION);
        waitForElement(PAYROLL_SUMMARY_REPORT_OPTION, 5, "visible");
        clickElement(PAYROLL_SUMMARY_REPORT_OPTION);
    }

    public void goToReportsLogs() {
        waitForElement(LOADING, 15, "invisible");
        clickElement(REPORTS_LOGS);
    }

    public void goToEmployees() {
        waitForElement(LOADING, 15, "invisible");
        clickElement(EMPLOYEES);
    }

    public void goToPayrollList() {
        waitForElement(LOADING, 15, "invisible");
        clickElement(PAYROLL_RUNS);
    }

    public void waitForText(By locator, long seconds, String text) {
        SelfHealingDriverWait wait = new SelfHealingDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
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

    public void scrollToTop() {
        JavascriptExecutor jsx = (JavascriptExecutor) this.driver;
        jsx.executeScript("window.scrollTo(0, 0);");
    }

    public void switchFrameLocator(By locator) {
        driver.switchTo().frame(driver.findElement(locator));
    }

    public void switchFrameDefault() {
        driver.switchTo().defaultContent();
    }
}
