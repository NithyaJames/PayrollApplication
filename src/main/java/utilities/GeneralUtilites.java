package utilities;

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

}
