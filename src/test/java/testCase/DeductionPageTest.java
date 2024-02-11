package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import elementRepository.ClientsPage;
import elementRepository.DeductionPage;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.ExcelUtilities;
import utilities.GeneralUtilites;

public class DeductionPageTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	ClientsPage cl;
	DeductionPage dp;
	ExcelUtilities eu;
	GeneralUtilites gu;
  @Test(groups="regression")
  public void verifyAddDeduction() throws InterruptedException, IOException {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  cl=new ClientsPage(driver);
	  dp=new DeductionPage(driver);
	  lp.sendUserName(eu.readStringData(1, 0));
	  lp.sendPassword(eu.readStringData(1, 1));
	  lp.loginButtonClick();
	  hp.deductionClick();
	  String[] arr = dp.addDeduction();
	  Assert.assertTrue(arr[1].toLowerCase().contains(arr[0].toLowerCase()),Constants.dp_verifyAddDeduction);
	 
  }
}
