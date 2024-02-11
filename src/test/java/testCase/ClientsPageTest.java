package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constants;
import elementRepository.ClientsPage;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.ExcelUtilities;

public class ClientsPageTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	ClientsPage cl;
	ExcelUtilities eu;
	@DataProvider(name = "client-search-data-provider")
	public Object[] clientSaerchData() {
		return new Object[] { "Nithya","Astar" ,"Sam" };
	}
	
  @Test(dataProvider = "client-search-data-provider",groups="regression")
  public void verifyValidClientSeach(String clientName) throws IOException, InterruptedException {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  cl=new ClientsPage(driver);
	  lp.sendUserName(eu.readStringData(1, 0));
	  lp.sendPassword(eu.readStringData(1, 1));
	  lp.loginButtonClick();
	  cl.clientsClick();
	  Thread.sleep(1000);
	  cl.clientSearch(clientName);
	  Thread.sleep(1000);
	  String actual = cl.searchRowByName(clientName);
	  String expected=clientName;
	  Assert.assertTrue(actual.contains(expected),Constants.cp_verifyValidClientSeach);
	  
  }
  @Test(dataProvider = "client-search-data-provider",groups="regression")
  public void verifyResetfunctionality(String client) throws InterruptedException, IOException {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  cl=new ClientsPage(driver);
	  lp.sendUserName(eu.readStringData(1, 0));
	  lp.sendPassword(eu.readStringData(1, 1));
	  lp.loginButtonClick();
	  cl.clientsClick();
	  boolean actual = cl.resetButtonClick(client);
	  Assert.assertTrue(actual,Constants.cp_verifyResetfunctionality );
	  
  }
}
