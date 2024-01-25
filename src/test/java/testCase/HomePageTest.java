package testCase;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;

public class HomePageTest extends BaseClass {
	HomePage hp;
	LoginPage lp;
	@Test
	public void verifyOnClickMenu() {
		lp=new LoginPage(driver);
		  hp=new HomePage(driver);
		  lp.sendUserName("carol");
		  lp.sendPassword("1q2w3e4r");
		  lp.loginButtonClick();
		  hp.clientsClick();
		  hp.createClientsClick();
		  hp.workersClick();
		  hp.deductionClick();
		  hp.timeSheetClick();
		  hp.paySlipClick();
		  hp.invoiceClick();
	}
 }