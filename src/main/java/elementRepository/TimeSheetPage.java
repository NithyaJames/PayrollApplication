package elementRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilites;
import utilities.WaitUtilities;

public class TimeSheetPage {
	WebDriver driver;
	public static FileInputStream f;
	GeneralUtilites gu = new GeneralUtilites();

	public TimeSheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory FindBy
	}
	@FindBy(xpath = "//button[@class='btn btn-warning btn-responsive playslip']")
	WebElement generatePlaySlipButton;
	@FindBy(xpath = "//button[@class='btn btn-warning btn-responsive invoice']")
	WebElement generateInvoiceButton;
	@FindBy(xpath = "//div[1]/ul/li[3]/a") WebElement createTimesheetTab;
	@FindBy(xpath = "//div[@class='btn btn-primary btn-file']") WebElement browse;
	@FindBy(xpath = "//button[@class='btn btn-default btn-secondary fileinput-upload fileinput-upload-button']") WebElement uploadButton;
	@FindBy(xpath = "//div[3]/div/div/div[1]/h1") WebElement createTimesheet;
	
	public String generatePlaySlipButton() throws InterruptedException {
		String alertText;
		generatePlaySlipButton.click();
		Thread.sleep(1000);
		gu.confirmationAlert(driver);
		Thread.sleep(10000);
		alertText = gu.confirmationAlert(driver);
		return alertText;
	}
	public String generateInvoiceButton() throws InterruptedException {
		String alertText;
		generateInvoiceButton.click();
		Thread.sleep(1000);
		gu.confirmationAlert(driver);
		Thread.sleep(10000);
		alertText = gu.confirmationAlert(driver);
		return alertText;
	}
	public void createTimeSheetTab() {
		createTimesheetTab.click();
	}
	public void uploadTimesheet() throws FileNotFoundException, InterruptedException, AWTException {
		
		browse.click();
		gu.uploadFile();
	    uploadButton.click();

	}
	public String createTimesheetPage() {
		return createTimesheet.getText();
	}
}
