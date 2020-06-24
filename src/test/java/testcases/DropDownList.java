package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownList {

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

		driver.get("https://www.wikipedia.org/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		 driver.findElement(By.id("searchLanguage")).sendKeys("Esti");
		Select select = new Select(driver.findElement(By.id("searchLanguage")));
		 select.selectByIndex(10);
		 select.selectByValue("uk");
//		 method1
       List <WebElement> l=select.getOptions();
       System.out.println("number of elements in the list="+l.size());
       for(WebElement w:l) {
    	  System.out.println(w.getText());
       }
//		 method2
		List<WebElement> l1 = driver.findElements(By.tagName("Option"));
		
		System.out.println("number of elements in the list=" + l1.size());
		for (WebElement w1 : l1) {
			System.out.print(w1.getAttribute("lang")+" + ");
			System.out.println();
			System.out.print(w1.getAttribute("value")+" + ");
			System.out.println();
			System.out.print(w1.getText()+" + ");
		}
		
		
		
		
		// driver.quit();
		
		

	}

}
