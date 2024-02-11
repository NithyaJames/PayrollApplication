package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilites {
	
	public void selectDropDownUsingIndex(WebElement element,int index) {
		Select obj = new Select(element);
		obj.selectByIndex(index);
	}
	
	public String confirmationAlert(WebDriver driver) {
		Alert alertConfirm = driver.switchTo().alert();
		String actual=alertConfirm.getText();
		alertConfirm.accept();
		return actual;
	}
	public void uploadFile() throws AWTException {
		StringSelection s1=new  StringSelection(System.getProperty("user.dir")+"\\src\\main\\resources\\TimesheetFile\\rose.jpg");	 
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s1, null);
	    Robot robot = new Robot();    //upload using Robot class
	     robot.delay(1000);
	     robot.keyPress(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_V);
	     robot.delay(250);
	     robot.keyRelease(KeyEvent.VK_CONTROL);
	     robot.keyRelease(KeyEvent.VK_V);
	     robot.delay(250);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	

}
