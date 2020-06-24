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

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMouseOver {

	public static String browser = "firefox";
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

		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.name("q")).sendKeys("way2automation");
		driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div[1]/div[3]/center/input[1]")).click();
		driver.findElement(By.xpath(
				"/html/body/div[6]/div[2]/div[9]/div[1]/div[2]/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/a/h3"))
				.click();

		WebElement menu = driver.findElement(By.xpath("/html/body/div[4]/div/header/div[3]/div/nav/div[2]/ul/li[8]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(menu).perform();
		driver.findElement(By.linkText("Practice site 1")).click();
		

		// driver.close();
//		driver.quit();

	}
}
