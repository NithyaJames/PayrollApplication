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
	
	public void generatePlaySlipButton() {
		generatePlaySlipButton.click();
	}
	public void generateInvoiceButton() {
		generateInvoiceButton.click();
	}
	public void createTimeSheetTab() {
		createTimesheetTab.click();
	}
	public void uploadTimesheet() throws FileNotFoundException, InterruptedException, AWTException {
		
		browse.click();
		StringSelection s1=new  StringSelection(System.getProperty("user.dir")+"\\src\\main\\resources\\TimesheetFile\\rose.jpg");	 
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s1, null);
	    Robot robot = new Robot();    //upload using Robot class
	     robot.delay(1000);
	     robot.keyPress(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_V);
	     robot.delay(250);
	     robot.keyRelease(KeyEvent.VK_CONTROL);
	     robot.keyRelease(KeyEvent.VK_V);
	     robot.delay(250);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     uploadButton.click();

	}
	public String createTimesheetPage() {
		return gu.getElementText(createTimesheet);
	}
}
