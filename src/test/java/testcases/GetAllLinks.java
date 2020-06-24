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

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAllLinks {

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
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//		List<WebElement> all_links = driver.findElements(By.tagName("a"));
//		System.out.println(all_links.size());
//		
//		for(WebElement element:all_links) {
//			System.out.println(element.getAttribute("href"));
//		} 
	    List<WebElement> l1 = driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[7]/div[3]")).findElements(By.tagName("a"));
        System.out.println(l1.size());
        for(WebElement w:l1) {
        	System.out.println(w.getAttribute("href"));
        }
		driver.quit();

	}

}
