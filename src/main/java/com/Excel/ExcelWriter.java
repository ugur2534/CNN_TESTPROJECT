package com.Excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {
	CreationHelper createHelper;

	public void writerExcelListCNN(String path, List<String> data) {

		// FileImageOutputStream file= new FileImageOutputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook();
		createHelper = workbook.getCreationHelper();

		// Create a Sheet
		XSSFSheet sheet = workbook.createSheet("A");
		String[] header = { "Name", "Value", "Percentage" };

		System.out.println(data.get(0).split(",").length);

		int count = data.get(0).split(",").length;

		// add table data now

		AtomicInteger rownumber = new AtomicInteger(sheet.getLastRowNum() + 1);

		Row headerRow = sheet.createRow(0);
		AtomicInteger colmHeader = new AtomicInteger(0);

		Arrays.stream(header).forEach(headTitle -> {
			Cell cell = headerRow.createCell(colmHeader.getAndIncrement());

			cell.setCellValue(headTitle);

		});

		data.forEach((value) -> {

			Row row = sheet.createRow(rownumber.getAndIncrement());
			AtomicInteger colmNumber = new AtomicInteger(0);
			String[] content = new String[value.split(",").length];

			for (int i = 0; i < value.split(",").length; i++) {

				content[i] = value.split(",")[i];
			}

			DataFormat format = workbook.createDataFormat();
			Arrays.stream(content).forEach(allValue -> {
				Cell cell = row.createCell(colmNumber.getAndIncrement());
				CellStyle style1 = workbook.createCellStyle(); // Create new style
				// .getFormat("#,##0.00")
				style1.setDataFormat(format.getFormat("#,##0.00"));
				style1.setWrapText(true); // Set wordwrap
				cell.setCellStyle(style1); // Apply style to cell
				cell.setCellValue(allValue);

			});

		});

		// Resize all columns to fit the content size

		for (int i = 0; i < data.get(0).split(",").length; i++) {
			sheet.autoSizeColumn(i);
		}

		try {
			// Write the output to a file
			FileOutputStream fileOut = new FileOutputStream(path);

			workbook.write(fileOut);
			System.out.println("Excel data written successfull");
			fileOut.close();
			// Closing the workbook
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
