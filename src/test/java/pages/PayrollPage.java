package pages;

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.By;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PayrollPage extends PageBase {

    private String fromDay;
    private String toDay;
    private String year;
    private String month;
    private String runType;
    private String fromDate;
    private String toDate;
    private String payrollGroup;
    private String computePHICval;
    private String computeSSSval;
    private String computePagIbigval;
    private String computeTaxval;
    private String forceEOMval;

    private static final By PAYROLL_LIST_TABLE = By.id("ctl00_ph1_grdPayrolls");
    private static final By PAYROLL_LIST_TABLE_FIRST = By.className("rgPageFirst");
    private static final By PAYROLL_LIST_TABLE_PREV = By.className("rgPagePrev");
    private static final By PAYROLL_LIST_TABLE_NEXT = By.className("rgPageNext");
    private static final By PAYROLL_LIST_TABLE_LAST = By.className("rgPageLast");
    private static final By PAYROLL_LIST_PAGE_INPUT = By.id("ctl00_ph1_grdPayrolls_ctl00_ctl03_ctl01_GoToPageTextBox");
    private static final By PAYROLl_LIST_SIZE_INPUT = By.id("ctl00_ph1_grdPayrolls_ctl00_ctl03_ctl01_ChangePageSizeTextBox");
    private static final By PAYROLL_LIST_GOTO_PAGE_BTN = By.id("ctl00_ph1_grdPayrolls_ctl00_ctl03_ctl01_GoToPageLinkButton");
    private static final By PAYROLL_LIST_CHANGE_SIZE_BTN = By.id("ctl00_ph1_grdPayrolls_ctl00_ctl03_ctl01_ChangePageSizeLinkButton");
    private static final By CREATE_PAYROLL_BTN = By.id("ph1_btnCreate");
    private static final By UPLOAD_YTD_BTN = By.id("ph1_btnYtd");

    private static final By YEAR_INPUT = By.id("ctl00_ph1_txtYear");
    private static final By MONTH_ARROW = By.id("ctl00_ph1_cmbMonth_Arrow");
    private static final By PAYGROUP_ARROW = By.id("ctl00_ph1_cmbEmployeeTypeDynamic_Arrow");
    private static final By RUNTYPE_ARROW = By.id("ctl00_ph1_cmbPayrollType_Arrow");
    private static final By TO_DATE_INPUT = By.id("ctl00_ph1_rdpTo_dateInput");
    private static final By FROM_DATE_INPUT = By.id("ctl00_ph1_rdpFrom_dateInput");
    private static final By DESCRIPTION_INPUT = By.id("ctl00_ph1_txtDescription");

    private static By COMPUTE_PHIC_OPTION;
    private static By COMPUTE_SSS_OPTION;
    private static By COMPUTE_PAGIBIG_OPTION;
    private static By COMPUTE_TAX_OPTION;
    private static By FORCE_EOM_OPTION;
    private static By MONTH_OPTION;
    private static By RUNTYPE_OPTION;
    private static By PAYGROUP_OPTION;
    private static By ADJUSTMENT_OPTION;
    private static By SELECTED_ADJ_EMPLOYEE;
    private static By SEARCH_EMPLOYMENT_STATUS_OPTION;
    private static By APPLIED_BEFORE_TAX_OPTION;
    private static By TAXABLE_OPTION;

    private static final By BACK_PAYROLL_LIST_BTN = By.id("ph1_btnBack");
    private static final By SAVE_SETUP_BTN = By.id("ph1_btnSave");
    private static final By BACK_PAYROLL_LIST_BTN_2 = By.id("ph1_btnBack2");
    private static final By UPLOAD_ADJ_BTN = By.id("ph1_btnImportAdjustments");
    private static final By IMPORT_ADJ_BTN = By.id("ph1_btnImportAdj");
    private static final By DELETE_SETUP_BTN = By.id("btnDelete");
    private static final By NEXT_BTN = By.id("ph1_btnNext");

    private static final By PAYROLL_SELECTED_EMPLOYEES_TABLE = By.id("kendoRightGridEmployees");
    private static final By PAYROLL_AVAILABLE_EMPLOYEES_TABLE = By.id("kendoLeftGridEmployees");
    private static final By PAYROLL_SELECTED_EMPLOYEES_LOADING = By.id("kendoRightGridLoader");
    private static final By PAYROLL_AVAILABLE_EMPLOYEES_LOADING = By.id("kendoLeftGridLoader");
    private static final By SELECTED_ADJ_EMPLOYEE_BTN = By.xpath("//div[@id='kendoRightGridEmployees']//table[@class='k-grid-table k-table k-table-md k-selectable']/tbody/tr[1]/td[2]/a");

    private static final By ADJUSTMENT_MODAL = By.id("RadWindowWrapper_ctl00_ph1_winEmployeeData");
    private static final By ADJUSTMENT_FRAME = By.name("winEmployeeData");
    private static final By ADJUSTMENT_ROW = By.id("ctl00_ph1_grdAdjustments_ctl00__0");
    private static final By CLOSE_ADJUSTMENT_MODAL_BTN = By.cssSelector("a.rwCloseButton");
    private static final By NEW_ADJUSTMENT_RECORD_BTN = By.id("ctl00_ph1_grdAdjustments_ctl00_ctl02_ctl00_InitInsertButton");

    private static final By ADJUSTMENT_FORM = By.className("rgEditForm");
    private static final By ADJUSTMENT_ARROW = By.id("ctl00_ph1_grdAdjustments_ctl00_ctl02_ctl03_cmbType_Arrow");
    private static final By ADJUSTMENT_DROPDOWN = By.id("ctl00_ph1_grdAdjustments_ctl00_ctl02_ctl03_cmbType_DropDown");
    private static final By ADJUSTMENT_NAME_INPUT = By.id("ctl00_ph1_grdAdjustments_ctl00_ctl02_ctl03_txtName");
    private static final By ADJUSTMENT_CODE_INPUT = By.id("ctl00_ph1_grdAdjustments_ctl00_ctl02_ctl03_txtCode");
    private static final By ADJUSTMENT_AMOUNT_INPUT = By.id("ctl00_ph1_grdAdjustments_ctl00_ctl02_ctl03_txtAmount");
    private static final By ADJUSTMENT_REMARKS_INPUT = By.id("ctl00_ph1_grdAdjustments_ctl00_ctl02_ctl03_txtRemarks");
    private static final By SAVE_ADJUSTMENT_BTN = By.id("ctl00_ph1_grdAdjustments_ctl00_ctl02_ctl03_lnkItemUpdate");

    private static final By SAVE_DROPDOWN = By.id("ph1_SaveDiv");
    private static final By SAVE_AND_PROCESS_BTN = By.xpath("//div[@id='ph1_SaveDiv']/div[@class='dropdown-content']/input[contains(@value, 'SAVE & PROCESS')]");
    private static final By SAVE_AS_DRAFT_BTN = By.xpath("//div[@id='ph1_SaveDiv']/div[@class='dropdown-content']/input[contains(@value, 'SAVE AS DRAFT')]");
    private static final By SAVE_AND_PREVIEW_EMAIL_BTN = By.xpath("//div[@id='ph1_SaveDiv']/div[@class='dropdown-content']/input[contains(@value, 'Save & PREVIEW Email')]");

    private static final By IMPORT_DROPDOWN = By.id("ph1_ImportDiv");
    private static final By IMPORT_ATTENDANCE_BTN = By.xpath("//div[@id='ph1_ImportDiv']/div[@class='dropdown-content']/input[contains(@value, 'IMPORT ATTENDANCE')]");
    private static final By IMPORT_FILE_BTN = By.xpath("//div[@id='ph1_ImportDiv']/div[@class='dropdown-content']/input[contains(@value, 'IMPORT FILE')]");
    private static final By DOWNLOAD_BTN = By.xpath("ph1_btnDownload");
    private static final By BACK_PAYROLL_LIST_BTN_3 = By.id("ph1_btnBack");

    private static final By SEARCH_EMPLOYEE_ID_INPUT = By.id("ctl00_ph1_txtEmployeeNumber");
    private static final By SEARCH_EMPLOYEE_LAST_NAME_INPUT = By.id("ctl00_ph1_txtLastName");
    private static final By SEARCH_EMPLOYEE_FIRST_NAME_INPUT = By.id("ctl00_ph1_txtFirstName");
    private static final By SEARCH_EMPLOYMENT_STATUS_ARROW = By.id("ctl00_ph1_cmbStatus_Arrow");
    private static final By SEARCH_EMPLOYEE_BTN = By.id("ph1_btnSearch");
    private static final By CLEAR_SEARCH_BTN = By.id("ph1_btnClear");

    private static final By PAYROLL_SUMMARY_TABLE = By.id("ctl00_ph1_ctl00_ph1_grdPayrollPanel");
    private static final By ADJUSTMENT_REPORT_BTN = By.id("ph1_btnAdjReport");
    private static final By DOWNLOAD_SUMMARY_REPORT_BTN = By.id("ph1_btnDownloadreport");

    public PayrollPage(SelfHealingDriver driver) {
        super(driver);
    }

    public boolean onPayrolls() {
        return isElementDisplayed(PAYROLL_LIST_TABLE);
    }

    public void backToPayrollList() {
        clickElement(PAYROLL_RUNS);
    }

    public void createPayrollRun(String payrollDate, String runType, String payrollGroup) {
        Pattern pattern = Pattern.compile("(\\w+) (\\d+)-(\\d+), (\\d+)");
        Matcher matcher = pattern.matcher(payrollDate);
        if (matcher.find()) {
            this.month = matcher.group(1);
            this.fromDay = matcher.group(2);
            this.toDay = matcher.group(3);
            this.year = matcher.group(4);
        }
        this.fromDate = this.month + " " + this.fromDay + ", " + this.year;
        this.toDate = this.month + " " + this.toDay + ", " + this.year;
        this.runType = runType;
        this.payrollGroup = payrollGroup;
        waitForElement(LOADING, 15, "invisible");
        clickElement(CREATE_PAYROLL_BTN);
        waitForElement(LOADING, 15, "invisible");
        // selectYear();
        // waitForElement(LOADING, 15, "invisible");
        selectMonth();
        selectPayGroup();
        selectRunType();
        setDateFrom();
        setDateTo();
    }

    public void createAdvPayrollRun(String payrollDate, String runType, String payrollGroup, String computePHICval, String computeSSSval, String computePagIbigval, String computeTaxval, String forceEOMval) {
        Pattern pattern = Pattern.compile("(\\w+) (\\d+)-(\\d+), (\\d+)");
        Matcher matcher = pattern.matcher(payrollDate);
        if (matcher.find()) {
            this.month = matcher.group(1);
            this.fromDay = matcher.group(2);
            this.toDay = matcher.group(3);
            this.year = matcher.group(4);
        }
        this.fromDate = this.month + " " + this.fromDay + ", " + this.year;
        this.toDate = this.month + " " + this.toDay + ", " + this.year;
        this.runType = runType;
        this.payrollGroup = payrollGroup;
        this.computePHICval = computePHICval;
        this.computeSSSval = computeSSSval;
        this.computePagIbigval = computePagIbigval;
        this.computeTaxval = computeTaxval;
        this.forceEOMval = forceEOMval;
        waitForElement(LOADING, 15, "invisible");
        clickElement(CREATE_PAYROLL_BTN);
        waitForElement(LOADING, 15, "invisible");
        // selectYear();
        // waitForElement(LOADING, 15, "invisible");
        selectMonth();
        selectPayGroup();
        selectRunType();
        setDateFrom();
        setDateTo();
        setComputePhicOption();
        setComputeSssOption();
        setComputePagibigOption();
        setComputeTaxOption();
        setForceEomOption();
    }

    public void selectYear() {
        enterText(YEAR_INPUT, year);
        waitForElement(LOADING, 15, "invisible");
    }

    public void selectMonth() {
        MONTH_OPTION = By.xpath("//div[@id='ctl00_ph1_cmbMonth_DropDown']/div[@class='rcbScroll rcbWidth']/ul[@class='rcbList']/li[text()='"+month+"']");
        clickElement(MONTH_ARROW);
        waitForElement(MONTH_OPTION, 15, "visible");
        clickElement(MONTH_OPTION);
        waitForElement(LOADING, 15, "invisible");
    }

    public void selectPayGroup() {
        clickElement(PAYGROUP_ARROW);
        if (payrollGroup.equals("all")) {
            PAYGROUP_OPTION = By.xpath("//input[contains(@class,'rcbCheckAllItemsCheckBox')]");
            waitForElement(PAYGROUP_OPTION, 15, "visible");
            clickElement(PAYGROUP_OPTION);
        }
        else {
            PAYGROUP_OPTION = By.xpath("//div[@id='ctl00_ph1_cmbEmployeeTypeDynamic_DropDown']/div[@class='rcbScroll rcbWidth']/ul[@class='rcbList']/li[@class='rcbItem']//descendant::label[contains(text(),'" + payrollGroup + "')]");
            waitForElement(PAYGROUP_OPTION, 15, "visible");
            clickElement(PAYGROUP_OPTION);
        }
        waitForElement(LOADING, 15, "invisible");
    }

    public void selectRunType() {
        RUNTYPE_OPTION = By.xpath("//div[@id='ctl00_ph1_cmbPayrollType_DropDown']/div[@class='rcbScroll rcbWidth']/ul[@class='rcbList']/li[text()='"+runType+"']");
        clickElement(RUNTYPE_ARROW);
        waitForElement(RUNTYPE_OPTION, 15, "visible");
        clickElement(RUNTYPE_OPTION);
        waitForElement(LOADING, 15, "invisible");
    }

    public void setDateFrom() {
        enterText(TO_DATE_INPUT, fromDate);
    }

    public void setDateTo() {
        enterText(TO_DATE_INPUT, toDate);
    }

    public void setComputePhicOption() {
        if (computePHICval.equals("Full")) {
            COMPUTE_PHIC_OPTION = By.id("ph1_chkPHWhole");
        } else if (computePHICval.equals("Yes")) {
            COMPUTE_PHIC_OPTION = By.cssSelector("input[type='radio'][id='ph1_rblPhilHeath_0']");
        } else {
            COMPUTE_PHIC_OPTION = By.cssSelector("input[type='radio'][id='ph1_rblPhilHeath_1']");
        }
        waitForElement(COMPUTE_PHIC_OPTION, 15, "visible");
        clickElement(COMPUTE_PHIC_OPTION);
        waitForElement(LOADING, 15, "invisible");
    }

    public void setComputeSssOption() {
        if (computeSSSval.equals("Full")) {
            COMPUTE_SSS_OPTION = By.id("ph1_chkSSSWhole");
        } else if (computeSSSval.equals("Yes")) {
            COMPUTE_SSS_OPTION = By.cssSelector("input[type='radio'][id='ph1_rblSSS_0']");
        } else {
            COMPUTE_SSS_OPTION = By.cssSelector("input[type='radio'][id='ph1_rblSSS_1']");
        }
        waitForElement(COMPUTE_SSS_OPTION, 15, "visible");
        clickElement(COMPUTE_SSS_OPTION);
        waitForElement(LOADING, 15, "invisible");
    }

    public void setComputePagibigOption() {
        if (computePagIbigval.equals("Full")) {
            COMPUTE_PAGIBIG_OPTION = By.id("ph1_chkHDMFWhole");
        } else if (computePagIbigval.equals("Yes")) {
            COMPUTE_PAGIBIG_OPTION = By.cssSelector("input[type='radio'][id='ph1_rblPagibig_0']");
        } else {
            COMPUTE_PAGIBIG_OPTION = By.cssSelector("input[type='radio'][id='ph1_rblPagibig_1']");
        }
        waitForElement(COMPUTE_PAGIBIG_OPTION, 15, "visible");
        clickElement(COMPUTE_PAGIBIG_OPTION);
        waitForElement(LOADING, 15, "invisible");
    }

    public void setComputeTaxOption() {
        if (computeTaxval.equals("Yes")) {
            COMPUTE_TAX_OPTION = By.cssSelector("input[type='radio'][id='ph1_rblTax_0']");
        } else {
            COMPUTE_TAX_OPTION = By.cssSelector("input[type='radio'][id='ph1_rblTax_1']");
        }
        waitForElement(COMPUTE_TAX_OPTION, 15, "visible");
        clickElement(COMPUTE_TAX_OPTION);
        waitForElement(LOADING, 15, "invisible");
    }

    public void setForceEomOption() {
        if (forceEOMval.equals("Yes")) {
            FORCE_EOM_OPTION = By.cssSelector("input[type='radio'][id='ph1_rblEndOfMonth_0']");
        } else {
            FORCE_EOM_OPTION = By.cssSelector("input[type='radio'][id='ph1_rblEndOfMonth_1']");
        }
        waitForElement(FORCE_EOM_OPTION, 15, "visible");
        clickElement(FORCE_EOM_OPTION);
        waitForElement(LOADING, 15, "invisible");
    }

    public void savePayroll() {
        clickElement(SAVE_SETUP_BTN);
    }

    public void saveAndNext() {
        clickElement(SAVE_SETUP_BTN);
        waitForElement(NEXT_BTN, 15, "visible");
        clickElement(NEXT_BTN);
    }

    public void next() {
        waitForElement(LOADING, 15 ,"invisible");
        waitForElement(NEXT_BTN, 15, "visible");
        clickElement(NEXT_BTN);
    }

    public void clickAdjustments(String empId) {
        waitForElement(LOADING, 5, "invisible");
        scrollToBottom();
        waitForElement(PAYROLL_SELECTED_EMPLOYEES_TABLE, 15, "visible");
        waitForElement(PAYROLL_SELECTED_EMPLOYEES_LOADING, 15, "invisible");
        SELECTED_ADJ_EMPLOYEE = By.xpath("//div[@id='kendoRightGridEmployees']//table[@class='k-grid-table k-table k-table-md k-selectable']/tbody/tr[1]/td[3][text()='"+empId+"']");
        if (isElementDisplayed(SELECTED_ADJ_EMPLOYEE)) {
            clickElement(SELECTED_ADJ_EMPLOYEE_BTN);
        }
        waitForElement(LOADING, 15, "invisible");
        waitForElement(ADJUSTMENT_MODAL, 15, "visible");
        switchFrameLocator(ADJUSTMENT_FRAME);
    }

    public void addNewAdjustmentRecord(String adjustmentType, String name, String code, String amount, String remarks) throws InterruptedException {
        ADJUSTMENT_OPTION = By.xpath("//div[@id='ctl00_ph1_grdAdjustments_ctl00_ctl02_ctl03_cmbType_DropDown']/div[@class='rcbScroll rcbWidth']/ul[@class='rcbList']/li[text()='" + adjustmentType + "']");
        clickElement(NEW_ADJUSTMENT_RECORD_BTN);
        waitForElement(LOADING, 15, "invisible");
        waitForElement(ADJUSTMENT_FORM, 15, "visible");
        clickElement(ADJUSTMENT_ARROW);
        waitForElement(ADJUSTMENT_DROPDOWN, 15, "visible");
        waitForElement(ADJUSTMENT_OPTION, 15, "visible");
        clickElement(ADJUSTMENT_OPTION);
        waitForElement(LOADING, 15, "invisible");
        enterText(ADJUSTMENT_NAME_INPUT, name);
        enterText(ADJUSTMENT_CODE_INPUT, code);
        enterText(ADJUSTMENT_AMOUNT_INPUT, amount);
        enterText(ADJUSTMENT_REMARKS_INPUT, remarks);
        waitForElement(LOADING, 15, "invisible");
        clickElement(SAVE_ADJUSTMENT_BTN);
    }

    public void addNewAdjustmentRecordAdv(String adjustmentType, String name, String code, String amount, String remarks, String appliedBeforeTax, String taxable) throws InterruptedException {
        ADJUSTMENT_OPTION = By.xpath("//div[@id='ctl00_ph1_grdAdjustments_ctl00_ctl02_ctl03_cmbType_DropDown']/div[@class='rcbScroll rcbWidth']/ul[@class='rcbList']/li[text()='" + adjustmentType + "']");
        clickElement(NEW_ADJUSTMENT_RECORD_BTN);
        waitForElement(LOADING, 15, "invisible");
        waitForElement(ADJUSTMENT_FORM, 15, "visible");
        clickElement(ADJUSTMENT_ARROW);
        waitForElement(ADJUSTMENT_DROPDOWN, 15, "visible");
        waitForElement(ADJUSTMENT_OPTION, 15, "visible");
        clickElement(ADJUSTMENT_OPTION);
        waitForElement(LOADING, 15, "invisible");
        enterText(ADJUSTMENT_NAME_INPUT, name);
        enterText(ADJUSTMENT_CODE_INPUT, code);
        enterText(ADJUSTMENT_AMOUNT_INPUT, amount);
        enterText(ADJUSTMENT_REMARKS_INPUT, remarks);
        if (appliedBeforeTax.equals("Yes")) {
            APPLIED_BEFORE_TAX_OPTION = By.id("ctl00_ph1_grdAdjustments_ctl00_ctl02_ctl03_rblAppliedBeforeTax_0");
        } else {
            APPLIED_BEFORE_TAX_OPTION = By.id("ctl00_ph1_grdAdjustments_ctl00_ctl02_ctl03_rblAppliedBeforeTax_1");
        }
        waitForElement(APPLIED_BEFORE_TAX_OPTION, 15, "visible");
        clickElement(APPLIED_BEFORE_TAX_OPTION);
        waitForElement(LOADING, 15, "invisible");
        if (taxable.equals("Yes")) {
            TAXABLE_OPTION = By.id("ctl00_ph1_grdAdjustments_ctl00_ctl02_ctl03_rblTaxable_0");
        } else {
            TAXABLE_OPTION = By.id("ctl00_ph1_grdAdjustments_ctl00_ctl02_ctl03_rblTaxable_1");
        }
        waitForElement(TAXABLE_OPTION, 15, "visible");
        clickElement(TAXABLE_OPTION);
        waitForElement(LOADING, 15, "invisible");
        clickElement(SAVE_ADJUSTMENT_BTN);
    }

    public boolean isAdjustmentDisplayed() {
        waitForElement(LOADING, 15, "invisible");
        return isElementDisplayed(ADJUSTMENT_ROW);
    }

    public void closeAdjustmentModal() throws InterruptedException {
        switchFrameDefault();
        scrollToTop();
        clickElement(CLOSE_ADJUSTMENT_MODAL_BTN);
        waitForElement(LOADING, 5, "invisible");
        Thread.sleep(3000);
    }

    public void searchEmployee(String empId, String firstName, String lastName, String empStatus) {
        SEARCH_EMPLOYMENT_STATUS_OPTION = By.xpath("//div[@id='ctl00_ph1_cmbStatus_DropDown']/div[@class='rcbScroll rcbWidth']/ul[@class='rcbList']/li[text()='"+empStatus+"']");
        waitForElement(LOADING, 15, "invisible");
        enterText(SEARCH_EMPLOYEE_ID_INPUT, empId);
        enterText(SEARCH_EMPLOYEE_FIRST_NAME_INPUT, firstName);
        enterText(SEARCH_EMPLOYEE_LAST_NAME_INPUT, lastName);
        clickElement(SEARCH_EMPLOYEE_BTN);
    }

    public void saveAndProcessPayroll() {
        waitForElement(LOADING, 5, "invisible");
        clickElement(SAVE_DROPDOWN);
        waitForElement(SAVE_AND_PROCESS_BTN, 5, "visible");
        clickElement(SAVE_AND_PROCESS_BTN);
    }

    public boolean isSummaryTableDisplayed() {
        waitForElement(LOADING, 15, "invisible");
        return isElementDisplayed(PAYROLL_SUMMARY_TABLE);
    }

}
