package com.java.iq.poi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PoiWriteExcelFile {

	private static final XSSFWorkbook workbook = new XSSFWorkbook();

	public void generate(int i) {
		try {
			FileOutputStream fileOut = new FileOutputStream("/Users/manju_kogunde/poi-test" + i + ".xlsx");

			XSSFSheet worksheet = workbook.createSheet("POI Worksheet " + i);

			// index from 0,0... cell A1 is cell(0,0)
			XSSFRow row1 = worksheet.createRow((short) 0);

			XSSFCell cellA1 = row1.createCell((short) 0);
			cellA1.setCellValue("Hello");
			XSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
			cellA1.setCellStyle(cellStyle);

			XSSFCell cellB1 = row1.createCell((short) 1);
			cellB1.setCellValue("Goodbye");
			cellStyle = workbook.createCellStyle();
			cellStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
			cellB1.setCellStyle(cellStyle);

			XSSFCell cellC1 = row1.createCell((short) 2);
			cellC1.setCellValue(true);

			XSSFCell cellD1 = row1.createCell((short) 3);
			cellD1.setCellValue(new Date());
			cellStyle = workbook.createCellStyle();
			cellD1.setCellStyle(cellStyle);

			workbook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
