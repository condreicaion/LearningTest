package testcases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestElementScreenShot {
	public static String browser = "chrome";
	public static WebDriver driver;

	public static void captureScreenShot() throws IOException {
		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//" + fileName));
	}

	public static void captureElementScreenshot(WebElement ele) throws IOException {
		
		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullImg = ImageIO.read(screenshotFile);

		Point p = ele.getLocation();
		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();

		BufferedImage eleScreenShot = fullImg.getSubimage(p.x, p.y, eleWidth, eleHeight);
		ImageIO.write(eleScreenShot, "jpg", screenshotFile);

		File screenshotLocation = new File(".//screenshot//"+fileName);
		FileUtils.copyFile(screenshotFile, screenshotLocation);
	}

	public static void main(String[] args) throws IOException, InterruptedException {

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
		 
		
		driver.get("https://www.way2automation.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//img[contains(@class,'header-logo__img')]"));
		//captureElementScreenshot(element);		
		captureScreenShot();

		driver.close();
		
//		driver.get("https://www.google.com");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//
//		element = driver.findElement(By.id("hplogo"));
//		captureElementScreenshot(element);

		driver.quit();
	}
}
