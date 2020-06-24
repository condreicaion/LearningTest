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

public class TestWebTable {
	public static String browser = "chrome";
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
		
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List <WebElement> rownum= driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
	    System.out.println("Total rows:="+rownum.size());
	    
	    List <WebElement> colnum= driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[1]/td"));
	    System.out.println("Total rows:="+colnum.size());
	    
	    for(int rows=1;rows<=rownum.size();rows++) {
	    	for(int cols=1;cols<=colnum.size();cols++) {
	    		System.out.print(driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+rows+"]/td["+cols+"]")).getText()+" | ");
	    	}
	    	System.out.println();
	    }
	    System.out.println("Table read finished ok!!!");
		driver.quit();
	}
}
