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
    private SelfHealingDriver driver;

    private static final String URL = "https://payroll-staging.sprout.ph/Login.aspx";

    private static final By USERNAME_FIELD = By.id("txtUsername");
    private static final By PASSWORD_FIELD = By.id("txtPassword");
    private static final By LOGIN = By.id("btnLogin");
    private static final By COMPANY_NAME = By.id("tdcompanyName");

    private static final By PAYROLL_RUNS = By.id("mnuPayrolls");

    private static final By REPORTS = By.id("mnuReports");

    private static final By PAYROLL_REPORT_OPTION = By.id("A1");
    private static final By PAYROLL_SUMMARY_REPORT_OPTION = By.id("mnuPayrollSummary");
    private static final By MONTHLY_SUMMARY_REPORT_OPTION = By.id("mnuMonthlySummary");
    private static final By VARIANCE_REPORT_OPTION = By.id("mnuVarianceReport");
    private static final By GENERAL_LEDGER_REPORT_OPTION = By.id("mnuGeneralLedgerReport");
    private static final By PAYSLIP_REPORT_OPTION = By.id("mnuPayslipReport");
    private static final By FINAL_PAY_REPORT_OPTION = By.id("mnuFinalPayReport");
    private static final By ADJUSTMENT_REPORT_OPTION = By.id("mnuAdjustmentReport");
    private static final By YTD_REPORT_OPTION = By.id("mnuYTDReport");
    private static final By YTD_REPORT_ADJUSTMENTS_OPTION = By.id("mnuYTDAdjustmentReport");

    private static final By SSS_REPORT_OPTION = By.id("A2");
    private static final By SSS_R3_REPORT_OPTION = By.id("mnuR3Report");
    private static final By SSS_R5_REPORT_OPTION = By.id("mnuR5Report");
    private static final By SSS_LMS_REPORT_OPTION = By.id("mnuLMS");
    private static final By SSS_AMSCCL_REPORT_OPTION = By.id("A6");
    private static final By SSS_ML1_REPORT_OPTION = By.id("mnuML1");
    private static final By SSS_R1A_REPORT_OPTION = By.id("mnuR1A");

    private static final By PHILHEALTH_REPORT_OPTION = By.id("A3");
    private static final By PHILHEALTH_ER2_REPORT_OPTION = By.id("mnuER2");
    private static final By PHILHEALTH_RF1_DATA_REPORT_OPTION = By.id("mnuRF1Data");
    private static final By PHILHEALTH_RF1_PDF_REPORT_OPTION = By.id("mnuRF1Pdf");

    private static final By PAGIBIG_REPORT_OPTION = By.id("A4");
    private static final By PAGIBIG_MCRF_REPORT_OPTION = By.id("mnuMCRF");
    private static final By PAGIBIG_EXCEL_REPORT_OPTION = By.id("mnuM1Excel");
    private static final By PAGIBIG_STLRF_REPORT_OPTION = By.id("mnuSTLRF");
    private static final By PAGIBIG_STLRF_EXCEL_REPORT_OPTION = By.id("mnuSTLRFExcel");

    private static final By BIR_REPORT_OPTION = By.id("A5");
    private static final By BIR_1601C_REPORT_OPTION = By.id("mnu1601C");
    private static final By BIR_1601EQ_REPORT_OPTION = By.id("mnu1601EQ");
    private static final By BIR_1604C_REPORT_OPTION = By.id("mnu1604C");
    private static final By BIR_1604CF_REPORT_OPTION = By.id("mnu1604CF");
    private static final By BIR_2316_REPORT_OPTION = By.id("mnu2316");
    private static final By BIR_2306_REPORT_OPTION = By.id("mnu2306");
    private static final By BIR_2307_REPORT_OPTION = By.id("mnu2307");
    private static final By BIR_ANNUALIZATION_REPORT_OPTION = By.id("mnuAnnualization");
    private static final By BIR_ALPHALIST_7_REPORT_OPTION = By.id("A16");
    private static final By BIR_ALPHALIST_7_2_REPORT_OPTION = By.id("A17");

    private static final By ONEHUB_DAT_FILES = By.id("A11");
    private static final By SSS_EPF_REPORT_OPTION = By.id("mnuSSSEPF");
    private static final By SSS_CONTRIB_REPORT_OPTION = By.id("mnuSSSContri");
    private static final By PAGIBIG_DAT_REPORT_OPTION = By.id("mnuPagIbigDATRpt");
    private static final By PHILHEALTH_REMITTANCE_REPORT_OPTION = By.id("mnuReportPhilhealthRemittanceRpt");

    private static final By BPI_REPORT_OPTION = By.id("A18");
    private static final By BPI_PAGIBIG_REPORT_OPTION = By.id("mnuBPIHDMF");
    private static final By BPI_SSS_CONTRIB_REPORT_OPTION = By.id("mnuBPISSSContri");
    private static final By BPI_SSS_LOAN_REPORT_OPTION = By.id("mnuBPISSSLoan");
    private static final By BPI_SSS_MCL_REPORT_OPTION = By.id("mnuSSSMCLBPI");
    private static final By BPI_PHILHEALTH_REPORT_OPTION = By.id("mnuBPIPhilhealth");

    private static final By SECURITYBANK_REPORT_OPTION = By.id("A19");
    private static final By SECURITYBANK_PAGIBIG_REPORT_OPTION = By.id("mnuSecurityBankHDMF");
    private static final By SECURITYBANK_SSS_CONTRIB_REPORT_OPTION = By.id("mnuSecurityBankSSSContri");

    private static final By CERT_CONTRIBUTION_OPTION = By.id("A7");

    private static final By CERT_LOAN_OPTION = By.id("A8");

    private static final By STATUTORY_REPORT_OPTION = By.id("A9");

    private static final By DEMOGRAPHIC_OPTION = By.id("A10");

    private static final By SETUP = By.id("mnuProfile");

    private static final By COMPANY_SETUP_OPTION = By.id("mnuCoProfile");
    private static final By COMPANY_PROFILE_SETUP_OPTION = By.id("A13");
    private static final By COMPANY_COST_CENTERS_SETUP_OPTION = By.id("mnuCoCostCenters");
    private static final By COMPANY_GENERAL_LEDGER_SETUP_OPTION = By.id("mnuGeneralLedger");
    private static final By COMPANY_DEPARTMENTS_SETUP_OPTION = By.id("mnuCoDepts");
    private static final By COMPANY_BANKS_SETUP_OPTION = By.id("mnuCoBanks");

    private static final By PAYROLL_SETUP_OPTION = By.id("A14");
    private static final By PAYROLL_OT_RATES_SETUP_OPTION = By.id("mnuCoOTRates");
    private static final By PAYROLL_ADJ_TEMPLATES_SETUP_OPTION = By.id("mnuCoAdjustments");
    private static final By PAYROLL_COMPANY_ADJ_SETUP_OPTION = By.id("mnuCoCompAdj");

    private static final By REFERENCES_SETUP_OPTION = By.id("A15");
    private static final By REFERENCES_TAX_TABLE_SETUP_OPTION = By.id("mnuCoTax");
    private static final By REFERENCES_ANNUAL_TAX_TABLE_SETUP_OPTION = By.id("mnuCoTaxAnnual");
    private static final By REFERENCES_PHILHEALTH_SETUP_OPTION = By.id("mnuCoPhilhealth");
    private static final By REFERENCES_PAGIBIG_SETUP_OPTION = By.id("mnuHDMF");
    private static final By REFERENCES_SSS_SETUP_OPTION = By.id("mnuCoSSS");
    private static final By REFERENCES_GOVT_OR_SETUP_OPTION = By.id("mnuGovOR");

    private static final By ACCESS_CONTROL_SETUP_OPTION = By.id("A20");

    private static final By EMPLOYEES = By.id("mnuEmployees");

    private static final By USERS = By.id("mnuUsers");

    private static final By REPORTS_LOGS = By.id("mnuReportsLogs");

    private static final By ADMIN_DROPDOWN = By.className("drop-menu");
    private static final By SECURITY_PASSWORD_OPTION = By.id("lnkChangeSecurityPassword");
    private static final By CHANGE_PASSWORD_OPTION = By.id("lnkChangePassword");
    private static final By PRIVACY_POLICY_OPTION = By.cssSelector("a[href='https://sprout.ph/privacy-policy/']");
    private static final By TERMS_OF_SERVICE_OPTION = By.cssSelector("a[href='https://sprout.ph/terms-of-service/']");
    private static final By HELP_OPTION = By.cssSelector("a[href='https://sprout.zendesk.com/hc/en-us']");
    private static final By LOGOUT = By.id("lnkLogout");

    public PageBase(SelfHealingDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get(URL);
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
}
