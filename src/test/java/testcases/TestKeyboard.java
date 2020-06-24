package testcases;

import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.record.chart.ChartEndObjectRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestKeyboard {

	public static String browser = "chrome";
	public static WebDriver driver;

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

		driver.get("https://accounts.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.id("identifierId")).sendKeys("condreica");
		
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]")).click();
		
				
		Actions action =new Actions(driver);
		//action.sendKeys(Keys.ENTER).perform();
		
		action.keyDown(Keys.CONTROL).sendKeys(Keys.chord("a")).keyUp(Keys.CONTROL).perform();		
		action.keyDown(Keys.CONTROL).sendKeys(Keys.chord("c")).keyUp(Keys.CONTROL).perform();
		
		action.click(driver.findElement(By.id("identifierId"))).perform();		
		
		action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		
		
		

	}
	
}
