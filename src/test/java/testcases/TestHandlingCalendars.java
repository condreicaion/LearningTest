package testcases;

import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestHandlingCalendars {

	public static String browser = "chrome";
	public static WebDriver driver;
	static int targetDay = 0, targetMonth = 0, targetYear = 0;
	static int currentDay = 0, currentMonth = 0, currentYear = 0;
	static int jumpMonthsBy = 0;
	static boolean increment = true;

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

		driver.get("https://fengyuanchen.github.io/datepicker/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		/*
		 * 
		 * target day, month, year current day, month, year jump to the month increment
		 * or decrement
		 * 
		 */

		String dateToSet = "10/10/2020";
		// current date
		getCurrentDateMonthAndYear();
		System.out.println("current:=" + currentDay + "/" + currentMonth + "/" + currentYear);
		getTargetDateMonthAndYear(dateToSet);

		System.out.println("target:=" + targetDay + "/" + targetMonth + "/" + targetYear);

		calculateHowManyMonthsToJump();
		System.out.println(jumpMonthsBy);
		System.out.println(increment);

		driver.findElement(By.xpath("//input[@placeholder='Pick a date']")).click();

		for (int i = 0; i < jumpMonthsBy; i++) {

			if (increment) {
				driver.findElement(By.xpath("/html/body/div[3]/div[3]/ul[1]/li[3]")).click();
			} else {
				driver.findElement(By.xpath("/html/body/div[3]/div[3]/ul[1]/li[1]")).click();
			}
			Thread.sleep(500);
		}
		
		driver.findElement(By.xpath("//li[contains(text(),'"+(Integer.toString(targetDay)+"')]"))).click();

	}

	public static void getCurrentDateMonthAndYear() {
		Calendar cal = Calendar.getInstance();
		currentDay = cal.get(Calendar.DAY_OF_MONTH);
		currentMonth = cal.get(Calendar.MONTH) + 1;
		currentYear = cal.get(Calendar.YEAR);
	}

	public static void getTargetDateMonthAndYear(String dateString) {

		int firstIndex = dateString.indexOf("/");
		int lastIndex = dateString.lastIndexOf("/");

		targetDay = Integer.parseInt(dateString.substring(0, firstIndex));
		targetMonth = Integer.parseInt(dateString.substring(firstIndex + 1, lastIndex));
		targetYear = Integer.parseInt(dateString.substring(lastIndex + 1, dateString.length()));
	}

	public static void calculateHowManyMonthsToJump() {

		if ((targetMonth - currentMonth) > 0) {
			jumpMonthsBy = (targetMonth - currentMonth);
			increment = true;
		} else {
			jumpMonthsBy = Math.abs(targetMonth - currentMonth);
			increment = false;
		}
	}

}
