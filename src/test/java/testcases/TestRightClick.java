package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRightClick {
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
		
		driver.get("http://deluxe-menu.com/popup-mode-sample.html");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
				
		WebElement image= driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/div[2]/table[1]/tbody/tr/td[3]/p[2]/img"));
		
		Actions action = new Actions(driver);
		
		action.contextClick(image).perform();
		
		WebElement productInfo=driver.findElement(By.xpath("//*[@id=\'dm2m1i1tdT\']"));
		action.moveToElement(productInfo).perform();
		
		WebElement installation =driver.findElement(By.xpath("//*[@id=\'dm2m2i1tdT\']"));
		action.moveToElement(installation).perform();
		
		WebElement howTo =driver.findElement(By.xpath("//*[@id=\'dm2m3i1tdT\']"));
		action.click(howTo).perform();

}
}
