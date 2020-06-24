package parallelTest;

import java.util.Date;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParallelDP {
	
	@Test(dataProvider="dp1")
	public void doLogin(String b) throws InterruptedException {
		
		Date d= new Date();		
		System.out.println("Browser:="+b+"|||||"+d);
		Thread.sleep(2000);
	}
	@DataProvider(name ="dp1", parallel=true)
	public Object[][] getData(){
		
		Object [][] data =new Object[2][1];
		data[0][0]="firefox";
		data[1][0]="chrome";
		
		return data;
		
	}

}
