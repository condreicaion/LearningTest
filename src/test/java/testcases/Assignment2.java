package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {
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

		driver.get("https://www.qa.way2automation.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		if (isElementPresent(By.name("name"))) {

			driver.findElement(By.name("name")).sendKeys("Uloha");
		} else {
			System.out.println("The element with the specified keyword Not found!");
		}

		if (isElementPresent(By.name("country"))) {
			Select select = new Select(driver.findElement(By.name("country")));
			select.selectByValue("Romania");

		} else {
			System.out.println("The element with the specified keyword Not found!");
		}
		// variant1 relative xPath long version
		if (isElementPresent(By.xpath(
				"//div[@id='load_box']/form[@id='load_form']/div[@class='bottom row']/div[@class='span_1_of_4']/input[@class='button'][@value='Submit']"))) {
			driver.findElement(By.xpath(
					"//div[@id='load_box']/form[@id='load_form']/div[@class='bottom row']/div[@class='span_1_of_4']/input[@class='button'][@value='Submit']"))
					.click();
		} else {
			System.out.println("The element with the specified keyword Not found!");
		}
		// variant2 relative xPath short version
		if (isElementPresent(By.xpath(
				"(//input[@class='button'][@value='Submit'])[2]"))) {
			driver.findElement(By.xpath(
					"(//input[@class='button'][@value='Submit'])[2]"))
					.click();
		} else {
			System.out.println("The element with the specified keyword Not found!");
		}

	}
}
