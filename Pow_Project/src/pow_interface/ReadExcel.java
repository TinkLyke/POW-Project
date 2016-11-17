package pow_interface;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

public class ReadExcel {

	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;

	public static void Read(ArrayList<Deadbird> dbArray) throws FileNotFoundException, IOException {

		workbook = new XSSFWorkbook(new FileInputStream("ron_bbs_trend_en_2011.xlsx"));
		sheet = workbook.getSheetAt(0);

		String location = "empty";
		String name = "empty";
		String reliability = "low";
		double trend = 0.0;
		double probInc = 0.0;

		int skip = 0;

		// -------------------------------------------------------------------
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			if (skip == 1) {
				XSSFRow row = (XSSFRow) rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				int cellIndex = 0;
				while (cellIterator.hasNext()) {
					// data we need to extract

					Cell cell = cellIterator.next();
					if (cellIndex == 1 || cellIndex == 3 || cellIndex == 10 || cellIndex == 16 || cellIndex == 7) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (cellIndex == 7) {
								trend = cell.getNumericCellValue();
							} else if (cellIndex == 16) {
								probInc = cell.getNumericCellValue();
							}
							break;
						case Cell.CELL_TYPE_STRING:
							if (cellIndex == 1) {
								String temp = cell.getStringCellValue();
								String temp2 = temp.replace("-", "");
								name = temp2;
							} else if (cellIndex == 3) {
								location = cell.getStringCellValue();
							} else if (cellIndex == 10) {
								reliability = cell.getStringCellValue();
							}
							break;
						}
					}
					cellIndex++;
				}
				dbArray.add(new Deadbird(name, location, reliability, trend, probInc));
			} else {
				skip = 1;
				XSSFRow row = (XSSFRow) rowIterator.next();
			}
		}
		// CLOSE THE FILE RIGHT HERE
	}
	// -------------------------------------------------------------------
}
