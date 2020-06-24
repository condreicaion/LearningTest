package test_GRID;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testDP {
	
	public WebDriver driver;
	DesiredCapabilities dc = new DesiredCapabilities();
	ThreadLocal<WebDriver>dr=new ThreadLocal<WebDriver>();
	
	public WebDriver getDriver() {
		return dr.get();
	}
	public void setDriver(WebDriver driver1) {
		 dr.set(driver1);		
	}
	
	@Test(dataProvider="dp1")
	public void openGoogle(String browser1) throws MalformedURLException, InterruptedException {
		Date d = new Date();		

		if (browser1.equals("firefox")) {
			System.out.println(browser1+":Open google page!!"+d.toString());
			dc.setCapability(CapabilityType.BROWSER_NAME, "firefox");
			dc.setPlatform(Platform.ANY);
			FirefoxOptions opt= new FirefoxOptions();
			opt.merge(dc);			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), opt);
			
		} else if (browser1.equals("chrome")) {
			System.out.println(browser1+":Open google page!!"+d.toString());
			dc.setCapability(CapabilityType.BROWSER_NAME, "chrome");
			dc.setPlatform(Platform.ANY);
			ChromeOptions opt= new ChromeOptions();
			opt.merge(dc);	
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), opt);
		} else if (browser1.equals("IE")) {
			System.out.println(browser1+":Open google page!!"+d.toString());
			dc.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
			dc.setPlatform(Platform.WINDOWS);
			InternetExplorerOptions opt= new InternetExplorerOptions();
			opt.merge(dc);	
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), opt);
		}

		driver.get("http://www.google.com");

		Thread.sleep(1000);

		driver.quit();

	}
	
	@DataProvider(name="dp1",parallel=true)
	public Object[][] getData(){
		
		Object[][] data =new Object[3][1];
		
		data[0][0] = "chrome";
		data[1][0] = "firefox";
		data[2][0] = "IE";
		
		return data;
		
	}
}
