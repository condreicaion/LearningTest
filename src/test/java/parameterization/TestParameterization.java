package parameterization;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterization {

	@Test(dataProvider = "getData")
	public void doLogin(Integer id,String username, String password) {
		System.out.println(id+":::"+username + "----------" + password);
	}

	@DataProvider
	public Object[][] getData() {
		
		Object[][] data=new Object[3][3];
		
		data[0][0]=1;
		data[0][1]="a@yahoo.com";
		data[0][2]="123";
		
		data[1][0]=2;
		data[1][1]="b@hahoo.com";
		data[1][2]="456";
		
		data[2][0]=3;
		data[2][1]="c@jahoo.com";
		data[2][2]="789";
		
		return data;
	}
}
