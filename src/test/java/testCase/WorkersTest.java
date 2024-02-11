package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import elementRepository.ClientsPage;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.Workers;
import utilities.ExcelUtilities;

public class WorkersTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	ClientsPage cl;
	Workers wk;
	ExcelUtilities eu;
  @Test(groups="regression")
  public void verifyWorkersView() throws IOException {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  cl=new ClientsPage(driver);
	  wk=new Workers(driver);
	  lp.sendUserName(eu.readStringData(1, 0));
	  lp.sendPassword(eu.readStringData(1, 1));
	  lp.loginButtonClick();
	  hp.workersClick();
	  String expected = wk.getTextOfWorkersTable(1,2);
	  String actual = wk.workersViewClick();
	  Assert.assertTrue(actual.equalsIgnoreCase(expected), Constants.wp_verifyWorkersView);
  }
}
