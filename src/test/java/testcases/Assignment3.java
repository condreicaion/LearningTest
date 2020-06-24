package testcases;

import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.formula.eval.NumberEval;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.protobuf.ByteString.Output;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {
	public static String browser = "chrome";
	public static WebDriver driver;

	public static boolean isElementPresent(By by) {

		try {
			driver.findElement(by);
			return true;
		} catch (Throwable t) {

			return false;
		}

	}

	public static void main(String[] args) {

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (browser.equals("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		}

		driver.get("https://timesofindia.indiatimes.com/poll.cms");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String initial_s = null;
		Integer output = 0;
		String[] x =null;
		
		if (isElementPresent(By.id("mathq2"))) {
			initial_s = driver.findElement(By.id("mathq2")).getText();
			initial_s=initial_s.replaceAll("\\s","");
			initial_s=initial_s.replaceAll("[=]","");			
			
			if (initial_s.indexOf("+") != -1) {
				x=initial_s.split("[+]");						
				output=Integer.parseInt(x[0]) + Integer.parseInt(x[1]);
			} else if (initial_s.indexOf("-") != -1) {
				x=initial_s.split("[-]");						
				output=Integer.parseInt(x[0]) - Integer.parseInt(x[1]);	
			} else if (initial_s.indexOf("*") != -1) {
				x=initial_s.split("[*]");						
				output=Integer.parseInt(x[0]) * Integer.parseInt(x[1]);
			} else if (initial_s.indexOf("/") != -1) {
				x=initial_s.split("[/]");
				if(Integer.parseInt(x[1])!=0) {
					output=Integer.parseInt(x[0]) / Integer.parseInt(x[1]);
				}else {
					System.out.println("Divide by 0 exception!!!");
				}				
			}

		} else {
			System.out.println("The element with the specified keyword Not found!");
		}

		if (isElementPresent(By.id("mathuserans2"))) {           
			driver.findElement(By.id("mathuserans2")).sendKeys(output.toString());
		} else {
			System.out.println("The element with the specified keyword Not found!");
		}

	}
}
