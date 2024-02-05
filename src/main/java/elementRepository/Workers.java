package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilites;

public class Workers {
	WebDriver driver;
	GeneralUtilites gu = new GeneralUtilites();

	public Workers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory FindBy
	}
	@FindBy(xpath = "//span[@class='glyphicon glyphicon-eye-open']")
	WebElement view;
	@FindBy(xpath="//div[3]/div/div/div[1]/h1") WebElement workerName;
	
	public String workersViewClick() {
		view.click();
		return gu.getElementText(workerName);
	}
	
	
	public String getTextOfWorkersTable(int row, int column) {
		String tableElementPath = "//*[@id='w1']/table/tbody//tr[" + row + "]//td["
				+ column + "]";
		WebElement element = driver.findElement(By.xpath(tableElementPath));
		return element.getText();
	}
}
