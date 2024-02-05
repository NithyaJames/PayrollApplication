package testCase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import elementRepository.ClientsPage;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.ExcelUtilities;

public class HomePageTest extends BaseClass {
	HomePage hp;
	LoginPage lp;
	ExcelUtilities eu;
	ClientsPage cl;
	@Test(groups="regression")
	public void verifyOnClickMenu() throws IOException {
		lp=new LoginPage(driver);
		  hp=new HomePage(driver);
		  cl=new ClientsPage(driver);
		  lp.sendUserName(eu.readStringData(1, 0));
		  lp.sendPassword(eu.readStringData(1, 1));
		  lp.loginButtonClick();
		  cl.clientsClick();
		  boolean workersClickStatus = hp.workersClick();
		  Assert.assertEquals(workersClickStatus, true, Constants.hp_verifyOnClickMenuWorkers);
		  boolean deductionClickStatus = hp.deductionClick();
		  Assert.assertEquals(deductionClickStatus, true, Constants.hp_verifyOnClickMenuDeduction);
		  boolean timeSheetClickStatus = hp.timeSheetClick();
		  Assert.assertEquals(timeSheetClickStatus, true, Constants.hp_verifyOnClickMenuTimesheet);
		  boolean paySlipClickStatus = hp.paySlipClick();
		  Assert.assertEquals(paySlipClickStatus, true, Constants.hp_verifyOnClickMenuPaySlip);
		  boolean invoiceClickStatus = hp.invoiceClick();
		  Assert.assertEquals(invoiceClickStatus, true, Constants.hp_verifyOnClickMenuInvoice);
	}
 }