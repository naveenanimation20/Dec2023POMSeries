package com.qa.opencart.tests;

import java.io.FileReader;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

public class Testing {

	@DataProvider
	public Object[][] csvData() throws Exception {
		String csvFile = "./src/test/resources/testdata/data.csv";

		CSVReader reader = new CSVReader(new FileReader(csvFile));

		List<String[]> rows = reader.readAll();

		reader.close();

		Object[][] data = new Object[rows.size()][];
		
		for (int i = 0; i < rows.size(); i++) {
			data[i] = rows.get(i);
		}

		return data;
	}

	@Test(dataProvider = "csvData")
	public void testData(String param1, String param2, String param3, String p4, String p5) {
		System.out.println("Param1: " + param1 + ", Param2: " + param2 + ", Param3: " + param3 +  "Param 4" + p4 + " Param 5" + p5);
	}
}
