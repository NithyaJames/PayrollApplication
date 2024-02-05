package testCase;

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
  public void verifyWorkersView() {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  cl=new ClientsPage(driver);
	  wk=new Workers(driver);
	  lp.sendUserName("carol");
	  lp.sendPassword("1q2w3e4r");
	  lp.loginButtonClick();
	  hp.workersClick();
	  String expected = wk.getTextOfWorkersTable(1,2);
	  System.out.println(expected);
	  String actual = wk.workersViewClick();
	  System.out.println(actual);
	  Assert.assertTrue(actual.equalsIgnoreCase(expected), Constants.wp_verifyWorkersView);
  }
}
