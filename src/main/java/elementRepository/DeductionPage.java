package elementRepository;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.GeneralUtilites;
import utilities.WaitUtilities;

public class DeductionPage {
	WebDriver driver;
	GeneralUtilites gu = new GeneralUtilites();
	WaitUtilities wu = new WaitUtilities();

	public DeductionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory FindBy
	}
	
	@FindBy(linkText = "Add Deduction")
	WebElement addDeductionTab;
	@FindBy(xpath = "//span[@class='select2-selection__arrow']") WebElement deductionWorkerName;
	@FindBy(xpath = "//input[@type='search']") WebElement inputSearch;
	@FindBy(xpath="//ul[@class='select2-results__options']//li[1]") WebElement deductionWorkerList;
	@FindBy(id = "deduction-type") WebElement deductionType;
	@FindBy(id = "deduction-amount") WebElement deductionAmount;
	@FindBy(id = "deduction-effective_from") WebElement deductionEffectiveDate;
	@FindBy(xpath = "//button[@type='submit']") WebElement deductionSaveButton;
	@FindBy(id = "select2-deduction-worker_id-container") WebElement selectedWorkerName;
	@FindBy(xpath="//div[3]/div/div/div[1]/h1") WebElement savedWorkerName;
	
	public String[] addDeduction() throws InterruptedException {
		addDeductionTab.click();
		deductionWorkerName.click();
		inputSearch.sendKeys("Den");
		deductionWorkerList.click();
		String actual = selectedWorkerName.getText();
		gu.selectDropDownUsingIndex(deductionType, 1);
		deductionAmount.sendKeys("1000");
		deductionEffectiveDate.clear();
		deductionEffectiveDate.sendKeys("01-02-2024");
		deductionSaveButton.click();
		Thread.sleep(5000);
		String expected = savedWorkerName.getText();
		String[] arr = {expected,actual};
		return arr;

	}
	
	
}
