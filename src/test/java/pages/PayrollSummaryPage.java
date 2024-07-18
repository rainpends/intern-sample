package pages;

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.By;

public class PayrollSummaryPage extends PageBase {

    private static final By SELECTED_PAYROLL = By.cssSelector("a[href*='ctl00$ph1$grdPayrolls$ctl00$ctl08$ctl00']");

    private static final By EXPORT_EXCEL_BTN = By.id("ph1_btnToExcel");
    private static final By EXPORT_PDF_BTN = By.id("ph1_btnPrint");
    private static final By EMPLOYER_CONTRIB_BTN = By.id("ph1_btnERContrib");
    private static final By BANK_ADVICE_BTN = By.id("ph1_btnInstruction");

    private static final By VARIANCE_DROPDOWN = By.id("btnDownloadVarianceReport");
    private static final By VARIANCE_BASIC_SALARY_OPTION = By.id("btnBasicSalary");
    private static final By VARIANCE_NET_PAY_OPTION = By.id("ph1_btnNetPayValidation");
    private static final By VARIANCE_RECURRING_ADJ_INCOME_OPTION = By.id("btnRecurringAdjustmentsIncome");
    private static final By VARIANCE_RECURRING_ADJ_DEDUCTION_OPTION = By.id("btnRecurringAdjustmentsDeduction");
    private static final By VARIANCE_WITHHOLDING_TAX_OPTION = By.id("btnWithholdingTaxValidation");

    private static final By DOWNLOAD = By.id("ctl00_ph1_grdQueue_ctl00_ctl04_linkDownload");
    private static final By STATUS = By.className("status-text");

    public PayrollSummaryPage(SelfHealingDriver driver) {
        super(driver);
    }

    public void selectPayroll() {
        waitForElement(LOADING, 15, "invisible");
        clickElement(SELECTED_PAYROLL);
        waitForElement(LOADING, 15, "invisible");
        clickElement(EXPORT_EXCEL_BTN);
    }
}
