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
	@FindBy(xpath="/html/body/header/div[3]/div/div/div[1]/h1")
	WebElement payrollApplication;
	//clients elements
	@FindBy(xpath="//ul[@id=\"w3\"]/li[3]/a")
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
	return 	payrollApplication.getText();
	}
	public void clientsClick() {
		clients.click();	
	}
	public void createClientsClick() {
		createClients.click();	
	}
	public boolean workersClick() {
		workers.click();
		return workers.isEnabled();
	}
	public boolean deductionClick() {
		deduction.click();
		return deduction.isEnabled();
	}
	public boolean timeSheetClick() {
		timeSheet.click();
		return timeSheet.isEnabled();
	}
	public boolean paySlipClick() {
		payslip.click();
		return payslip.isEnabled();
	}
	public boolean invoiceClick() {
		invoice.click();
		return invoice.isEnabled();
	}
	

}
