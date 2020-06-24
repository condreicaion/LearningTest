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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDragAndDrop {

	public static String browser ="chrome";
	public static WebDriver driver;

	public static void main(String[] args) {
		
		if(browser.equals("chrome"))
		{		
		WebDriverManager.chromedriver().setup();		
		driver =new ChromeDriver();
		}else if (browser.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();		
			driver =new FirefoxDriver();
		}else if (browser.equals("ie")) {
			WebDriverManager.iedriver().setup();		
			driver =new InternetExplorerDriver();
		}else if (browser.equals("opera")) {
			WebDriverManager.operadriver().setup();		
			driver =new OperaDriver();
		}
		
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebDriverWait wait= new WebDriverWait(driver,5);	
		
		System.out.println("count of frames:="+driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0);
		
        WebElement dragable=driver.findElement(By.id("draggable"));
        WebElement dropable=driver.findElement(By.id("droppable"));
        

//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/span")));
		
		Actions action= new Actions(driver);	
		
		action.dragAndDrop(dragable, dropable).perform();
		action.dragAndDrop(dragable, dropable).perform();

}
}