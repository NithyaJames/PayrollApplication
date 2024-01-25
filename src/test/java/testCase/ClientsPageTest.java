package testCase;

import org.testng.annotations.Test;

import elementRepository.ClientsPage;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.ExcelUtilities;

public class ClientsPageTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	ClientsPage cl;
	
  @Test
  public void verifyClientSeach() {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  cl=new ClientsPage(driver);
	  cl.clientSearch();
	  
	  
	  
  }
}
