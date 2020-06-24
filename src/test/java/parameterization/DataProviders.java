package parameterization;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {

	@Test(dataProvider = "dp1")
	public void doLogin(String fName, String lName) {

		System.out.println("name:=" + fName + "lname:=" + lName);
	}

	@DataProvider(name = "dp1")
	public static Object getData(Method m) {
		Object[][] data = null;

		if (m.getName().equals("doLoginTest")) {
			data = new Object[2][2];
			data[0][0] = "beuca";
			data[0][1] = "David";
			data[1][0] = "benzar";
			data[1][1] = "fedur";
		}
		if (m.getName().equals("doLoginTest1")) {
			data = new Object[2][3];

			data[0][0] = "beuca";
			data[0][1] = "David";
			data[0][2] = "a@gmail.com";

			data[1][0] = "benzar";
			data[1][1] = "fedur";
			data[1][2] = "b@yahoo.com";

		}

		return data;

	}

//	@DataProvider(name = "dp2")
//	public static Object getData1() {
//
//		Object[][] data = new Object[2][3];
//
//		data[0][0] = "beuca";
//		data[0][1] = "David";
//		data[0][2] = "a@gmail.com";
//
//		data[1][0] = "benzar";
//		data[1][1] = "fedur";
//		data[1][2] = "b@yahoo.com";
//
//		return data;
//
//	}
}
