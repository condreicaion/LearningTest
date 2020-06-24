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

public class TestIsElementPresent {
	public static String browser = "chrome";
	public static WebDriver driver;
	
	public static boolean isElementPresent(By by) {
		
		try {
			driver.findElement(by);
			return true;
		}catch(Throwable t) {
			
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

		driver.get("https://www.wikipedia.org/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  
		System.out.println(isElementPresent(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[7]/div[3]/div[10]/a/div[2]/span[1]")));
        System.out.println(isElementPresent(By.cssSelector("#www-wikipedia-org > div.footer > div.other-projects > div:nth-child(10) > a > div.other-project-text > span.other-project-title.jsl10n")));

		driver.quit();
}
}
