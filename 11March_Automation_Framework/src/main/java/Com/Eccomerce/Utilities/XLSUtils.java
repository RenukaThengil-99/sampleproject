package Com.Eccomerce.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSUtils {
	
	public static FileInputStream file;
	public static XSSFWorkbook WB;
	public static XSSFSheet Sheet;
	public static XSSFRow Row;
	public static XSSFCell Col;
	
	
	public static int GetRowcount(String path, String sheet) throws IOException {
		
		 file= new FileInputStream(path);
		 WB= new XSSFWorkbook(file);
		 Sheet=WB.getSheet(sheet);
		 int Rowcount=Sheet.getLastRowNum();
		 WB.close();
		 file.close();
		 return Rowcount;
	}
	
    public static int getcellcount(String path, String sheetnum, int row) throws IOException {
		
		  file= new FileInputStream(path);
		  WB= new XSSFWorkbook(file);
	      Sheet=WB.getSheet(sheetnum);
		  Row=Sheet.getRow(row);
		  int cellcount= Row.getLastCellNum();
		  WB.close();
		  file.close();
		  return cellcount;
	}
    
   public static String getCelldata(String path, String sheet, int row,int cellnum) throws IOException {
	     file= new FileInputStream(path);
	     WB= new XSSFWorkbook(file);
	     Sheet=WB.getSheet(sheet);
	     Row=Sheet.getRow(row);
		
		 Col=Row.getCell(cellnum);
		String data;
		try {
			DataFormatter formatter= new DataFormatter();
			String Celldata=formatter.formatCellValue(Col);
			return Celldata;
		}catch(Exception e) {
			data=" ";
		}
	   
		WB.close();
		file.close();
		return data;
   }

}
