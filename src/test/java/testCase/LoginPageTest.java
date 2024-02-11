package testCase;

import java.io.IOException;

import java.time.Duration;

import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constants;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.ExcelUtilities;

public class LoginPageTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	ExcelUtilities eu;
	@DataProvider(name = "login-data-provider")
	public Object[][] dpMethod() {
		return new Object[][] { { "Carol", "Admin" },{ "Admin", "1q2w3e4r" },{ "Admin", "12345" }};
	}
  @Test(priority=1,groups="regression")
  public void verifyLoginWithValidDetails() throws IOException {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  eu = new ExcelUtilities();
	  lp.sendUserName(eu.readStringData(1, 0));
	  lp.sendPassword(eu.readStringData(1, 1));
	  lp.loginButtonClick();
	  String expected="PAYROLL APPLICATION";
	  String actual=hp.homePageLoginCheck();
	  Assert.assertEquals(actual, expected, Constants.lp_verifyLoginWithValidDetailsErrorMessage);
	}
  @Test(dataProvider = "login-data-provider",groups="regression")
	public void verifyLoginWithIncorrectCredentials(String name, String pass) {
		lp = new LoginPage(driver);
		lp.sendUserName(name);
		lp.sendPassword(pass);
		lp.loginButtonClick();
		String expected="Incorrect username or password.";
		String actual=lp.wrongCredentialAlert();
		Assert.assertEquals(actual, expected, Constants.lp_verifyLoginWithIncorrectCredentials);
	}
  }

