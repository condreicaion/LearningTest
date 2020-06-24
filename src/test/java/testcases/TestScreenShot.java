package testcases;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScreenShot {

	public static String browser = "chrome";
	public static WebDriver driver;
	
	public static void captureScreenShot() throws IOException {
		Date d=new Date();
		String fileName=d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+fileName));
	}

	public static void main(String[] args) throws IOException {

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

		driver.switchTo().frame("iframeResult");
//		((JavascriptExecutor) (driver)).executeScript("myFunction()");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("myFunction()");

		WebElement elem = driver.findElement(By.xpath("//input[@id='mySubmit']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='10px solid green'", elem);

		captureScreenShot();
		
		System.out.println(
				"finished the capture and saved it:C:\\Eclipse\\Workspace\\MavenSeleniumTesting\\screenshot\\error.jpg");
		driver.quit();
		
	
		
		
	}

}
