package parameterization;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameterFromXML {

	@Parameters({"browser","setting","options"})
	@Test
	public void test(String browser,String set,String o) {	
		
		System.out.println(browser+"|+|"+set+"|*|"+o);
	}
}
