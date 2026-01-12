package uiapi.NationsBenefits;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelRead {

	@DataProvider
	public Object[][] readData() {

		Object[][] data= null;
		try {
			File input = new File("C:\\Users\\OM SATAPATHY\\Downloads\\Book1.xlsx");
			FileInputStream fs = new FileInputStream(input);
			XSSFWorkbook wb = new XSSFWorkbook(fs);
			XSSFSheet sh = wb.getSheet("Sheet1");

			int rowcount = sh.getPhysicalNumberOfRows();
			System.out.println(rowcount);
			int cellcoutnt = sh.getRow(0).getLastCellNum();
			data = new Object[rowcount - 1][cellcoutnt];
	
			for (int i = 1; i < rowcount-1; i++) {
				for (int j = 0; j < cellcoutnt; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] =df.formatCellValue(sh.getRow(i).getCell(j));
				}

				System.out.println();
			}
	


		} catch (IOException e) {

			e.printStackTrace();
		}
		return data;
	
		

	}

}
