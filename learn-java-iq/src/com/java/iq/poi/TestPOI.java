package com.java.iq.poi;

public class TestPOI {

	public static void main(String[] args) {
		PoiWriteExcelFile writeExcelFile = new PoiWriteExcelFile();
		for (int index = 0; index < 2; index++) {
			writeExcelFile.generate(index);
		}
	}

}
