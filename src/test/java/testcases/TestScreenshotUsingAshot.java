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
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TestScreenshotUsingAshot {

	public static String browser = "chrome";
	public static WebDriver driver;
	
	public static void captureEntirePageWithScrollDownWithAShot(int time_sec) throws IOException {
		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		time_sec*=1000;
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(time_sec)).takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(), "jpg", new File(".//screenshot//"+fileName));
		
	}
	
	public static void captureElementWithScrollDownWithAShot(WebElement ele,int time_sec) throws IOException {
		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		time_sec*=1000;
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(time_sec)).takeScreenshot(driver,ele);
        ImageIO.write(screenshot.getImage(), "jpg", new File(".//screenshot//"+fileName));
		
	}


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

		WebElement ele= driver.findElement(By.xpath("//img[contains(@class,'header-logo__img')]"));
		captureElementWithScrollDownWithAShot(ele,1);
		//captureEntirePageWithScrollDownWithAShot(3);
		
		driver.quit();
	}
	
}
