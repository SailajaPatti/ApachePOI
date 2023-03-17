import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;



public class XSSFWorkbookdemo {
	
	public ArrayList<String> getTestcase(String testcase) throws IOException {
ArrayList<String> a=new ArrayList();
		
		FileInputStream fis=new FileInputStream("C://Users/1685453/ExcelDriven.xlsx");
		//java accepts double slashes that 's y we need to provide in file location
		
		XSSFWorkbook workbook =new XSSFWorkbook(fis); //so this class recognising the "fis" as workbook
		//HSSFWorkbook workbook = new HSSFWorkbook(fis);
	    int sheets=workbook.getNumberOfSheets();
	    for(int i=0;i<sheets;i++)
	    {
	    	
	    	if(workbook.getSheetName(i).equalsIgnoreCase("TestData"))
	    	{
	    		XSSFSheet Reqsheet=workbook.getSheetAt(i);
	    		//Identify the Test_name column by going through the 1st row
	    		 //sheet is a collection of rows so iterate sheet ntg but a iterating rows only
	    		
	    	Iterator<Row> rows=	Reqsheet.iterator(); //sheet is a collection of rows so we will iterate each row to find the eeq column so in first row itself it will find the req Test Name column rt
	    	
	    	//first row access u got
	    		Row firstrow=rows.next();
	    	Iterator<Cell> cell=firstrow.cellIterator();
	    	int k=0;
	    	int colIndex=0;
	    	
	    		while(cell.hasNext())
	    		{
	    			Cell reqcell=cell.next();
	    			if(reqcell.getStringCellValue().equalsIgnoreCase("data1")) //successfully scanned first row and requred column
	    			{
	    			colIndex=k;
	    			
	    		}
	    		k++; //to get the column index we have taken k variable 
	    	}
	    	
			System.out.println(colIndex);
			while(rows.hasNext()) {
				Row r=rows.next();
				if(r.getCell(colIndex).getStringCellValue().equalsIgnoreCase("testcase")) //found required tets case so now we need to grab the text of that required testcase
						{
					Iterator <Cell> rv=r.cellIterator();
					
					while(rv.hasNext()) {
						Cell reqCell =rv.next();
						if(reqCell.getCellType()==CellType.STRING) {
					     a.add(rv.next().getStringCellValue());
						}
					   else {
						a.add( NumberToTextConverter.toText( reqCell.getNumericCellValue()));
					   }
					}
				}
			
						
			}
	    }
	    	
	    
	
	    //now Basic Logic to drive the data from EXCEL
	    //we need to identify the Test cases column by scanning entire first row
	    //once the column identified- then scan entire column to fine the login page testcase
	    //once the test case identified-pull the all data in that row and feed to our testcase as input
	   
	}
		return a;

	}
	
		
	
}
