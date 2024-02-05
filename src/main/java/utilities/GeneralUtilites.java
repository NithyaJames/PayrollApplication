package utilities;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilites {
	public String getElementText(WebElement element)
	{
		return element.getText();
		
	}
	public void selectDropDownUsingIndex(WebElement element,int index) {
		Select obj = new Select(element);
		obj.selectByIndex(index);
	}
	public void sendKeyFunction(WebElement element,String inputValue)
	{
		element.sendKeys(inputValue);
	}
	public void alertHandling(WebDriver driver) {
		Alert alertSend = driver.switchTo().alert();
		System.out.println(alertSend.getText());
		alertSend.accept();
		//driver.switchTo().alert().accept();
		//String alertText = driver.switchTo().alert().getText();
		//return alertText;
	}
	

}
