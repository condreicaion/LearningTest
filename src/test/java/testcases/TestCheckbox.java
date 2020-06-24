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

public class TestCheckbox {
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

		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//		driver.findElement(By.xpath("//div[4]/input[1]")).click();
//		driver.findElement(By.xpath("//div[4]/input[2]")).click();
//		driver.findElement(By.xpath("//div[4]/input[3]")).click();
//		driver.findElement(By.xpath("//div[4]/input[4]")).click();

//		for(int i=1;i<5;i++) {
//			driver.findElement(By.xpath("//div[4]/input["+i+"]")).click();
//		}
//		int i = 1;
//
//		while (isElementPresent(By.xpath("//div[4]/input[" + i + "]"))) {
//			driver.findElement(By.xpath("//div[4]/input[" + i + "]")).click();
//			i++;
//		}
//		System.out.println("Total checkboxes are: " + (i-1));
        WebElement e1= driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]"));
		List<WebElement> list = e1.findElements(By.name("sports"));
		System.out.println("Total checkboxes are: " + list.size());
		
		for (WebElement e : list) {
			e.click();
			System.out.println(e.getAttribute("value"));
		}
		// driver.quit();
	}
}
