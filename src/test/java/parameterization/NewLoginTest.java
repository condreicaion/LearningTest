package parameterization;

import org.testng.annotations.Test;

public class NewLoginTest {

	@Test(dataProviderClass=DataProviders.class,
			dataProvider="dp1")
	public void doLoginTest(String name,String lname) {
		System.out.println("name:="+name+"lname:="+lname);
	}
	
	@Test(dataProviderClass=DataProviders.class,
			dataProvider="dp1")
	public void doLoginTest1(String name,String lname,String mail) {
		System.out.println("name:="+name+"lname:="+lname+"mail:="+mail);
	}
}

