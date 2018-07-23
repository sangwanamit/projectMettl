package genericLib;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLib {
	
	//Method returns a hashMap of all the data saved into the excel file for configuration of the browser.
	public static HashMap<String,String> getConfigData(){
		
		HashMap<String, String> data = new HashMap<>();
		
		try {
			File config = new File(".//res/config.xlsx");
			FileInputStream fis = new FileInputStream(config);
			Workbook workBook = new XSSFWorkbook(fis);
			Sheet sheet = workBook.getSheet("config");
			
			int RowCount = sheet.getLastRowNum() ;

			for(int rowInd = 0 ; rowInd <= RowCount ; rowInd++) {

					String key = sheet.getRow(rowInd).getCell(0).getStringCellValue();
					String value = sheet.getRow(rowInd).getCell(1).getStringCellValue();
					data.put(key, value);
			
			}

		}
			catch(Exception E) {
					System.out.println("Exception in Try Block");
					E.printStackTrace();	
			}	
		return data ;
		
	}

	

}
