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

public class Assignment1 {

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

		driver.get("https://www.google.ro/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//div[2]/input")).sendKeys("Way2Automation");
		driver.findElement(By.xpath("//div[3]/center/input[1]")).click();
		driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div[1]/a/h3")).click();

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links:=" + links.size());
		int count = 0, invalid_links_count = 0;

		for (WebElement link : links) {

			if (link.getAttribute("href").length() > 3 && !link.getAttribute("href").equals("javascript:void(0);")) {
				System.out.println(link.getAttribute("href"));
				count++;
			} else {
				invalid_links_count++;
				System.out.println("!!! Invalid link:="+link.getAttribute("href"));
			}

		}
		System.out.println("Total number of valid links:=" + count);
		System.out.println("Total number of invalid links:=" + invalid_links_count);
		
		driver.quit();
	}
}
