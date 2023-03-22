package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "Data") 
	public String[][] getAllData() throws IOException {

		String path = System.getProperty("user.dir") + "//TestData//datasheet.xlsx";
		XLUtility xl = new XLUtility(path);

		int rownum = xl.getRowCount("testDataforApi");
		int colcount = xl.getCellCount("testDataforApi", 1);

		// array size should be same as that of the excel data with same number of rows
		// and columns.
		String apidata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				apidata[i - 1][j] = xl.getCellData("testDataforApi", i, j);
			}
		}

		return apidata;
	}

	@DataProvider(name = "UserNames")
	public String[] getUserNames() throws IOException { 

		String path = System.getProperty("user.dir") + "//TestData//datasheet.xlsx";
		XLUtility xl = new XLUtility(path);

		int rownum = xl.getRowCount("testDataforApi");
		
		String apidata[] = new String[rownum];
		
		for(int i=1;i<=rownum;i++) {
			apidata[i-1] = xl.getCellData("testDataforApi",i, 1);
		}
		
		return apidata;

	}
}
