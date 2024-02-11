package testCase;

import java.awt.AWTException;
import java.io.IOException;

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
import utilities.WaitUtilities;

public class TimeSheetTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	ClientsPage cl;
	ExcelUtilities eu;
	TimeSheetPage ts;
	GeneralUtilites gu;
	WaitUtilities wu;

	@Test(groups = "regression")
	public void verifyGeneratePlaySlipButton() throws InterruptedException, IOException {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		cl = new ClientsPage(driver);
		ts = new TimeSheetPage(driver);
		wu = new WaitUtilities();
		lp.sendUserName(eu.readStringData(1, 0));
		lp.sendPassword(eu.readStringData(1, 1));
		lp.loginButtonClick();
		hp.timeSheetClick();
		String actual= ts.generatePlaySlipButton();
		String expected="Payslip generated!!!";
		Assert.assertEquals(actual, expected,Constants.tp_verifyGeneratePlaySlipButton);
		
	}
	@Test(groups="regression")
	public void verifyGenerateInvoiceButton() throws InterruptedException, IOException {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		cl = new ClientsPage(driver);
		ts = new TimeSheetPage(driver);
		lp.sendUserName(eu.readStringData(1, 0));
		lp.sendPassword(eu.readStringData(1, 1));
		lp.loginButtonClick();
		hp.timeSheetClick();
		String actualInvoice=ts.generateInvoiceButton();
		String expectedInvoice="Invoice generated!!!";
		Assert.assertEquals(actualInvoice, expectedInvoice, Constants.tp_verifyGenerateInvoiceButton);
		
	}
	@Test(groups="regression")
	public void verifyUploadTimesheetFile() throws InterruptedException, AWTException, IOException {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		cl = new ClientsPage(driver);
		ts = new TimeSheetPage(driver);
		lp.sendUserName(eu.readStringData(1, 0));
		lp.sendPassword(eu.readStringData(1, 1));
		lp.loginButtonClick();
		hp.timeSheetClick();
		ts.createTimeSheetTab();
		ts.uploadTimesheet();
		Thread.sleep(2000);
		String expected="CREATE TIMESHEET";
		String actual=ts.createTimesheetPage();
		Assert.assertEquals(actual, expected, Constants.tp_verifyUploadTimesheetFile);
	}
}
