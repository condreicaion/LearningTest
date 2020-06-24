package parameterization;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGParameterizationExcelHashTable {

	public static ExcelReader excel = null;

	@Test(dataProvider = "getData")
	public void testData(Hashtable<String, String> elements) {
		System.out.println("|username:=" + elements.get("username") + "|password:=" + elements.get("password")
				+ "|is_correct:=" + elements.get("is_correct") + "|age:=" + elements.get("age") + "|gen:="
				+ elements.get("gen") + "|name:=" + elements.get("name"));
	}

	@DataProvider
	public static Object[][] getData() {

		Hashtable<String, String> table = null;

		if (excel == null) {
			excel = new ExcelReader("C:\\Eclipse\\Workspace\\TestNGLearning\\testNGdata.xlsx");
		}
		String sheetName = "loginTest";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][1];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			table = new Hashtable<String, String>();
			for (int colNum = 0; colNum < cols; colNum++) {
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}

		}

		return data;
	}

}
