package testCase;

import java.awt.AWTException;
import java.io.FileNotFoundException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import elementRepository.ClientsPage;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.TimeSheetPage;
import utilities.ExcelUtilities;
import utilities.GeneralUtilites;

public class TimeSheetTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	ClientsPage cl;
	ExcelUtilities eu;
	TimeSheetPage ts;
	GeneralUtilites gu;

	@Test(groups = "smoke")
	public void verifyGeneratePlaySlipButton() throws InterruptedException {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		cl = new ClientsPage(driver);
		ts = new TimeSheetPage(driver);
		lp.sendUserName("carol");
		lp.sendPassword("1q2w3e4r");
		lp.loginButtonClick();
		hp.timeSheetClick();
		ts.generatePlaySlipButton();
		Thread.sleep(1000);
		// gu.alertHandling(driver);
		Alert alertConfirm = driver.switchTo().alert();
		System.out.println(alertConfirm.getText());
		alertConfirm.accept();
		Thread.sleep(10000);
		Alert alertSimple = driver.switchTo().alert();
		String actual=alertSimple.getText();
		String expected="Payslip generated!!!";
		alertSimple.accept();
		Thread.sleep(1000);
		Assert.assertEquals(actual, expected,Constants.tp_verifyGeneratePlaySlipButton);
		
	}
	@Test(groups="smoke")
	public void verifyGenerateInvoiceButton() throws InterruptedException {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		cl = new ClientsPage(driver);
		ts = new TimeSheetPage(driver);
		lp.sendUserName("carol");
		lp.sendPassword("1q2w3e4r");
		lp.loginButtonClick();
		hp.timeSheetClick();
		ts.generateInvoiceButton();
		Thread.sleep(1000);
		// gu.alertHandling(driver);
		Alert alertConfirmInvoice = driver.switchTo().alert();
		System.out.println(alertConfirmInvoice.getText());
		alertConfirmInvoice.accept();
		Thread.sleep(10000);
		Alert alertSimpleInvoice = driver.switchTo().alert();
		String actualInvoice=alertSimpleInvoice.getText();
		String expectedInvoice="Invoice generated!!!";
		alertSimpleInvoice.accept();
		Thread.sleep(1000);
		Assert.assertEquals(actualInvoice, expectedInvoice, Constants.tp_verifyGenerateInvoiceButton);
		
	}
	@Test(groups="regression")
	public void verifyUploadTimesheetFile() throws FileNotFoundException, InterruptedException, AWTException {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		cl = new ClientsPage(driver);
		ts = new TimeSheetPage(driver);
		lp.sendUserName("carol");
		lp.sendPassword("1q2w3e4r");
		lp.loginButtonClick();
		hp.timeSheetClick();
		ts.createTimeSheetTab();
		ts.uploadTimesheet();
		Thread.sleep(2000);
		String expected="CREATE TIMESHEET";
		String actual=ts.createTimesheetPage();
		System.out.println(actual);
		Assert.assertEquals(actual, expected, Constants.tp_verifyUploadTimesheetFile);
	}
}
