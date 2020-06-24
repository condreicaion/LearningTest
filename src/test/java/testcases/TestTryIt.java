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

public class TestTryIt {

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

		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		
		System.out.println(driver.findElements(By.tagName("iframe")).size());

		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		int index=1;
		System.out.println("Atribute: id");
		for (WebElement frame : frames) {
			System.out.println(index+":"+frame.getAttribute("id"));	
			index++;
		}
		index=1;
		System.out.println("Atribute: name");
		for (WebElement frame : frames) {			
			System.out.println(index+":"+frame.getAttribute("name"));	
			index++;
		}		

		driver.switchTo().frame("iframeResult");
		// driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='iframeResult']")));

		driver.findElement(By.xpath("/html/body/button")).click();

		System.out.println(driver.findElement(By.xpath("//*[@id=\'demo\']")).getText());

		System.out.println(driver.findElements(By.tagName("iframe")).size());

		driver.switchTo().parentFrame();

		System.out.println(driver.findElements(By.tagName("iframe")).size());

		driver.switchTo().defaultContent();

		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
	}

}
