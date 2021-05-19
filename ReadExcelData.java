package week5.Hw1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tools.ant.types.FileList.FileName;
import org.testng.annotations.Test;

@Test
public class ReadExcelData {

	public static String[][] readExcel(String sheetName)throws InvalidFormatException, IOException {

		//open workbook
		XSSFWorkbook wbook = new XSSFWorkbook("./data1/Inputdatas.xlsx");

		
		//navigate to sheet inside workbook
		XSSFSheet sheet = wbook.getSheet(sheetName);
		
		//get row and column total count

		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		
		//creating string array for passingdata to data provider by assigning excel rows and columns
		String[][] data = new String[rowCount][columnCount];
		//iterate rows and columns to print entire workbook
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < columnCount; j++) {
				XSSFCell column = row.getCell(j);
				
		//Here since i(row) starts from 1, our data provider array starts with 0, i value reduced by 1
				System.out.println(column.getStringCellValue());
				
				data[i-1][j] = column.getStringCellValue();

			}
		}

		wbook.close();
		return data;

	}

}
