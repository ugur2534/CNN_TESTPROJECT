package com.Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ExcelRead {
	
	
	public static List<String> returnExcel(String path, String sheetName) {

		// Get Excel
	
			// Create our Workbook Object
		XSSFWorkbook workbook = null;
			//ZipSecureFile.setMinInflateRatio(-1.0d);
			try {
				
				File src = new File(path);
				
				FileInputStream fis =new FileInputStream(src);
				workbook= new XSSFWorkbook(fis);
				//workbook = WorkbookFactory.create(new File(directory));
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} 
			
			// Go to Our Sheet
			assert workbook != null;
			Sheet sheet = workbook.getSheet(sheetName);

			// Create our DataFormatter
			DataFormatter df = new DataFormatter();

			List<String[]> returningValue = StreamSupport.stream(sheet.spliterator(), false)
					 
				.filter(e -> !df.formatCellValue(e.getCell(0)).contains("Most"))
					.map(row -> new String[] { df.formatCellValue(row.getCell(0)), df.formatCellValue(row.getCell(1)),
							df.formatCellValue(row.getCell(2)) })
					.collect(Collectors.toList());

			try {
				workbook.close();
			} catch (IOException e1) {
				
			}
			System.gc();
			
			List<String> valueList =new ArrayList<>();
			for(String[] i:returningValue) {
				valueList.add(Arrays.toString(i).replace("[", "").replace("]", ""));
		}
	//.replace("[", "").replace("]", "")
		return valueList;

	}

	
	public static void main(String[] args) {
		
				
		//System.out.println(ReturnExcelNew.returnExcel("./Test Data/Test Data Financial.xlsx", "Market"));
		
		System.out.println(ExcelRead.returnExcel("./Test Data/Test Data Financial.xlsx", "Most Popular Stocks"));

	}
	}