package testCase;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenShotCapture;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {
  WebDriver driver;
  ScreenShotCapture sc;
  public static Properties pro;
  public static void testBasic() throws IOException {

		pro = new Properties();
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Properties\\config.properties");
		pro.load(fp);
	}
  @BeforeMethod(alwaysRun = true)
  @Parameters("browser")
  public void beforeMethod(String browserName) throws IOException {
	  if(browserName.equals("Chrome")) {
		testBasic();
	    System.setProperty(pro.getProperty("ChromeDriver"), System.getProperty("user.dir")+"\\src\\main\\resources\\Driver\\chrome\\chromedriver.exe");
		  //WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	  }
	  else if(browserName.equals("Firefox")) {
		  testBasic();
		  WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
	  }
		driver.get(pro.getProperty("BaseURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));//implicit wait
  }
  @AfterMethod(alwaysRun = true)
  public void afterMethode(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			sc = new ScreenShotCapture();
			sc.captureFailureScreenShot(driver, iTestResult.getName());
		}
		driver.quit();
	}

}
