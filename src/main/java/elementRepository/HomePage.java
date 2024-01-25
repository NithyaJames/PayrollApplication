package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.GeneralUtilites;

public class HomePage {
	WebDriver driver;
	GeneralUtilites gu=new GeneralUtilites();
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}
	@FindBy(xpath="//div[@class='col-sm-6 page-title']//h1")
	WebElement payrollApplication;
	//clients elements
	@FindBy(xpath="/html/body/header/div[2]/div/div/nav/div/div[2]/ul/li[3]/a")
	WebElement clients;
	@FindBy(xpath="//a[text()='Create Client']")
	WebElement createClients;
	@FindBy(linkText="Workers")
	WebElement workers;
	@FindBy(linkText="Deduction")
	WebElement deduction;
	@FindBy(linkText="TimeSheet")
	WebElement timeSheet;
	@FindBy(linkText="Payslip")
	WebElement payslip;
	@FindBy(linkText="Invoice")
	WebElement invoice;
	

	public String homePageLoginCheck()
	{
	return 	gu.getElementText(payrollApplication);
	}
	public void clientsClick() {
		clients.click();	
	}
	public void createClientsClick() {
		createClients.click();	
	}
	public void workersClick() {
		workers.click();	
	}
	public void deductionClick() {
		deduction.click();	
	}
	public void timeSheetClick() {
		timeSheet.click();	
	}
	public void paySlipClick() {
		payslip.click();	
	}
	public void invoiceClick() {
		invoice.click();	
	}
	

}
