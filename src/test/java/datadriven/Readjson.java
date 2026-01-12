package datadriven;

import java.awt.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Map;

public class Readjson {

	@Test
	public Object[][] jsonDataRead() {

		Object[][] data = null;
		/*
		ObjectMapper mp = new ObjectMapper();
		  List<Map<String, String>> testData = mp.readValue(
	                new File("src/test/resources/testdata.json"),
	                new TypeReference<List<Map<String, String>>>() {}
	        );
		  
		Object[][] data = new Object[testData.size()][2];

		for (int i = 0; i < testData.size(); i++) {
			data[i][0] = testData.get(i).get("username");
			data[i][1] = testData.get(i).get("password");
		}
		*/
		return data;
	
	}
}
