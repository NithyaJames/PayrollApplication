package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilites;

public class ClientsPage {
	WebDriver driver;
	GeneralUtilites gu = new GeneralUtilites();

	public ClientsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory FindBy
	}

	@FindBy(xpath = "//*[@id=\"w1\"]/li[3]/a")
	WebElement clients;
	@FindBy(xpath = "//input[@id='clientsearch-client_name']")
	WebElement clientSearch;
	@FindBy(id = "clientsearch-id")
	WebElement clientsId;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchButton;
	@FindBy(xpath = "//button[@type='reset']")
	WebElement resetButton;
	@FindBy(xpath = "//a[text()='Create Client']")
	WebElement createClients;
	@FindBy(id = "client-branch_id")
	WebElement clientBranchId;
	@FindBy(id = "client-division_id")
	WebElement clientDivisionId;
	@FindBy(xpath = "//input[@id='client-client_name']")
	WebElement clientName;
	@FindBy(id = "client-client_address")
	WebElement clientAddress;
	@FindBy(id = "client-postcode")
	WebElement clientPostCode;
	@FindBy(xpath = "//input[@id='client-country']")
	WebElement clientCountry;
	@FindBy(xpath = "//input[@id='client-your_ref']']")
	WebElement clientYourRef;
	@FindBy(xpath = "//input[@'client-invoice_contact']")
	WebElement clientInvoiceContact;
	@FindBy(id = "client-phone")
	WebElement clientPhone;
	@FindBy(id = "client-fax")
	WebElement clientFax;
	@FindBy(xpath = "//input[@id='client-email']")
	WebElement clientEmail;
	@FindBy(xpath = "//input[@id='client-company_reg']")
	WebElement clientCompanyReg;
	@FindBy(id = "client-invoice_order")
	WebElement clientInvoiceOrder;
	@FindBy(id = "client-invoice_delivery_method")
	WebElement clientInvoiceDeliveryMethod;
	@FindBy(id = "client-master_document")
	WebElement clientMasterDocument;
	@FindBy(id = "client-settilement_days")
	WebElement clientSettilementDays;
	@FindBy(id = "client-vat_rate")
	WebElement clientVatRate;
	@FindBy(xpath = "/html/body/header/div[3]/div/div/div[1]/h1")
	WebElement nithyaClient;
	@FindBy(xpath ="//button[text()='Reset']") WebElement reset;

	public void clientSearch(String cleintName) {
		gu.sendKeyFunction(clientSearch, cleintName);
		searchButton.click();

	}
	public String getTextOfClientTable(int row, int column) {
		String tableElementPath = "//div[@id='w1']/table//tbody//tr[" + row + "]//td["
				+ column + "]";
		WebElement element = driver.findElement(By.xpath(tableElementPath));
		return element.getText();
	}
	public void clientsClick() {
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", clients);
	}
	
	public String searchRowByName(String Name) 
	{	String rowsValue="";
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"w1\"]/table/tbody/tr/td[2]"));
		for(int i=0;i<rows.size();i++) {
			rowsValue = rows.get(i).getText();
			
		}
		return rowsValue;
		
	}
	public boolean resetButtonClick(String cleintName) {
		gu.sendKeyFunction(clientSearch, cleintName);
		reset.click();
		return gu.getElementText(clientSearch).isEmpty();
	}
	

}
