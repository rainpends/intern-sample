package pages;

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.By;

public class EmployeesPage extends PageBase {

    private static final By EMPLOYEES_TABLE = By.id("ctl00_ph1_grdEmployees");
    private static final By SELECTED_ADJ_EMPLOYEE_BTN = By.cssSelector("a[href='EmployeeAdjustments.aspx?ID=1']");

    private static final By NEW_ADJUSTMENT_RECORD_BTN = By.id("ctl00_ph1_grdAdj_ctl00_ctl02_ctl00_InitInsertButton");

    private static By ADJUSTMENT_OPTION;
    private static By SELECTED_ADJ_EMPLOYEE;

    private static final By ADJUSTMENT_FORM = By.className("rgEditForm");
    private static final By ADJUSTMENT_ARROW = By.id("ctl00_ph1_grdAdj_ctl00_ctl02_ctl03_cmbType_Arrow");
    private static final By ADJUSTMENT_DROPDOWN = By.id("ctl00_ph1_grdAdj_ctl00_ctl02_ctl03_cmbType_DropDown");
    private static final By ADJUSTMENT_NAME_INPUT = By.id("ctl00_ph1_grdAdj_ctl00_ctl02_ctl03_AdjustmentName");
    private static final By ADJUSTMENT_CODE_INPUT = By.id("ctl00_ph1_grdAdj_ctl00_ctl02_ctl03_AdjustmentCode");
    private static final By ADJUSTMENT_AMOUNT_INPUT = By.id("ctl00_ph1_grdAdj_ctl00_ctl02_ctl03_AdjustmentAmount");
    private static final By ADJUSTMENT_DATE_INPUT = By.id("ctl00_ph1_grdAdj_ctl00_ctl02_ctl03_AdjustmentDate_dateInput");
    private static final By ADJUSTMENT_REMARKS_INPUT = By.id("ctl00_ph1_grdAdj_ctl00_ctl02_ctl03_AdjustmentRemarks");

    private static final By SAVE_ADJUSTMENT_BTN = By.id("ctl00_ph1_grdAdj_ctl00_ctl02_ctl03_lnkItemUpdate");

    public EmployeesPage(SelfHealingDriver driver) {
        super(driver);
    }

    public void clickAdjustments(String empId) {
        waitForElement(LOADING, 5, "invisible");
        SELECTED_ADJ_EMPLOYEE = By.xpath("//div[@id='ctl00_ph1_grdEmployees']//table[@class='rgMasterTable']/tbody/tr[1]/td[4][text()='"+empId+"']");
        if (isElementDisplayed(SELECTED_ADJ_EMPLOYEE)) {
            clickElement(SELECTED_ADJ_EMPLOYEE_BTN);
        }
    }

    public void addNewAdjustmentRecord(String adjustmentType, String name, String code, String amount, String remarks, String date) throws InterruptedException {
        ADJUSTMENT_OPTION = By.xpath("//div[@id='ctl00_ph1_grdAdj_ctl00_ctl02_ctl03_cmbType_DropDown']/div[@class='rcbScroll rcbWidth']/ul[@class='rcbList']/li[text()='" + adjustmentType + "']");
        waitForElement(LOADING, 15, "invisible");
        clickElement(NEW_ADJUSTMENT_RECORD_BTN);
        waitForElement(LOADING, 15, "invisible");
        waitForElement(ADJUSTMENT_FORM, 15, "visible");
        scrollToBottom();
        clickElement(ADJUSTMENT_ARROW);
        waitForElement(ADJUSTMENT_DROPDOWN, 15, "visible");
        waitForElement(ADJUSTMENT_OPTION, 15, "visible");
        clickElement(ADJUSTMENT_OPTION);
        waitForElement(LOADING, 15, "invisible");
        enterText(ADJUSTMENT_NAME_INPUT, name);
        enterText(ADJUSTMENT_CODE_INPUT, code);
        enterText(ADJUSTMENT_AMOUNT_INPUT, amount);
        enterText(ADJUSTMENT_REMARKS_INPUT, remarks);
        enterText(ADJUSTMENT_DATE_INPUT, date);
        waitForElement(LOADING, 15, "invisible");
        clickElement(SAVE_ADJUSTMENT_BTN);
    }
}
