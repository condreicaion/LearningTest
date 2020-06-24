package testcases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentNaukri {
	public static String browser = "chrome";
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

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

		driver.get("https://www.naukri.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Set<String> winids = driver.getWindowHandles();
		Iterator<String> itr = winids.iterator();
		String window,first_window="";
		
        if(winids.size()>0) {
        	first_window=itr.next();
        }
        System.out.println(first_window+": " + driver.switchTo().window(first_window).getTitle());
        
		while (itr.hasNext()) {
			window = itr.next();
			System.out.println(window+": " + driver.switchTo().window(window).getTitle());
			driver.close();
		}
		Thread.sleep(5000);
		driver.switchTo().window(first_window);
		driver.close();
	}
}
