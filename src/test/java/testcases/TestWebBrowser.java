package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWebBrowser {
	
	public static String browser ="chrome";
	public static WebDriver driver;

	public static void main(String[] args) {
		
		if(browser.equals("chrome"))
		{		
		WebDriverManager.chromedriver().setup();		
		driver =new ChromeDriver();
		}else if (browser.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();		
			driver =new FirefoxDriver();
		}else if (browser.equals("ie")) {
			WebDriverManager.iedriver().setup();		
			driver =new InternetExplorerDriver();
		}else if (browser.equals("opera")) {
			WebDriverManager.operadriver().setup();		
			driver =new OperaDriver();
		}
		
		driver.get("http://www.way2automation.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getTitle().length());
		
//		driver.close();
		driver.quit();

	
	}
}
