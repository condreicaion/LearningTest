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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestXml {
	public WebDriver driver;
	DesiredCapabilities dc = new DesiredCapabilities();

	@Parameters({ "browser" })
	@Test
	public void openGoogle(String browser1) throws MalformedURLException, InterruptedException {
		Date d = new Date();
		//System.out.println("Open google page!!"+d.toString());

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

		Thread.sleep(6000);

		driver.quit();

	}

}
