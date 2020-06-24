package invokation;

import org.testng.annotations.Test;

public class TestInvokation extends BaseTest {

	/*
	 * I have covered an inDepth framework on Parallel testing and Dockers in 2nd
	 * level of this course i.e. Automation Architect Selenium with 7 live projects.
	 * 2nd Live project in that talks about how to handle these scenarios.
	 * 
	 * 
	 */

	@Test(invocationCount = 5, threadPoolSize = 5)
	public void doLogin123() throws InterruptedException {

		driver = openBrowser("chrome");
		driver.get("https://www.google.ro/");
		System.out.println(driver.getTitle());
		driver.quit();

	}
}
