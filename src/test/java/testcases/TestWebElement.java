package testcases;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWebElement {
	
	public static WebElement fluentWait(final By locator) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)

		.withTimeout(Duration.ofSeconds(30))

		.pollingEvery(Duration.ofSeconds(1))

		.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {

		public WebElement apply(WebDriver driver) {

		return driver.findElement(locator);

		}

		});

		return element;

		};

	public static String browser = "chrome";
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

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
		/// Explicit wait is equivalent to the Fluent Wait
		// WebDriverWait wait= new WebDriverWait(driver,20);

		// Fluent Wait

		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).withMessage(">>>VaBe was here :Timeout within 30 sec!!!!")
				.ignoring(NoSuchElementException.class);

		driver.get("https://login.yahoo.com");

		/*
		 * implicitlyWait Specifies the amount of time the driver should wait when
		 * searching for an element if it is not immediately present.
		 */
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// for yahoo mail
		driver.findElement(By.id("login-username")).sendKeys("io_io_dog");
		// driver.findElement(By.xpath("//*[@id=\"login-signin\"]")).click();
		// Explicit wait
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"login-signin\"]"))).click();
        WebElement loginbtn=fluentWait(By.xpath("//*[@id=\"login-signin\"]"));
        loginbtn.click();
         
		// driver.findElement(By.name("password")).sendKeys("123456");
		// Explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("123456");
          
		driver.findElement(By.id("login-signin")).click();
		// Explicit wait
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-signin"))).click();;
		System.out.println(driver.findElement(By.cssSelector(".error-msg")).getText());

		/// for gmail

		// driver.findElement(By.id("identifierId")).sendKeys("condreicaion@gmail.com");
		// driver.findElement(By.cssSelector("#identifierNext > span > span")).click();
		// driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();
//		Thread.sleep(2000);
		// driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		// end gmail
		// Implicit Wait and Explicit Wait,Fluent Wait

		// driver.close();

		driver.quit();

	}

}
