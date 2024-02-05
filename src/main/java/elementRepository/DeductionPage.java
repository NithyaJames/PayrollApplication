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
		gu.sendKeyFunction(inputSearch, "Den");
		deductionWorkerList.click();
		String actual = gu.getElementText(selectedWorkerName);
		gu.selectDropDownUsingIndex(deductionType, 1);
		gu.sendKeyFunction(deductionAmount,"1000");
		deductionEffectiveDate.clear();
		gu.sendKeyFunction(deductionEffectiveDate,"01-02-2024");
		deductionSaveButton.click();
		Thread.sleep(5000);
		//wu.fluentWait(driver, savedWorkerName, "cla","//div[3]/div/div/div[1]/h1]");
		String expected = gu.getElementText(savedWorkerName);
		String[] arr = {expected,actual};
		return arr;

	}
	
	
}
