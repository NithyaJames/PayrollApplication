package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilites;

public class ClientsPage {
	WebDriver driver;
	GeneralUtilites gu=new GeneralUtilites();
	public ClientsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory FindBy
	}
	@FindBy(xpath="/html/body/header/div[2]/div/div/nav/div/div[2]/ul/li[3]/a") WebElement clients;
	@FindBy(xpath="//input[@id='clientsearch-client_name']") WebElement clientSearch;
	@FindBy(id="clientsearch-id") WebElement clientsId;
	@FindBy(xpath="//button[@type='submit']") WebElement searchButton;
	@FindBy(xpath="//button[@type='reset']") WebElement resetButton;
	@FindBy(xpath="//a[text()='Create Client']") WebElement createClients;
	@FindBy(id="client-branch_id") WebElement clientBranchId;
	@FindBy(id="client-division_id") WebElement clientDivisionId;
	@FindBy(xpath="//input[@id='client-client_name']") WebElement clientName;
	@FindBy(id="client-client_address") WebElement clientAddress;
	@FindBy(id="client-postcode") WebElement clientPostCode;
	@FindBy(xpath="//input[@id='client-country']") WebElement clientCountry;
	@FindBy(xpath="//input[@id='client-your_ref']']") WebElement clientYourRef;
	@FindBy(xpath="//input[@'client-invoice_contact']") WebElement clientInvoiceContact;
	@FindBy(id="client-phone") WebElement clientPhone;
	@FindBy(id="client-fax") WebElement clientFax;
	@FindBy(xpath="//input[@id='client-email']") WebElement clientEmail;
	@FindBy(xpath="//input[@id='client-company_reg']") WebElement clientCompanyReg;
	@FindBy(id="client-invoice_order") WebElement clientInvoiceOrder;
	@FindBy(id="client-invoice_delivery_method") WebElement clientInvoiceDeliveryMethod;
	@FindBy(id="client-master_document") WebElement clientMasterDocument;
	@FindBy(id="client-settilement_days") WebElement clientSettilementDays;
	@FindBy(id="client-vat_rate") WebElement clientVatRate;
	@FindBy(xpath="/html/body/header/div[3]/div/div/div[1]/h1") WebElement nithyaClient;
	
	
	public void clientSearch() {
		gu.sendKeyFunction(clientSearch, "Astar");	
	}
	public void createClient() {
		gu.sendKeyFunction(clientSearch, "Astar");
		
	}
	
	
}
