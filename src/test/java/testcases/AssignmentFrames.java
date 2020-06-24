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

public class AssignmentFrames {
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
		/* The result of above 2 loops
		 * Atribute: id
			1:iframeResult
			2:
			3:
			4:ssIFrame_google
			5:GoogleSetNPA
		  Atribute: name
			1:iframeResult
			2:__cmpLocator
			3:__uspapiLocator
			4:
			5:GoogleSetNPA
		 */
		
		//2nd element
		driver.switchTo().frame(1);
		//or
		driver.switchTo().frame("__cmpLocator");
		
		//3rd element
		driver.switchTo().frame(2);
		//or
		driver.switchTo().frame("__uspapiLocator");

	}
}
