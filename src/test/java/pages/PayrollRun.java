package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PayrollRun {
    private String month = "September";
    private String runType = "Normal Payroll";
    private WebDriver driver;

    private By txtUsername = By.id("txtUsername");
    private By txtPassword = By.id("txtPassword");
    private By btnLogin = By.id("btnLogin");
    private By tdcompanyName = By.id("tdcompanyName");
    private By grayBar = By.className("grayBar");

    private By ph1_btnCreate = By.id("ph1_btnCreate");

    private By monthArrow = By.id("ctl00_ph1_cmbMonth_Arrow");
    private By monthOption = By.xpath("//div[@id='ctl00_ph1_cmbMonth_DropDown']/div[@class='rcbScroll rcbWidth']/ul[@class='rcbList']/li[text()='"+month+"']");
    private By payGroupArrow = By.id("ctl00_ph1_cmbEmployeeTypeDynamic_Arrow");
    private By payGroupOptionAll = By.xpath("//input[contains(@class,'rcbCheckAllItemsCheckBox')]");
    private By runTypeArrow = By.id("ctl00_ph1_cmbPayrollType_Arrow");
    private By runTypeOption = By.xpath("//div[@id='ctl00_ph1_cmbPayrollType_DropDown']/div[@class='rcbScroll rcbWidth']/ul[@class='rcbList']/li[text()='"+runType+"']");
    private By toDateInput = By.id("ctl00_ph1_rdpTo_dateInput");

    private By ph1_btnSave = By.id("ph1_btnSave");
    private By ph1_btnNext = By.id("ph1_btnNext");

    private By ph1_saveDiv = By.id("ph1_SaveDiv");
    private By saveAndProcess = By.xpath("//div[@id='ph1_SaveDiv']/div[@class='dropdown-content']/input[contains(@value, 'SAVE & PROCESS')]");

    private By summaryTable = By.id("ctl00_ph1_ctl00_ph1_grdPayrollPanel");


    public PayrollRun(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("https://payroll-staging.sprout.ph/Login.aspx");
    }

    public void enterUsername(String username) {
        driver.findElement(txtUsername).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(btnLogin).click();
    }

    public boolean isLoggedIn() {
        return driver.findElement(tdcompanyName).isDisplayed();
    }

    public void clickNewPayrollButton() {
        driver.findElement(ph1_btnCreate).click();
        WebDriverWait waitInvisible = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitInvisible.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='raDiv']")));
    }

    public String onPayrolls() {
        WebElement pageName =  driver.findElement(grayBar).findElement(By.tagName("strong"));
        return pageName.getText();
    }

    public void selectMonth() {
        driver.findElement(monthArrow).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ctl00_ph1_cmbMonth_DropDown']/div[@class='rcbScroll rcbWidth']/ul[@class='rcbList']/li[text()='"+month+"']")));
        driver.findElement(monthOption).click();
    }

    public void selectPayGroup() {
        driver.findElement(payGroupArrow).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@class,'rcbCheckAllItemsCheckBox')]")));
        driver.findElement(payGroupOptionAll).click();
    }

    public void selectRunType() {
        driver.findElement(runTypeArrow).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ctl00_ph1_cmbPayrollType_DropDown']/div[@class='rcbScroll rcbWidth']/ul[@class='rcbList']/li[text()='"+runType+"']")));
        driver.findElement(runTypeOption).click();
        WebDriverWait waitInvisible = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitInvisible.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='raDiv']")));
    }

    public void setDateTo(String toDate) {
        driver.findElement(toDateInput).clear();
        driver.findElement(toDateInput).sendKeys(toDate);
    }

    public void savePayroll() {
        driver.findElement(ph1_btnSave).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ph1_btnNext")));
        driver.findElement(ph1_btnNext).click();
        WebDriverWait waitInvisible = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitInvisible.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='raDiv']")));
    }

    public void saveAndProcessPayroll() {
        driver.findElement(ph1_saveDiv).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ph1_SaveDiv']/div[@class='dropdown-content']/input[contains(@value, 'SAVE & PROCESS')]")));
        driver.findElement(saveAndProcess).click();
    }

    public boolean isTableDisplayed() {
        return driver.findElement(summaryTable).isDisplayed();
    }

}
