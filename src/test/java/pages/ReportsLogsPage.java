package pages;

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.By;

public class ReportsLogsPage extends PageBase {

    private static final By DOWNLOAD_BTN = By.id("ctl00_ph1_grdQueue_ctl00_ctl04_linkDownload");
    private static final By STATUS_TXT = By.className("status-text");

    public ReportsLogsPage(SelfHealingDriver driver) {
        super(driver);
    }

    public void downloadReportLog() throws InterruptedException {
        waitForElement(LOADING, 10, "invisible");
        Thread.sleep(2000);
        waitForText(STATUS_TXT, 10, "READY");
        clickElement(DOWNLOAD_BTN);
        waitForElement(LOADING, 5, "invisible");
    }
}
